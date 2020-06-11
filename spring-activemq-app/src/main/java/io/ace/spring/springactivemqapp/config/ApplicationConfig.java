package io.ace.spring.springactivemqapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MessageConfig.class)
@ComponentScan(basePackages = "io.ace.spring.springactivemqapp")
public class ApplicationConfig {

}
