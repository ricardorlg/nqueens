package co.edu.unal.sistemas.nqueens;

import java.awt.EventQueue;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drawer drawer = new Drawer();
					Agent agent = new Agent();
					Board board = new Board(drawer);
					agent.setBoard(board);

					MainFrame frame = new MainFrame(agent);
					frame.addBoard(board);
					frame.setVisible(true);
					board.setUp();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
