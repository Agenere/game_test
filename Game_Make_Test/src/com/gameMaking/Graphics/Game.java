package com.gameMaking.Graphics;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.gameMaking.Controls.InputControl;
import com.gameMaking.Models.CBullet;
import com.gameMaking.Models.Player;
import com.gameMaking.System.Image_Loader;

public class Game extends BasicGame{
	
	public static final int Screen_Width = 640;
	public static final int Screen_Height = 800;

	private InputControl input;
	private Player p;
	
	public Game(String title) {
		super(title);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		
		Image_Loader.getInstance().LoadGameResource();
		
		input = new InputControl(gc);
		p = new Player(300,750);
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		//g.drawString("Press UP,DOWN,LEFT,RIGHT", 10, 100);
		
		List<CBullet> bullets = p.getBullets();
		for(int i=0;i<bullets.size();i++) {
			CBullet temp = bullets.get(i);
			temp.getImage().draw(temp.getX(), temp.getY());
		}
		
		if(p.getState() == 2)
			p.getCurrentAnimation().getCurrentFrame().getFlippedCopy(true, false).draw(p.getX(),p.getY());
		else
			p.getCurrentAnimation().draw(p.getX(),p.getY());
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
		p.move(input.getMessage());
		
		if(p.getState()==2) p.getCurrentAnimation().update(delta);
		
		List<CBullet> bullets = p.getBullets(); //ÃÑ¾Ë»óÀÚ
		
		for(int i = 0; i< bullets.size();i++) {
			CBullet temp = bullets.get(i);
			
			if(temp.outOfrange()) {
				bullets.remove(i);
				continue;
			}
			
			temp.move();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Game("My first java2D Game"));
			appgc.setDisplayMode(Screen_Width, Screen_Height, false);
			appgc.start();
		} catch (SlickException ex) {
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE,null,ex);
		}
		
	}

}
