package logica;

import java.util.ArrayList;
import java.util.List;
/**
 *   <!-- DOCUMENTACION ACA -->
 *   
 * <!-- Aunque en el UML se muestra el enum roles como atributo de usuario,-->
 * <!--  se construye desde cada uno de sus subclases. -->
 * <!--  TODO implementar los metodos y su relacion con lo de reserva -->
 */

public class Empleado extends Usuario {
	
	private static final long serialVersionUID = 2L;
	public String codigoSede;
	protected Roles cargo;
	public Sede sede;
	public EmpresaAlquiler empresa;

	public Empleado(String username, String password, String codigoSede, Roles cargo, Sede sede) {
		super(username, password, cargo);
		this.codigoSede = codigoSede;
		this.cargo = Roles.EMPLEADO;
		this.sede = sede;
		}
	
	/**
	 * <!-- METODOS REALIZABLES POR EMPLEADO -->
	 */

    
    public void mandarMantenimiento(String placaVehiculo) {

        Vehiculo vehiculoAMantenimiento = null;
        for (Vehiculo vehiculo : this.sede.getListaVehiculos()) {
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

    public List<List<String>> reporteCarrosMantenimiento() {
        List<String> carro = new ArrayList<>();
        List<List<String>> resp = new ArrayList<>();
        for (Vehiculo vehiculo : this.sede.getListaVehiculos()) {
            if (vehiculo.getEstados().equals(Estados.NECESITAMANTENIMIENTO)) {
            	carro.add("Placa: " + vehiculo.getPlaca());
            	carro.add("Marca: " + vehiculo.getMarca());
            	carro.add("Modelo: " + vehiculo.getModelo());
            	carro.add("Categoría: " + vehiculo.getCategoria());
            	resp.add(carro);
            }
        }
        return resp;
    }
	
	public String iniciarReserva(String codigoReserva, String tipoDeCarro,
			String sedeRecogida, String sedeEntrega, String nuevaSedeEntrega,String fechaHoraRecogida, String fechaHoraEntrega,
			String placaVehiculo, String usernameCliente, String rutaImagenConductorAdiciones, int cantidadConductoresAdicionales) {
			// TODO implement me
			
			Reserva reserva= new Reserva(codigoReserva, tipoDeCarro,sedeRecogida, sedeEntrega, nuevaSedeEntrega, fechaHoraRecogida, fechaHoraEntrega, placaVehiculo, usernameCliente, rutaImagenConductorAdiciones,cantidadConductoresAdicionales,Entrega.ESPERANDOASERENTREGADOACLIENTE);
			addConductorAdicionalAlIniciarReserva(rutaImagenConductorAdiciones,reserva);
			String Mensaje =reserva.iniciarReserva();
			
			for(Sede sedes : empresa.listaSedes) {
				if (sedes.codigoSede==codigoSede) {
					sedes.mapaReservas.put(reserva.codigoReserva,reserva);
				}
			}			
		return Mensaje;
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
		// TODO IGUAL ACA LO DE LA SEDE	
		for (Sede sedes : empresa.listaSedes) {
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