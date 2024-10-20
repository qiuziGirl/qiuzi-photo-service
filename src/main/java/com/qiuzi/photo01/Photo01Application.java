package com.qiuzi.photo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;


@SpringBootApplication
public class Photo01Application {

    public static void main(String[] args) {
        SpringApplication.run(Photo01Application.class, args);
    }

    /**
     * 配置上传总文件和单个文件的最大值
     * @return
     */
    @Bean
   public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 单个数据大小
        factory.setMaxFileSize("20MB");
        // 总上传数据大小
        factory.setMaxRequestSize("100MB");
        return factory.createMultipartConfig();
    }

}
