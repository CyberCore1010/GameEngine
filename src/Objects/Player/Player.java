package Objects.Player;

import Objects.GameObject;
import Objects.Interfaces.Movable;
import Objects.Interfaces.Name;
import Objects.Interfaces.Positionable;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject implements Name, Movable, Positionable{
    private String name;
    private float x, y, z, width, height;
    private float velX = 0, velY = 0;
    private boolean movable = true, wPressed = false, aPressed = false, sPressed = false, dPressed = false;
    private BufferedImage bufferedImage;

    public Player(String name, float x, float y, float z, float width, float height) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {
        if(movable) {
            move(4);
        }
        x += velX;
        y += velY;
    }

    private void move(int walkSpeed) {
        if(wPressed) {
            velY = -walkSpeed;
        } else if(!sPressed){
            velX = 0;
        }
        if(sPressed) {
            velY = walkSpeed;
        } else if(!wPressed) {
            velY = 0;
        }
        if(aPressed) {
            velX = -walkSpeed;
        } else if(!dPressed) {
            velX = 0;
        }
        if(dPressed) {
            velX = walkSpeed;
        } else if(!aPressed) {
            velX = 0;
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.RED);
        g2d.fillRect((int)x, (int)y, (int)width, (int)height);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setMovable(boolean movable) {
        this.movable = movable;
    }

    @Override
    public void setWPressed(boolean pressed) {
        wPressed = pressed;
    }

    @Override
    public void setAPressed(boolean pressed) {
        aPressed = pressed;
    }

    @Override
    public void setSPressed(boolean pressed) {
        sPressed = pressed;
    }

    @Override
    public void setDPressed(boolean pressed) {
        dPressed = pressed;
    }
}
