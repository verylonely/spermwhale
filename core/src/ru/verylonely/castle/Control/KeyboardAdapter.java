package ru.verylonely.castle.Control;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

public class KeyboardAdapter extends InputAdapter
{
    private boolean leftPressed, rightPressed, upPressed, downPressed;

    @Override
    public boolean keyDown(int keycode)
    {
        if(keycode == Input.Keys.A) leftPressed = true;
        if(keycode == Input.Keys.D) rightPressed = true;
        if(keycode == Input.Keys.W) upPressed = true;
        if(keycode == Input.Keys.S) downPressed = true;

        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        if(keycode == Input.Keys.A) leftPressed = false;
        if(keycode == Input.Keys.D) rightPressed = false;
        if(keycode == Input.Keys.W) upPressed = false;
        if(keycode == Input.Keys.S) downPressed = false;

        return false;
    }

    public Vector2 GetDirection()
    {
        Vector2 direction = new Vector2();

        if(leftPressed) direction.set(-1, 0);
        else if(rightPressed) direction.set(1,0);
        else if (upPressed) direction.set(0,1);
        else if(downPressed) direction.set(0,-1);

        return direction;
    }

}
