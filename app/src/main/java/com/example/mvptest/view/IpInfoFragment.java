package com.example.mvptest.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvptest.presenter.IpInfoContract;
import com.example.mvptest.R;
import com.example.mvptest.model.IpData;
import com.example.mvptest.model.IpInfo;

public class IpInfoFragment extends Fragment implements IpInfoContract.View {

    private TextView tv_country;
    private TextView tv_area;
    private TextView tv_city;
    private Button bt_ipinfo;
    private IpInfoContract.Presenter mPresenter;
    private Dialog mDialog;

    public static IpInfoFragment newInstance(){
        return new IpInfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_ipinfo,container,false);
        tv_country=(TextView)root.findViewById(R.id.tv_country);
        tv_area=(TextView)root.findViewById(R.id.tv_area);
        tv_city=(TextView)root.findViewById(R.id.tv_city);
        bt_ipinfo=(Button)root.findViewById(R.id.bt_ipinfo);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDialog=new ProgressDialog(getActivity());
        mDialog.setTitle("获取数据中");
        bt_ipinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getIpInfo("39.155.184.147");
            }
        });
    }

    @Override
    public void setIpInfo(IpInfo ipInfo) {
        if(ipInfo!=null&&ipInfo.getData()!=null){
            IpData ipData=ipInfo.getData();
            tv_country.setText(ipData.getCountry());
            tv_city.setText(ipData.getCity());
            tv_area.setText(ipData.getArea());
        }
    }

    @Override
    public void showLoading() {
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if(mDialog.isShowing()){
            mDialog.hide();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getActivity().getApplicationContext(),"网络出错",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();   //Fragment.isAdded()判断Fragemnt是否加入Activity中
    }

    @Override
    public void setPresenter(IpInfoContract.Presenter presenter) {
        this.mPresenter=presenter;
    }
}
