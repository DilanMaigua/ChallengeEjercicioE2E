package com.example.tasks.web;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.example.userinterfaces.pages.DemoblazeHomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ComprarProducto implements Task {

    private final String category;

    public ComprarProducto(String category) {
        this.category = category;
    }

    public static ComprarProducto forCategory(String category) {
        return instrumented(ComprarProducto.class, category);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Target categoryButton;

        switch (category.toLowerCase()) {
            case "phones":
                categoryButton = BTN_Phones;
                break;
            case "laptops":
                categoryButton = BTN_Laptops;
                break;
            case "monitors":
                categoryButton = BTN_Monitors;
                break;
            default:
                throw new IllegalArgumentException("Categoría desconocida: " + category);
        }

        actor.attemptsTo(
                WaitUntil.the(categoryButton, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(categoryButton),
                WaitUntil.the(BTN_item1, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_item1)
        );
    }
}
