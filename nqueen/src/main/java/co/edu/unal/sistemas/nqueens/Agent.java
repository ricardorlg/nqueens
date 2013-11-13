package co.edu.unal.sistemas.nqueens;

import java.util.LinkedList;
import java.util.List;

public class Agent {
	private Board board;
	private List<Queen> queens = new LinkedList<Queen>();
	private int n = 8;

	public void setBoard(Board board) {
		this.board = board;
	}

	public void reset() {
		queens.clear();
		for (int i = 0; i < n; i++) {
			queens.add(new Queen(board.getDrawer()));
		}
	}

	public void solve() {

		int row = 1;

		if ((n % 2 == 0) && (n % 6 != 2)) {
			while (row <= (n / 2)) {
				placeQueen((row - 1), ((row * 2) - 1));
				row++;
			}

			while (row <= n) {
				placeQueen((row - 1), (2 * row - n - 2));
				row++;
			}
		} else if (n % 2 == 0) {
			placeQueen(0, ((2 + n / 2 - 3) % n));
			while (row < (n / 2)) {
				placeQueen(row, ((2 * (row + 1) + n / 2 - 3) % n));
				row++;
			}

			while (row < n) {
				placeQueen(row, (((2 * (n - row + 1) + 1) + n / 2 - 3) % n));
				row++;
			}
		} else {
			n--;
			if ((n % 2 == 0) && (n % 6 != 2)) {
				while (row <= (n / 2)) {
					placeQueen((row - 1), ((row * 2) - 1));
					row++;
				}

				while (row <= n) {
					placeQueen((row - 1), (2 * row - n - 2));
					row++;
				}
				n++;
				placeQueen((row - 1), (n - 1));
			} else if (n % 2 == 0) {
				placeQueen(0, ((2 + n / 2 - 3) % n));
				while (row < (n / 2)) {
					placeQueen(row, ((2 * (row + 1) + n / 2 - 3) % n));
					row++;
				}

				while (row < n) {
					placeQueen(row, (((2 * (n - row + 1) + 1) + n / 2 - 3) % n));
					row++;
				}
				n++;
				placeQueen(row, (n - 1));
			}
		}
		board.setQueens(queens);
		board.getDrawer().repaint();
		System.out.println(queens);
	}

	public void setN(int n) {
		this.n = n;
		board.getView().setN(n);
	}

	private void placeQueen(int x, int y) {

		Queen q = queens.get(x);
		q.setX(x);
		q.setY(y);

	}

	private boolean checkX(int x, Queen qu) {
		for (Queen q : queens) {
			if(qu!=q){
			if (q.getX() == x) {
				return true;
			}}
		}
		return false;
	}
	public boolean validSolution(){
		for(Queen q:queens){
			if(checkX(q.getX(), q)){
				return false;
			}
		}
		return false;}
}
