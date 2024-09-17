package com.ucb.FrankyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @Autowired
    GreetingService greetingService;

    @GetMapping
    public String greeting() {
        return greetingService.getGreeting();
    }

    @GetMapping("/{name}")
    public String personalizedGreeting(
            @PathVariable String name,
            @RequestParam(value = "lang", required = false) String lang) {

        Locale locale = lang != null ? new Locale(lang) : Locale.getDefault();
        return greetingService.getPersonalizedGreeting(name, locale);
    }
}
