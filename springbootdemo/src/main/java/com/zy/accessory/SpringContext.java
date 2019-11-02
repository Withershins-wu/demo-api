package com.zy.accessory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 用于获取当前环境
 * Created by zuoqingshan on 2019/3/7.
 */
@Component
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static String getActiveProfile() {
        return context.getEnvironment().getActiveProfiles()[0];
    }

}
