package com.example.klusek.myapplication.Mapping;

import org.simpleframework.xml.Element;

/**
 * Created by Klusek on 15.01.2017.
 */

public class ActionRolePlayingGame {
    @Element(name = "Ilość")
    private int ilosc;

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public ActionRolePlayingGame(@Element(name = "Ilość") int ilosc) {
        this.ilosc = ilosc;
    }
}
