package com.example.Controller.Domain;

import java.time.LocalDateTime;

public class City {

    public double longitud;
    public double latitud;
    public String name;
    public double id;
    public String hint1;
    public String hint2;
    public String hint3;

    public City( int id, String name, double longitud, double latitud, String hint1, String hint2, String hint3) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.name = name;
        this.id = id;
        this.hint1 =hint1;
        this.hint2 =hint2;
        this.hint3 =hint3;
    }
}

