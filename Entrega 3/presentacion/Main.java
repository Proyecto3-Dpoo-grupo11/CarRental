package presentacion;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

import java.util.Scanner;

import logica.AdminGeneral;
import logica.AdminSede;
import logica.Cliente;
import logica.Empleado;
import logica.EmpresaAlquiler;
import logica.Estados;
import logica.Roles;
import logica.Usuario;

public class Main {

	private EmpresaAlquiler empresa;

	public Main() {
		this.empresa = new EmpresaAlquiler();
		Scanner sc = new Scanner(System.in);
		int op;
		// TODO Aca hagan el menu. y relacionen con las demas clases
		do {
			System.out.println("Digite:\n" + "0. Salir\n" + "1. Iniciar Sesion" + "2. Crear Usuario"); // Tiene que
																										// primero
																										// preguntar si
																										// es un admin
																										// empleado o
																										// cliente, SOLO
																										// si
			// es cliente entonces si se puede usar el metodo crear usuario, si no NO.
			// Dependiendo de cual sea toca especificar el tipo de usuario.
			op = sc.nextInt();
			this.empresa.leerArchivos();

			if (op == 1) {
				iniciarSesion(empresa);

			} else if (op == 2) {
				crearCuenta(empresa);

			}
		} while (op != 0);
		sc.close();
	}

	// TODO IMPLEMENTAR
	private void iniciarSesion(EmpresaAlquiler empresa) {

		boolean accesoApp = false;
		while (!accesoApp) {
			Scanner scanner = new Scanner(System.in);

			System.out.print("Ingrese su nombre de usuario");
			String name = scanner.nextLine();
			System.out.print("Ingrese su contraseña");
			String password = scanner.nextLine();
			scanner.close();
			Usuario accesoGeneral = (EmpresaAlquiler.mapaUsuarios.get(name));
			if (accesoGeneral.getPassword() != password) {
				System.out.println("Contraseña Incorrecta");

				

			} else {
				accesoApp = true;

				if (accesoGeneral.getRol() == Roles.ADMINISTRADORGENERAL) {

					AdminGeneral accesoAdmiGeneral = (AdminGeneral) EmpresaAlquiler.mapaUsuarios.get(name);
					MenuAdministradorGeneral(accesoAdmiGeneral);
					if(name=="admin") {
					

					System.out.print("Ingrese su nuevo nombre de usuario");
					String nuevoUser = scanner.nextLine();
					System.out.print("Ingrese su contraseña");
					String nuevoPassword = scanner.nextLine();
					accesoAdmiGeneral.cambiarContraseña(name, nuevoUser, nuevoPassword, Roles.ADMINISTRADORGENERAL);
					scanner.close();
					}
					// TODO admin general crear metodo cambiar contrasena

				}

				if (accesoGeneral.getRol() == Roles.ADMINISTRADORSEDE) {
					AdminSede accesoAdminSede = (AdminSede) EmpresaAlquiler.mapaUsuarios.get(name);
					MenuAdministradorSede(accesoAdminSede);
				}

				if (accesoGeneral.getRol() == Roles.EMPLEADO) {
					Empleado accesoEmpleado = (Empleado) EmpresaAlquiler.mapaUsuarios.get(name);
					MenuEmpleado(accesoEmpleado);
				}

				if (accesoGeneral.getRol() == Roles.CLIENTE) {
					Cliente accesoCliente = (Cliente) EmpresaAlquiler.mapaUsuarios.get(name);
					MenuCliente(accesoCliente);
				}
			}

		}
		
	}

	// if rol = admingeneral, entonces mostrar menu admin general
	// if rol = cliente mostrar opciones

	/// ifopcion3 -> input
	// nombre usuario, contrasena, la sede

	// Username password, de la clase abstracta usuario

	// private elegirMenu()

	// if user.cargo = Roles.ADMINISTRADORGENERAL{MOSTRARR MENU ADMIN}

	// mapa = empresa.getmapa(usuario)
	// usuarioBuscado = mapa.get(usuario)
	// if usuarioBuscado.cargo = Roles.ADMINISTRADORGENERAL {MOSTRAR OPCIONES ADMIN
	// }

	// if opcion == anadir sede
	// usuarioBuscado.addSede(nombreSede, empresa.listaSede)

	// TODO IMPLEMENTAR

