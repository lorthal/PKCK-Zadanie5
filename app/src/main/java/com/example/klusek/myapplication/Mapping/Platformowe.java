package com.example.klusek.myapplication.Mapping;

import org.simpleframework.xml.Element;

/**
 * Created by Klusek on 15.01.2017.
 */

public class Platformowe {
    @Element(name = "Ilość")
    private int ilosc;

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(@Element(name = "Ilość") int ilosc) {
        this.ilosc = ilosc;
    }

    public Platformowe(@Element(name = "Ilość") int ilosc) {
        this.ilosc = ilosc;
    }
}
