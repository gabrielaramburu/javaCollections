package recursion.simplemaze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Maze {
	private final static char KATE = 'k';
	private final static char WALL = '#';
	private final static char FREE = ' ';
	private final static char FINAL = '*';
	
	private Position initialPos;
	private char[][] mazeMatrix;
	private int countKates = 0;

	public static void main(String[] args) {
		new Maze().hasExitRecursive(new String[] 
				{		"####",
						"#  #",
						"# k#",
						"#  #",
						"####"
						});}

	
	public static boolean hasExit(String[] maze) {

        return new Maze().hasExitRecursive(maze);
    }
	
	public boolean hasExitRecursive(String[] maze) {
		showArray(maze);
		buildMazeAsMatrixAndSetInitialPos(maze);
		if (countKates != 1) throw new IllegalArgumentException("Too many Kates");
		
		boolean result = findExit(
				this.initialPos.findSpacesAround(new ArrayList<Maze.Position>()), 
				this.initialPos,
				new ArrayList<Maze.Position>());
		
		return result; 
    }

	private boolean findExit(List<Position> spacesAroundCurrentPos, Position currentPos, List<Position> celdsOnPath) {
		if (currentPos.isMatrixBorder()) return true;
		
		for (Position spacePos: spacesAroundCurrentPos) {
			if (spacePos.isMatrixBorder()) return true;
		
			boolean result = findExit(
					spacePos.findSpacesAround(celdsOnPath), 
					new Position(spacePos.row, spacePos.col), 
					updateAndCopyCeldsOnPath(celdsOnPath, spacePos));
			if (result == true) return true;
			
		}

		return false;
	}
	
	private List<Position> updateAndCopyCeldsOnPath(List<Position> current, Position pos){
		List<Position> newList = new ArrayList<Maze.Position>();
		newList.addAll(current);
		newList.add(pos);
		return newList;
	}
	
	private void buildMazeAsMatrixAndSetInitialPos(String[] maze) {
		int columns = getMazeMaxSize(maze);
		int rows = maze.length;
		
		char[][] matrix = new char[rows][columns];
		for (int row = 0; row < matrix.length ; row++) {
			for (int col = 0;col< columns;col++ ){
				matrix[row][col] = characterToFillMatrix(maze[row], col);
				if (matrix[row][col] == KATE) { 
					this.initialPos = new Position(row, col);
					countKates++;
				};
			}
		}
		this.mazeMatrix = matrix;
	}
	
	private  int getMazeMaxSize(String[] maze) {
		return  Arrays.asList(maze).stream()
				.reduce((str1, str2) -> str1.length() >= str2.length()?str1:str2).get().length();
	}

	private char characterToFillMatrix(String charsOfRow, int matrixCol) {
		char charFromRow = matrixCol < charsOfRow.length()   
				?charsOfRow.charAt(matrixCol)
				:FREE;
		
		return charFromRow;
	}
	
	class Position {
		int row;
		int col;
		char content;
		
		Position (int row, int col) {
			this.row = row;
			this.col = col;
		}

		List<Position> findSpacesAround(List<Position> celdsOnPath) {
			List<Position> neighborCelds = new ArrayList<Maze.Position>();
			neighborCelds.add(new Position(this.row - 1, this.col));
			neighborCelds.add(new Position(this.row + 1, this.col));
			neighborCelds.add(new Position(this.row, this.col + 1));
			neighborCelds.add(new Position(this.row, this.col - 1));
			
			Predicate<Position> celdDoesNotBelongToCurrentPath = pos -> celdsOnPath.contains(pos) ? false:true;
			Predicate<Position> isValidPosition = pos -> pos.isInsideTheMatrix()? true:false;
			Predicate<Position> isFree = pos -> pos.isFree()? true: false;
					
			neighborCelds.stream().filter(isValidPosition).forEach(pos -> pos.addContent());
			
			List<Position> spaces = 
					neighborCelds.stream()
						.filter(celdDoesNotBelongToCurrentPath.and(isValidPosition).and(isFree))
						.collect(Collectors.toList());
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

		boolean isInsideTheMatrix() {
			return row >= 0 && col >= 0 && row < mazeMatrix.length && col < mazeMatrix[0].length;
		}
		
		boolean isFree() {
			return content != WALL;
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
	
	private void showMatrix(char[][] mat, Position pos) {
		System.out.println("New matrix");
		char aux = mat[pos.row][pos.col];
		mat[pos.row][pos.col] = 'X';
		for (char[] arr : mat) {
			System.out.println(Arrays.toString(arr));
		}
		mat[pos.row][pos.col]=aux;
	}
	
	private void showArray(String[] arg) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for (String line: arg) {

			builder.append("\"");
			builder.append(line);
			builder.append("\",");
			builder.append("\n");
		}
		builder.append("}");
		System.out.println(builder.toString());
	}

}
