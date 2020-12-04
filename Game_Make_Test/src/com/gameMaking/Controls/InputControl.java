package com.gameMaking.Controls;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.command.KeyControl;

public class InputControl implements InputProviderListener {
	
	private boolean[] keys = new boolean[16];
	private Command[] commands = new Command[16];
	
	private InputProvider provider;

	private enum KEY_TYPE {Forward,Down,Left,Right,X}
	
	private int[] KEY_VALUE = {Input.KEY_UP,Input.KEY_DOWN,Input.KEY_LEFT,Input.KEY_RIGHT,Input.KEY_X};

	public InputControl(GameContainer gc) {

		provider = new InputProvider(gc.getInput());
		provider.addListener(this);
		
		KEY_TYPE[] types = KEY_TYPE.values();
		
		for(int i = 0;i < types.length;i++) {
			commands[i] = new BasicCommand(String.valueOf(types[i]));
			provider.bindCommand(new KeyControl(KEY_VALUE[i]), commands[i]);
		}

	}

	@Override
	public void controlPressed(Command command) {

		switch (command.toString()) {
		case "[Command=Forward]":
			keys[0] = true;
			break;
		case "[Command=Down]":
			keys[1] = true;
			break;
		case "[Command=Left]":
			keys[2] = true;
			break;
		case "[Command=Right]":
			keys[3] = true;
			break;
		case "[Command=X]":
			keys[4] = true;
			break;
		default:
			break;
		}

	}

	@Override
	public void controlReleased(Command command) {
		switch (command.toString()) {
		case "[Command=Forward]":
			keys[0] = false;
			break;
		case "[Command=Down]":
			keys[1] = false;
			break;
		case "[Command=Left]":
			keys[2] = false;
			break;
		case "[Command=Right]":
			keys[3] = false;
			break;
		case "[Command=X]":
			keys[4] = false;
			break;
		default:
			break;	
		}

	}

	public boolean[] getMessage() {return keys;}

}
