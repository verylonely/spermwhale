package ru.verylonely.castle;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import ru.verylonely.castle.Actors.*;
import ru.verylonely.castle.Control.KeyboardAdapter;

import java.util.ArrayList;
import java.util.Random;


public class CastleGame extends ApplicationAdapter {
	SpriteBatch batch;
	ArrayList<Actor> actorList;
	Player player;
	Texture background;
	KeyboardAdapter keyboardAdapter;
	OrthographicCamera camera;

	World world;

	int score;
	
	@Override
	public void create () {
		world = new World();

		camera = new OrthographicCamera(1, (float) Gdx.graphics.getHeight() / Gdx.graphics.getWidth());

		batch = new SpriteBatch();
		keyboardAdapter = new KeyboardAdapter();

		Gdx.input.setInputProcessor(keyboardAdapter);

		player = new Player(new Vector2(new Random().nextInt(0, world.getWidth()), new Random().nextInt(0, world.getHeight())));

		world.actors.add(player);


		background = new Texture(Resources.BACKGROUND_SPRITE);
	}

	@Override
	public void render () {
		ScreenUtils.clear(Color.BLACK);

		camera.position.x = player.GetPosition().x + Resources.TEXTURES_SIZE_HALF;
		camera.position.y = player.GetPosition().y + Resources.TEXTURES_SIZE_HALF;
		camera.zoom = 150;
		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		player.move(keyboardAdapter.GetDirection(), world);

		world.DrawBackground(batch, background);

		for (Actor actor: world.actors)
		{
			if(actor.isToDestroy())
			{
				actor.dispose();
				world.actors.remove(actor);
			}
			else
				actor.render(batch);
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		for (Actor actor: actorList)
		{
			actor.dispose();
		}
	}


}
