package ru.verylonely.castle.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import ru.verylonely.castle.Resources;
import ru.verylonely.castle.World;

public abstract class Actor
{
    private boolean toDestroy = false;
    protected final Vector2 position, angle;
    protected final Texture texture;
    protected final TextureRegion textureRegion;

    public Actor(Vector2 _position, String _texture) {
        position = _position;
        angle = new Vector2();
        texture = new Texture(_texture);
        textureRegion = new TextureRegion(texture);
    }

    public void render(Batch batch)
    {
        batch.draw(
                textureRegion,
                position.x,
                position.y,
                Resources.TEXTURES_SIZE_HALF,
                Resources.TEXTURES_SIZE_HALF,
                Resources.TEXTURES_SIZE,
                Resources.TEXTURES_SIZE,
                1,
                1,
                angle.angleDeg()

        );
    }

    public void dispose()
    {
        texture.dispose();
    }

    public void move(Vector2 direction, World world)
    {
        Vector2 nextPosition = new Vector2( position.x + direction.x * Resources.TEXTURES_SIZE, position.y + direction.y * Resources.TEXTURES_SIZE);

        if(CanMove(nextPosition, world))
        {
            position.add(direction.x * Resources.TEXTURES_SIZE, direction.y * Resources.TEXTURES_SIZE);
        }

        if(!direction.equals(Vector2.Zero))
        {
            angle.x = direction.y * 90;
            angle.y = direction.x * -90;
        }
    }

    public Vector2 GetPosition()
    {
        return new Vector2(position.x, position.y);
    }

    public boolean isToDestroy()
    {
        return toDestroy;
    }

    public void Destroy()
    {
        this.toDestroy = true;
    }

    private boolean CanMove(Vector2 nextPosition, World world)
    {
        if(
                nextPosition.x < world.getWidth() &&
                nextPosition.x > 0 &&
                        nextPosition.y < world.getHeight() &&
                        nextPosition.y > 0)
            return true;

        return false;
    }
}
