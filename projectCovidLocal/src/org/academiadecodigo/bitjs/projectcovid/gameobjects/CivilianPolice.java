package org.academiadecodigo.bitjs.projectcovid.gameobjects;

import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class CivilianPolice extends Civilian{

    public CivilianPolice(FieldPosition fieldPosition){
        super(fieldPosition);

    }



    @Override
    public void bootPictures(){
        super.setInfectedPictureUp(new Picture(0,0, "resources/Images/CivilianPolice/policeUpInfected.png"));
        super.setInfectedPictureDown(new Picture(0,0, "resources/Images/CivilianPolice/policeDownInfected.png"));
        super.setInfectedPictureLeft(new Picture(0,0, "resources/Images/CivilianPolice/policeLeftInfected.png"));
        super.setInfectedPictureRight(new Picture(0,0, "resources/Images/CivilianPolice/policeRightInfected.png"));
        super.setCivilianPictureUp(new Picture(0,0, "resources/Images/CivilianPolice/policeUp.png"));
        super.setCivilianPictureDown(new Picture(0,0, "resources/Images/CivilianPolice/policeDown.png"));
        super.setCivilianPictureLeft(new Picture(0,0, "resources/Images/CivilianPolice/policeLeft.png"));
        super.setCivilianPictureRight(new Picture(0,0, "resources/Images/CivilianPolice/policeRight.png"));

        super.setActualPicture(super.getCivilianPictureDown());
    }
}
