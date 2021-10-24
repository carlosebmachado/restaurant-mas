/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.app.restaurant.core.objects;

import java.io.Serializable;
import java.util.ArrayList;
import the.project.core.data.RestaurantData;

/**
 *
 * @author JF
 */
public class RequestSearch implements Serializable {
    ArrayList<Restaurant> restaurantes;
    Request preferencias;
//    String [][] bairroXdistancia = RestaurantData.bairroXdistancia;
    
    public RequestSearch(ArrayList rest, Request prefer){
        restaurantes = rest;
        preferencias = prefer;
    }
    
    public RequestSearch(Request prefer){
        restaurantes = new ArrayList<Restaurant>();
        preferencias = prefer;
    }
    
    public ArrayList<Restaurant> getRestaurantes(){
        return restaurantes;
    }
    public Request getPreferencias(){
        return preferencias;
    }
     public void setRestaurantes(ArrayList rests){
        restaurantes = rests;
    }
    public void setPreferencias(Request prefers){
        preferencias = prefers;
    }
    
//    public String[][] getDistancias(){
//        return bairroXdistancia;
//    }
}
