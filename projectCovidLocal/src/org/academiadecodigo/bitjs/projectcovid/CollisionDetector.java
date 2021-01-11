package org.academiadecodigo.bitjs.projectcovid;

import org.academiadecodigo.bitjs.projectcovid.field.BulletFieldPosition;
import org.academiadecodigo.bitjs.projectcovid.field.FieldPosition;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Civilian;
import org.academiadecodigo.bitjs.projectcovid.gameobjects.Player;

public class CollisionDetector {

    private static Civilian[] civilians;
    private static Player player;

    // especie de paredes   private Wall[] walls   para testar se as balas ou nós batemos nas paredes
    // Falta parametros aqui ainda nao tinha as outras coisas para testar

    public static void setCivilians(Civilian[] civiliansArray) {
        civilians = civiliansArray;
    }

    public static void setPlayer(Player player1) {
        player = player1;
    }

    public static void checkInfections() {
        for (int i = 0; i < civilians.length; i++) {
            if (civilians[i].isInfected()) {
                if (checkForPlayerInRange(1,civilians[i].getFieldPosition())){
                    if(player.getPlayerImmunity()==0) {
                        player.setHealth(player.getHealth() - 1);
                        SoundHandler.playSound("loseHealth");
                        player.setPlayerImmunity(3);
                    }
                }
                Civilian civilianToInfect = checkForCivilianInRange(1, civilians[i].getFieldPosition());
                if (civilianToInfect != null) {
                    double random = Math.random();
                    if(random<0.5){ SoundHandler.playSound("sneeze");
                    }else {SoundHandler.playSound("cough");}
                    civilianToInfect.infect();
                }

            }
        }
    }

    public static boolean checkBulletHit(BulletFieldPosition bulletFieldPosition) {

        for (int j = 0; j < civilians.length; j++) {
            if (civilians[j].isInfected()) {
                int col = civilians[j].getFieldPosition().getCol();
                int row = civilians[j].getFieldPosition().getRow();
                if (bulletFieldPosition.equals(col, row)) {
                    civilians[j].cure();
                    civilians[j].showAccordingToDirection();
                    bulletFieldPosition.getBullet().getBullet().delete();
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean checkMovement(int col, int row) {
        for (int i = 0; i < civilians.length; i++) {
            if (civilians[i].getFieldPosition().getCol() == col && civilians[i].getFieldPosition().getRow() == row) {
                return false;
            }
        }
        if (player.getFieldPosition().getCol() == col && player.getFieldPosition().getRow() == row) {
            return false;
        }
        return true;


    }


    private static Civilian checkForCivilianInRange(int range, FieldPosition position1) {

        for (int i = 1; i <= range; i++) {
            if (isCivilianHere(position1.getCol() + i, position1.getRow()) != null) {
                return isCivilianHere(position1.getCol() + i, position1.getRow());
            }
            if (isCivilianHere(position1.getCol() - i, position1.getRow()) != null) {
                return isCivilianHere(position1.getCol() - i, position1.getRow());
            }
            if (isCivilianHere(position1.getCol(), position1.getRow() + i) != null) {
                return isCivilianHere(position1.getCol(), position1.getRow() + i);
            }
            if (isCivilianHere(position1.getCol(), position1.getRow() - i) != null) {
                return isCivilianHere(position1.getCol(), position1.getRow() - i);
            }
        }
        return null;
    }

    private static boolean checkForPlayerInRange(int range, FieldPosition position){
        for (int i = 1; i <= range; i++) {
            if (isPlayerHere(position.getCol() + i, position.getRow())) {
                return true;
            }
            if (isPlayerHere(position.getCol() - i, position.getRow())) {
                return true;
            }
            if (isPlayerHere(position.getCol() , position.getRow()+i)) {
                return true;
            }
            if (isPlayerHere(position.getCol() , position.getRow()-i)) {
                return true;
            }
        }
        return false;
    }


    private static Civilian isCivilianHere(int col, int row) {

        for (int i = 0; i < civilians.length; i++) {

            if (civilians[i].getFieldPosition().getCol() == col && civilians[i].getFieldPosition().getRow() == row) {
                return civilians[i];
            }
        }
        return null;
    }
    private static boolean isPlayerHere(int col,int row){
        if (player.getFieldPosition().getCol()==col && player.getFieldPosition().getRow()== row){
            return true;
        }
        return false;
    }
}
