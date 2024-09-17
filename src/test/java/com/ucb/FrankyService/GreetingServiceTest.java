package com.ucb.FrankyService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GreetingServiceTest {

    @Autowired
    private GreetingService greetingService;

    @Test
    void getPersonalizedGreetingInSpanish() {
        String name = "Juan";
        String expectedMessage = "Juan. Pregúntate si lo que estás haciendo hoy te acerca al lugar en el que quieres estar mañana.";
        assertEquals(expectedMessage, greetingService.getPersonalizedGreeting(name, new Locale("es")));
    }

    @Test
    void getPersonalizedGreetingInEnglish() {
        String name = "John";
        String expectedMessage = "John. Ask yourself if what you're doing today is bringing you closer to where you want to be tomorrow.";
        assertEquals(expectedMessage, greetingService.getPersonalizedGreeting(name, new Locale("en")));
    }

    @Test
    void getPersonalizedGreetingInFrench() {
        String name = "Jean";
        String expectedMessage = "Jean. Demande-toi si ce que tu fais aujourd'hui te rapproche de l'endroit où tu veux être demain.";
        assertEquals(expectedMessage, greetingService.getPersonalizedGreeting(name, new Locale("fr")));
    }
}
