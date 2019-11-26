package com.zy.accessory;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = FirstDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "firstSqlSessionFactory")
public class FirstDataSourceConfig {
    static final String PACKAGE = "com.zy.dao";
    static final String MAPPER_LOCATION = "classpath*:/mappings/*.xml";

    @Bean(name = "firstDataSource")
    @Primary //必须加此注解，不然报错，下一个类则不需要添加
    @ConfigurationProperties(prefix = "spring.datasource")//读取的配置文件中的前缀
    public DataSource firstDataSource() {
        DataSource build = DataSourceBuilder.create().build();
        return build;
    }
    
    @Bean
    public SqlSessionFactory firstSqlSessionFactory(@Qualifier("firstDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources(MAPPER_LOCATION));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate firstSqlSessionTemplate(@Qualifier("firstSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
        return template;
    }
}
