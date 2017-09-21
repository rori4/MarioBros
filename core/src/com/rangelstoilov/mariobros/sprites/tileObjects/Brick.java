package com.rangelstoilov.mariobros.sprites.tileObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.rangelstoilov.mariobros.MarioBros;
import com.rangelstoilov.mariobros.scenes.Hud;
import com.rangelstoilov.mariobros.screens.PlayScreen;
import com.rangelstoilov.mariobros.sprites.Mario;

public class Brick extends InteractiveTileObject{
    public Brick(PlayScreen screen, MapObject object) {
        super(screen, object);
        fixture.setUserData(this);
        setCategoryFilter(MarioBros.BRICK_BIT);
    }

    @Override
    public void onHeadHit(Mario mario) {
        if (mario.isBig()){
            Gdx.app.log("Brick","Collision");
            setCategoryFilter(MarioBros.DESTROYED_BIT);
            getCell().setTile(null);
            Hud.addScore(200);
            MarioBros.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
        }
        MarioBros.manager.get("audio/sounds/bump.wav", Sound.class).play();

    }
}
