/* Kevin Stubblefield
 * Last Updated: February 11, 2015
 * Known Issues: None
 */

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
    
    protected float x, y;
    protected float width, height;
    protected boolean solid;
    
    public GameObject(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public abstract void update();
    
    public abstract void render(Graphics g);
    
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, (int)width, (int)height);
    }
    
    public boolean getCollision(GameObject object) {
        return this.getBounds().intersects(object.getBounds());
    }

    public boolean isSolid() {
        return solid;
    }

    public void setSolid(boolean solid) {
        this.solid = solid;
    }
    
}
