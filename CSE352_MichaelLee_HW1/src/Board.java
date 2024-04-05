import java.util.*;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.io.*;
public class Board {
	
	private int N = 3;
	private int[] board = new int[9];
	
	public Board(int[] board2) {
		for(int i = 0; i < board2.length; i++) {
			board[i] = board2[i];
		}
	}
	 public int dimension() {
		 return N;
	 }
	 
	 public int manhattan() {
		 int sum = 0;
		 for(int i = 0; i < 9; i++) {
			 if(board [i] != i + 1 && board[i] != 0) {
				 sum = sum + manhattanDist(board[i], i);
			 }
		 }
		 return sum;
	 }
	 
	 public double euclidean() {
		 double sum = 0.0;
		 for(int i = 0; i < 9; i++) {
			 if(board [i] != i + 1 && board[i] != 0) {
				 sum = sum + euclideanDist(board[i], i);
			 }
		 }
		 return sum;
		 
		 
	 }
	 
	 private double euclideanDist(int value, int pos) {
		Point point1 = new Point(pos / N, pos % N);
		Point point2 = new Point((value - 1) / N, (value - 1) % N);
		return point1.distance(point2);
	 }
	 
	 private int manhattanDist(int value, int pos) {
		 int row, column;
		 row = Math.abs((value - 1) % 3 - (pos % 3));
		 column = Math.abs((value - 1) / 3 - (pos / 3));
		 return row + column;
	 }
	 
	 public boolean isSolved() {
		 for(int i = 0; i < 8; i++) {
			 if(board[i] != i + 1) {
				 return false;
			 }
		 }
		 return true;
	 }
	 
	public String toString() {
		return Arrays.toString(board);
	}
	
	public String getMoves() {
		String m;
		StringBuilder sb = new StringBuilder();
		int index = getIndex();
		
				switch(index) {
				case 0: sb.append("RD");
						break;
				case 1: sb.append("LRD");
						break;
				case 2: sb.append("LD");
						break;
				case 3: sb.append("URD");
						break;
				case 4: sb.append("LURD");
						break;
				case 5: sb.append("LUD");
						break;
				case 6: sb.append("UR");
						break;
				case 7: sb.append("LUR");
						break;
				case 8: sb.append("LU");
						break;
			

				}
		
		m = sb.toString();
		return m;
	}
	
	public int[] getBoard() {
		return board;
	}
	
	public int getIndex() {
		int index = -1;
		for(int i = 0; i < 9; i++) {
			if(board[i] == 0) {
				index = i;
			}
		}
		return index;
		
	}

}
