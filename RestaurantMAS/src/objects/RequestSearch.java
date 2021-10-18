/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.ArrayList;
import the.project.main.data.RestaurantData;

/**
 *
 * @author JF
 */
public class RequestSearch {
    ArrayList<Restaurante> restaurantes;
    String [][] preferencias;
    String [][] bairroXdistancia = RestaurantData.bairroXdistancia;
    
    RequestSearch(ArrayList rest, String[][] prefer){
        restaurantes = rest;
        preferencias = prefer;
    }
    
    public ArrayList getRestaurantes(){
        return restaurantes;
    }
    public String[][] getPreferencias(){
        return preferencias;
    }
     public void setRestaurantes(ArrayList rests){
        restaurantes = rests;
    }
    public void setPreferencias(String[][] prefers){
        preferencias = prefers;
    }
    
    public String[][] getDistancias(){
        return bairroXdistancia;
    }
}
