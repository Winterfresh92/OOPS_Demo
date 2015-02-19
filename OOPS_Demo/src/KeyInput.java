
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    
    private static boolean right = false;
    private static boolean left = false;
    private static boolean up = false;
    private static boolean down = false;
    
    private GameData gameData;
    
    public KeyInput(GameData gameData){
        this.gameData = gameData;
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                right = true;
            }
        } 
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
            if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                left = true;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
            if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                up = true;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
            if(gameData.getTextBoxQueue().isEmpty() || !gameData.getTextBoxQueue().peek().isPriority()) {
                down = true;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(!gameData.getTextBoxQueue().isEmpty()) {
                gameData.getTextBoxQueue().poll();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_1) {
            gameData.start = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_M) { //Mute/next track
            if(Music.volume == Music.Volume.Mute) {
                       Music.volume = Music.Volume.Low;
                       if(Music.bossFight == true) {
                           Music.Boss.play();
                       }
                       else {
                           switch (Music.track) {
                               case 1:
                                   Music.LevelMusic1.next();
                                   break;
                               case 2:
                                   Music.LevelMusic2.next();
                                   break;
                               case 3:
                                   Music.LevelMusic3.next();
                                   break;
                               case 4:
                                   Music.LevelMusic4.next();
                                   break;
                           }
                       }
                   }
                   else{
                       Music.volume = Music.Volume.Mute;
                       if (Music.bossFight == true) {
                           Music.Boss.Mute();
                       }
                       switch(Music.track) {
                           case 1:
                               Music.LevelMusic1.Mute();
                               break;
                           case 2:
                               Music.LevelMusic2.Mute();
                               break;
                           case 3:
                               Music.LevelMusic3.Mute();
                               break;
                           case 4:
                               Music.LevelMusic4.Mute();
                               break;
                       }
                   }
               }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            left = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
          up = false;
       }
       if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
          down = false;

       }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    public static boolean isRight() {
        return right;
    }

    public static void setRight(boolean right) {
        KeyInput.right = right;
    }

    public static boolean isLeft() {
        return left;
    }

    public static void setLeft(boolean left) {
        KeyInput.left = left;
    }

    public static boolean isUp() {
        return up;
    }

    public static void setUp(boolean up) {
        KeyInput.up = up;
    }

    public static boolean isDown() {
        return down;
    }

    public static void setDown(boolean down) {
        KeyInput.down = down;
    }
    
}
