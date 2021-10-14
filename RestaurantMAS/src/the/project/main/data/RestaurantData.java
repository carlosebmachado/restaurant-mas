package the.project.main.data;

public class RestaurantData {

    public static final int PHOTO    = 0;
    public static final int NAME     = 1;
    public static final int SCORE    = 2;
    public static final int PRICE    = 3;
    public static final int DISTANCE = 4;
    public static final int TYPE     = 5;

    // Data
    // Photo:    Inteiro representando a imagem de 0 a 15
    // Name:     String do nome
    // Score:    1 a 5 ⋆ (estrela)
    // Price:    1 a 3 $ (cifrão)
    // Distance: em quilometros utilizando vírgula (ex: 5,5km)
    // Type:     String da categoria do restaurante

    public static final String[][] data =
    {
        {
            "0",
            "Babico Pastelaria",
            "⋆⋆⋆⋆",
            "$$$",
            "8,7km",
            "Pastel"
        },
        {
            "1",
            "Restaurante Sal & Brasa",
            "⋆⋆⋆⋆⋆",
            "$$",
            "4,7km",
            "Brasileira"
        },
        {
            "2",
            "Lanchonete Old Burger",
            "⋆⋆⋆",
            "$$$",
            "3,4km",
            "Hamburguer"
        },
        {
            "3",
            "Panificadora Larissa",
            "⋆⋆⋆⋆⋆",
            "$$$",
            "2,1km",
            "Pães, tortas e doces"
        }
    };
    public static final String[][] produtoXpreco =
    {
        {
            "Pastel",
            "6.00"
        },
        {
            "Hamburguer",
            "10.00"
            
        },
        {
            "Cachorro-quente",
            "6.00"
        },
        {
            "Pizza",
            "30.00"
        }
    };
    
     public static final String[][] bairroXdistancia =
    {
        {
            "São João",
            "6"
        },
        {
            "Centro",
            "10"
            
        },
        {
            "Cidade Nova",
            "5"
        },
        {
            "Praia Brava",
            "15"
        }
    };

}
