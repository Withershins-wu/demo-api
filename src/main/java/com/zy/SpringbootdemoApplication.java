package com.zy;

import com.zy.accessory.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.servlet.DispatcherType;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableJms
public class SpringbootdemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }

    @Override//为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

    /**
     * 跨域过滤器
     */
    @Bean
    FilterRegistrationBean CORSFilter() {
        FilterRegistrationBean filterReg = new FilterRegistrationBean(new CorsFilter());
        //优先级
        filterReg.setOrder(60);
        filterReg.setDispatcherTypes(DispatcherType.REQUEST);
        //匹配路径
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");

        filterReg.setUrlPatterns(urlPatterns);
        return filterReg;
    }
}
