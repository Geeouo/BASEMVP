package com.houserentmanage.base;

/**
 * Created by Administrator on 2017/11/21.
 */
public interface IBaseView {

    void showLoadingView();

    void dismissLoadingView();

    void showToast(String msg);

    void showError();
}
