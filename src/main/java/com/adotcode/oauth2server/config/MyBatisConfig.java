package com.adotcode.oauth2server.config;

import com.adotcode.oauth2server.core.interceptor.VersionInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * MyBatis配置
 *
 * @author risfeng
 * @date 2019/08/18
 */
@Configuration
public class MyBatisConfig {

  /**
   * Mapper扫描配置. 自动扫描将Mapper接口生成代理注入到Spring.
   */
  @Bean
  public static MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    mapperScannerConfigurer.setBasePackage("com.adotcode.oauth2server.mapper");
    return mapperScannerConfigurer;
  }

  /**
   * 乐观锁插件
   *
   * @return VersionInterceptor
   */
  @Bean
  public Interceptor versionInterceptor() {
    return new VersionInterceptor();
  }

}