package com.houserentmanage.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;

/**
 * Created by Geeouo on 2018/12/12.
 */

public abstract class BaseFragment extends Fragment {
    Gson mGson;
    View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(initLayoutId(), container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    public View getRootView() {
        return this.rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewConfig();//初始化控件
        loadData();
    }

    /**
     * 初始化布局
     *
     * @return LayoutId
     */
    protected abstract int initLayoutId();

    /**
     * 初始化控件及控件配置
     */
    protected void initViewConfig() {

    }

    protected abstract void loadData();

    /**
     * onDestroyView中进行解绑操作
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public Gson getGson() {
        if (mGson == null)
            mGson = new Gson();
        return this.mGson;
    }
}
