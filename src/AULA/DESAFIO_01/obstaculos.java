package AULA.DESAFIO_01;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class obstaculos extends Rectangle{
	private Color CorFundo, CorBorda;
	
	public obstaculos(int px, int py, int l, int a) {
		this.x = px; this.y = py;
		this.width = l; this.height = a;
		this.CorFundo = Color.BLUE; this.CorBorda = Color.BLACK;
		
	}
	public void desenharObstaculos(Graphics2D d2) {
		d2.setColor(CorFundo);
		d2.fillRect(this.x, this.y, this.width, this.height);
		d2.setColor(CorBorda);
		d2.drawRect(this.x, this.y, this.width, this.height);
	}
	
	public int getLargura() {
		return this.width;
	}
	public int getAltura() {
		return this.height;
	}
	public int getPosX() {
		return this.x;
	}
	public int getPosY() {
		return this.y;
	}

}
