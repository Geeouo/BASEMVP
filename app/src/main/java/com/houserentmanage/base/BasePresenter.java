package com.houserentmanage.base;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/11/21.
 */
public class BasePresenter<V extends IBaseView> {

    private List<Disposable> mDisposables = new ArrayList<>();

    private V mView;

    public void attachView(V view) {
        this.mView = view;
    }

    public void addDisposable(Disposable disposable) {
        if (disposable != null) {
            mDisposables.add(disposable);
        }
    }

    public void detachView() {
        this.mView = null;

        try {
            for (Disposable disposable : mDisposables) {
                if (disposable != null && !disposable.isDisposed()) {
                    disposable.dispose();
                }
            }
        } catch (Exception e) {

        }
    }

    public boolean isViewAttach() {
        return mView != null;
    }

    public V getView() {
        return mView;
    }

}
