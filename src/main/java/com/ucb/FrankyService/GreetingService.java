package com.ucb.FrankyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Service
public class GreetingService {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private LocaleResolver localeResolver;

    @Value("${greeting.message}")
    private String greet;

    public String getGreeting(){
        return greet;
    }

    public String getPersonalizedGreeting(String name, Locale locale) {
        String greetingMessage = messageSource.getMessage("greeting.message", null, locale);
        return name + ". " + greetingMessage;
    }

}
