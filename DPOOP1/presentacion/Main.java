package presentacion;
/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

import java.util.Scanner;

import logica.EmpresaAlquiler;

public class Main {
	
	private EmpresaAlquiler empresa;
	
	public Main() {
		this.empresa = new EmpresaAlquiler();
		Scanner sc = new Scanner(System.in);
		int op;
		//Aca hagan el menu. y relacionen con las demas clases
		do {
			System.out.println("Digite:\n"
					+ "0. Salir\n"
					+ "1. Cargar Archivo\n"
					+ "2. \n");			
			op = sc.nextInt();
			if(op == 1) {				
				this.empresa.leerArchivos();
			}else if(op == 2) {
				
			}
		}while(op != 0);
		sc.close();
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}




