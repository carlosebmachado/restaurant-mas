/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author JF
 */
public class Restaurante {
    public String nome = "Babico Pastelaria";
    public String score = "⋆⋆⋆⋆";
    public String medPrc = "$$$";
    public String distancia = "8.7";
    public String TipoComida = "Pastel";
    public String [][] comidaXpreco;
    
    public Restaurante(String name, String scor, String medPrec, String dist, String [][] foodxPrice){
        nome = name;
        score = scor;
        medPrc = medPrec;
        distancia = dist;
        comidaXpreco = foodxPrice;
    }
}
