package com.example.springdemo.api.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger配置文件
 * 通过http://localhost:端口号/swagger-ui.html 即可访问查看效果
 * 没有该类Swagger也是可以访问的
 */
@Configuration
@EnableWebMvc
public class SwaggerCongfig implements WebMvcConfigurer {

    public static final String VERSION = "1.0.1";
    public static final String AUTHOR = "SpringBootDemo";

    @Bean
    public Docket createRestApi() {
        System.out.println("createRestApi");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //Controller的位置
                .apis(RequestHandlerSelectors.basePackage("com.example.springdemo.api.v1.controller"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(ApiIgnore.class)
                .enableUrlTemplating(false)
                .tags(new Tag("Account", "账号模块"))
                .tags(new Tag("Category", "商品类别"));
    }

    private ApiInfo apiInfo() {
        System.out.println("apiInfo");
        return new ApiInfoBuilder()
                //设置文档标题
                .title("Api文档")
                .description("SpringBootDemo-API文档")
                .version(VERSION)
                .contact(new Contact(AUTHOR, "www.baicu.com", "xx@qq.com"))
                .build();
    }

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/"};

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(
                    CLASSPATH_RESOURCE_LOCATIONS);
        }
    }
}
