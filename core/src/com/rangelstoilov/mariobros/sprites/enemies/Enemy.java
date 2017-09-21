package com.rangelstoilov.mariobros.sprites.enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.rangelstoilov.mariobros.screens.PlayScreen;
import com.rangelstoilov.mariobros.sprites.Mario;

public abstract class Enemy extends Sprite {
    protected World world;
    protected PlayScreen screen;
    public Body b2body;
    public Vector2 velocity;

    public Enemy(PlayScreen screen,float x, float y){
        this.world = screen.getWorld();
        this.screen = screen;
        setPosition(x,y);
        defineEnemy();
        velocity = new Vector2(1,0);
        b2body.setActive(false);
    }
    protected abstract void defineEnemy();
    public abstract void update(float dt);
    public abstract void hitOnHead(Mario mario);
    public abstract void onEnemyHit(Enemy userData);


    public void reverceVelocity(boolean x, boolean y){
        if (x)
            velocity.x = -velocity.x;
        if(y)
            velocity.y = -velocity.y;
    }

}