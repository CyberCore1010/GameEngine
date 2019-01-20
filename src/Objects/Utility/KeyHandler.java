package Objects.Utility;

import Objects.GameObject;
import Objects.Interfaces.Movable;
import Objects.Player.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {
    private ObjectHandler objectHandler;
    private Movable movable;

    /**
     * @param objectHandler - takes the object handler as a parameter so it can set variables in it.
     */
    public KeyHandler(ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(movable == null) {
            for(GameObject object : objectHandler.objects) {
                Player playerObject = (Player)object;
                if(playerObject.getName().equals("Player")) {
                   movable = (Player)object;
                }
            }
        }

        if(key == KeyEvent.VK_W) {
            if(movable != null) {
                movable.setWPressed(true);
            }
        }
        if(key == KeyEvent.VK_A) {
            if(movable != null) {
                movable.setAPressed(true);
            }
        }
        if(key == KeyEvent.VK_S) {
            if(movable != null) {
                movable.setSPressed(true);
            }
        }
        if(key == KeyEvent.VK_D) {
            if(movable != null) {
                movable.setDPressed(true);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            if(movable != null) {
                movable.setWPressed(false);
            }
        }
        if(key == KeyEvent.VK_A) {
            if(movable != null) {
                movable.setAPressed(false);
            }
        }
        if(key == KeyEvent.VK_S) {
            if(movable != null) {
                movable.setSPressed(false);
            }
        }
        if(key == KeyEvent.VK_D) {
            if(movable != null) {
                movable.setDPressed(false);
            }
        }
    }
}
