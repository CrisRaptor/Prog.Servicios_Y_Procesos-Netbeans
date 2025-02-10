package com.crisgc.exament4;

/**
 *
 * @author CrisGC
 */
public class Product {
    int id;
    String title, description, category, image;
    double price;
    Rating rating;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public Rating getRating() {
        return rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
    
    
}
