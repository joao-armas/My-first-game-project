package org.academiadecodigo.bitjs.projectcovid.gameobjects;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CivilianRapper extends Civilian {

    public CivilianRapper(FieldPosition fieldPosition){
        super(fieldPosition);

    }



    @Override
    public void bootPictures(){
        super.setInfectedPictureDown(new Picture(0,0, "resources/Images/Civilians2/civilianUpInfected2.png"));
        super.setInfectedPictureLeft(new Picture(0,0, "resources/Images/Civilians2/civilianLeftInfected2.png"));
        super.setInfectedPictureRight(new Picture(0,0, "resources/Images/Civilians2/civilianRightInfected2.png"));
        super.setInfectedPictureUp(new Picture(0,0, "resources/Images/Civilians2/civilianDownInfected2.png"));
        super.setCivilianPictureUp(new Picture(0,0, "resources/Images/Civilians2/civilianDown2.png"));
        super.setCivilianPictureDown(new Picture(0,0, "resources/Images/Civilians2/civilianUp2.png"));
        super.setCivilianPictureLeft(new Picture(0,0, "resources/Images/Civilians2/civilianLeft2.png"));
        super.setCivilianPictureRight(new Picture(0,0, "resources/Images/Civilians2/civilianRight2.png"));
        super.setActualPicture(super.getCivilianPictureDown());
    }
}
