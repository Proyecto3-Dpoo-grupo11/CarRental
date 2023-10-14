package logica;

import java.util.ArrayList;
import java.util.HashMap;

import persistencia.LectorArchivo;

/**
 * <!-- ACA VA DOCUMENTACION -->
 * TODO  ahi vamos viendo que metodos metemos hasata ahora asi.  -->
 */

public class EmpresaAlquiler
{
	static HashMap<String, Usuario> mapaUsuarios;
	ArrayList<Sede> listaSedes;
	
	/**
	 * <!-- CONSTRUCTOR -->
	 */
	
	public EmpresaAlquiler() {
		this.listaSedes = new  ArrayList<Sede>();
		EmpresaAlquiler.mapaUsuarios = new HashMap<String, Usuario>();
	}
	
	/**
	 * <!-- METODO PARA LA CONSOLA -->
	 */

	public void leerArchivos() {
		
		ArrayList<String> lineas;
		lineas = LectorArchivo.leer("empleados.dat");
		for(String linea : lineas) {
			String []datos = linea.split(";");
			Usuario u = new Empleado((datos[0]), datos[1], Integer.parseInt(datos[2]), Roles.EMPLEADO); //SE LLAMA AL CONSTRUCTOR DE EMPLEADO 		
			EmpresaAlquiler.mapaUsuarios.put(datos[0], u);	//SE GUARDA EN EL MAPA EL USERNAME Y EL USUARIO 		
		}//ACA HAY QUE GUARDARLL EN LA SEDE QUE PERTENECE.


		lineas = LectorArchivo.leer("administradores.dat"); 
		for(String linea : lineas) {
			String []datos = linea.split(";");
			Usuario u = new AdminSede(datos[0], datos[1], Integer.parseInt(datos[2]), Roles.ADMINISTRADORSEDE); // Polimorfismo porque creamos un usuario U pero como un adminsitrador Sede
			EmpresaAlquiler.mapaUsuarios.put(datos[0], u);			
		}
	
//valuesMapa.Usuarios.Cliente.nombre
		
		//TODO IMPLEMENTAR
		lineas = LectorArchivo.leer("clientes.dat");
		for(String linea : lineas) {
			String []datos = linea.split(";");
			Usuario u = new Cliente(datos[0], datos[1], Roles.CLIENTE, datos[2], datos[3], datos[4], datos[5], datos[6], datos[7], datos[8], datos[9], datos[10], datos[11]); 
			EmpresaAlquiler.mapaUsuarios.put(datos[0], u);		
		}
		
		//TODO IMPLEMENTAR SEDES
		lineas = LectorArchivo.leer("sedes.dat");
		for(String linea : lineas) {
			String []datos = linea.split(";");
			ArrayList<Sede> listaSedes;
			Sede u = new Sede(datos[0], datos[1], datos[2],listaVehiculos,listaEmpleados,listaReservas); 
			listaSedes.add(u);
		}
			
		
	}
		
		public String infoCarroEspecifico() {
			//Busquedas, guardan variables
			return ("el carro %s, esta en %s........."); //.format(codigocarro,ubicacion,etc)
		}
	
	/**
	 * <!-- GETTERS SETTERS -->
	 */

	public ArrayList<Sede> getListaSedes() {
		return listaSedes;
	}

	public void setListaSedes(ArrayList<Sede> listaSedes) {
		this.listaSedes = listaSedes;
	}
	
}
	


