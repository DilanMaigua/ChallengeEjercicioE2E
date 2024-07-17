Feature: Comprar dos productos en la tienda Demoblaze

    @CompraProductos
    Scenario Outline: El cliente compra dos productos diferentes de la tienda
        Given el Cliente inicia la aplicación Demoblaze
        When selecciona la categoría "<jsonCategory>" y selecciona un producto de la categoría
        Then agrega el producto al carrito
        When selecciona la categoría "<jsonCategory>" y selecciona un producto de la categoría
        Then agrega el producto al carrito
        And visualiza el carrito luego genera la compra
        When ingresa los datos al formulario "<jsonDatos>"
        Then finaliza la compra y verifica la compra

        Examples:
            | jsonCategory | jsonDatos |
            |  {\"category1\": \"Laptops\", \"category2\": \"Phones\", \"category3\": \"Monitors\"} | {\"name\": \"Dilan\", \"country\": \"Ecuador\", \"city\": \"Quito\", \"ccard\": \"111114444777\", \"month\": \"julio\", \"year\": \"2024\"} |
            |  {\"category1\": \"Laptops\", \"category2\": \"Phones\", \"category3\": \"Monitors\"} | {\"name\": \"Dilan\", \"country\": \"Ecuador\", \"city\": \"Quito\", \"ccard\": \"111114444777\", \"month\": \"julio\", \"year\": \"2024\"} |
