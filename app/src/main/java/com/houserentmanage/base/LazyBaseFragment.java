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

public abstract class LazyBaseFragment extends Fragment {

    protected boolean isHaveData = false; //是否已经加载过数据
    protected boolean isViewCreated = false; // 是否视图已经创建完成
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
        setViewCreated(true);
        lazyLoadDataIfViewCreated();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyLoadDataIfViewCreated();
        }
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


    /**
     * 懒加载判断方法
     */
    public void lazyLoadDataIfViewCreated() {
        if (getUserVisibleHint() && !isHaveData() && isViewCreated()) {
            //如果此时界面对用户可见&&初次加载数据&&视图已经创建完毕=>loadData()
            initViewConfig();//初始化控件
            loadData();
            setHaveData(true);
        }
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

    public boolean isHaveData() {
        return isHaveData;
    }

    public void setHaveData(boolean haveData) {
        isHaveData = haveData;
    }

    public boolean isViewCreated() {
        return isViewCreated;
    }

    public void setViewCreated(boolean viewCreated) {
        isViewCreated = viewCreated;
    }
}
