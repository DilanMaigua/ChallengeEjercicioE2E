package com.example.userinterfaces.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DemoblazePlaceOrder {
    public static final Target txt_nombre = Target.the("Ingreso nombre").located(By.id("name"));
    public static final Target txt_pais = Target.the("Ingreso pais").located(By.id("country"));
    public static final Target txt_ciudad = Target.the("Ingreso ciudad").located(By.id("city"));
    public static final Target txt_ccard = Target.the("Ingreso tarjerta de credito").located(By.id("card"));
    public static final Target txt_mes= Target.the("Ingreso mes").located(By.id("month"));
    public static final Target txt_anio = Target.the("Ingreso año").located(By.id("year"));
    public static final Target btn_purchase = Target.the("Boton purchase").located(By.xpath("//button[contains(text(),'Purchase')]"));
    public static final Target txt_Validarpurchase = Target.the("Texto validacion").located(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]"));
    public static final Target txt_Informacion = Target.the("Informacion datos compra").located(By.xpath("//body[1]/div[10]/p[1]"));
}
