package com.jhr.git.first.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jinhuari
 * date: 2017/12/5
 */
public class PerformanceTools {
    private static Logger logger = LoggerFactory.getLogger(PerformanceTools.class);

    /**
     * 方法性能记录
     *
     * @param service    模块
     * @param className  类名
     * @param methodName 方法名
     * @param spendTime  花费时间
     */
    public static void logMethodPerformance(String service, String className, String methodName, Long spendTime) {
        StringBuilder buf = new StringBuilder(64);
        buf.append("调用")
                .append(service)
                .append(":")
                .append(className)
                .append(".")
                .append(methodName)
                .append(",执行时间: ")
                .append(spendTime)
                .append("ms");
        logger.info(buf.toString());
    }
}
