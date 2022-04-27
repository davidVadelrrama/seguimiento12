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


	
	
	public void passTurn() {
		actual.setCount(actual.getCount()+1);
		actual = actual.getNext();
		System.out.println("se paso el turno");
	}
	
	
	public void elimTurn() {
		elimTurn(actual);
		
	}
	
	private void elimTurn(Node current) {
		Node a = current.getNext();
		Node b = current.getPrev();
		a.setPrev(b);
		b.setNext(a);
		actual = a;
		head = actual;
		showTurns();
	}
	
	public void elimLateTurns() {
		elimLateTurns(actual);
	}


	private void elimLateTurns(Node n) {
		Node a = n.getNext();
		Node b = n.getPrev();
		if(n.getCount() == 3) {
			a.setPrev(b);
			b.setNext(a);
			actual = a;
			head = actual;
			return;
		}
		elimLateTurns(n.getNext());
	}


	public void showTurns() {
		System.out.println("----------------------");
		showTurns(head);
		System.out.println("----------------------");
	}
	private void showTurns(Node n) {
		if(n.getNext() == head) {
			System.out.println(n.getValue());
			return;
		}
		System.out.println(n.getValue());
		showTurns(n.getNext());
	}
	
	

}
