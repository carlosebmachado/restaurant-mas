/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.app.restaurant.core.objects;

import java.io.Serializable;

/**
 *
 * @author JF
 */
public class Restaurant implements Serializable {

    private String image;
    private String name;
    private String score;
    private String price;
    private String distance;
    private String type;

    public Restaurant(String image, String name, String score, String price, String distance, String type) {
        this.image = image;
        this.name = name;
        this.score = score;
        this.price = price;
        this.distance = distance;
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
