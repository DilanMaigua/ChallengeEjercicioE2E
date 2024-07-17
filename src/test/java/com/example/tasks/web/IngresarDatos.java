package com.example.tasks.web;

import com.example.userinterfaces.pages.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class IngresarDatos implements Task {

    private final String nombre;
    private final String pais;
    private final String ciudad;
    private final String ccard;
    private final String mes;
    private final String anio;

    public IngresarDatos(String nombre,String pais,String ciudad,String ccard,String mes,String anio){
        this.nombre=nombre;
        this.pais=pais;
        this.ciudad=ciudad;
        this.ccard=ccard;
        this.mes=mes;
        this.anio=anio;
    }

    public static Performable ingresoDatos(String nombre, String pais, String ciudad, String ccard, String mes, String anio){
        return instrumented(IngresarDatos.class,nombre,pais,ciudad,ccard,mes,anio);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DemoblazePlaceOrder.txt_nombre, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(nombre).into(DemoblazePlaceOrder.txt_nombre),
                Enter.theValue(pais).into(DemoblazePlaceOrder.txt_pais),
                Enter.theValue(ciudad).into(DemoblazePlaceOrder.txt_ciudad),
                Enter.theValue(ccard).into(DemoblazePlaceOrder.txt_ccard),
                Enter.theValue(mes).into(DemoblazePlaceOrder.txt_mes),
                Enter.theValue(anio).into(DemoblazePlaceOrder.txt_anio)
                );
    }
}
