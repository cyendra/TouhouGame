package com.cyendra.touhougame.game;

import java.awt.Graphics;
import java.awt.Image;

import com.cyendra.touhougame.inter.GameInter;

public abstract class GameCharacter implements GameInter {
	protected int x,y;
	protected int speed;
	protected int hp;
	public GameCharacter() {
		hp = 1;
		x = 0;
		y = 0;
		speed = 5;
	}
	@Override
	public abstract void logic();
	@Override
	public abstract void draw(Graphics g);
	public int getSpeed() {return speed;}
	public void setSpeed(int sp) {speed=sp;}
	public void setPos(int x,int y) {this.x=x;this.y=y;}
	public void setPosX(int x) {this.x=x;}
	public void setPosY(int y) {this.y=y;}
	public int getPosX() {return x;}
	public int getPosY() {return y;}
	public void setHp(int x) {hp=x;}
	public int getHp(int x) {return hp;}
	
}
