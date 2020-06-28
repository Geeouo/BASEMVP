package com.houserentmanage.logic.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.Toast;

import com.houserentmanage.R;

import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * Create by Gee on 2020/6/21.
 */
public class LoginView extends View {
    Paint mPaint;
    private int mDesireWidth;
    private int mDesireHeight;
    private Scroller mScroller;

    public LoginView(Context context) {
        this(context, null);
    }

    public LoginView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoginView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.LoginView);
        mDesireWidth = ta.getDimensionPixelSize(R.styleable.LoginView_desireWidth, 0);
        mDesireHeight = ta.getDimensionPixelSize(R.styleable.LoginView_desireHeight, 0);
        ta.recycle();

        //初始化scroller
        mScroller = new Scroller(context);
        mPaint = new Paint();
        mPaint.setTextSize(30);
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        mPaint.setAntiAlias(true);
        //String
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int defaultWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int defaultWidthSize = MeasureSpec.getSize(widthMeasureSpec);
        int defaultHeightMode = MeasureSpec.getMode(heightMeasureSpec);
        int defaultHeightSize = MeasureSpec.getSize(heightMeasureSpec);
        if (mDesireWidth == 0 && mDesireHeight == 0)
            setMeasuredDimension(0, 0);
        int resultWidth = resolveSize(mDesireWidth, widthMeasureSpec);
        int resultHeight = resolveSize(mDesireHeight, heightMeasureSpec);
        setMeasuredDimension(resultWidth, resultHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(getResources().getColor(android.R.color.holo_blue_light));
        canvas.drawText("Gee is very good!",20,20,mPaint);

    }


    void startScroll(int destX, int destY, int duration) {
        int scrollX = getScrollX();
        int deltaX = destX - scrollX;
        int scrollY = getScrollY();
        int deltaY = destY - scrollY;
        mScroller.startScroll(scrollX, scrollY, deltaX, deltaY, duration);
        invalidate();
        Toast.makeText(getContext(),"startScroll perform",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        Toast.makeText(getContext(),"computeScroll perform",Toast.LENGTH_SHORT).show();
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }
}
