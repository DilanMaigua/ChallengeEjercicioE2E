package com.example.userinterfaces.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DemoblazeHomePage {
    public static final Target BTN_Phones = Target.the("Seccion Celulares").located(By.xpath("//a[contains(text(),'Phones')]"));
    public static final Target BTN_Laptops = Target.the("Seccion Laptops").located(By.xpath("//a[contains(text(),'Laptops')]"));
    public static final Target BTN_Monitors = Target.the("Seccion Monitores").located(By.xpath("//a[contains(text(),'Monitors')]"));
    public static final Target BTN_Home = Target.the("Home").located(By.xpath("//body[1]/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]"));
    public static final Target BTN_Cart = Target.the("Seccion Carrito").located(By.xpath("//a[@id='cartur']"));
    public static final Target BTN_AddCart = Target.the("Boton agregar al carrito").located(By.xpath("//a[contains(text(),'Add to cart')]"));
    public static final Target BTN_item1 = Target.the("Item 1").located(By.xpath("//body/div[@id='contcont']/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/img[1]"));
    public static final Target txt_PrecioItem1 = Target.the("Precio item 1").located(By.xpath("//body[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h5[1]"));
    public static final Target txt_DescripcionProducto = Target.the("Descripcion item 1").located(By.xpath("//body[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]"));
    public static final Target txt_descripcion1 = Target.the("Descripcion del item 1 en el carrito").located(By.xpath("//body[1]/div[6]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]"));
    public static final Target txt_descripcion2 = Target.the("Descripcion del item 1 en el carrito").located(By.xpath("//body[1]/div[6]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[2]"));
    public static final Target BTN_PlaceOrder = Target.the("Boton Place Order").located(By.xpath("//button[contains(text(),'Place Order')]"));
}
