package com.example.klusek.myapplication.Mapping;

import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by Klusek on 15.01.2017.
 */


public class OgolneInformacje {

    @ElementList(name = "Autorzy", type = Autor.class)
    private List<Autor> autorzy;

    public List getAutorzy() {
        return autorzy;
    }

    public void setAutorzy(List autorzy) {
        this.autorzy = autorzy;
    }

    OgolneInformacje(){

    }

    OgolneInformacje(List<Autor> autorzy){
        this.autorzy = autorzy;
    }

    @Override
    public String toString() {
        String str = "Autorzy: \n";
        for (Object a:getAutorzy()) {
            str += a.toString() + "\n";
        }
        return str;
    }
}
