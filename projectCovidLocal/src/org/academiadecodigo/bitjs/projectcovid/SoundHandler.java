package org.academiadecodigo.bitjs.projectcovid;

import sound.Sound;

import java.util.HashMap;

public class SoundHandler {
    private static HashMap<String, Sound> soundHashMap;


    public SoundHandler() {

        soundHashMap = new HashMap<>();
        soundHashMap.put("shoot", new Sound("/resources/sound/Arrow2.wav"));
        soundHashMap.put("sneeze", new Sound("/resources/sound/sneeze.wav"));
        soundHashMap.put("winMenu", new Sound("/resources/sound/Win.wav"));
        soundHashMap.put("gameOver", new Sound("/resources/sound/GameOver.wav"));
        soundHashMap.put("ambientSound", new Sound("/resources/sound/ambientSound.wav"));
        soundHashMap.put("mainSound", new Sound("/resources/sound/MainMenuSound.wav"));
        soundHashMap.put("granny", new Sound("/resources/sound/GrannyCureSound.wav"));
        soundHashMap.put("sandrim", new Sound("/resources/sound/Sandrim.wav"));
        soundHashMap.put("mrT-cure", new Sound("/resources/sound/MrTCuredSound.wav"));
        soundHashMap.put("police-cure", new Sound("/resources/sound/OfficerSound.wav"));
        soundHashMap.put("cough",new Sound("/resources/sound/Cough.wav"));
        soundHashMap.put("midMenu", new Sound("/resources/sound/MidMenu.wav"));
        soundHashMap.put("loseHealth", new Sound("/resources/sound/LosingHealthUsed.wav"));
    }

    public static void playSound(String sound) {
        soundHashMap.get(sound).play(true);

    }

    public static Sound getSound(String sound) {

        return soundHashMap.get(sound);
    }

    public void closeHandler() {
        for (String sound : soundHashMap.keySet()) {
            soundHashMap.get(sound).close();
        }

    }
}
