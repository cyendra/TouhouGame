package com.cyendra.touhougame.manager;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DataManager {
	public Image imgMenuBackground;
	public Image imgBackgroundCloud;
	public Image[] imgPlayer;
	public Image imgPlayerHp;
	public DataManager() {
		try {
			imgMenuBackground = ImageIO.read(new File("graphics\\menu\\menu.jpg"));
			imgBackgroundCloud = ImageIO.read(new File("graphics\\background\\cloud.jpg"));
			imgPlayer = new Image[10];
			for (int i=0;i<10;i++) {
				imgPlayer[i] = ImageIO.read(new File("graphics\\player\\player"+i+".png"));
			}
			imgPlayerHp = ImageIO.read(new File("graphics\\player\\hp.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
