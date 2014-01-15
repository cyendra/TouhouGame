package com.cyendra.touhougame.manager;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.cyendra.touhougame.game.GameBackground;
import com.cyendra.touhougame.game.GamePlayer;
import com.cyendra.touhougame.inter.GameInter;
import com.cyendra.touhougame.inter.KeyInter;
import com.cyendra.touhougame.scene.MenuScene;

public class GameManager implements KeyInter,GameInter {
	public static final int GAME_MENU = 0;
	public static final int GAME_IN = 1;
	public static final int GAME_WIN = 2;
	public static final int GAME_LOST = 3;
	public static final int GAME_PAUSE = 4;
	
	public static int gameState = GAME_MENU;
	
	DataManager dm;
	MenuScene menuScene;
	GameBackground gameBackground;
	GamePlayer player;
	
	public GameManager() {
		dm = new DataManager();
		menuScene = new MenuScene(dm.imgMenuBackground, null);
		gameBackground = new GameBackground(dm.imgBackgroundCloud);
		player = new GamePlayer(dm.imgPlayer, dm.imgPlayerHp);
	}
	
	@Override
	public void logic() {
		switch (gameState) {
		case GAME_MENU:
			break;
		case GAME_IN:
			gameBackground.logic();
			player.logic();
			break;
		case GAME_WIN:
			break;
		case GAME_LOST:
			break;
		case GAME_PAUSE:
			break;
		}
	}
	
	@Override
	public void draw(Graphics g) {
		switch (gameState) {
		case GAME_MENU:
			menuScene.draw(g);
			break;
		case GAME_IN:
			gameBackground.draw(g);
			player.draw(g);
			break;
		case GAME_WIN:
			break;
		case GAME_LOST:
			break;
		case GAME_PAUSE:
			break;
		}
	}
	
	@Override
	public void onKeyType(KeyEvent e) {
		switch (gameState) {
		case GAME_MENU:
			break;
		case GAME_IN:
			break;
		case GAME_WIN:
			break;
		case GAME_LOST:
			break;
		case GAME_PAUSE:
			break;
		}
	}
	
	@Override
	public void onKeyDown(KeyEvent e) {
		switch (gameState) {
		case GAME_MENU:
			menuScene.onKeyDown(e);
			break;
		case GAME_IN:
			player.onKeyDown(e);
			break;
		case GAME_WIN:
			break;
		case GAME_LOST:
			break;
		case GAME_PAUSE:
			break;
		}
	}
	
	@Override
	public void onKeyUp(KeyEvent e) {
		switch (gameState) {
		case GAME_MENU:
			break;
		case GAME_IN:
			player.onKeyUp(e);
			break;
		case GAME_WIN:
			break;
		case GAME_LOST:
			break;
		case GAME_PAUSE:
			break;
		}
	}
}
