package recursion.boggle;

import java.util.ArrayList;
import java.util.List;

public class Boggle {
	char[][] board;
	String word;
	int currentCharPosition;
	String sequence;

	public Boggle(final char[][] board, final String word) {
		this.board = board;
		this.word = word;
	}
 
	public boolean check() {
		boolean result = false;
		outerloop:
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				initialiceSearch();
				if (currentChar() == board[i][j]) {
					Celd celd = new Celd(i, j);
					addCharToSequence();
					moveNextChar();
					result = checkRecursive(celd.findNeighborCelds());
					if (result) break outerloop;
				}
			}
		}
		System.out.println("Result for word " + word + " = " + result);
		return result;
	}

	private void initialiceSearch() {
		this.currentCharPosition = 0;
		this.sequence="";
	}
	
	private boolean checkRecursive(List<Celd> neighborsCelds) {
		if (sequence.equals(word)) return true;
		
		for (Celd celd: neighborsCelds) {
			
			if (celd.celdContainsChar(currentChar()) && !celdAlreadyUsed()) {
				System.out.println("sequence: " + this.sequence);
				addCharToSequence();
				moveNextChar();
				return checkRecursive(celd.findNeighborCelds());
			}
		}
		return false;
	}
	
	private void addCharToSequence() {
		sequence += currentChar();
	}
	
	private void moveNextChar() {
		currentCharPosition++;
	}

	private char currentChar() {
		return word.charAt(currentCharPosition);
	}
	
	private boolean celdAlreadyUsed() {
		return false;
	}
	
	class Celd {
		int x;
		int y;
		int matrixSize;

		Celd(int x, int y) {
			this.x = x;
			this.y = y;
			this.matrixSize = board.length;
		}

		List<Celd> findNeighborCelds() {
			List<Celd> neighbors = new ArrayList<Celd>();
			if ((x - 1) >= 0)
				neighbors.add(new Celd(x - 1, y));
			if ((x + 1) < matrixSize)
				neighbors.add(new Celd(x + 1, y));
			if ((y + 1) < matrixSize)
				neighbors.add(new Celd(x, y + 1));
			if ((y - 1) >= 0)
				neighbors.add(new Celd(x, y - 1));
			if (((x + 1) < matrixSize) && ((y - 1) >= 0))
				neighbors.add(new Celd(x + 1, y - 1));
			if (((x - 1) >= 0) && ((y - 1) >= 0))
				neighbors.add(new Celd(x - 1, y - 1));
			if (((x - 1) >= 0) && ((y + 1) < matrixSize))
				neighbors.add(new Celd(x - 1, y + 1));
			if (((x + 1) < matrixSize) && ((y + 1) < matrixSize))
				neighbors.add(new Celd(x + 1, y + 1));
			
			System.out.println("Neighbors chars of " + this.celdContent());
			neighbors.forEach(coord -> System.out.println(coord.celdContent()));
			return neighbors;
		}
		
		boolean celdContainsChar(char c){
			return board[x][y] == c ? true:false;
		}
		
		char celdContent() {
			return board[x][y];
		}

		@Override
		public String toString() {
			return "("+x+","+y+")";
		}
		
	}

	public static void main(String[] args) {
		final char[][] board = { { 'E', 'A', 'R', 'A' }, { 'N', 'L', 'E', 'C' }, { 'I', 'A', 'I', 'S' },
				{ 'B', 'Y', 'O', 'R' } };

		//testCoordinate();
		
		Boggle nb = new Boggle(board, "EARS");
		System.out.println("Result: " + nb.check());
		
	}
	
	private static void testCoordinate() {
		final char[][] board = { { 'E', 'A', 'R', 'A' }, { 'N', 'L', 'E', 'C' }, { 'I', 'A', 'I', 'S' },
				{ 'B', 'Y', 'O', 'R' } };

		Boggle boogle = new Boggle(board, " ");
		System.out.println(boogle.new Celd(1, 1).findNeighborCelds());
		System.out.println(boogle.new Celd(0, 0).findNeighborCelds());
		System.out.println(boogle.new Celd(2, 2).findNeighborCelds());
	}
}
