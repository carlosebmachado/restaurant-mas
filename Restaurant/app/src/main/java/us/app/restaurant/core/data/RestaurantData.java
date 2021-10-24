package us.app.restaurant.core.data;

import us.app.restaurant.core.objects.Restaurant;

public class RestaurantData {

    // Data
    // Photo:    Inteiro representando a imagem de 0 a 15
    // Name:     String do nome
    // Score:    1 a 5 ⋆ (estrela)
    // Price:    1 a 3 $ (cifrão)
    // Distance: em quilometros utilizando vírgula (ex: 5,5km)
    // Type:     String da categoria do restaurante

    public static final Restaurant[] data =
    {
        new Restaurant(
            "0",
            "Babico Pastelaria",
            "⋆⋆⋆⋆",
            "$$$",
            "8.7",
            "Pastel"
        ),
        new Restaurant(
            "1",
            "Restaurante Sal & Brasa",
            "⋆⋆⋆⋆⋆",
            "$$",
            "4.7",
            "Brasileira"
        ),
        new Restaurant(
            "2",
            "Lanchonete Old Burger",
            "⋆⋆⋆",
            "$$$",
            "3.4",
            "Hamburguer"
        ),
        new Restaurant(
            "3",
            "Panificadora Larissa",
            "⋆⋆⋆⋆⋆",
            "$$$",
            "2.1",
            "Pães, tortas e doces"
        ),
        new Restaurant(
            "4",
            "Panificadora Pão Doce",
            "⋆⋆",
            "$",
            "2.1",
            "Pães, tortas e doces"
        )
    };

}