	// se llama desde el main cuando el usuario seleccione que es un empleado y que
	// quiere crear cuenta
	private void crearCuenta(EmpresaAlquiler empresa) {
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Crear un cliente:");

		System.out.print("Ingrese el nombre de usuario: ");
		String nuevoUsername = sc.next();
		System.out.print("Ingrese la contraseña: ");
		String newPassword = sc.next();

		System.out.print("Ingrese el nombre del cliente: ");
		String nombreCliente = sc.next();

		System.out.print("Ingrese el email: ");
		String email = sc.next();

		System.out.print("Ingrese el telefono: ");
		String telefono = sc.next();

		System.out.print("Ingrese su fecha de nacimiento: ");
		String fechaNacimiento = sc.next();

		System.out.print("Ingrese su nacionalida: ");
		String nacionalidad = sc.next();

		System.out.print("Ingrese la foto de su cedula: ");
		String imagenCedula = sc.next();

		System.out.print("Ingrese la imagen de su licencia: ");
		String imagenLicencia = sc.next();

		System.out.print("Ingrese su metodo de pago: ");
		String metodoDePago = sc.next();

		System.out.print("Ingrese su numero de tarjeta: ");
		String numeroTarjeta = sc.next();

		System.out.print("Ingrese la fecha de vencimiento de su tarjeta: ");
		String fechaVencimiento = sc.next();
		empresa.crearCliente(nuevoUsername, newPassword, Roles.CLIENTE, nombreCliente, email, telefono,
				fechaNacimiento, nacionalidad, imagenCedula, imagenLicencia, metodoDePago, numeroTarjeta,
				fechaVencimiento);
		sc.close();
	}
		

	private void MenuAdministradorGeneral(AdminGeneral accesoAdmiGeneral) {
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
					+ "7. Modificar Seguros\n");
			op = sc.nextInt();
			
