package logica;

import java.util.ArrayList;
/**
 *   <!-- DOCUMENTACION ACA -->
 *   
 * <!-- Aunque en el UML se muestra el enum roles como atributo de usuario,-->
 * <!--  se construye desde cada uno de sus subclases. -->
 * <!--  TODO implementar los metodos y su relacion con lo de reserva -->
 */

public class Empleado extends Usuario {
	
	public String codigoSede;
	protected Roles cargo;
	private Sede sede;

	public Empleado(String username, String password, String codigoSede, Roles cargo) {
		super(username, password, cargo);
		this.codigoSede = codigoSede;
		this.cargo = Roles.EMPLEADO;
		}
	
	/**
	 * <!-- METODOS REALIZABLES POR EMPLEADO -->
	 */

	
	
    ArrayList<Vehiculo> listaVehiculos = sede.getListaVehiculos();
    
    public void mandarMantenimiento(String placaVehiculo) {

        Vehiculo vehiculoAMantenimiento = null;
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPlaca().equals(placaVehiculo)) {
                vehiculoAMantenimiento = vehiculo;
            }
            else {
                System.out.println("Placa de vehiculo no encontrada.");
            }
        }

        if (vehiculoAMantenimiento != null) {
            vehiculoAMantenimiento.setEstados(Estados.NECESITAMANTENIMIENTO);
            System.out.println("El vehículo con placa " + placaVehiculo + " ha sido marcado para mantenimiento.");
        } else {
            System.out.println("No se encontró un vehículo con la placa " + placaVehiculo + ".");
        }
    }

    public void reporteCarrosMantenimiento() {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getEstados() == Estados.NECESITAMANTENIMIENTO) {
                System.out.println("Placa: " + vehiculo.getPlaca());
                System.out.println("Marca: " + vehiculo.getMarca());
                System.out.println("Modelo: " + vehiculo.getModelo());
                System.out.println("Categoría: " + vehiculo.getCategoria());
            }
        }
    }
	
	public Void crearCliente(String username, String password, Roles cargo, String nombreCliente, String email, String telefono, String fechaNacimiento, String nacionalidad, String imagenCedula,String imagenLicencia, String metodoDePago, String numeroTarjeta, String fechaVencimiento) {
		Usuario u = new Cliente(username,password,cargo,nombreCliente,email,telefono,fechaNacimiento,nacionalidad,imagenCedula,imagenCedula,metodoDePago,numeroTarjeta,fechaVencimiento);
		EmpresaAlquiler.mapaUsuarios.put(username, u);
		// TODO implement me
		return null;	
	}
	
	public String iniciarReserva(String codigoReserva, String tipoDeCarro,
			String sedeRecogida, String sedeEntrega, String nuevaSedeEntrega,String fechaHoraRecogida, String fechaHoraEntrega,
			String placaVehiculo, String usernameCliente, String rutaImagenConductorAdiciones, int calculoPrecioFinal, int cantidadConductoresAdicionales,
			int duracionPorDia, String textoFactura) {
			// TODO implement me
			ArrayList<String> listaConductoresAdicionales= new ArrayList<String>();
			Reserva reserva= new Reserva(codigoReserva, listaConductoresAdicionales, tipoDeCarro, sedeRecogida, sedeEntrega, nuevaSedeEntrega, fechaHoraRecogida, fechaHoraEntrega, placaVehiculo, usernameCliente, rutaImagenConductorAdiciones, 0,0, 0, "", Entrega.ESPERANDOASERENTREGADOACLIENTE);
			addConductorAdicionalAlIniciarReserva(rutaImagenConductorAdiciones,reserva);
			String Mensaje =reserva.iniciarReserva();
			
			for(Sede sedes : EmpresaAlquiler.listaSedes) {
				if (sedes.codigoSede==codigoSede) {
					sedes.mapaReservas.put(reserva.codigoReserva,reserva);
				}
					
				}
			
		
		return Mensaje ;	
	}
	
	public void generarEntrega(String CodigoReserva) {
		sede.mapaReservas.get(CodigoReserva).entregaACliente();
	
		
		
	}
	
	
	
	public String cerrarGuardarReserva() {
		// TODO implement me
		return "";	
	}
	
	
	
	

	public void addConductorAdicionalAlIniciarReserva(String rutaImagen, Reserva reserva) {
		// TODO implement me	
		reserva.addConductorAdicional(rutaImagen);
	}
	public void addConductorAdicional(String rutaImagen, String codigoSede,String codigoReserva) {
		// TODO implement me	
		for (Sede sedes : EmpresaAlquiler.listaSedes) {
			if (sedes.codigoSede==codigoSede) {
				sedes.mapaReservas.get(codigoReserva)
				.listaConductoresAdicionales.add(rutaImagen);
			}
			
		}
	}

	/**
	 * <!-- GETTERS AND SETTERS -->
	 */

	

	
	public Roles getCargo() { //Para comprobar si el rol si es en las demas funciones.
		return cargo;
	}


	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public void setCargo(Roles cargo) {
		this.cargo = cargo;
	}
	
}