//Carlos Peña III last updated: 02/19/2015
import java.io.*;
import javax.sound.sampled.*;


public enum Music {
    LevelMusic1("The Asteriod Field.wav"),
    LevelMusic2("Anakin vs. Obi-Wan.wav"),
    LevelMusic3("Battle of the Heroes.wav"),
    LevelMusic4("Tie Fighter Attack.wav"),
    Boss("Duel of the Fates.wav");

    public enum Volume{
        Mute, Low, Medium, High
    }
    public static Volume volume = Volume.Low;
    private Clip clip;
    public static int track = 1; //keeps track of what track is playing
    public static boolean bossFight = false;
    
    Music(String musicfile) {
        try {
            File sound = new File(musicfile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(sound);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        } catch(UnsupportedAudioFileException e){
            System.out.println("Unsupported audio file");
        } catch(IOException e){
            System.out.println("IO Exception");
        } catch(LineUnavailableException e){
            System.out.println("Line Unavailable");
        }
    }
    
    public void play() {
        if(volume != Volume.Mute) {
            if(clip.isRunning()) {
                clip.stop();
            }
            clip.setFramePosition(0);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
    public void next() {
        if(track == 4){
            track = 1;
        }
        else{
            track++;
        }
        switch(track) {
            case 1:
                LevelMusic1.play();
                break;
            case 2:
                LevelMusic2.play();
                break;
            case 3:
                LevelMusic3.play();
                break;
            case 4:
                LevelMusic4.play();
                break;
        }
    }
    public void Mute() {
        clip.stop();
    }
    
    static void init() {
        values();
    }
}