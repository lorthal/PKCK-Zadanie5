package com.example.klusek.myapplication.Mapping;

import org.simpleframework.xml.Element;

/**
 * Created by Klusek on 15.01.2017.
 */

public class Statystyki {

    @Element(name = "GraAkcji")
    private GraAkcji graAkcji;

    @Element(name = "Platformowe")
    private Platformowe platformowe;

    @Element(name = "ActionRole-PlayingGame")
    private ActionRolePlayingGame actionRolePlayingGame;

    public GraAkcji getGraAkcji() {
        return graAkcji;
    }

    public void setGraAkcji(GraAkcji graAkcji) {
        this.graAkcji = graAkcji;
    }

    public Platformowe getPlatformowe() {
        return platformowe;
    }

    public void setPlatformowe(Platformowe platformowe) {
        this.platformowe = platformowe;
    }

    public ActionRolePlayingGame getActionRolePlayingGame() {
        return actionRolePlayingGame;
    }

    public void setActionRolePlayingGame(ActionRolePlayingGame actionRolePlayingGame) {
        this.actionRolePlayingGame = actionRolePlayingGame;
    }

    public Statystyki(@Element(name = "GraAkcji") GraAkcji graAkcji,@Element(name = "Platformowe") Platformowe platformowe,@Element(name = "ActionRole-PlayingGame") ActionRolePlayingGame actionRolePlayingGame) {
        this.graAkcji = graAkcji;
        this.platformowe = platformowe;
        this.actionRolePlayingGame = actionRolePlayingGame;
    }

    @Override
    public String toString() {
        return  "graAkcji=" + graAkcji.getIlosc() +
                "\nplatformowe=" + platformowe.getIlosc() +
                "\nactionRolePlayingGame=" + actionRolePlayingGame.getIlosc();
    }
}
