package com.sso.util;

import java.sql.Timestamp;

/**
 * 时间工具类
 */
public class DateTimeUtil {

    /**
     * 生成当前时间
     * @return
     */
    public static Timestamp getNowTime() {
        return new Timestamp(System.currentTimeMillis());
    }

}
