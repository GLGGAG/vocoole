package com.vocoole.foundation.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author GLGGAG
 * @date 2018-04-04 16:13
 * @Description: 商户管理数据库连接配置
 */
@Configuration
@MapperScan(basePackages = "com.vocoole.foundation.mapper.shop", sqlSessionTemplateRef = "shopSqlSessionTemplate")
public class ShopDataSourceConfig {


    @Bean(name = "shopDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.shop")
    public DruidDataSource setDataSource() {
        return new DruidDataSource();
    }

    @Bean(name = "shopTransactionManager")
    public DataSourceTransactionManager setTransactionManager(@Qualifier("shopDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean(name = "shopSqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("shopDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/shop/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "shopSqlSessionTemplate")
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("shopSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
