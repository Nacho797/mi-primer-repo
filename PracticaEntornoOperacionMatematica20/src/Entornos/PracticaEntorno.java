package Entornos;

import java.util.Scanner;

public class PracticaEntorno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int opc;
		int num1;
		int num2;
		System.out.println("Bienvenido a las operaciones matemáticas!");
		do {

			System.out.println("Elige las opciones para las operaciones matemáticas");
			System.out.println("1. Suma.");
			System.out.println("2. Resta.");
			System.out.println("3. Multiplicación.");
			System.out.println("4. División.");
			System.out.println("5. Salir");
			opc = sc.nextInt();

			switch (opc) {

			case 1:
				System.out.println("Dime un número");
				num1 = sc.nextInt();

				System.out.println("Dime el segundo número");
				num2 = sc.nextInt();
				num1 += num2;
				System.out.println("La suma total de número 1 y número 2 es: " + num1);
				break;
			case 2:
				System.out.println("Dime un número");
				num1 = sc.nextInt();

				System.out.println("Dime el segundo número");
				num2 = sc.nextInt();
				num1 -= num2;
				System.out.println("La suma total de número 1 y número 2 es: " + num1);
				break;
			case 3:
				System.out.println("Dime un número");
				num1 = sc.nextInt();

				System.out.println("Dime el segundo número");
				num2 = sc.nextInt();
				num1 *= num2;
				System.out.println("La suma total de número 1 y número 2 es: " + num1);
				break;
			case 4:
				System.out.println("Dime un número");
				num1 = sc.nextInt();

				System.out.println("Dime el segundo número");
				num2 = sc.nextInt();
				num1 /= num2;
				System.out.println("La suma total de número 1 y número 2 es: " + num1);
				break;
			case 5:
				System.out.println("Salir");
				break;
			default:
				System.out.println("Opción inválida");

			}

		} while (opc != 5);
	}

}
