package the.project.core.data;

import the.project.core.objects.Restaurant;

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
            "Babico Pastelaria",
            "⋆⋆⋆⋆",
            "$$$",
            "8.7",
            "Pastel"
        ),
        new Restaurant(
            "Restaurante Sal & Brasa",
            "⋆⋆⋆⋆⋆",
            "$$",
            "4.7",
            "Brasileira"
        ),
        new Restaurant(
            "Lanchonete Old Burger",
            "⋆⋆⋆",
            "$$$",
            "3.4",
            "Hamburguer"
        ),
        new Restaurant(
            "Panificadora Larissa",
            "⋆⋆⋆⋆⋆",
            "$$$",
            "2.1",
            "Pães, tortas e doces"
        ),
        new Restaurant(
            "Panificadora Pão Doce",
            "⋆⋆",
            "$",
            "2.1",
            "Pães, tortas e doces"
        )
    };

//    public static final String[][] produtoXpreco =
//    {
//        {
//            "Pastel",
//            "6.00"
//        },
//        {
//            "Hamburguer",
//            "10.00"
//            
//        },
//        {
//            "Cachorro-quente",
//            "6.00"
//        },
//        {
//            "Pizza",
//            "30.00"
//        }
//    };
//    
//     public static final String[][] bairroXdistancia =
//    {
//        {
//            "São João",
//            "6"
//        },
//        {
//            "Centro",
//            "10"
//            
//        },
//        {
//            "Cidade Nova",
//            "5"
//        },
//        {
//            "Praia Brava",
//            "15"
//        }
//    };

}
