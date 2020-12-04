package com.gameMaking.Models;

import java.util.Random;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.gameMaking.System.Bullet;

public class CBullet extends Bullet{

	Image bulletImg;
	
	public CBullet(float x, float y, float speed, float angle, float speedRate, float angleRate) throws SlickException {
		super(x, y, speed, angle, speedRate, angleRate);
	
		bulletImg = loader.cBullet.getSubImage(new Random().nextInt(16), 0);
	}
	
	public void init() throws SlickException{
		
	}
	
	public void move() {
	//	this.setX((this.getX())+((float)Math.cos(Math.toDegrees(angle*(Math.PI/180)))*speed));
	//	this.setY((this.getY())+((float)Math.sin(Math.toDegrees(angle*(Math.PI/180)))*speed));
		
		this.setY(this.getY()-speed);
		speed += speedRate;
	}
	
	public boolean outOfrange() {
		
		if(this.getY() < 0)return true;
		else return false;
		
	}
	
	public Image getImage() {
		return bulletImg;
		
	}
}
