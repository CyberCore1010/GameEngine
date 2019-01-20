package Objects.Utility;

import Objects.GameObject;
import Objects.Player.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {
    private ObjectHandler objectHandler;
    private Player player;

    /**
     * @param objectHandler - takes the object handler as a parameter so it can set variables in it.
     */
    public KeyHandler(ObjectHandler objectHandler) {
        this.objectHandler = objectHandler;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if(player == null) {
            for(GameObject object : objectHandler.objects) {
                Player playerObject = (Player)object;
                if(playerObject.getName().equals("Player")) {
                    player = (Player)object;
                }
            }
        }

        if(key == KeyEvent.VK_W) {
            if(player != null) {
                player.setWPressed(true);
            }
        }
        if(key == KeyEvent.VK_A) {
            if(player != null) {
                player.setAPressed(true);
            }
        }
        if(key == KeyEvent.VK_S) {
            if(player != null) {
                player.setSPressed(true);
            }
        }
        if(key == KeyEvent.VK_D) {
            if(player != null) {
                player.setDPressed(true);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_W) {
            if(player != null) {
                player.setWPressed(false);
            }
        }
        if(key == KeyEvent.VK_A) {
            if(player != null) {
                player.setAPressed(false);
            }
        }
        if(key == KeyEvent.VK_S) {
            if(player != null) {
                player.setSPressed(false);
            }
        }
        if(key == KeyEvent.VK_D) {
            if(player != null) {
                player.setDPressed(false);
            }
        }
    }
}
