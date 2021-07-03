package recursion.simplemaze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Maze {
	private final static char KATE = 'k';
	private final static char WALL = '#';
	private final static char FREE = ' ';
	
	private Position initialPosition;

	public static void main(String[] args) {
		new Maze().hasExit(new String[] {"########",
                 "# # ####",
                 "# #k#   ",
                 "# # # ##",
                 "# # # ##",
                 "#      #",
                 "########"});
	}
	
	public boolean hasExit(String[] maze) {
		char[][] mazeAsMatix = buildMazeAsMatrix(maze);
		return findExit(mazeAsMatix, this.initialPosition);
    }

	private boolean findExit(char[][] mazeAsMatrix, Position currentPosition) {
		if (currentPosition.isMatrixBorder(mazeAsMatrix)) {
			return true;
		}
		
		for (Position pos: currentPosition.spaces(mazeAsMatrix)) {
			boolean result = findExit(mazeAsMatrix, pos);
			if (result == true) return true;
		}
		return false;
	}
	
	private char[][] buildMazeAsMatrix(String[] maze) {
		int columns = getMazeMaxSize(maze);
		int rows = maze.length;
		
		char[][] matrix = new char[rows][columns];
		for (int row = 0; row < matrix.length ; row++) {
			for (int col = 0;col< columns;col++ ){
				matrix[row][col] = characterFromMazeRow(maze[row], col);
				if (matrix[row][col] == KATE) { this.initialPosition = new Position(row, col);};
			}
		}
		showMatrix(matrix);
		return matrix;
	}
	
	private  int getMazeMaxSize(String[] maze) {
		Optional<String> maxLength = Arrays.asList(maze).stream()
				.reduce((str1, str2) -> str1.length() >= str2.length()?str1:str2);
		
		return maxLength.get().length();
	}

	private char characterFromMazeRow(String charsOfRow, int matrixCol) {
		char charFromRow = matrixCol < charsOfRow.length()   
				?charsOfRow.charAt(matrixCol)
				:FREE;
		
		return charFromRow;
	}

	private void showMatrix(char[][] mat) {
		System.out.println("New matrix");
		for (char[] arr : mat) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	class Position {
		int row;
		int col; 
		
		Position (int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		public List<Position> spaces(char[][] matrix) {
			List<Position> pos = new ArrayList<Maze.Position>();
			if (free(matrix[this.row - 1][this.col])) pos.add(new Position(this.row - 1, this.col));
			if (free(matrix[this.row - 1][this.col - 1])) pos.add(new Position(this.row - 1, this.col - 1));
			if (free(matrix[this.row - 1][this.col + 1])) pos.add(new Position(this.row - 1, this.col + 1));
			if (free(matrix[this.row + 1][this.col])) pos.add(new Position(this.row + 1, this.col));
			if (free(matrix[this.row + 1][this.col + 1])) pos.add(new Position(this.row + 1, this.col + 1));
			if (free(matrix[this.row + 1][this.col - 1])) pos.add(new Position(this.row + 1, this.col - 1));
			if (free(matrix[this.row][this.col + 1])) pos.add(new Position(this.row, this.col + 1));
			if (free(matrix[this.row][this.col - 1])) pos.add(new Position(this.row, this.col - 1));
			
			System.out.println(Arrays.asList(pos));
			return pos;
		}
	
		private boolean free(char c) {
			return c == FREE?true:false;
		}

		boolean isMatrixBorder(char[][] matrix) {
			return row == 0?true
					:row == matrix.length -1?true
					:col == 0?true
					:col == matrix[0].length -1?true
					:false;
		}

		@Override
		public String toString() {
			return "("+this.row+","+ this.col+")";
		}
		
		
	}

}
