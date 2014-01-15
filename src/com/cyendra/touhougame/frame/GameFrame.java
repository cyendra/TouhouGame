package com.cyendra.touhougame.frame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.cyendra.touhougame.manager.GameManager;

public class GameFrame extends JFrame implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	
	private String title = "东方红白梦";
	public final static int WIDTH = 800;
	public final static int HEIGHT = 600;
	private int fps = 30; 
	
	// 双缓冲技术
	private Image iBuffer;
	private Graphics gBuffer;
	
	public GameManager gm = null;// 游戏管理器
	Thread mThread = null;// 游戏循环
	
	public GameFrame() {
		init();
	}
	
	public void init(){
		this.setTitle(title);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.setResizable(false);
		this.addKeyListener(this);
		gm = new GameManager();
		mThread = new Thread(this);
		mThread.start();
	}
	
	// 重载paint
	public void paint(Graphics g){
		if (iBuffer == null){
			iBuffer = createImage(this.getSize().width, this.getSize().height);
			gBuffer = iBuffer.getGraphics();
		}
		gBuffer.setColor(getBackground());
		gBuffer.fillRect(0, 0, this.getSize().width, this.getSize().height);
		gm.draw(gBuffer);
		g.drawImage(iBuffer,0,0,this);
	}
	// 重载update
	public void update(Graphics g){
		paint(g);
	}

	@Override
	public void run() {
		while (true) {
			gm.logic();
			repaint();
			try {
				Thread.sleep(1000/fps);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gm.onKeyDown(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		gm.onKeyUp(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		gm.onKeyType(e);
	}
	
}
