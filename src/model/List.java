package model;

public class List {
	
	private Node head;
	private Node actual;
	
	public void addLast(Node n) {
		if(head == null) {
			head = n;
			head.setNext(head);
			head.setPrev(head);
			actual = head;
			return;
		}else {
			Node tail = head.getPrev();
			head.setPrev(n);
			tail.setNext(n);
			
			n.setNext(head);
			n.setPrev(tail);
			return;
		}
	}

	
	public void print() {
		System.out.println("-------------");
		print(head);
		System.out.println("-------------");
	}
	private void print(Node n) {
		if(n.getNext() == head) {
			System.out.println(n.getValue());
			return;
		}
		System.out.println( n.getValue());
		print(n.getNext());
	}
	
	
	public void mostrarTurno() {
		if(actual == null) {
			System.out.println("no hay turnos aún");
			return;
		}else {
			System.out.println(actual.getValue());
		}
	}
	
	
	
	

}
