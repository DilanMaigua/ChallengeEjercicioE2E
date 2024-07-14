package com.example.tasks.web;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static com.example.userinterfaces.pages.DemoblazeHomePage.*;


public class GenerarCompra implements Task {

    public GenerarCompra(){

    }

    public static GenerarCompra genCompra(){
        return instrumented(GenerarCompra.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_Cart)
        );
    }
}
