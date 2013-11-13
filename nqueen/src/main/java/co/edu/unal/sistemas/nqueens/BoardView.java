package co.edu.unal.sistemas.nqueens;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BoardView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7759680737965998150L;

	/**
	 * Create the panel.
	 */
	private int n = 8;
	private Drawer drawer;

	private int w;

	private int h;

	public BoardView(Drawer drawer) {
		setBackground(Color.WHITE);
		this.setDrawer(drawer);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(this.drawer);
		setPreferredSize(new Dimension(400, 400));
		setSize(400, 400);
		setMinimumSize(new Dimension(400, 400));
	}

	public Drawer getDrawer() {
		return drawer;
	}

	public void setDrawer(Drawer drawer) {
		this.drawer = drawer;
	}

	public void setSquareSize() {
		w = getWidth() / n;
		h = getHeight() / n;
		System.out.println(w);
		System.out.println(h);
	}

	public void drawBoard() {
		Graphics2D g2 = (Graphics2D) drawer.getStrategy().getDrawGraphics();

		for (int i = 0; i < n; i++) {

			Color c = i % 2 == 0 ? Color.gray : Color.white;
			for (int j = 0; j < n; j++) {

				g2.setStroke(new BasicStroke(3));
				g2.setColor(c);
				g2.fillRect(j * w, i * h, w, h);
				g2.setPaint(Color.black);
				g2.drawRect(j * w, i * h, w, h);
				if (c == Color.gray) {
					c = Color.white;
				} else {
					c = Color.gray;
				}
			}
		}
		g2.dispose();
	}

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public void setN(int n) {
		this.n = n;
	}
}
