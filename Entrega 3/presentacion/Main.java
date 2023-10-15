package presentacion;
/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

import logica.AdminGeneral;
import logica.EmpresaAlquiler;
import logica.Roles;
import logica.Usuario;

public class Main {
	
	private EmpresaAlquiler empresa;
	
	public Main() {
		this.empresa = new EmpresaAlquiler();
		Scanner sc = new Scanner(System.in);
		int op;
		//TODO Aca hagan el menu. y relacionen con las demas clases
		do {
			System.out.println("Digite:\n"
					+ "0. Salir\n"
					+ "1. Cargar Archivo\n"
					+ "2. Iniciar Sesion"
					+ "3. Iniciar Sesion");			
			op = sc.nextInt();
			
			if(op == 1) {				
				this.empresa.leerArchivos();
			}
			if(op == 2) {				
				iniciarSesion();
			
			}else if(op == 3) {
				crearCuenta();
				
			}
		}while(op != 0);
		sc.close();
	}
	
	//TODO IMPLEMENTAR
	private void iniciarSesion() {
		this.empresa = new EmpresaAlquiler();
		HashMap<String, Usuario>mapa=EmpresaAlquiler.getMapaUsuarios();
		Usuario user= new AdminGeneral("Admin","contraseña",Roles.ADMINISTRADORGENERAL);
		
		mapa.put("Admin",user);
		
		boolean accesoApp=false;
		while(!accesoApp) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Ingrese su nombre de usuario");
		String name = scanner.nextLine();
		System.out.print("Ingrese su contraseña");
		String password = scanner.nextLine();
		
		Usuario acceso= mapa.get(name);
		if (acceso.getPassword()!=password){
			System.out.println("Contraseña Incorrecta");
			
		}else {accesoApp=true;
		
		if(acceso.getRol()==Roles.ADMINISTRADORGENERAL) {
			MenuAdministradorGeneral(name,password,acceso.getRol());
		}
		
		if(acceso.getRol()==Roles.ADMINISTRADORSEDE) {}
		
		if(acceso.getRol()==Roles.EMPLEADO) {}
		
		if(acceso.getRol()==Roles.CLIENTE) {}
		
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		//if rol = admingeneral, entonces mostrar menu admin general
		//if rol = cliente mostrar opciones
	}
	
	
	///ifopcion3 -> input
	//nombre usuario, contrasena, la sede
	
	
	//Username password, de la clase abstracta usuario
	
	// private elegirMenu()
	
	//if user.cargo = Roles.ADMINISTRADORGENERAL{MOSTRARR MENU ADMIN}
	
	// mapa =  empresa.getmapa(usuario)
	// usuarioBuscado = mapa.get(usuario)
	// if usuarioBuscado.cargo = Roles.ADMINISTRADORGENERAL {MOSTRAR OPCIONES ADMIN }
	
	// if opcion == anadir sede
	//usuarioBuscado.addSede(nombreSede, empresa.listaSede)
	
	//TODO IMPLEMENTAR
	
	//se llama desde el main cuando el usuario seleccione que es un empleado y que quiere crear cuenta
	private void crearCuenta() {
		
		//todo llamar el mapa
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String username = null;
        String password = null;

        try {
            System.out.print("Introduce tu nombre de usuario: ");
            username = br.readLine();

            System.out.print("Introduce tu contraseña: ");
            password = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Has ingresado el siguiente nombre de usuario: " + username);
        System.out.println("Has ingresado la siguiente contraseña: " + password);
        //TODO preguntar todo licencia etc al cliente.
        
        //Constructor de cliente y luego anadirlo en el mapa ya instanciado

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private void MenuAdministradorGeneral(String username, String password, Roles rol) {
		this.empresa = new EmpresaAlquiler();
		Scanner sc = new Scanner(System.in);
		int op;
		//TODO Aca hagan el menu. y relacionen con las demas clases
		do {
			System.out.println("Menu Administrador General"
					+"Digite:\n"
					+ "0. Salir\n"
					+ "1. Crear Nuevo Administrador de la sede\n"
					+ "2. Eliminar Administrador de la sede\n"
					+ "3. Añadir nuevo Vehiculo\n"
					+ "4. Borrar Vehiculo\n"
					+ "5. Añadir nueva Sede\n"
					+ "6. Eliminar Sede\n"	
					+ "7. Eliminar Sede\n");
			op = sc.nextInt();
			
			if(op == 1) {				
				this.empresa.leerArchivos();
			}
			if(op == 2) {			
				System.out.println("Ingrese el codigo de la sede");
				String CodSede = sc.nextLine();
				EmpresaAlquiler.getAdmin().crearAdminSede(username, password,CodSede , Roles.ADMINISTRADORSEDE);;
				
			
			}else if(op == 3) {
				crearCuenta();
				
			}
		}while(op != 0);
		sc.close();
	}
		
	}
	private void MenuAdministradorSede() {
		
	}
	private void Empleado() {
		
	}
	private void Cliente() {
		
	}
	
        
	
	
	
	public static void main(String[] args) {
		new Main();
	}
	
}