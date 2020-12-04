package com.gameMaking.System;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Image_Loader {

	public SpriteSheet p_idle;
	public SpriteSheet p_move;

	public SpriteSheet cBullet;
	
	
	public static final Image_Loader instance = new Image_Loader();
	
	public static Image_Loader getInstance() {
		
		return instance;
	}
	
	public void LoadGameResource() throws SlickException {
		p_idle = new SpriteSheet(new Image("Images/Player_idle.png"), 32, 42);
		p_move = new SpriteSheet(new Image("Images/Player_move.png"), 32, 42);
		
		cBullet = new SpriteSheet(new Image("Images/Attack.png"), 16, 16);
		
	}


	
}
