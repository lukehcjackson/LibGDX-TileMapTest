package com.mygdx.tilemaptest.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite {
    //movement velocity - Vector2 stores 2 values, for x and y
    private Vector2 velocity = new Vector2();
    private float speed = 120;
    private float gravity = 1;

    public Player(Sprite playerSprite) {
        //call super constructor - i.e. the constructor of the Sprite class, which takes the player sprite as an argument
        super(playerSprite);

    }

    public void draw(Batch spritebatch) {
        update(Gdx.graphics.getDeltaTime());
        super.draw(spritebatch);
    }

    public void update(float delta) {
        //apply gravity
        velocity.y -= gravity * delta;
        //clamp velocity - because otherwise it's y will become massively negative as we subtract from it every frame
        if (velocity.y > speed) {
            velocity.y = speed;
        } else if (velocity.y < speed) {
            velocity.y = -speed;
        }

        //apply velocity to the player's position
        setX(getX() + velocity.x * delta);
        setY(getY() + velocity.y * delta);
    }

    public Vector2 getPlayerPos() {
        return new Vector2(getX(),getY());
    }

}
