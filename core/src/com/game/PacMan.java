package com.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PacMan extends ApplicationAdapter {
	public SpriteBatch batch;
	boolean isInit;
	
	public GameMap map;
	Panel panel;
	Player player;
	public int viewWidth;
	public int viewHeight;
	
	@Override
	public void create () {
		viewWidth = 720;
		viewHeight= 820;
		Gdx.graphics.setWindowedMode(viewWidth, viewHeight); //24*24 30*30
		batch = new SpriteBatch();
		map = new GameMap(this);
		map.loadMap("map.png");
		panel = new Panel(this);
		player = new Player(this);
		this.isInit = false;
	}
	
	
	
	public void init(){

	}

	@Override
	public void render () {
		update();
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		map.draw();
		player.draw();
		panel.draw();
		batch.end();
	}
	
	public void update(){
		if(!isInit){
			init();
			isInit = true;
		}
	}
	
	
	@Override
	public void dispose () {
		batch.dispose();
		map.dispose();
		panel.dispose();
		player.dispose();
	}
}
