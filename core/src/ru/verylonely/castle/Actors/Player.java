package ru.verylonely.castle.Actors;

import com.badlogic.gdx.math.Vector2;
import ru.verylonely.castle.Control.KeyboardAdapter;
import ru.verylonely.castle.Resources;

public class Player extends Actor{

    public Player(Vector2 _start)
    {
        super(_start, Resources.PLAYER_SPRITE);
    }
}
