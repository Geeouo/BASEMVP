package com.houserentmanage.utils;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Geeouo on 2018/12/12.
 */

public class ActivityUtils {

    private static ActivityUtils instance = new ActivityUtils();
    private static List<Activity> activityStack = new LinkedList<>();

    private ActivityUtils() {
    }

    public static ActivityUtils getInstance() {
        return instance;
    }

    public void addActivity(Activity aty) {
        activityStack.add(aty);
    }

    public void removeActivity(Activity aty) {
        activityStack.remove(aty);
    }

    /**
     * 结束所有的Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    public List<Activity> getAllActivityList() {
        return activityStack;
    }
}
