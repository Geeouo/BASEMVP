package com.houserentmanage.utils;

/**
 * Create by Gee on 2020/6/25.
 */
public class SingleFactory {

    private static class SingletonHoler{
        private static SingleFactory instance = new SingleFactory();
    }
    public static SingleFactory getInstance(){
        return SingletonHoler.instance;
    }
}
