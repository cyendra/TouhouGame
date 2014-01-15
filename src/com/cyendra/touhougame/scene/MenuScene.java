package com.cyendra.touhougame.scene;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import com.cyendra.touhougame.frame.GameFrame;
import com.cyendra.touhougame.manager.GameManager;

public class MenuScene {
	private Image imgMenuBackground;
	private Image imgStartButton;
	private int btnX, btnY;
	public MenuScene(Image imgMB, Image imgSB) {
		imgMenuBackground = imgMB;
		//imgStartButton = imgSB;
		//btnX = GameFrame.WIDTH / 2 - imgStartButton.getWidth(null) / 2;
		//btnY = GameFrame.HEIGHT - imgStartButton.getHeight(null);
	}
	
	public void draw(Graphics g) {
		g.drawImage(imgMenuBackground, 0, 0, null);
		g.drawString("Press Enter to start.", GameFrame.WIDTH / 2, GameFrame.HEIGHT / 2);
		//g.drawImage(imgStartButton, btnX, btnY, null);
	}
	public void onKeyDown(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			GameManager.gameState = GameManager.GAME_IN;
		}
		
	}
	
}
