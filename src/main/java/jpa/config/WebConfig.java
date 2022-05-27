package com.nhnacademy.jpa.config;

import com.nhnacademy.jpa.controller.ControllerBase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = ControllerBase.class)
@EnableSpringDataWebSupport
public class WebConfig implements WebMvcConfigurer {
// , ApplicationContextAware, MessageSourceAware
    // private ApplicationContext applicationContext;
    // private MessageSource messageSource;
    //
    // @Override
    // public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    //     this.applicationContext = applicationContext;
    // }
    //
    // @Override
    // public void setMessageSource(MessageSource messageSource) {
    //     this.messageSource = messageSource;
    // }
    //
    // @Override
    // public void configureViewResolvers(ViewResolverRegistry registry) {
    //     registry.viewResolver(thymeleafViewResolver());
    // }
    //
    // @Bean
    // public ViewResolver thymeleafViewResolver(){
    //     ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
    //     thymeleafViewResolver.setTemplateEngine(templateEngine());
    //     thymeleafViewResolver.setCharacterEncoding("UTF-8");
    //     thymeleafViewResolver.setOrder(1);
    //     return thymeleafViewResolver;
    // }
    //
    // public SpringTemplateEngine templateEngine(){
    //     SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    //     templateEngine.setTemplateResolver(templateResolver());
    //     templateEngine.setTemplateEngineMessageSource(messageSource);
    //     return templateEngine;
    // }
    //
    // public SpringResourceTemplateResolver templateResolver(){
    //     SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    //     templateResolver.setApplicationContext(applicationContext);
    //     templateResolver.setCharacterEncoding("UTF-8");
    //     templateResolver.setPrefix("/WEB-INF/views/");
    //     templateResolver.setSuffix(".html");
    //     templateResolver.setTemplateMode(TemplateMode.HTML);
    //     return templateResolver;
    // }
    //
    // @Bean
    // RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
    //     RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
    //     requestMappingHandlerAdapter.setIgnoreDefaultModelOnRedirect(true);
    //     return requestMappingHandlerAdapter;
    // }

}
