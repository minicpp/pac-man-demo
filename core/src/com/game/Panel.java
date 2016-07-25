package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Panel {
	int highestScores;
	int credits;
	int scores;
	PacMan pacMan;
	private BitmapFont font;
	private Texture creditImg;

	public Panel(PacMan pacMan) {
		this.pacMan = pacMan;
		// set/get highestscore
		FileHandle file = Gdx.files.local("score.txt");
		if (file.exists()) {
			highestScores = Integer.parseInt(file.readString());
		} else {
			highestScores = 0;
			file.writeString(String.valueOf(highestScores), false);
		}
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		creditImg = new Texture("credit.png");
		reset();
	}
	
	public void reset(){
		credits = 3;
		scores = 0;
	}
	
	public void draw(){
		//font.getData().setScale(.25f,.25f);
		font.draw(pacMan.batch, "Credits:", 10, pacMan.viewHeight - 30);
		for(int i=0; i<this.credits; ++i){
			pacMan.batch.draw(creditImg, 70+i*50, pacMan.viewHeight - 60);
		}
		font.draw(pacMan.batch,"Scores: "+this.scores,
				10, pacMan.viewHeight - 70);
		font.draw(pacMan.batch,"Highest Scores: "+this.highestScores,
				pacMan.viewWidth/2, pacMan.viewHeight - 30);
	}
	
	
	public void dispose(){
		font.dispose();
		this.creditImg.dispose();
		
	}
}
