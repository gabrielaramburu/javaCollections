package recursion.boggle;

import java.util.ArrayList;
import java.util.List;

public class Boggle {
	private char[][] board;
	private String word;
	

	public Boggle(final char[][] board, final String word) {
		this.board = board;
		this.word = word;
	}
 

	public boolean check() {
		String sequence;
		boolean result = false;
		outerloop:
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board.length; x++) {
				int currentCharPosition = 0;
				sequence = "";
				List<Celd> usedCelds = new ArrayList<Celd>();
				
				Celd celd = new Celd(x, y);
				if (word.charAt(currentCharPosition) == celd.celdContent()) {
					sequence += celd.celdContent();
					usedCelds.add(celd);
					sequence = checkRecursive(sequence, currentCharPosition+1,  usedCelds, new Celd(x, y).findNeighborCelds());
					if (sequence.equals(word)) {
						result = true;
						break outerloop;
					}
				}
			}
		}
		System.out.println("*** Result for word " + word + " = " + result);
		return result;
	}
	
	private String checkRecursive(String sequence, int currentPosition, List<Celd> usedCelds, List<Celd> neighborsCelds) {
		if (sequence.equals(word)) return sequence;
		
		for (Celd celd: neighborsCelds) {
			

			if (celd.celdContainsChar(word.charAt(currentPosition)) && !usedCelds.contains(celd)) {
				usedCelds.add(celd);
				System.out.println("sequence: " + sequence);
				List<Celd> newList = new ArrayList<Boggle.Celd>();
				newList.addAll(usedCelds);
				
				String auxSequence = checkRecursive(sequence+celd.celdContent(), currentPosition+1, newList, celd.findNeighborCelds());
				if (auxSequence.equals(word)) {
					return auxSequence;
				}
			}
		}
		return sequence;
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
			
			System.out.println("Neighbors chars of " +  this.toString());
			neighbors.forEach(coord -> System.out.println(coord.celdContent() + coord.toString()));
			return neighbors;
		}
		
		boolean celdContainsChar(char c){
			return board[y][x] == c ? true:false;
		}
		
		char celdContent() {
			return board[y][x];
		}

		@Override
		public String toString() {
			return "("+x+","+y+") " + this.celdContent();
		}

		@Override
		public boolean equals(Object obj) {
			Celd otherCeld = ((Celd)obj); 
			return otherCeld.x == this.x && otherCeld.y == this.y?true:false;
		}
		
		private void logInfo() {
			System.out.println("Word: " + word);
			for (int y = 0; y < board.length; y++) {
				for (int x = 0; x < board.length; x++) {
					System.out.print(board[y][x] + ",");
				}
				System.out.println("");
			}
		}
	}
}
