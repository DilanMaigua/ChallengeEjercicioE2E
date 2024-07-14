Feature: Comprar dos productos en la tienda Demoblaze

    @CompraProductos
    Scenario Outline: El cliente compra dos productos diferentes de la tienda
        Given el Cliente inicia la aplicación Demoblaze
        When selecciona la categoría "<category1>" y selecciona un producto de la categoría
        Then agrega el producto al carrito
        When selecciona la categoría "<category2>" y selecciona un producto de la categoría
        Then agrega el producto al carrito
        And visualiza el carrito luego genera la compra
        When ingresa los datos al formulario con nombre "<name>", país "<country>", ciudad "<city>", tarjeta de crédito "<ccard>", mes "<month>", y año "<year>"
        Then finaliza la compra y verifica la compra

        Examples:
            | category1 | category2 | name  | country | city  | ccard       | month | year |
            | Phones    | Laptops   | Dilan | Ecuador | Quito | 111114444777 | julio | 2024 |
            | Monitors  | Phones    | Jose  | Peru    | Lima  | 154871521544 | julio | 2024 |