			if(op == 1) {			
				System.out.println("Ingrese el nombre de usuario del nuevo administrador de la sede");
				String userNuevoAdminSede = sc.nextLine();
				System.out.println("Ingrese la contraseña del nuevo administrador de la sede");
				String passwordNuevoAdminSede = sc.nextLine();
				System.out.println("Ingrese el codigo de la sede");
				String CodSede = sc.nextLine();
				//DIGITE NOMBRE DE ADMIN, PASSWORD, Cod sede
				
				
				accesoAdmiGeneral.crearAdminSede(userNuevoAdminSede,passwordNuevoAdminSede,CodSede,Roles.ADMINISTRADORSEDE);
				
			
			}else if(op == 2) {
				System.out.println("Ingrese el username del administrador que desea borrar");
				String userBorrarAdminSede = sc.nextLine();
				System.out.println("Ingrese el codigo de la sede a la que pertence el administrador que desea borrar ");
				String codigoSedeBorrarAdminSede = sc.nextLine();
				accesoAdmiGeneral.eliminarAdminSede(userBorrarAdminSede,codigoSedeBorrarAdminSede);	
				
			}else if(op == 3) {
				System.out.print("Registrar nuevo vehiculo: ");
				
				System.out.print("Ingrese la categoría del vehículo: ");
                String categoria = sc.next();

                System.out.print("Ingrese la placa del vehículo: ");
                String placa = sc.next();

                System.out.print("Ingrese la marca del vehículo: ");
                String marca = sc.next();

                System.out.print("Ingrese el modelo del vehículo: ");
                String modelo = sc.next();

                System.out.print("Ingrese el color del vehículo: ");
                String color = sc.next();

                System.out.print("Ingrese el tipo de transmisión del vehículo: ");
                String tipoTransmision = sc.next();

                System.out.print("Ingrese el código de sede: ");
                String codigoSede = sc.next();
               
                accesoAdmiGeneral.nuevoVehiculo(categoria, placa, marca, "", modelo, color, tipoTransmision,Estados.DISPONIBLE, codigoSede);
			
			}else if(op == 4) {
				
				System.out.print("Ingrese la placa del vehiculo que desea eliminar: ");
                String placa = sc.next();

                

                System.out.print("Ingrese el código de la sede: ");
                String codigoSede3 = sc.next();

                accesoAdmiGeneral.borrarVehiculo(placa, codigoSede3);
				
			}else if(op == 5) {
				
				System.out.print("Ingrese el código de la sede: ");
                String codigoSede = sc.next();

                System.out.print("Ingrese la ubicación de la sede: ");
                String ubicacion = sc.next();

                System.out.print("Ingrese el horario de atención de la sede: ");
                String horarioAtencion = sc.next();
                accesoAdmiGeneral.addSede(codigoSede, ubicacion, horarioAtencion);
				
			}else if(op == 6) {
				System.out.print("Ingrese el código de la sede que desea eliminar: ");
                String codigoSede = sc.next();

                accesoAdmiGeneral.eliminarSedes(codigoSede);
                        
			}else if(op == 7) {
				System.out.print("Ingrese el nombre del seguro que desea modificar: ");
                String nombreSeguro = sc.next();
                System.out.print("Ingrese el nombre del seguro nuevamente o escriba uno nuevo si desea cambiar el nombre: ");
                String nuevoNombreSeguro = sc.next();
                System.out.print("Ingrese la nueva tarifa del seguro: ");
                int tarifaSeguro = sc.nextInt();
				accesoAdmiGeneral.modificarSeguro(nombreSeguro,nuevoNombreSeguro,tarifaSeguro);
                

		}}while(op != 0);{
		sc.close();
	}
   
}

	

	private void MenuAdministradorSede(AdminSede adminSede) {
		this.empresa = new EmpresaAlquiler();
		Scanner sc = new Scanner(System.in);
		int op;
		do {
			System.out.println(
					"Menu Administrador Sede" 
					+"0. Salir\n" 
					+"1. Crear nuevo empleado\n"
					+ "2. Eliminar un empleado\n");
			op = sc.nextInt();

			
			if (op == 1) {
				System.out.println("Agregar un empleado:");
				System.out.print("Ingrese el nombre de usuario: ");
				String nuevoUsername = sc.next();
				System.out.print("Ingrese la contraseña: ");
				String newPassword = sc.next();

				// Llama al método de agregar empleado de la clase AdminSede
				adminSede.addEmpleado(nuevoUsername, newPassword,Roles.EMPLEADO);
				System.out.println("Empleado agregado con éxito.");

			}
			if (op == 2) {
				System.out.println("Eliminar un empleado:");
				System.out.print("Ingrese el nombre de usuario del empleado a eliminar: ");
				String usernameAEliminar = sc.next();

				adminSede.deleteEmpleado(usernameAEliminar);
				System.out.println("Empleado eliminado con éxito.");
			}
		} while (op != 0);
		{
			sc.close();
		}

	}

	private void MenuEmpleado(Empleado empleado) {

		Scanner sc = new Scanner(System.in);
		int opcion = 0;

		 do{
			
			
			System.out.println("Menú de Empleado:");
			System.out.println("1. Mandar vehículo a mantenimiento");
			System.out.println("2. Crear un cliente");
			System.out.println("3. Iniciar una reserva");
			System.out.println("4. Cerrar y guardar reserva");
			System.out.println("5. Generar reporte de vehículos en mantenimiento");
			System.out.println("6. Generar entrega");
			System.out.println("7. Añadir Conductor adiccional");
			System.out.println("8. Salir");
			System.out.print("Elija una opción: ");
			opcion = sc.nextInt();

			if (opcion == 1) {
				System.out.println("Mandar vehículo a mantenimiento:");
				System.out.println("Ingrese la placa del vehiculo");
				String placaVehiculo = sc.next();
				empleado.mandarMantenimiento(placaVehiculo);
			} else if (opcion == 2) {
				System.out.println("Crear un cliente:");

				System.out.print("Ingrese el nombre de usuario: ");
				String nuevoUsername = sc.next();
				System.out.print("Ingrese la contraseña: ");
				String newPassword = sc.next();

				System.out.print("Ingrese el nombre del cliente: ");
				String nombreCliente = sc.next();

				System.out.print("Ingrese el email: ");
				String email = sc.next();

				System.out.print("Ingrese el telefono: ");
				String telefono = sc.next();

				System.out.print("Ingrese su fecha de nacimiento: ");
				String fechaNacimiento = sc.next();

				System.out.print("Ingrese su nacionalida: ");
				String nacionalidad = sc.next();

				System.out.print("Ingrese la foto de su cedula: ");
				String imagenCedula = sc.next();

				System.out.print("Ingrese la imagen de su licencia: ");
				String imagenLicencia = sc.next();

				System.out.print("Ingrese su metodo de pago: ");
				String metodoDePago = sc.next();

				System.out.print("Ingrese su numero de tarjeta: ");
				String numeroTarjeta = sc.next();

				System.out.print("Ingrese la fecha de vencimiento de su tarjeta: ");
				String fechaVencimiento = sc.next();

				empleado.crearCliente(nuevoUsername, newPassword, Roles.CLIENTE, nombreCliente, email, telefono,
						fechaNacimiento, nacionalidad, imagenCedula, imagenLicencia, metodoDePago, numeroTarjeta,
						fechaVencimiento);
			} else if (opcion == 3) {
				System.out.println("Iniciar una reserva:");

				
				System.out.print("Ingrese el tipo de carro: ");
				String tipoDeCarro = sc.next();

				System.out.print("Ingrese el codigo de la sede en la que se recogera el vehiculo ");
				String sedeRecogida = sc.next();

				System.out.print("Ingrese el codigo de la sede en la que se entregara el vehiculo");
				String sedeEntrega = sc.next();
				
				System.out.print("Ingrese la fecha y hora de recogida en el formato Año/Mes/Dia/Hora/Min/Seg: ");
				String fechaHoraRecogida = sc.next();

				System.out.print("Ingrese la fecha y hora de entrega en el formato Año/Mes/Dia/Hora/Min/Seg: ");
				String fechaHoraEntrega = sc.next();

				System.out.print("Ingrese la placa del vehiculo: ");
				String placaVehiculo = sc.next();

				System.out.print("Ingrese el usuario del cliente: ");
				String usernameCliente = sc.next();
				
				
				empleado.iniciarReserva("", tipoDeCarro, sedeRecogida, sedeEntrega,"",
						fechaHoraRecogida, fechaHoraEntrega, placaVehiculo, usernameCliente,
						"",0,0,0,"");
			} else if (opcion == 4) {
				System.out.println("Cerrar y guardar reserva:");
				empleado.cerrarGuardarReserva();
			} else if (opcion == 5) {
				System.out.println("Generar reporte de vehículos en mantenimiento: ");
				empleado.reporteCarrosMantenimiento();
				
				
				
				
			}else if (opcion == 6) {
				System.out.println("Generar reporte de vehículos en mantenimiento: ");
				System.out.print("Ingrese el codigo de reserva: ");
				String codigoReserva = sc.next();
				empleado.generarEntrega(codigoReserva);
				
				
				
				
			}else if (opcion == 7) {
				System.out.println("Generar reporte de vehículos en mantenimiento: ");
				System.out.print("Ingrese la ruta de la imagen: ");
				String rutaImagen = sc.next();
				System.out.print("Ingrese el codigo de la sede donde se realizo la reserva: ");
				String codigoSede2 = sc.next();
				System.out.print("Ingrese el codigo de reserva: ");
				String codigoReserva = sc.next();
				empleado.addConductorAdicional(rutaImagen, codigoSede2, codigoReserva);
				
			} else if (opcion == 8) {
				System.out.println("Saliendo del menú de Empleado...");
			} else {
				System.out.println("Opción no válida. Inténtelo de nuevo.");
			}
		}while (opcion != 8); {
			sc.close();
			
		}
	}

	private void MenuCliente(Cliente cliente) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;

		do {
			System.out.println("Menú de Cliente:");
			System.out.println("1. Iniciar Reserva");
			System.out.println("2. Cerrar y Guardar Reserva");
			System.out.println("3. Ver Método de Pago");
			System.out.println("4. Salir");
			System.out.print("Elija una opción: ");
			opcion = sc.nextInt();

			if (opcion == 1) {
				System.out.println("Iniciar Reserva:");
				System.out.println("Iniciar una reserva:");

				System.out.print("Ingrese el codigo de la sede donde se realizara la reserva: ");
				String codigoSede = sc.next();
				System.out.print("Ingrese el tipo de carro: ");
				String tipoDeCarro = sc.next();

				System.out.print("Ingrese el codigo de la sede en la que se recogera el vehiculo ");
				String sedeRecogida = sc.next();

				System.out.print("Ingrese el codigo de la sede en la que se entregara el vehiculo");
				String sedeEntrega = sc.next();
				
				System.out.print("Ingrese la fecha y hora de recogida en el formato Año/Mes/Dia/Hora/Min/Seg: ");
				String fechaHoraRecogida = sc.next();

				System.out.print("Ingrese la fecha y hora de entrega en el formato Año/Mes/Dia/Hora/Min/Seg: ");
				String fechaHoraEntrega = sc.next();

				System.out.print("Ingrese la placa del vehiculo: ");
				String placaVehiculo = sc.next();

				System.out.print("Ingrese el usuario del cliente: ");
				String usernameCliente = sc.next();
				cliente.getIniciarSecion(codigoSede,"", tipoDeCarro, sedeRecogida, sedeEntrega,"",
						fechaHoraRecogida, fechaHoraEntrega, placaVehiculo, usernameCliente,
						"",0,0,0,"");
			} else if (opcion == 2) {
				System.out.println("Cerrar y Guardar Reserva:");
				cliente.getCerrarSesion();
			} else if (opcion == 3) {
				System.out.println("Método de Pago:");
				cliente.getMetodoDePago();
			} else if (opcion == 4) {
				System.out.println("Saliendo del menú de Cliente...");
			} else {
				System.out.println("Opción no válida. Inténtelo de nuevo.");
			}
		}while (opcion != 4); {
			sc.close();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}