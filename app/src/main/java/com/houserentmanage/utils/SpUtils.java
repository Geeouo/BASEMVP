package com.houserentmanage.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.houserentmanage.base.BaseApplication;


/**
 * Created by Geeouo on 2018/12/14.
 */
public class SpUtils {
    public static final String FILE_NAME = "share_data";

    public static boolean clearSpData() {
        SharedPreferences sp = BaseApplication.getGlobalContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        return editor.commit();
    }

    public static void putStr(String key, String vaule) {
        SharedPreferences sp = BaseApplication.getGlobalContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, vaule);
        editor.apply();
    }

    public static String getStr(String key, String defValue) {
        SharedPreferences sp = BaseApplication.getGlobalContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static void putBoolean(String key, boolean vaule) {
        SharedPreferences sp = BaseApplication.getGlobalContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, vaule);
        editor.apply();
    }

    public static boolean getBoolean(String key, boolean defValue) {
        SharedPreferences sp = BaseApplication.getGlobalContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static void removeStr(String key) {
        SharedPreferences sp = BaseApplication.getGlobalContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }

    public static void putInt(String key, int value) {
        SharedPreferences sp = BaseApplication.getGlobalContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static int getInt(String key, int defValue) {
        SharedPreferences sp = BaseApplication.getGlobalContext().getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    //token
    public final static String PR_TOKEN = "pr_token";

    public final static void setToken(String token) {
        putStr(PR_TOKEN, token);
    }

    public final static String getToken() {
        return getStr(PR_TOKEN, "");
    }

    public static void removeToken() {
        removeStr(PR_TOKEN);
    }

    //loginNum
    public final static String FLAG_LOGIN_PHONE_NUM = "flag_login_phone_num";

    public final static void setLoginPhoneNum(String phoneNum) {
        putStr(FLAG_LOGIN_PHONE_NUM, phoneNum);
    }

    public final static String getLoginPhoneNum() {
        return getStr(FLAG_LOGIN_PHONE_NUM, "");
    }

    //RefreshToken
    public final static String PR_REFRESH_TOKEN = "pr_refresh_token";

    public static void setPrRefreshToken(String token) {
        putStr(PR_REFRESH_TOKEN, token);
    }

    public static String getPrRefreshToken() {
        return getStr(PR_REFRESH_TOKEN, "");
    }

    public static void removeRefreshToken() {
        removeStr(PR_REFRESH_TOKEN);
    }


    //用户名
    public final static String PR_USER_NAME = "pr_user_name";

    public static void setPrUserName(String userName) {
        putStr(PR_USER_NAME, userName);
    }

    public static String getPrUserName() {
        return getStr(PR_USER_NAME, "");
    }

    //用户密码
    public final static String PR_USER_PSW = "pr_user_psw";

    public static void setPrUserPsw(String userPsw) {
        putStr(PR_USER_PSW, userPsw);
    }

    public static String getPrUserPsw() {
        return getStr(PR_USER_PSW, "");
    }

    //deviceId
    public final static String PR_DEVICE_ID = "pr_device_id";

    public static void setPrDeviceId(String deviceId) {
        putStr(PR_DEVICE_ID, deviceId);
    }

    public static String getPrDeviceId() {
        return getStr(PR_DEVICE_ID, "");
    }

    //deviceBrand
    public final static String PR_DEVICE_BRAND = "pr_device_brand";

    public static void setDeviceBrand(String deviceBrand) {
        putStr(PR_DEVICE_BRAND, deviceBrand);
    }

    public static String getDeviceBrand() {
        return getStr(PR_DEVICE_BRAND, "");
    }

    //deviceModel
    public final static String PR_DEVICE_MODEL = "pr_device_model";

    public static void setDeviceModel(String deviceModel) {
        putStr(PR_DEVICE_MODEL, deviceModel);
    }

    public static String getDeviceModel() {
        return getStr(PR_DEVICE_MODEL, "");
    }

    //deviceVersion
    public final static String PR_DEVICE_VERSION = "pr_device_Version";

    public static void setDeviceVersion(String deviceVersion) {
        putStr(PR_DEVICE_VERSION, deviceVersion);
    }

    public static String getDeviceVersion() {
        return getStr(PR_DEVICE_VERSION, "");
    }


    //是否显示引导图
    public final static String IS_SHOW_GUIDE = "is_show_guide";

    public static void setShowGuide(boolean isShowGuide) {
        putBoolean(IS_SHOW_GUIDE, isShowGuide);
    }

    public static boolean isShowGuide() {
        return getBoolean(IS_SHOW_GUIDE, true);
    }
}
