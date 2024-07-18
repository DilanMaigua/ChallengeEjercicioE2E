package com.example.tasks.web;

import com.example.userinterfaces.pages.DemoblazeHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static com.example.userinterfaces.pages.DemoblazeHomePage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class GenerarCompra implements Task {

    public GenerarCompra(){

    }

    public static GenerarCompra genCompra(){
        return instrumented(GenerarCompra.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_Cart),
                WaitUntil.the(txt_descripcion1, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(txt_descripcion2, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(DemoblazeHomePage.BTN_PlaceOrder, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DemoblazeHomePage.BTN_PlaceOrder)
        );
    }
}
