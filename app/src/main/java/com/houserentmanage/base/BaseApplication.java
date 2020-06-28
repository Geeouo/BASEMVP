package com.houserentmanage.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;

/**
 * Created by Geeouo on 2018/12/13.
 */

public class BaseApplication extends Application {

    private static Handler mHandler = new Handler();

    private static BaseApplication mGlobalContext;

    public static BaseApplication getGlobalContext() {
        return mGlobalContext;
    }
    public static Handler getHandler() {
        return mHandler;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mGlobalContext = this;
    }

    /**
     * 判断当前进程是否是应用的主进程
     *
     * @return
     */
    public boolean isMainProcess() {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return getApplicationInfo().packageName.equals(appProcess.processName);
            }
        }
        return false;
    }

    //判断当前应用是否是debug状态
    public static boolean isDebug(Context context) {
        try {
            boolean isDebug = context.getApplicationInfo() != null &&
                    (context.getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
            return isDebug;
        } catch (Exception e) {
            return false;
        }
    }


}
