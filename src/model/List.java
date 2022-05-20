package model;

public class List {

	private Node head;
	private Node actual;

	public boolean confirmation() {
		if (head == null) {
			return false;
		} else {
			return true;
		}

	}

	public void addLast(Node n) {
		if (head == null) {
			head = n;
			head.setNext(head);
			head.setPrev(head);
			actual = head;
			return;
		} else if (n.getValue() == 50) {
			System.out.println("No se pueden añadir mas turnos");
			return;
		} else {
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
		if (n.getNext() == head) {
			System.out.println(n.getValue());
			return;
		}
		System.out.println(n.getValue());
		print(n.getNext());
	}

	public void mostrarTurno() {
		if (actual == null) {
			System.out.println("no hay turnos aún");
			return;
		} else {
			System.out.println(actual.getValue());
		}
	}

	public void passTurn() {
		actual.count++;
		actual = actual.getNext();
		System.out.println("se paso el turno");
		System.out.println("Turno actual: " + actual.getValue());
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
		if (n.count != 3) {
			System.out.println("No se elimino ningun turno");
			return;
		} else if (n.getNext() == head) {
			return;
		}
		System.out.println("se ha eliminado el turno: " + n.getValue());
		Node a = n.getNext();
		Node b = n.getPrev();
		a.setPrev(b);
		b.setNext(a);
		actual = a;
		head = actual;

		elimLateTurns(n.getNext());

	}

	public void showTurns() {
		System.out.println("----------------------");
		showTurns(head);
		System.out.println("----------------------");
	}

	private void showTurns(Node n) {
		if (n.getNext() == head) {
			System.out.println(n.getValue());
			return;
		}
		System.out.println(n.getValue());
		showTurns(n.getNext());
	}

}
