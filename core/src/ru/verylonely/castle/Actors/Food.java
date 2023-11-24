package ru.verylonely.castle.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Food extends Actor implements IEatable{
    public Food(Vector2 _position, String _texture)
    {
        super(_position, _texture);
    }

    @Override
    public void Eat()
    {
        Destroy();
    }
}
