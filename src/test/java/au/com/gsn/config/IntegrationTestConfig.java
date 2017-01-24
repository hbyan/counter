package au.com.gsn.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("au.com.mybiz")
@EnableConfigurationProperties
public class IntegrationTestConfig {
}