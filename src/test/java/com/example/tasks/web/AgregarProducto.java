package com.example.tasks.web;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Alert;

import static com.example.userinterfaces.pages.DemoblazeHomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class AgregarProducto extends UIInteractionSteps implements Task {

    public  AgregarProducto(){

    }

    public static AgregarProducto addProducto(){
         return instrumented(AgregarProducto.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_AddCart)
        );

        try {
            Alert alert = getDriver().switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
        } catch (Exception e) {
            System.out.println(" ");
        }

        actor.attemptsTo(
                WaitUntil.the(BTN_Home, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(BTN_Home)
        );
    }
}
