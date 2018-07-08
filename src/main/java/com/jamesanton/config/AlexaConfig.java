package com.jamesanton.config;

import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.servlet.SpeechletServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class AlexaConfig {

    @Autowired
    private Speechlet mySpeechlet;


    @PostConstruct
    public void postConstruct() {
        // Gotta disable to request signature check for testing purposes.
        // Never run this in production
        System.setProperty("com.amazon.speech.speechlet.servlet.disableRequestSignatureCheck", "true");
    }

    @Bean
    public ServletRegistrationBean registerServlet() {
        SpeechletServlet servlet = new SpeechletServlet();
        servlet.setSpeechlet(mySpeechlet);


        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "/");
        servletRegistrationBean.addUrlMappings("/test");
        return servletRegistrationBean;
    }

}