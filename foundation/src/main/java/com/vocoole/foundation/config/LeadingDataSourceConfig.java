package com.vocoole.foundation.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author GLGGAG
 * @date 2018-04-04 16:00
 * @Description: 应用前端数据库连接配置
 */
@Configuration
@MapperScan(basePackages = "com.vocoole.foundation.mapper.leading", sqlSessionTemplateRef = "leadingSqlSessionTemplate")
public class LeadingDataSourceConfig {


    @Bean(name = "leadingDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.leading")
    @Primary
    public DataSource setDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "leadingTransactionManager")
    @Primary
    public DruidDataSource setTransactionManager(@Qualifier("leadingDataSource") DataSource dataSource) {
        return new DruidDataSource();
    }


    @Bean(name = "leadingSqlSessionFactory")
    @Primary
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("leadingDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/leading/*.xml"));
        return bean.getObject();
    }


    @Bean(name = "leadingSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(@Qualifier("leadingSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}