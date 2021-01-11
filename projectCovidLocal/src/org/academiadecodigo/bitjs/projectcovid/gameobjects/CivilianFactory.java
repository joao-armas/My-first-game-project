package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.Direction;
import org.academiadecodigo.bitjs.projectcovid.field.Field;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;

public class CivilianFactory {
    private Field field;

    public CivilianFactory(Field field){
        this.field=field;
    }
    public Civilian makeCivilian(){
        double random = Math.random();

        Civilian civilianToReturn =(random < 0.5) ? new Civilian(new FieldPosition(field)) : new CivilianRapper(new FieldPosition(field));
        civilianToReturn.bootPictures();
        return civilianToReturn;

    }

    public Civilian makeCivilianLevel2(){
        double random = Math.random();

        Civilian  civilianToReturn =(random < 0.5) ? new CivilianGrandma(new FieldPosition(field)) : new CivilianPolice(new FieldPosition(field));;
        civilianToReturn.bootPictures();
        return civilianToReturn;
    }
}

