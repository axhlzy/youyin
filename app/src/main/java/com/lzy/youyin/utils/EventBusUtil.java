package com.lzy.youyin.utils;

import org.greenrobot.eventbus.EventBus;

/**
 * @author lzy <axhlzy@live.cn>
 * @created 19/07/21
 * @modified 19/07/21
 * @description EventBus工具类
 */
public class EventBusUtil {

    public static void register(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    public static void sendEvent(Event event) {
        EventBus.getDefault().post(event);
    }

    public static void sendStickyEvent(Event event) {
        EventBus.getDefault().postSticky(event);
    }

}
