package com.example.mvptest.net;

import com.example.mvptest.model.IpInfo;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.RequestParams;

public class IpInfoTask implements NetTask<String> {

    private static IpInfoTask INSTANCE=null;
    private static final String HOST="http://ip.taobao.com/service/getIpInfo.php";
    private LoadTasksCallBack loadTasksCallBack;

    private IpInfoTask(){
    }

    public static IpInfoTask getInstance(){
        if(INSTANCE==null){
            INSTANCE=new IpInfoTask();
        }
        return INSTANCE;
    }

    @Override
    public void excute(String ip, final LoadTasksCallBack callBack) {
        RequestParams requestParams=new RequestParams();
        requestParams.addFormDataPart("ip",ip);
        HttpRequest.post(HOST,requestParams,new BaseHttpRequestCallback<IpInfo>(){

            @Override
            protected void onSuccess(IpInfo ipInfo) {
                super.onSuccess(ipInfo);
                callBack.onSuccess(ipInfo);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                callBack.onFinish();
            }

            @Override
            public void onStart() {
                super.onStart();
                callBack.onStart();
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                callBack.onFailed();
            }
        });
    }
}
