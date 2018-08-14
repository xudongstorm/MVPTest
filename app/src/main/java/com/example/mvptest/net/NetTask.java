package com.example.mvptest.net;

public interface NetTask<T> {
    void excute(T data,LoadTasksCallBack callBack);
}
