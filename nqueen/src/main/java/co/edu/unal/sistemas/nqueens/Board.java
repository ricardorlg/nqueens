package co.edu.unal.sistemas.nqueens;

import java.util.List;

public class Board {

	private BoardView view;
	private List<Queen> queens;
	private Drawer drawer;

	public Board(Drawer drawer) {
		view = new BoardView(drawer);
		this.drawer = drawer;
		this.drawer.setBoard(this);
	}

	public void draw() {
		view.setSquareSize();
		view.drawBoard();
		if (queens != null) {
			for (Queen q : queens) {
				q.drawQueen(view.getW(), view.getH());
			}
		}
	}

	public void setQueens(List<Queen> queens) {
		this.queens = queens;
	}

	public BoardView getView() {
		return view;
	}

	public void setUp() {
		drawer.setUp();

	}

	public Drawer getDrawer() {
		// TODO Auto-generated method stub
		return drawer;
	}
}
