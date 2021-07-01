package recursion.boggle;

import java.util.ArrayList;
import java.util.List;

public class Boggle {
	private char[][] board;
	private String word;
	
	private int currentChar;
	private String sequence;
	private String usedCelds;

	public Boggle(final char[][] board, final String word) {
		this.board = board;
		this.word = word;
		logInfo();
	}
 

	public boolean check() {
		boolean result = false;
		outerloop:
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board.length; x++) {
				intizialiceSearchValues();
				
				Celd celd = new Celd(x, y);
				if (celd.containsChar(this.currentChar)) {
				
					this.sequence = checkRecursive(
							this.sequence+celd.celdContent(), this.currentChar+1,  
							this.usedCelds+celd.coordinatedToString(), new Celd(x, y).findNeighborCelds());
					
					if (wordIsFound(this.sequence)) {
						result = true;
						break outerloop;
					}
				}
			}
		}
		System.out.println("*** Result for word " + word + " = " + result);
		return result;
	}
	
	private void intizialiceSearchValues() {
		this.currentChar = 0;
		this.sequence = "";
		this.usedCelds = "";
	}


	private String checkRecursive(String sequence, int currentChar, String usedCelds, List<Celd> neighborsCelds) {
		if (wordIsFound(sequence)) return sequence;
		
		for (Celd celd: neighborsCelds) {
			System.out.println("Sequence:"+  sequence);
			if (celd.containsChar(currentChar) && !celd.isAlreadyUsed(usedCelds)) {
				
				String auxSequence = checkRecursive(sequence+celd.celdContent(), currentChar+1, usedCelds+celd.coordinatedToString(), celd.findNeighborCelds());
				if (wordIsFound(auxSequence)) return auxSequence;
			}
		}
		return sequence;
	}
	
	private boolean wordIsFound(String pattern) {
		return pattern.equals(this.word);
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
		
		boolean containsChar(int charPosition){
			char c = word.charAt(charPosition);
			return this.celdContent() == c ? true:false;
		}
		
		char celdContent() {
			return board[y][x];
		}
		
		boolean isAlreadyUsed(String celUsed) {
			boolean result = celUsed.contains(this.coordinatedToString());
			if (result) System.out.println("*** Celda ya usada"+ this.toString());
			return result;
		}
		
		String coordinatedToString() {
			return "("+x+","+y+")";
		}
		
		@Override
		public String toString() {
			return coordinatedToString() + " " + this.celdContent();
		}

		@Override
		public boolean equals(Object obj) {
			Celd otherCeld = ((Celd)obj); 
			return otherCeld.x == this.x && otherCeld.y == this.y?true:false;
		}
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
