package com.houserentmanage.api;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Create by Gee on 2020/6/9.
 */
public interface Api {
    /*
    *
    *
    * GrantType:Password Credentials
                            UserName:手机号码
                            Password:密码/验证码
                            Client_Id:XHouseClient001
                            Client_Secret:XHouseClient00100!@#
                            Scope:XServer
                            grant_type:password(密码登陆时) code_login(验证码登陆时)
    * */
    @FormUrlEncoded
    @POST("connect/token")
    Observable<JsonObject> getToken(@Field("GrantType") String grantType,
                                    @Field("UserName") String userName,
                                    @Field("Password") String password,
                                    @Field("Client_Id") String clientId,
                                    @Field("Client_Secret") String clientSecret,
                                    @Field("XServer") String Xserver,
                                    @Field("grant_type") String grant_type);
}
