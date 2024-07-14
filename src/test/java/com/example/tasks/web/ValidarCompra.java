package com.example.tasks.web;

import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import static com.example.userinterfaces.pages.DemoblazePlaceOrder.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidarCompra implements Task {

    private Scenario scenario;

    public ValidarCompra(){

    }

    public static ValidarCompra finalizarValidarCompra(){
        return instrumented(ValidarCompra.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String mensajeValidacion = "Thank you for your purchase!";

        actor.attemptsTo(
                Click.on(btn_purchase),
                WaitUntil.the(txt_Validarpurchase, isVisible()).forNoMoreThan(10).seconds()
        );

        String actualMessage = TextContent.of(txt_Validarpurchase).answeredBy(actor);
        System.out.println("Mensaje de validación: " + actualMessage);
        Assert.assertEquals("El mensaje de compra no coincide", mensajeValidacion, actualMessage);


    }

}
