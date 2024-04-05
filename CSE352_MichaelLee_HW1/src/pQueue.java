import java.util.ArrayList;
public class pQueue<T> {
	private ArrayList<Node> pq;
	private int size;
	
	public pQueue(){
		pq = new ArrayList<>();
		size = 0;
	}
	
	public void add(Node node) {
		if(size == 0) {
			pq.add(node);
			size++;
		} else {
			for(int i = 0; i < size; i++) {
				if(pq.get(i).getF() > node.getF()) {
					pq.add(0, node);
					size++;
					return;
				}
				
			}
			pq.add(node);
			size++;	
		}
		
		
			
		
	}
	public void add2 (Node node) {
		if(size == 0) {
			pq.add(node);
			size++;
		} else {
			for(int i = 0; i < size; i++) {
				if(pq.get(i).getF2() > node.getF2()) {
					pq.add(0, node);
					size++;
					return;
				}
				
			}
			pq.add(node);
			size++;	
		}
		
		
			
		
	}
	
	public void remove(Node n) {
		pq.remove(n);
	}
	
	
	public ArrayList<Node> getPq(){
		return pq;
	}
	
	public int getSize() {
		return size;
	}
	
	public void clear() {
		pq.clear();
		size = 0;
	}
	
	

}
