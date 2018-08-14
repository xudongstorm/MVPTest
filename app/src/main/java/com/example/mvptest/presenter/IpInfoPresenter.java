package com.example.mvptest.presenter;

import com.example.mvptest.model.IpInfo;
import com.example.mvptest.net.LoadTasksCallBack;
import com.example.mvptest.net.NetTask;

public class IpInfoPresenter implements IpInfoContract.Presenter,LoadTasksCallBack<IpInfo> {

    private NetTask netTask;
    private IpInfoContract.View addTaskView;

    public IpInfoPresenter(NetTask netTask,IpInfoContract.View addTaskView){
        this.netTask=netTask;
        this.addTaskView=addTaskView;
    }

    @Override
    public void getIpInfo(String ip) {
        netTask.excute(ip,this);
    }

    @Override
    public void onSuccess(IpInfo ipInfo) {
        if(addTaskView.isActive()){
            addTaskView.setIpInfo(ipInfo);
        }
    }

    @Override
    public void onStart() {
        if(addTaskView.isActive()){
            addTaskView.showLoading();
        }
    }

    @Override
    public void onFailed() {
        if(addTaskView.isActive()){
            addTaskView.hideLoading();
            addTaskView.showError();
        }
    }

    @Override
    public void onFinish() {
        if(addTaskView.isActive()){
            addTaskView.hideLoading();
        }
    }
}
