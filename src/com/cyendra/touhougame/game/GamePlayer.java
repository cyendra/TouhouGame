package com.cyendra.touhougame.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import com.cyendra.touhougame.frame.GameFrame;
import com.cyendra.touhougame.inter.KeyInter;

public class GamePlayer extends GameCharacter implements KeyInter {
	private Image hpImage;
	private boolean isUp,isDown,isLeft,isRight;
	private Image[] playerImage;
	private int imgCnt = 0;
	private int count = 0;
	private int maxCount = 5;
	
	public GamePlayer(Image img[],Image hpimg) {
		super();
		playerImage = img;
		hpImage=hpimg;
		this.setHp(5);
		this.setPos(GameFrame.WIDTH/2,GameFrame.HEIGHT/8*7);
	}

	@Override
	public void logic() {
		//System.out.println(isUp+" "+isDown+" "+isLeft+" "+isRight);
		
		if (isUp) y-=speed;
		if (isDown) y+=speed;
		if (isLeft) x-=speed;
		if (isRight) x+=speed;
	}

	@Override
	public void draw(Graphics g) {
		if (isLeft&&!isRight) {
			g.drawImage(playerImage[8], x, y, null);
		}
		else if (isRight&&!isLeft) {
			g.drawImage(playerImage[9], x, y, null);
		}
		else{
			g.drawImage(playerImage[imgCnt], x, y, null);
			count++;
			if (count>=maxCount){
				imgCnt=(imgCnt+1)%8;
				count=0;
			}
		}
		for (int i=0;i<hp;i++) {
			g.drawImage(hpImage, i*hpImage.getWidth(null)+10, GameFrame.HEIGHT-hpImage.getHeight(null)-10, null);
		}
	}

	@Override
	public void onKeyDown(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			isUp = true;
			break;
		case KeyEvent.VK_DOWN:
			isDown = true;
			break;
		case KeyEvent.VK_LEFT:
			isLeft = true;
			break;
		case KeyEvent.VK_RIGHT:
			isRight = true;
			break;
		}
	}

	@Override
	public void onKeyUp(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			isUp = false;
			break;
		case KeyEvent.VK_DOWN:
			isDown = false;
			break;
		case KeyEvent.VK_LEFT:
			isLeft = false;
			break;
		case KeyEvent.VK_RIGHT:
			isRight = false;
			break;
		}
	}

	@Override
	public void onKeyType(KeyEvent e) {}
	

}
