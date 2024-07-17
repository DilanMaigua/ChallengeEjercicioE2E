package com.example.questions.web;
import static com.example.userinterfaces.pages.DemoblazeHomePage.*;
import static com.example.userinterfaces.pages.DemoblazePlaceOrder.*;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class DemoblazeQ {

    public static Question<String> valorProducto(){
        return actor -> TextContent.of(txt_PrecioItem1).answeredBy(actor);
    }

    public static Question<String> descripcionProducto(){
        return actor -> TextContent.of(txt_DescripcionProducto).answeredBy(actor);
    }

    public static Question<String> descripcionOrdenCompra(){
        return actor -> TextContent.of(txt_Informacion).answeredBy(actor);
    }

}
