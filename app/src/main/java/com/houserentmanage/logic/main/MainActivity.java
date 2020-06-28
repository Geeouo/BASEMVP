package com.houserentmanage.logic.main;

import com.houserentmanage.R;
import com.houserentmanage.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements IMainView {

    @Override
    protected MainPresenter createPresenter() {
        return null;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void dismissLoadingView() {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showError() {

    }
}