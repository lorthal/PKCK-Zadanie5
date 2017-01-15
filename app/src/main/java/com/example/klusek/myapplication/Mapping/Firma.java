package com.example.klusek.myapplication.Mapping;


import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by Klusek on 15.01.2017.
 */

public class Firma {

    @Element(name = "Nazwa")
    private String nazwa;

    @Element(name = "Lokalizacja")
    private String lokalizacja;

    @Element(name = "DataZałożenia")
    private int dataZalozenia;

    @ElementList(name = "ListaGier", type = Gra.class, entry = "Gra")
    private List<Gra> listaGier;

    public Firma(@Element(name = "Nazwa") String nazwa,@Element(name = "Lokalizacja") String lokalizacja,@Element(name = "DataZałożenia") int dataZalozenia) {
        this.nazwa = nazwa;
        this.lokalizacja = lokalizacja;
        this.dataZalozenia = dataZalozenia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getLokalizacja() {
        return lokalizacja;
    }

    public void setLokalizacja(String lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public int getDataZalozenia() {
        return dataZalozenia;
    }

    @Override
    public String toString() {
        String str = nazwa + ", " + lokalizacja + " " + dataZalozenia + "    \nLista Gier:\n";
        for (Object g:listaGier) {
            str += "    " + g.toString() + "\n";
        }
        return str;
    }

    public void setDataZalozenia(int dataZalozenia) {
        this.dataZalozenia = dataZalozenia;
    }

    public List<Gra> getListaGier() {
        return listaGier;
    }

    public void setListaGier(List<Gra> listaGier) {
        this.listaGier = listaGier;
    }


}
