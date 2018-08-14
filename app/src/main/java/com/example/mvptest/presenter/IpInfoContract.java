package com.example.mvptest.presenter;

import com.example.mvptest.model.IpInfo;
import com.example.mvptest.view.BaseView;

public interface IpInfoContract {

    interface Presenter{
        void getIpInfo(String ip);
    }

    interface View extends BaseView<Presenter>{
        void setIpInfo(IpInfo ipInfo);
        void showLoading();
        void hideLoading();
        void showError();
        boolean isActive();
    }
}
