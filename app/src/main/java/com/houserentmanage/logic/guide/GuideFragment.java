package com.houserentmanage.logic.guide;

import android.widget.ImageView;

import com.houserentmanage.R;
import com.houserentmanage.base.BaseFragment;

import butterknife.BindView;

/**
 * Create by Gee on 2020/6/9.
 */
public class GuideFragment extends BaseFragment {
    @BindView(R.id.iv_guide)
    ImageView ivGuide;
    private int resourceId = -1;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_guide;
    }

    @Override
    protected void loadData() {
        ivGuide.setImageResource(resourceId);
    }

    public void setGuideImage(int resourceId) {
        this.resourceId = resourceId;
    }
}
