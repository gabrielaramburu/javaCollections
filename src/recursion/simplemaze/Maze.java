package recursion.simplemaze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
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
				new Position(this.initialPos.row,this.initialPos.col),
				new ArrayList<Maze.Position>());
		
		//System.out.println(result);
		return result; 
    }

	private boolean findExit(List<Position> spacesAround, Position currentPos, List<Position> celdsOnPath) {
		if (currentPos.isMatrixBorder()) return true;

		if (spacesAround.size() == 0 ) {
			currentPos.markAsFinalPositionOnPath();
		}
		
		for (Position spacePos: spacesAround) {
			if (spacePos.isMatrixBorder()) return true;
		
			spacePos.incrementNumbreOfVisitToPosition();
			//System.out.println("Estoy en celda:" + spacePos.toString());
		
			boolean result = findExit(
					spacePos.findSpacesAround(celdsOnPath), 
					new Position(spacePos.row, spacePos.col), 
					createNewListAndAddPos(celdsOnPath, spacePos));
			if (result == true) return true;
			
		}
		
		//System.out.println("termime for ");

		return false;
	}
	
	private List<Position> createNewListAndAddPos(List<Position> current, Position pos){
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
				matrix[row][col] = characterFromMazeRow(maze[row], col);
				if (matrix[row][col] == KATE) { 
					this.initialPos = new Position(row, col);
					countKates++;
				};
			}
		}
		this.mazeMatrix = matrix;
	}
	
	private boolean matrixFullCoverage() {
	
		for (int row = 0; row < this.mazeMatrix.length ; row++) {
			for (int col = 0;col< this.mazeMatrix[0].length;col++ ){
				if (this.mazeMatrix[row][col] == FREE) return false;
			}
		}
		//System.out.println("matrix llena");
		return true;
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

	private void showMatrix(char[][] mat, Position pos) {
		System.out.println("New matrix");
		char aux = mat[pos.row][pos.col];
		mat[pos.row][pos.col] = 'X';
		for (char[] arr : mat) {
			System.out.println(Arrays.toString(arr));
		}
		mat[pos.row][pos.col]=aux;
//		try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		Scanner s = new Scanner(System.in);
		//s.next();
		
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
	
	class Position implements Comparable<Position>{
		int row;
		int col;
		char content;
		
		Position (int row, int col) {
			this.row = row;
			this.col = col;
		}

		

		List<Position> findSpacesAround(List<Position> ingonerCelds) {
			List<Position> neighborCelds = new ArrayList<Maze.Position>();
			neighborCelds.add(new Position(this.row - 1, this.col));
			neighborCelds.add(new Position(this.row + 1, this.col));
			neighborCelds.add(new Position(this.row, this.col + 1));
			neighborCelds.add(new Position(this.row, this.col - 1));
			
			Predicate<Position> celdDoesNotBelongToCurrentPath = pos -> ingonerCelds.contains(pos) ? false:true;
			Predicate<Position> isValidPosition = pos -> pos.isInsideTheMatrix()? true:false;
			Predicate<Position> isFree = pos -> pos.isFree()? true: false;
			Predicate<Position> notFinalPath = pos -> pos.content == FINAL? false:true;
					
			neighborCelds.stream().filter(isValidPosition).forEach(pos -> pos.addContent());
			//System.out.println(" despues de cargar contenido");
			//showMatrix(mazeMatrix, this);
			//neighborCelds.forEach(pos -> System.out.println(pos.toString() + pos.content));
			List<Position> spaces = 
					neighborCelds.stream()
						.filter(celdDoesNotBelongToCurrentPath.and(isValidPosition).and(isFree).and(notFinalPath))
						.sorted(Comparator.reverseOrder())
						.collect(Collectors.toList());
		
			//System.out.println("Speces around celd: " + this.toString());
			//spaces.forEach(pos -> System.out.print(pos.toString() + " " + Character.toString(pos.content)));
			//System.out.println("");
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
			boolean result =  row >= 0 && col >= 0 && row < mazeMatrix.length && col < mazeMatrix[0].length;
			//System.out.println("Checking valid position for celd: " + this.toString() + " result " + result);
			return result;
					
		}
		
		boolean isFree() {
			return content != WALL;
		}
		
		public void incrementNumbreOfVisitToPosition() {
			if (this.content == FREE) mazeMatrix[this.row][this.col] = '1';
			mazeMatrix[this.row][this.col] += 1; 
		}
		
		public void markAsFinalPositionOnPath() {
			mazeMatrix[this.row][this.col] = FINAL;
		}
		
		
		@Override
		public String toString() {
			return "("+this.row+","+ this.col+")";
		}

		@Override
		public boolean equals(Object obj) {
			return obj != null && ((Position)obj).row == this.row && ((Position)obj).col == this.col;
		}

		@Override
		public int compareTo(Position pos) {
			return pos.content - this.content;
		}	
	}

}
