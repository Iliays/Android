package com.example.thirdlaba;

public class Pizza {

    private double pizza_size_price;
    private double grib_price = 0;
    private double kolbasa_price = 0;
    private double salami_price = 0;
    private double ananas_price = 0;


    public Pizza(){

    }

    public double getPizza_size_price() {
        return pizza_size_price;
    }

    public void setPizza_size_price(double pizza_size_price) {
        this.pizza_size_price = pizza_size_price;
    }

    public double getGrib_price() {
        return grib_price;
    }

    public void setGrib_price(double grib_price) {
        this.grib_price = grib_price;
    }

    public double getKolbasa_price() {
        return kolbasa_price;
    }

    public void setKolbasa_price(double kolbasa_price) {
        this.kolbasa_price = kolbasa_price;
    }

    public double getSalami_price() {
        return salami_price;
    }

    public void setSalami_price(double salami_price) {
        this.salami_price = salami_price;
    }

    public double getAnanas_price() {
        return ananas_price;
    }

    public void setAnanas_price(double ananas_price) {
        this.ananas_price = ananas_price;
    }
}
