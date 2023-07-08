package com.github.novicezk.midjourney;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import spring.config.BeanConfig;
import spring.config.WebMvcConfig;

@EnableScheduling
@SpringBootApplication
@Import({BeanConfig.class, WebMvcConfig.class})
public class ProxyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProxyApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        System.out.print("Inside corsConfigurer");
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("https://99c2c9.myshopify.com/")
                        .allowedHeaders("*")
                        .allowedMethods("*")
                        .allowedOriginPatterns("*")
                        .allowCredentials(true);
            }
        };
    }
}
