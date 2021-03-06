package main;

import java.util.Scanner;
import model.*;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	static List list;
	public static void main(String[] args) {
		list = new List();
		int option = 0;
		do {
			if(list.confirmation() == true) {
				list.elimLateTurns();
			}
			System.out.println("1. Asignar turno" + 
					"\n2. Mostrar turno"+
					"\n3. Pasar turno" + 
					"\n4. Eliminar turno actual"+
					"\n5. Mostrar todos los turnos"+
					"\n0. Cerrar programa");
			option = sc.nextInt();
			switchMenu1(option);
		}while(option != 0);
		
		
	
	}
	public static void switchMenu1(int option) {
		switch(option) {
		case 1:
			System.out.println("Entre el turno a asignar");
			int turno = sc.nextInt();
			list.addLast(new Node(turno));
			list.print();
			break;
		case 2:
			System.out.println("------------------");
			list.mostrarTurno();
			System.out.println("------------------");
			break;
		case 3:
			System.out.println("------------------");
			list.passTurn();
			System.out.println("------------------");
			break;
		case 4:
			list.elimTurn();
			break;
		case 5:
			list.showTurns();
			break;
		}
		
	}

}
