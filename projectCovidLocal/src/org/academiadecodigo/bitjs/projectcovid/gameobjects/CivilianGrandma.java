package org.academiadecodigo.bitjs.projectcovid.gameobjects;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;

public class CivilianGrandma extends Civilian{


    public CivilianGrandma(FieldPosition fieldPosition){
        super(fieldPosition);

    }



    @Override
    public void bootPictures(){
        super.setInfectedPictureUp(new Picture(0,0, "resources/Images/CivilianGrandma/grandmaUpInfected.png"));
        super.setInfectedPictureDown(new Picture(0,0, "resources/Images/CivilianGrandma/grandmaDownInfected.png"));
        super.setInfectedPictureLeft(new Picture(0,0, "resources/Images/CivilianGrandma/grandmaLeftInfected.png"));
        super.setInfectedPictureRight(new Picture(0,0, "resources/Images/CivilianGrandma/grandmaRightInfected.png"));
        super.setCivilianPictureUp(new Picture(0,0, "resources/Images/CivilianGrandma/grandmaUp.png"));
        super.setCivilianPictureDown(new Picture(0,0, "resources/Images/CivilianGrandma/grandmaDown.png"));
        super.setCivilianPictureLeft(new Picture(0,0, "resources/Images/CivilianGrandma/grandmaLeft.png"));
        super.setCivilianPictureRight(new Picture(0,0, "resources/Images/CivilianGrandma/grandmaRight.png"));

        super.setActualPicture(super.getCivilianPictureDown());
    }
}

