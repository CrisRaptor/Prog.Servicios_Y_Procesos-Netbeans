/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crisgc.test;

import java.util.ArrayList;

/**
 *
 * @author CrisGC
 */
public class Cat {

    ArrayList<Breed> breeds = new ArrayList<Breed>();
    private String id;
    private String url;
    private float width;
    private float height;

    // Getter Methods 
    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    // Setter Methods 
    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cat{" + "breeds=" + breeds.toString() + ", id=" + id + ", url=" + url + ", width=" + width + ", height=" + height + '}';
    }
}
