package com.mygdx.tilemaptest;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class Play implements Screen {

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0,0,0,1);

        renderer.setView(camera);
        renderer.render(); //takes a layers[] argument if we want to specifically render certain layers
    }

    @Override
    public void show() {
        TmxMapLoader loader = new TmxMapLoader();
        map = loader.load("test-tilemap.tmx");
        //make this one line: map = new TmxMapLoader().load(path);
        //remember to put both the map and all tilemaps in assets folder
        //also have to consider: if you create the map elsewhere (not directly in the assets folder) (and save it to desktop or something)
        //then you have to go into the .tsx files and change the filepaths of the tilemap png's

        renderer = new OrthogonalTiledMapRenderer(map); //can also take a scale argument
        camera = new OrthographicCamera(); //don't need to specify width and height because resize() is called after show()
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        map.dispose();
        renderer.dispose();
        //renderer contains it's own spritebatch so has to be disposed
    }
}
