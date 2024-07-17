package com.example.stepdefinitions.web;

import com.example.questions.web.DemoblazeQ;
import com.example.tasks.web.*;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.MatcherAssert.assertThat;

public class DemoblazeSD {
    private Scenario scenario;

    @Before
    public void setTheStage()  {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order = 1)
    public void setScenario (Scenario scenario){
        this.scenario = scenario;
    }

    @Given("^el (.*) inicia la aplicación Demoblaze$")
    public void elClienteIniciaLaAplicacionDemoblaze(String actor) {
        theActorCalled(actor).attemptsTo(
        NavigateTo.demoblazePage()
        );
        Serenity.takeScreenshot();

        screenShot();
    }

    @When("selecciona la categoría {string} y selecciona un producto de la categoría")
    public void seleccionaLaCategoríaYSeleccionaUnProductoDeLaCategoría(String arg0) {
        theActorInTheSpotlight().attemptsTo(
                ComprarProducto.forCategory(arg0)
        );

        System.out.println("Descripcion del producto a comprar: " + DemoblazeQ.descripcionProducto().answeredBy(theActorInTheSpotlight()));
        Serenity.takeScreenshot();

        screenShot();
    }

    @Then("agrega el producto al carrito")
    public void agregaElProductoAlCarrito() {
        theActorInTheSpotlight().attemptsTo(
                AgregarProducto.addProducto()
        );

    }

    @And("visualiza el carrito luego genera la compra")
    public void visualizaElCarritoLuegoGeneraLaCompra() {
        theActorInTheSpotlight().attemptsTo(
                GenerarCompra.genCompra()
        );
        Serenity.takeScreenshot();

        screenShot();

    }


    @When("ingresa los datos al formulario con nombre {string}, país {string}, ciudad {string}, tarjeta de crédito {string}, mes {string}, y año {string}")
    public void ingresaLosDatosAlFormularioConNombrePaísCiudadTarjetaDeCréditoMesYAñoYear(String nombre,String pais, String ciudad, String ccard, String mes, String anio) {
        theActorInTheSpotlight().attemptsTo(
                IngresarDatos.ingresoDatos(nombre,pais,ciudad,ccard,mes,anio)
        );
        Serenity.takeScreenshot();

        screenShot();

    }

    @Then("finaliza la compra y verifica la compra")
    public void finalizaLaCompraYVerificaLaCompra() {
        theActorInTheSpotlight().attemptsTo(
                ValidarCompra.finalizarValidarCompra()
        );
        System.out.println("Descripcion de la orden de compra: " + DemoblazeQ.descripcionOrdenCompra().answeredBy(theActorInTheSpotlight()));

        Serenity.takeScreenshot();
        screenShot();

    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) BrowseTheWeb.as(theActorInTheSpotlight()).getDriver()).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }


}
