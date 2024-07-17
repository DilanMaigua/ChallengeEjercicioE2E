package com.example.stepdefinitions.web;

import com.example.questions.web.DemoblazeQ;
import com.example.tasks.web.*;
import java.util.Random;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public void seleccionaLaCategoríaYSeleccionaUnProductoDeLaCategoría(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);

            String categoria1 = jsonNode.get("category1").asText();
            String categoria2 = jsonNode.get("category2").asText();
            String categoria3 = jsonNode.get("category3").asText();

            Random random = new Random();
            int randomNumber = random.nextInt(3); // Devuelve 0 o 1

            String categoriaSeleccionada;
            if (randomNumber == 0) {
                categoriaSeleccionada = categoria1;
            } else if (randomNumber == 1) {
                categoriaSeleccionada = categoria2;
            } else {
                categoriaSeleccionada = categoria3;
            }

            theActorInTheSpotlight().attemptsTo(
                   ComprarProducto.forCategory(categoriaSeleccionada)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

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


    @When("ingresa los datos al formulario {string}")
    public void ingresaLosDatosAlFormulario(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(json);

            String name = jsonNode.get("name").asText();
            String country = jsonNode.get("country").asText();
            String city = jsonNode.get("city").asText();
            String ccard = jsonNode.get("ccard").asText();
            String month = jsonNode.get("month").asText();
            String year = jsonNode.get("year").asText();
            theActorInTheSpotlight().attemptsTo(
                    IngresarDatos.ingresoDatos(name,country,city,ccard,month,year)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
