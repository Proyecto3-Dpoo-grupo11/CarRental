package control;

import java.util.List;

import logica.AdminGeneral;
import logica.AdminSede;
import logica.Cliente;
import logica.Empleado;
import logica.EmpresaAlquiler;
import logica.Roles;
import logica.Usuario;



public class Control {
	
	private EmpresaAlquiler empresa;
	public static Usuario usuarioActual;

	public Control() {
		
		usuarioActual = null;
	
		this.empresa = PersistenciaEmpresaAlquiler.cargarEmpresaAlquiler();
		try {
			if (empresa.getMapaUsuarios().isEmpty()) {
				this.empresa.leerArchivos();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public void GuardarEmpresa() {
		PersistenciaEmpresaAlquiler.guardarEmpresaAlquiler(this.empresa);
	}
	
	public int iniciarSesion(String username, char[] password) {
		
		int numConfirmacion = 0;
		
		
			Usuario accesoGeneral = this.empresa.mapaUsuarios.get(username);
			
			if (accesoGeneral != null && accesoGeneral.getPassword().equals(new String(password))) {

				if (accesoGeneral.getRol() == Roles.ADMINISTRADORGENERAL) {
					AdminGeneral accesoAdminGeneral = (AdminGeneral) this.empresa.mapaUsuarios.get(username);
					Control.usuarioActual = accesoAdminGeneral;
					
					if ("admin".equals(username)) {
//							System.out.print("Ingrese su nuevo nombre de usuario: ");
//							String nuevoUser = reader.readLine();
//							System.out.print("Ingrese su contraseña: ");
//							String nuevoPassword = reader.readLine();
						
						//Mandar esto de vuelta al view
						
						//accesoAdmiGeneral.cambiarContraseña(name, nuevoUser, nuevoPassword, Roles.ADMINISTRADORGENERAL);
					}
					numConfirmacion = 1;
				}

				else if (accesoGeneral.getRol() == Roles.ADMINISTRADORSEDE) {
					AdminSede accesoAdminSede = (AdminSede) this.empresa.mapaUsuarios.get(username);
					Control.usuarioActual = accesoAdminSede;
					
					numConfirmacion = 2;
				}

				else if (accesoGeneral.getRol() == Roles.EMPLEADO) {
					Empleado accesoEmpleado = (Empleado) this.empresa.mapaUsuarios.get(username);
					Control.usuarioActual = accesoEmpleado;
					
					numConfirmacion = 3;
				}

				else if (accesoGeneral.getRol() == Roles.CLIENTE) {
					Cliente accesoCliente = (Cliente) this.empresa.mapaUsuarios.get(username);
					Control.usuarioActual = accesoCliente;
					
					numConfirmacion = 4;
				}
				
			} else {
				//ESTO YA NO VA
				System.out.println("Contraseña Incorrecta");
			}
		
		return numConfirmacion;
	}

	    // ... otros métodos y propiedades

    public void crearCliente(String nuevoUsername, String newPassword, String nombreCliente,
                             String email, String telefono, String fechaNacimiento,
                             String nacionalidad, String imagenCedula, String imagenLicencia,
                             String metodoDePago, String numeroTarjeta, String fechaVencimiento) {

        if (empresa != null) {
            empresa.crearCliente(nuevoUsername, newPassword, Roles.CLIENTE, nombreCliente,
                                 email, telefono, fechaNacimiento, nacionalidad,
                                 imagenCedula, imagenLicencia, metodoDePago,
                                 numeroTarjeta, fechaVencimiento); 
        }
    }
    
    public void mandarMantenimiento(String placaMan, String username) {
		Empleado accesoEmpleado = (Empleado) this.empresa.mapaUsuarios.get(username);
		accesoEmpleado.mandarMantenimiento(placaMan);
	}
    

	public void cerrarGuardarReserva(String username) {
		Empleado accesoEmpleado = (Empleado) this.empresa.mapaUsuarios.get(username);
		accesoEmpleado.cerrarGuardarReserva();
	}

	public List<List<String>> reporteCarrosMantenimiento(String username) {
		Empleado accesoEmpleado = (Empleado) this.empresa.mapaUsuarios.get(username);
		List<List<String>> resp = accesoEmpleado.reporteCarrosMantenimiento();
		return resp;
	}

	public void generarEntrega(String code, String username) {
		Empleado accesoEmpleado = (Empleado) this.empresa.mapaUsuarios.get(username);
		accesoEmpleado.generarEntrega(code);
	}

	public void addConductorAdicional(String imagen, String code, String code2, String username) {
		Empleado accesoEmpleado = (Empleado) this.empresa.mapaUsuarios.get(username);
		accesoEmpleado.addConductorAdicional(imagen, code, code2);
	}

	public void getCerrarSesion(String username) {
		Cliente accesoCliente = (Cliente) this.empresa.mapaUsuarios.get(username);
		accesoCliente.getCerrarSesion();
	}

	public void getMetodoDePago(String username) {
		Cliente accesoCliente = (Cliente) this.empresa.mapaUsuarios.get(username);
		accesoCliente.getMetodoDePago();
		
	}
	public Cliente getCliente(String username) {
		Cliente accesoCliente = (Cliente) this.empresa.mapaUsuarios.get(username);
		return accesoCliente;
		
	}
}
