package com.cyendra.touhougame.game;

import java.awt.Graphics;
import java.awt.Image;

import com.cyendra.touhougame.frame.GameFrame;

public class GameBackground {
	private Image imgBackGround1,imgBackGround2;
	private int bg1x,bg1y,bg2x,bg2y;
	private int imgHeight;
	private int speed = 3;
	public GameBackground(Image img) {
		this.imgBackGround1 = img;
		this.imgBackGround2 = img;
		imgHeight = imgBackGround1.getHeight(null);
		bg1x = 0;
		bg1y = -Math.abs( imgHeight - GameFrame.HEIGHT);
		bg2x = 0;
		bg2y = bg1y - imgBackGround1.getHeight(null) + 1;
	}
	public void logic() {
		bg1y += speed;
		bg2y += speed;
		if (bg1y > GameFrame.HEIGHT) {
			bg1y = bg2y - imgHeight + 1;
		}
		if (bg2y > GameFrame.HEIGHT) {
			bg2y = bg1y - imgHeight + 1;
		}
	}
	public void draw(Graphics g) {
		g.drawImage(imgBackGround1, bg1x, bg1y, null);
		g.drawImage(imgBackGround2, bg2x, bg2y, null);
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int sp) {
		speed = sp;
	}

}
