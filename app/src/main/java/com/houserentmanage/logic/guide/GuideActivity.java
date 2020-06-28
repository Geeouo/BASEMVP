package com.houserentmanage.logic.guide;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.houserentmanage.R;
import com.houserentmanage.base.BaseActivity;
import com.houserentmanage.base.BasePresenter;
import com.houserentmanage.logic.login.LoginActivity;
import com.houserentmanage.logic.main.MainActivity;
import com.rd.PageIndicatorView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

/**
 * Create by Gee on 2020/6/9.
 */
public class GuideActivity extends BaseActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    PageIndicatorView indicator;
    @BindView(R.id.tv_start)
    TextView tvStart;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_guide;
    }

    @Override
    protected void initViewConfig() {
        List<GuideFragment> fragments = new ArrayList();

        GuideFragment guideFragment1 = (GuideFragment) GuideFragment.instantiate(this, GuideFragment.class.getName(), null);
        guideFragment1.setGuideImage(R.drawable.guide_one);
        fragments.add(guideFragment1);
        GuideFragment guideFragment2 = (GuideFragment) GuideFragment.instantiate(this, GuideFragment.class.getName(), null);
        guideFragment2.setGuideImage(R.drawable.guide_two);
        fragments.add(guideFragment2);
        GuideFragment guideFragment3 = (GuideFragment) GuideFragment.instantiate(this, GuideFragment.class.getName(), null);
        guideFragment3.setGuideImage(R.drawable.guide_three);
        fragments.add(guideFragment3);
        viewPager.setAdapter(new GuideViewPagerAdapter(getSupportFragmentManager(), fragments));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {/*empty*/}

            @Override
            public void onPageSelected(int position) {
                indicator.setSelection(position);
                if (position == fragments.size() - 1)
                    tvStart.setVisibility(View.VISIBLE);
                else tvStart.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onPageScrollStateChanged(int state) {/*empty*/}
        });

        tvStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuideActivity.this, LoginActivity.class));
                GuideActivity.this.finish();
            }
        });
    }

    class GuideViewPagerAdapter extends FragmentPagerAdapter {
        List<GuideFragment> pList = new ArrayList();

        public GuideViewPagerAdapter(@NonNull FragmentManager fm, List<GuideFragment> fragmentList) {
            super(fm);
            if (!pList.isEmpty())
                pList.clear();
            pList.addAll(fragmentList);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return pList.get(position);
        }

        @Override
        public int getCount() {
            return pList.size();
        }
    }
}
