package com.instagram.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class WebConfig implements WebMvcConfigurer {
    // profile.upload.path
    @Value("${file.upload.path}")
    private String fileUploadPath;

    @Value("${file.product.upload.path}")
    private String productUploadPath;

    @Value("${file.board.upload.path}")
    private String boardUploadPath;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // REST API CORS 설정
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:3001","http://localhost:3000")
                        .allowCredentials(true)
                        .allowedMethods("GET","POST","PUT","DELETE","PATCH","OPTIONS")
                        .allowedHeaders("*");

                // WebSocket CORS 설정 추가
                registry.addMapping("/ws/**")
                        .allowedOrigins("http://localhost:3001","http://localhost:3000")
                        .allowCredentials(true)
                        .allowedMethods("GET","POST","PUT","DELETE","PATCH","OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }

    // 프로필 이미지 정적 리소스 매핑 추가
    // ctrl + o -> override

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/profile_images/**")
                .addResourceLocations("file:"+fileUploadPath+"/"); // 폴더명칭뒤에 바로 이미지명칭 붙어서 에러 발생


        registry.addResourceHandler("/product_images/**")
                .addResourceLocations("file:"+productUploadPath + "/"); // 폴더명칭뒤에 바로 이미지명칭 붙어서 에러 발생


        registry.addResourceHandler("/board_images/**")
                .addResourceLocations("file:"+boardUploadPath + "/"); // 폴더명칭뒤에 바로 이미지명칭 붙어서 에러 발생

    }
}
