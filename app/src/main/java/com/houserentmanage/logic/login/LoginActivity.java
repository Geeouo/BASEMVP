package com.houserentmanage.logic.login;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.houserentmanage.R;
import com.houserentmanage.base.BaseActivity;

import androidx.annotation.Nullable;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Create by Gee on 2020/6/9.
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements ILoginView {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(LoginActivity.class.getSimpleName(), "onCreate: ");
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
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

    @OnClick({R.id.tv_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:

                //RxJava2Test();
                Intent intent = new Intent(LoginActivity.this, TestViewActivity.class);

                PackageManager packageManager = getPackageManager();
                ResolveInfo resolveInfo = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
                if (resolveInfo != null)
                    startActivity(intent);
                break;
        }
    }

    Disposable mD = null;

    private void RxJava2Test() {
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Log.e("GEERXJ", "Observable Current Thread--------------->" + Thread.currentThread().getId());
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                //e.onError(new Throwable("主动调用onError"));
                e.onNext(4);
                Log.e("GEERXJ", "e.onNext(4);");
            }
        });

        Observer observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                mD = d;
            }

            @Override
            public void onNext(Integer value) {
                Log.e("GEERXJ", "Observer Current Thread--------------->" + Thread.currentThread().getId());
                Log.e("GEERXJ", "onNext:value--------------->" + value);
                if (value == 2) mD.dispose();
            }

            @Override
            public void onError(Throwable e) {
                Log.e("GEERXJ", "onError:--------------->" + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.e("GEERXJ", "onComplete:--------------->");
            }
        };

        observable.subscribe(observer);
        //MyThread thread = new MyThread();
        //thread.run();
        System.out.println("start");
        new MyThread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Runnable  run ......");
            }
        }).start();
        System.out.println("end");
    }

    class MyThread extends Thread {
        public MyThread(Runnable runnable) {
            super(runnable);
        }

        @Override
        public void run() {
            super.run();
            System.out.println("MyThread  run ......");
        }
    }

}
