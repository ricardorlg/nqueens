package co.edu.unal.sistemas.nqueens;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Drawer extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1844632496711362055L;
	private BufferStrategy strategy;
	private Board board;

	public Drawer() {
		// setBackground(Color.white);

	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public void setUp() {
		this.createBufferStrategy(2);
		strategy = this.getBufferStrategy();
	}

	@Override
	public void paint(Graphics g) {
		System.out.println("aa");
		board.draw();
		strategy.show();
	}

	@Override
	public void update(Graphics g) {

		super.update(g);

	}

	public BufferStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(BufferStrategy strategy) {
		this.strategy = strategy;
	}
}
