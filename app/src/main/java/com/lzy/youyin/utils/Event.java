package com.lzy.youyin.utils;

/**
 * @author lzy <axhlzy@live.cn>
 * @created 19/07/21
 * @modified 19/07/21
 * @description EventBus发送的消息类
 */
public class Event<T> {
    private int code;
    private T data;

    public Event(int code) {
        this.code = code;
    }

    public Event(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //EventBus Code
    public static final class EventCode {
        public static final int EVENT_LOGIN = 0x000001;
        public static final int EVENT_LOGOUT = 0x000002;
        public static final int EVENT_UDATA = 0x000003;
        public static final int EVENT_GET_INFO = 0x000004;
        // other more
    }
}

