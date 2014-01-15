package com.cyendra.touhougame.inter;
import java.awt.event.KeyEvent;

public interface KeyInter {
	public void onKeyDown(KeyEvent e);
	public void onKeyUp(KeyEvent e);
	public void onKeyType(KeyEvent e);
}
