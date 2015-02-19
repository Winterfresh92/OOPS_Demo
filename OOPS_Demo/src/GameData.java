/* Kevin Stubblefield
 * Last Updated: February 12, 2015
 * Known Bugs: None
 */

import java.util.LinkedList;

// Handles all updates in the game and holds all data
public class GameData {
    
    private Game game;
    private TextBox textBox;
    private LinkedList<TextBox> textBoxQueue;
    private Player player;
    private Tree tree;
    
    private boolean collided = false;
    public boolean start = false;
    
    public GameData(Game game) {
        this.game = game;
        player = new Player(100, 100, 24, 24);
        tree = new Tree(500, 500, 48, 48);
        textBoxQueue = new LinkedList<>();        
    }
    
    // All updates will go here
    public void update() {
        if(start) {
            textBox = new TextBox(Game.WIDTH / 10, Game.HEIGHT - Game.HEIGHT / 3, 0, 0, "this is a textbox\nThis text is on a new line");
            textBoxQueue.offer(textBox);
            textBox = new TextBox(Game.WIDTH / 10, Game.HEIGHT - Game.HEIGHT / 3, 0, 0, "You can move with this\ntextbox in place");
            textBox.setPriority(false);
            textBoxQueue.offer(textBox);
            textBox = new TextBox(Game.WIDTH / 10, Game.HEIGHT - Game.HEIGHT / 3, 0, 0, "this is a textbox\nthat contains italics", true);
            textBoxQueue.offer(textBox);
            Music.LevelMusic1.play();
            start = false;
        }
        //textBox.update();
        player.update();
        tree.update();
        if(player.getCollision(tree) && !collided) {
            textBox = new TextBox(Game.WIDTH / 10, Game.HEIGHT - Game.HEIGHT / 3, 0, 0, "YOU HAVE COLLI\nDED!!", true);
            textBox.setPriority(false);
            textBoxQueue.offer(textBox);
            collided = true;
        }
        if(!player.getCollision(tree)) {
            collided = false;
        }
    }
    
    public Tree getTree() {
        return tree;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public TextBox getTextBox() {
        return textBox;
    }

    public void setTextBox(TextBox textBox) {
        this.textBox = textBox;
    }

    public LinkedList<TextBox> getTextBoxQueue() {
        return textBoxQueue;
    }

    public void setTextBoxQueue(LinkedList<TextBox> textBoxQueue) {
        this.textBoxQueue = textBoxQueue;
    }
    
}

