Feature: Comprar dos productos en la tienda Demoblaze

    @CompraProductos
    Scenario Outline: El cliente compra dos productos diferentes de la tienda
        Given el Cliente inicia la aplicación Demoblaze
        When selecciona la categoría "<jsonCategory>" y selecciona un producto de la categoría
        Then agrega el producto al carrito
        When selecciona la categoría "<jsonCategory>" y selecciona un producto de la categoría
        Then agrega el producto al carrito
        And visualiza el carrito luego genera la compra
        When ingresa los datos del indice <index> al formulario "<jsonDatos>"
        Then finaliza la compra y verifica la compra

        Examples:
            | jsonCategory | index  | jsonDatos |
            |  archivosJson/jsonCategory.json | 0 | archivosJson/ejemploDatos.json |
            |  archivosJson/jsonCategory.json | 1 | archivosJson/ejemploDatos.json |
