package com.houserentmanage.logic.splash;

import android.content.Intent;

import com.houserentmanage.R;
import com.houserentmanage.base.BaseActivity;
import com.houserentmanage.base.BaseApplication;
import com.houserentmanage.base.BasePresenter;
import com.houserentmanage.logic.guide.GuideActivity;
import com.houserentmanage.logic.main.MainActivity;
import com.houserentmanage.utils.SpUtils;
import com.jaeger.library.StatusBarUtil;


/**
 * Create by Gee on 2020/6/9.
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected boolean isInitStatusBarBySelf() {
        return true;
    }

    @Override
    protected void initStatusBarBySelf() {
        StatusBarUtil.setTranslucent(this, 0);
        StatusBarUtil.setLightMode(this);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void loadData() {
        BaseApplication.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (SpUtils.isShowGuide())
                    startActivity(new Intent(SplashActivity.this, GuideActivity.class));
                else
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
            }
        }, 2000);
    }
}
