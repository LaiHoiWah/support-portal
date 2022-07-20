package com.meowu.support.service.commons.config;

import com.meowu.commons.utils.GsonUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport{

    private Charset charset_UTF8 = StandardCharsets.UTF_8;

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters){
        // gson convert
        GsonHttpMessageConverter gsonConverter = new GsonHttpMessageConverter();
        gsonConverter.setDefaultCharset(charset_UTF8);
        gsonConverter.setGson(GsonUtils.generate());

        // string convert
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setDefaultCharset(charset_UTF8);

        converters.add(gsonConverter);
        converters.add(stringConverter);
    }

    @Override
    protected void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("POST", "GET", "PUT", "DELETE", "OPTIONS")
                .maxAge(-1);
    }
}
