package co.edu.unal.sistemas.nqueens;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Queen {

	private int x, y;
	private Drawer drawer;

	public Queen(Drawer drawer) {
		this.drawer = drawer;
	}

	public void drawQueen(int w, int h) {
		Graphics2D g2 = (Graphics2D) drawer.getStrategy().getDrawGraphics();
		g2.setStroke(new BasicStroke(3));
		Color c = Color.blue;
		g2.setColor(c);

		g2.fillOval((x * w) + (w / 2) - 10, (y * h) + (h / 2) - 10, 20, 20);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y - 1;
	}
	public int getX() {
		return x;
	}public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Queen other = (Queen) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Queen x = " + x + " , y = " + y;
	}
}
