package com.houserentmanage.logic.login;

import android.util.Log;

import com.houserentmanage.base.BaseActivity;
import com.houserentmanage.base.BasePresenter;

/**
 * Create by Gee on 2020/6/28.
 */
public class AnimatorTestActivity extends BaseActivity {

    private String tag = AnimatorTestActivity.class.getSimpleName();

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getContentViewId() {
        Log.e(tag, "new create activity for animator test");
        return 0;
    }
}
