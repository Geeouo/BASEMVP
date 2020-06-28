package com.houserentmanage.base;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.houserentmanage.R;
import com.houserentmanage.api.Api;
import com.houserentmanage.api.RetrofitClient;
import com.houserentmanage.utils.ActivityUtils;
import com.jaeger.library.StatusBarUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

/**
 * Create by Gee on 2020/6/8.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
    private Gson mGson;
    private P p;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取布局id
        setContentView(getContentViewId());
        //是否需要自己初始化statusBar
        if (isInitStatusBarBySelf())
            initStatusBarBySelf();
        else initStatusBarByGlobal();
        //初始化presenter
        p = createPresenter();
        if (p != null)
            p.attachView((IBaseView) this);
        //统一管理activity
        ActivityUtils.getInstance().addActivity(this);
        ButterKnife.bind(this);
        initViewConfig();//初始化控件
        loadData();//请求网络
    }

    protected boolean isInitStatusBarBySelf() {
        return false;//默认采用统一初始化，除非有特殊定制化需求
    }

    protected void initStatusBarBySelf() {

    }

    protected void initStatusBarByGlobal() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimary), 0);
        StatusBarUtil.setLightMode(this);
    }

    protected abstract P createPresenter();

    protected abstract int getContentViewId();

    /**
     * 初始化控件及控件配置
     */
    protected void initViewConfig() {
    }


    /**
     * 请求网络
     */
    protected void loadData() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public Gson getGson() {
        if (mGson == null)
            mGson = new Gson();
        return mGson;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (p != null)
            p.detachView();

        ActivityUtils.getInstance().removeActivity(this);
    }

    public Api getApi() {
        return RetrofitClient.getInstance().getApiService();
    }
}
