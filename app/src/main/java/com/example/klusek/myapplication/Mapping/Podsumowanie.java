package com.example.klusek.myapplication.Mapping;

import org.simpleframework.xml.Element;

/**
 * Created by Klusek on 15.01.2017.
 */

public class Podsumowanie {

    @Element(name = "Statystyki")
    private Statystyki statystyki;

    @Element(name = "DataRaportu")
    private String dataRaportu;

    public Statystyki getStatystyki() {
        return statystyki;
    }

    public void setStatystyki(Statystyki statystyki) {
        this.statystyki = statystyki;
    }

    public String getDataRaportu() {
        return dataRaportu;
    }

    public void setDataRaportu(String dataRaportu) {
        this.dataRaportu = dataRaportu;
    }

    public Podsumowanie(@Element(name = "Statystyki") Statystyki statystyki, @Element(name = "DataRaportu") String dataRaportu) {
        this.statystyki = statystyki;
        this.dataRaportu = dataRaportu;
    }

    @Override
    public String toString() {
        return "Podsumowanie:\n" +
                statystyki +
                "\n\ndataRaportu=" + dataRaportu;
    }
}
