package com.gameMaking.Models;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import com.gameMaking.Graphics.Game;
import com.gameMaking.System.GameObject;

public class Player extends GameObject{

	private int state = 0;
	
	private Animation idle;
	private Animation move;
	
	private List<CBullet> bullets = new ArrayList<CBullet>(); //총알담아둘 큰 상자
	
	private long prevTime = 0; // 공격딜레이
	
	public Player(float x, float y) throws SlickException {
		super(x, y);		
		init();
	}

	
	public void init() throws SlickException {
		
		idle = new Animation(loader.p_idle,100);
		move = new Animation(loader.p_move,100);
		move.setLooping(false);
	}
	
	public void move(boolean[] keys) throws SlickException {
		
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
		
		if(keys[4]) {
			fire();
		}
			

	}
	
	public void fire() throws SlickException{
		
		long curTime = System.currentTimeMillis() - prevTime; // 쿨타임 계산
		
		if(curTime > 100) {
			bullets.add(new CBullet(this.getX()+8, this.getY(), 2f, 0f, 0.01f, 0f));
			prevTime = System.currentTimeMillis(); //쿨타임 리셋
			
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

	public List<CBullet> getBullets() {
		return bullets;
	}
}
