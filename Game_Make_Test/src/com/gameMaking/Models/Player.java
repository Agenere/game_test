package com.gameMaking.Models;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import com.gameMaking.Graphics.Game;
import com.gameMaking.System.GameObject;

public class Player extends GameObject{

	private int state = 0;
	
	private Animation idle;
	private Animation move;
	
	public Player(float x, float y) throws SlickException {
		super(x, y);		
		init();
	}

	
	public void init() throws SlickException {
		
		idle = new Animation(loader.p_idle,100);
		move = new Animation(loader.p_move,100);
		move.setLooping(false);
	}
	
	public void move(boolean[] keys) {
		
		outOfrange();
		
		
		if(keys[0]) this.setY(this.getY()-0.3f);

			
		if(keys[1]) this.setY(this.getY()+0.3f);
			
			
		if(keys[2]) {
			this.setX(this.getX()-0.3f);
			state = 1;
		}else if(state==1){
			move.restart();
			state = 0;
		}
			
		if(keys[3]) {
			this.setX(this.getX()+0.3f);
			state = 2;
		}else if(state==2){
			move.restart();
			state = 0;
		}
			

	}
	
	public void outOfrange() {
		if (this.getX() < 0) this.setX(0);
		if (this.getX()+idle.getWidth()>Game.Screen_Width)
			this.setX(Game.Screen_Width-idle.getWidth());
		if (this.getY() < 0) this.setY(0);
		if (this.getY()+idle.getHeight()>Game.Screen_Height)
			this.setY(Game.Screen_Height-idle.getHeight());
		
	}
	
	public int getState() {
		return state;
	}
	
	public Animation getCurrentAnimation() {
		if(state != 0)
			return move;
		else
			return idle;
	}

}
