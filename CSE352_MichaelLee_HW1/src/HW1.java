import java.io.*;
import java.util.*;

public class HW1 {
	
	//Enter file name here.
	final static String path = "src/input2.txt";
	
	public static void main(String[] args)  {
		int[] array = new int[9];
		ArrayList<Integer> al = new ArrayList<>();
		try {
			FileInputStream fileInput = new FileInputStream(path);
			int r;
			while((r = fileInput.read()) != -1) {
				char c = (char) r;
				if(c == '\n' || c == ' ') {
					continue;
				}
				if(c == 'B') {
					al.add(0);
					continue;
				}
				al.add(Integer.parseInt("" + c));
				
			}
			fileInput.close();
		} catch(Exception e) {
			System.err.println("File error: " + e.getMessage());
			System.exit(-1);
		}
		for(int i = 0; i < array.length; i++) {
			array[i] = al.get(i);
		}
		
		Board board = new Board(array);
		
		Node root = new Node(board, null, board.manhattan(), 0, board.euclidean());
		pQueue<Node> pq = new pQueue<Node>();
		
		
		Set<Node> seen = new HashSet<Node>();
		
		
		pq.add(root);

		Node priorityNode = root;
		
		System.out.println("Manhattan Heuristic: ");
		
		solve(priorityNode, 'm', seen, pq, root);
		
		System.out.println("---------------------------");
		
		pq.add(root);
		
		priorityNode = root;
		
		System.out.println("Euclidean Heuristic: ");
		
		solve(priorityNode, 'e', seen, pq, root);
		

		


	}
	
	public static void solve(Node priorityNode, char h, Set<Node> seen, pQueue<Node> pq, Node root) {
		
		if(h == 'm') {
			while(!priorityNode.getState().isSolved()) {


				String moves = priorityNode.getState().getMoves();
				for(int i = 0; i < moves.length(); i++) {
					Node child = priorityNode.getChild(priorityNode, moves.charAt(i));
					if(!seen.contains(child)) {
						pq.add(child);
					}
				}
				
				priorityNode = pq.getPq().get(0);
				
				for(int i = 0; i < pq.getSize(); i++) {

					if(!seen.contains(pq.getPq().get(i))) {
						priorityNode = pq.getPq().get(i);
						break;
					}
				}
				seen.add(priorityNode);
				

			
			}
			
			
			for(Node x = pq.getPq().get(0); x.getParent() != null; x = x.getParent()) {
				System.out.print("\n" + x.toString() + "\n^\n|\n|\n");
			}
			System.out.println("\n"+root.toString());
			
			seen.clear();
			pq.clear();
			
		}else if(h == 'e') {
			while(!priorityNode.getState().isSolved()) {


				String moves = priorityNode.getState().getMoves();
				for(int i = 0; i < moves.length(); i++) {
					Node child = priorityNode.getChild(priorityNode, moves.charAt(i));
					if(!seen.contains(child)) {
						pq.add2(child);
					}
				}
				
				priorityNode = pq.getPq().get(0);
				
				for(int i = 0; i < pq.getSize(); i++) {

					if(!seen.contains(pq.getPq().get(i))) {
						priorityNode = pq.getPq().get(i);
						break;
					}
				}
				seen.add(priorityNode);
				

			
			}
			
			for(Node x = pq.getPq().get(0); x.getParent() != null; x = x.getParent()) {
				System.out.print("\n" + x.toString2() + "\n^\n|\n|\n");
			}
			System.out.println("\n"+root.toString2());
			seen.clear();
			pq.clear();
		}else {
			return;
		}
		
		
		
	}
	
	
	
	public static int findIndex(int index, Set<Node> seen, pQueue<Node> pq) {
		for(int i = 0; i < pq.getSize(); i++) {
			if(!seen.contains(pq.getPq().get(i))) {
				return index;
			}else {
				index++;
			}
		}
		
		return 0;
		
	}

}
