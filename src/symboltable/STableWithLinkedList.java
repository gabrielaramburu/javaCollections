import java.util.*;

public class STableWithLinkedList {
	public static void main(String[] args) {
		SymbolTable st = new SymbolTable();
		st.put(1,"hola");
		st.put(2," como");
		st.put(3," estas");
		
		System.out.println("Expected output: hola como estas, output:" +  st.get(1)+st.get(2)+st.get(3));
		st.remove(2);
		System.out.println("Expected output: hola estas, output:" +  st.get(1)+st.get(2)+st.get(3));
		
		System.out.println("number of nodes " + st.numberOfNodes());
	}
}

class SymbolTable {
	private int nodes;
	
	private Node lastInserted;
	
	public void put (int key, String value) {
		for (Node node = lastInserted; node != null; node = node.next) {
			if (node.getKey() == key) {
				//replace de old value with the new
				node.value = value;
				return;
			}
		}
			
		lastInserted = new Node(key, value, lastInserted);
		nodes++;
	}
	
	public void remove(int key) {
		for (Node node = lastInserted; node != null; node = node.next) {
			// this is an interested part: I dont need a double linked list for to remove an element
			//in this case I ask for the  value of the next node respectivly the node I'm positioned
			if (node.next != null && node.next.getKey() == key) {
				node.next = node.next.next;
				nodes--;
				break;
			}
		}
	}
	
	public String get(int key) {
		for (Node node = lastInserted; node != null; node = node.next) {
			if (node.getKey() == key) {
				return node.getValue();
			}
		}
		
		return null;
	}
	
	public Iterable<Node> keys() {
		List<Node> list = new ArrayList<Node>();
		for (Node node = lastInserted; node != null; node = node.next) {
			list.add(node);
		}
		return list;
	}
	
	public int numberOfNodes(){
		return this.nodes;
	}
}

class Node {
	int key;
	String value;
	Node next;
		
	public Node(int key, String value, Node lastInserted) {
		this.key = key;
		this.value = value;
		this.next = lastInserted;
	}
	
	public int getKey(){
		return this.key;
	}

	public String getValue() {
		return this.value;
	}	
}