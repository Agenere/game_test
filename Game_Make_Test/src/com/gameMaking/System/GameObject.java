package com.gameMaking.System;

public class GameObject {
	
	public float x,y;
	public Image_Loader loader;
	
	public GameObject(float x,float y) {
		this.x = x;
		this.y = y;
		loader = Image_Loader.getInstance();
	}

	public GameObject(float x, float y, float speed) {
		this.x = x;
		this.y = y;
		loader = Image_Loader.getInstance();
	}

	public GameObject(float x, float y, float speed, float angle) {
		this.x = x;
		this.y = y;
		loader = Image_Loader.getInstance();
	}

	public GameObject(float x, float y, float speed, float angle, float speedRate) {
		this.x = x;
		this.y = y;
		loader = Image_Loader.getInstance();
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
}
