package ru.verylonely.castle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import ru.verylonely.castle.Actors.Actor;
import ru.verylonely.castle.Actors.Food;

import java.util.ArrayList;
import java.util.Random;

public class World {

    private int width, height;

    public ArrayList<Actor> actors = new ArrayList<>();

    public World()
    {
        width = (int) (Gdx.graphics.getWidth() / 10 * 64);
        height = (int) (Gdx.graphics.getHeight() / 10 * 64);

        for(byte i = 0; i < 100; i++)
        {
            Food food = new Food(new Vector2(
                    new Random().nextInt(0, getWidth()),
                    new Random().nextInt(0, getHeight())
            ), Resources.APPLE_SPRITE);

            actors.add(food);
        }
    }

    public void DrawBackground(SpriteBatch _batch, Texture background)
    {
        for(byte x=0;x<Gdx.graphics.getWidth() / 10;x++)
            for(byte y=0;y<Gdx.graphics.getHeight() / 10;y++)
                _batch.draw(background, x * 64, y * 64);

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
