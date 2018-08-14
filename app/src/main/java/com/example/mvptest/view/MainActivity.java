package com.example.mvptest.view;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvptest.ActivityUtils;
import com.example.mvptest.R;
import com.example.mvptest.net.IpInfoTask;
import com.example.mvptest.presenter.IpInfoPresenter;

public class MainActivity extends AppCompatActivity {

    private IpInfoPresenter ipInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IpInfoFragment ipInfoFragment= (IpInfoFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);
        if(ipInfoFragment==null){
            ipInfoFragment=IpInfoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),ipInfoFragment,R.id.content_frame);
        }
        IpInfoTask ipInfoTask=IpInfoTask.getInstance();
        ipInfoPresenter=new IpInfoPresenter(ipInfoTask,ipInfoFragment);
        ipInfoFragment.setPresenter(ipInfoPresenter);
    }
}
