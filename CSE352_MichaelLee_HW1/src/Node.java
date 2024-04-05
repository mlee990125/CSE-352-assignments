import java.util.*;
import java.io.*;

public class Node {
	
	private Board state;
	private Node parent;
	private int hManhattan;
	private int gVal;
	private int fVal;
	private double fVal2;
	private double hEuclidean;
	
	public Node(Board root, Node parent, int hManhattan, int gVal, double hEuclidean) {
		this.state = root;
		this.parent = parent;
		this.hManhattan = hManhattan;
		this.gVal = gVal;
		this.fVal = gVal + hManhattan;
		this.hEuclidean = hEuclidean;
		this.fVal2 = gVal + hEuclidean;
	}
	
	public int getHManhattan() {
		return hManhattan;
	}
	
	public double getHEuclidean() {
		return hEuclidean;
	}
	
	
	public Board getState() {
		return this.state;
	}
	
	public Node getChild(Node node, char move) {
		Node childNode = null;
		int[] clone = node.getState().getBoard().clone();
		int index = node.getState().getIndex();
		if(move == 'L') {
			swap(clone, index, index - 1);
		}else if(move == 'U') {
			swap(clone, index, index - 3);
		}else if(move == 'R') {
			swap(clone, index, index + 1);
		}else if(move == 'D') {
			swap(clone, index, index + 3);
		}else {
			
		}
		Board childBoard = new Board(clone);
		childNode = new Node(childBoard, node, childBoard.manhattan(), this.gVal + 1, childBoard.euclidean());
		return childNode;
		
		
	}
	
	private void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	
	public int getF() {
		return fVal;
	}
	
	public double getF2() {
		return fVal2;
	}
	
	public String toString() {
		return this.state.toString() + "\nF: " + fVal + " G: " + gVal + " H(m): " + hManhattan;
	}
	
	public String toString2() {
		return this.state.toString() + "\nF: " + fVal2 + " G: " + gVal + " H(e): " + hEuclidean;
	}
	
	
	public Node getParent() {
		return parent;
	}
	
	@Override
	public boolean equals(Object o) {
		return Arrays.equals(this.getState().getBoard(), ((Node) o).getState().getBoard());
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
	
	
	
	


	
	
	

}
