package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class GameMap {
	private PacMan pacMan;
	private Pixmap pixmap;
	
	private Texture mapDot;
	private Texture mapMarble;
	private Texture mapPill;
	private Texture mapStone;
	private Texture mapWood;
	
	private final int WALL = 0x000000FF;
	private final int WOOD = 0x0000FFFF;
	private final int DOT = 0xFFFFFFFF;
	private final int EMPTY = 0x00000000;
	private final int PILL = 0xFF0000FF;
	private final int PLAYER_BIRTH = 0xFFFF00FF;
	
	private int[][] mapInfo;
	
	private Vector2 playerBirthPlace;
	
	private int tileWidth, tileHeight;
	
	public GameMap(PacMan pacMan){
		this.pacMan = pacMan;
		mapDot = new Texture("map_dot.png");
		mapMarble = new Texture("map_marble.png");
		mapPill = new Texture("map_pill.png");
		mapStone = new Texture("map_stone.png");
		mapWood = new Texture("map_wood.png");
		tileWidth = mapStone.getWidth();
		tileHeight = mapStone.getHeight();
	}
	
	public void loadMap(String filename){
		pixmap = new Pixmap(Gdx.files.internal(filename));
		init();
	}
	
	public void init(){
		int w = pixmap.getWidth();
		int h = pixmap.getHeight();
		mapInfo = new int[h][w];
		int v;
		for(int y=0; y<h; ++y){
			for(int x=0; x<w; ++x){
				v = pixmap.getPixel(x, y);
				mapInfo[h-1-y][x] = v;
				if(v == PLAYER_BIRTH){
					this.playerBirthPlace =
							new Vector2(x*this.tileWidth,
									(h-1-y)*this.tileHeight);
				}
			}
		}
	}
	
	public Vector2 getPlayerBirthPlace(){
		return this.playerBirthPlace;
	}
	
	public int getWidth(){
		return pixmap.getWidth();
	}
	
	public int getHeight(){
		return pixmap.getHeight();
	}
	
	public void draw(){
		int w = pixmap.getWidth();
		int h = pixmap.getHeight();
		
		int v = 0;
		int posY;
		int posX;
		for(int y=0; y<h; ++y){
			posY = y*tileHeight;
			for(int x=0; x<w; ++x){
				posX = x*tileWidth;
				v = this.mapInfo[y][x];
				if(v == EMPTY)
					continue;
				else if(v == WALL)
					pacMan.batch.draw(mapStone, posX, posY);
				else if(v == WOOD)
					pacMan.batch.draw(mapWood, posX, posY);
				else if(v == DOT)
					pacMan.batch.draw(mapDot, posX, posY);
				else if(v == PILL)
					pacMan.batch.draw(mapPill, posX, posY);
			}
		}
	}
	
	public void dispose () {
		mapDot.dispose();
		mapMarble.dispose();
		mapPill.dispose();
		mapStone.dispose();
		mapWood.dispose();
		pixmap.dispose();
	}
}
