package com.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player {
	private PacMan pacMan;
	private Texture player;
	private Texture playerEat;
	//0 is ready, 1 is up, 2 is right, 3 is down, 4 is left, 5 is dead
	private int state; 
	private static final int READY = 0;
	private static final int UP = 1;
	private static final int RIGHT = 2;
	private static final int DOWN = 3;
	private static final int LEFT = 4;
	private static final int DEAD = 5;
	private Vector2 birthPlace;
	
	public Player(PacMan pacMan){
		this.pacMan = pacMan;
		this.player = new Texture("player.png");
		this.playerEat = new Texture("player_eat.png");
		state = READY;
		this.birthPlace = pacMan.map.getPlayerBirthPlace();
	}
	
	public void update(){
		
	}
	public void draw(){
		if(state == READY){
			pacMan.batch.draw(player, birthPlace.x, birthPlace.y);
		}
	}
	
	public void dispose(){
		player.dispose();
		playerEat.dispose();
	}
}
