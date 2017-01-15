package com.example.klusek.myapplication.Mapping;

import org.simpleframework.xml.Element;

/**
 * Created by Klusek on 15.01.2017.
 */

public class Gra {

    @Element(name = "Nazwa")
    private String nazwa;

    @Element(name = "RokWydania")
    private String rokWydania;

    @Element(name = "Gatunek")
    private String gatunek;

    @Element(name = "Cena")
    private String cena;

    @Element(name = "IlośćSztuk")
    private int iloscSztuk;

    public Gra(@Element(name = "Nazwa") String nazwa,@Element(name = "RokWydania") String rokWydania,@Element(name = "Gatunek") String gatunek,@Element(name = "Cena") String cena,@Element(name = "IlośćSztuk") int iloscSztuk) {
        this.nazwa = nazwa;
        this.rokWydania = rokWydania;
        this.gatunek = gatunek;
        this.cena = cena;
        this.iloscSztuk = iloscSztuk;
    }

    @Override
    public String toString() {
        return "Gra{" +
                "nazwa='" + nazwa + '\'' +
                ", rokWydania='" + rokWydania + '\'' +
                ", gatunek='" + gatunek + '\'' +
                ", cena='" + cena + '\'' +
                ", iloscSztuk=" + iloscSztuk +
                '}';
    }

    public String getNazwa() {

        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(String rokWydania) {
        this.rokWydania = rokWydania;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public int getIloscSztuk() {
        return iloscSztuk;
    }

    public void setIloscSztuk(int iloscSztuk) {
        this.iloscSztuk = iloscSztuk;
    }
}
