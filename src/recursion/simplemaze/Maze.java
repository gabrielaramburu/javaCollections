package recursion.simplemaze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Maze {
	private final static char KATE = 'k';
	private final static char WALL = '#';
	private final static char FREE = ' ';
	
	private Position initialPos;
	private char[][] mazeMatrix;
	private int countKates = 0;

	public static void main(String[] args) {
		/*new Maze().hasExit(new String[] {"########",
                 "# # ####",
                 "# #k#   ",
                 "# # # ##",
                 "# # # ##",
                 "#      #",
                 "########"}); */
		new Maze().hasExit(new String[] {"k"});
	}
	
	public boolean hasExit(String[] maze) {
		buildMazeAsMatrixAndSetInitialPos(maze);
		if (countKates != 1) return false;
		
		boolean result = findExit(this.initialPos.spacesAround(null), this.initialPos.row, this.initialPos.col);
		
		System.out.println(result);
		return result;
    }

	private boolean findExit(List<Position> spacesAround, int row, int col) {
		Position currentPos = new Position(row, col);
		if (currentPos.isMatrixBorder()) return true;
		
		for (Position spacePos: spacesAround) {
			if (spacePos.isMatrixBorder()) return true;
			System.out.println("Estoy en celda:" + spacePos.toString());
			boolean result = findExit(spacePos.spacesAround(currentPos), spacePos.row, spacePos.col);
			if (result == true) return true;
			
		}
		System.out.println("termime for ");

		return false;
	}
	
	private void buildMazeAsMatrixAndSetInitialPos(String[] maze) {
		int columns = getMazeMaxSize(maze);
		int rows = maze.length;
		
		char[][] matrix = new char[rows][columns];
		for (int row = 0; row < matrix.length ; row++) {
			for (int col = 0;col< columns;col++ ){
				matrix[row][col] = characterFromMazeRow(maze[row], col);
				if (matrix[row][col] == KATE) { 
					this.initialPos = new Position(row, col);
					countKates++;
				};
			}
		}
		showMatrix(matrix);
		this.mazeMatrix = matrix;
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
		char content;
		
		Position (int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		List<Position> spacesAround(Position previousCeld) {
			List<Position> neighborCelds = new ArrayList<Maze.Position>();
			neighborCelds.add(new Position(this.row - 1, this.col));
			neighborCelds.add(new Position(this.row + 1, this.col));
			neighborCelds.add(new Position(this.row, this.col + 1));
			neighborCelds.add(new Position(this.row, this.col - 1));
			
			List<Position> spaces = neighborCelds.stream()
				.filter(pos -> pos.isValidPosition())
				.map(pos -> {pos.addContent(); return pos;})
				.filter(pos -> pos.content == FREE && (!pos.equals(previousCeld))? true: false)
				.collect(Collectors.toList());
			
			System.out.println("Speces around celd " + this.toString() + " = " +  Arrays.asList(spaces));
			return spaces;
		}
	
		private void addContent() {
			this.content = mazeMatrix[this.row][this.col];
		}


		boolean isMatrixBorder() {
			return row == 0?true
					:row == mazeMatrix.length -1?true
					:col == 0?true
					:col == mazeMatrix[0].length -1?true
					:false;
		}

		boolean isValidPosition() {
			return  row >= 0 && col >= 0 && row < mazeMatrix.length && col < mazeMatrix[0].length;
					
		}
		
		@Override
		public String toString() {
			return "("+this.row+","+ this.col+")";
		}

		@Override
		public boolean equals(Object obj) {
			return obj != null && ((Position)obj).row == this.row && ((Position)obj).col == this.col;
		}	
	}

}
