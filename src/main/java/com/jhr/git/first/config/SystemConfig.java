package com.jhr.git.first.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * @author jinhuari
 * date: 2017/11/28
 * description:
 */
@Repository
public class SystemConfig implements EnvironmentAware {
    private static Environment environment;

    private static String serviceVersion;
    @Override
    public void setEnvironment(Environment environment) {
        SystemConfig.environment = environment;
    }


    public static String getServiceVersion() {
        if (StringUtils.isEmpty(serviceVersion) && environment != null && !(StringUtils.isEmpty(environment.getProperty("service.version")))) {
            SystemConfig.serviceVersion = environment.getProperty("service.version");
        }
        return serviceVersion;
    }
}
