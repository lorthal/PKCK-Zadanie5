package com.example.klusek.myapplication.Mapping;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Klusek on 15.01.2017.
 */

@Root
public class Gry {

    @Element(name = "OgólneInformacje")
    private OgolneInformacje ogolneInformacje;

    @ElementList(name = "ListaFirm", type = Firma.class)
    private List<Firma> listaFirm;

    @Element(name = "Podsumowanie")
    private Podsumowanie podsumowanie;

    public Podsumowanie getPodsumowanie() {
        return podsumowanie;
    }

    public void setPodsumowanie(Podsumowanie podsumowanie) {
        this.podsumowanie = podsumowanie;
    }

    public OgolneInformacje getOgolneInformacje() {
        return ogolneInformacje;
    }

    public void setOgolneInformacje(OgolneInformacje ogolneInformacje) {
        this.ogolneInformacje = ogolneInformacje;
    }

    public List<Firma> getListaFirm() {
        return listaFirm;
    }

    public void setListaFirm(List<Firma> listaFirm) {
        this.listaFirm = listaFirm;
    }

    Gry(@Element(name = "OgólneInformacje") OgolneInformacje ogolneInformacje, @Element(name = "Podsumowanie") Podsumowanie podsumowanie) {
        this.ogolneInformacje = ogolneInformacje;
        this.podsumowanie = podsumowanie;
    }

    @Override
    public String toString() {
        String str = ogolneInformacje.toString();
        str += "\nFirmy: \n";

        for (Object f:listaFirm) {
            str += f + "\n";
        }

        str += "\n" + podsumowanie;
        return str;
    }
}
