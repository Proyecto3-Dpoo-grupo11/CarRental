package logica;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * <!-- DOCUMENTACION AQUI PORFA -->
 * TODO: Solamente implementar los metodos de abajo
 * 
 * TODO: Tambien tienen que pensar como se va a formatear el horario de atencion y 
 * luego cambiarlo en el archivo de preuba  -->
 * 
 * 
 */



//TODO IMPLEMENTAR MAPA EN VEZX DE LISTA DE LOS VEHICULOS POR CATEGORIA
//TODO o si piensan mejor un mapa <KEY: CodigoCarro, Value: objeto Carro> esta bien tmb

//Se accederia tipodecarroquequiero
	//listadeesetipodecarro = sede.mapa.get(tipodecarroquequiero)
public class Sede implements Serializable
{
	private static final long serialVersionUID = 3L;
	public String codigoSede;
	public String ubicacion;
	public String horarioAtencion;
	
	public ArrayList<Vehiculo> listaVehiculos;
	public HashMap<String,Empleado> mapaEmpleados;
	public HashMap<String,Reserva> mapaReservas;
	
	
	/**
	 * <!-- CONSTRUCTOR  -->
	 * @generated
	 */
	
	
	/**
	 * <!-- FUNCIONES DEL ADMIN  -->
	 */
	
	
	
	

	public Sede(String codigoSede, String ubicacion, String horarioAtencion, ArrayList<Vehiculo> listaVehiculos,
			HashMap<String, Reserva> mapaReservas,HashMap<String,Empleado> mapaEmpleados ) {
		super();
		this.codigoSede = codigoSede;
		this.ubicacion = ubicacion;
		this.horarioAtencion = horarioAtencion;
		this.listaVehiculos = listaVehiculos;
		this.mapaReservas = mapaReservas;
		this.mapaEmpleados=mapaEmpleados;
	}

	public void addEmpleado(String username, String password, Roles cargo) {
        Empleado nuevoEmpleado = new Empleado(username, password,codigoSede, cargo, this);
        mapaEmpleados.put(username,nuevoEmpleado);
    }

    public void deleteEmpleado(String username) {
        mapaEmpleados.remove(username);
        }

    public void addVehiculo(String categoria, String placa, String marca, String codigoReservaActual, String modelo, String color, String tipoTransmision, Estados estados, String codigoSede,  TipoVehiculo tipoVehiculo) {
        Vehiculo nuevoVehiculo = new Vehiculo(categoria, placa, marca, codigoReservaActual, color, tipoTransmision, estados,modelo,codigoSede, tipoVehiculo);

        listaVehiculos.add(nuevoVehiculo);
    }
    

	
	public void crearSeguros(String nombreSeguro, int tarifa ) {
		Seguro.registrarSeguro(codigoSede,tarifa);
	}
	
	public int calcularVehiculosDisponiblesEnAño(int year) {
        int vehiculosDisponibles = 0;

        // Recorre las reservas de la sede
        for (Reserva reserva : mapaReservas.values()) {
            // Convierte las fechas de recogida y entrega a LocalDate
            LocalDate fechaRecogida = LocalDate.parse(reserva.getFechaHoraRecogida());
            LocalDate fechaEntrega = LocalDate.parse(reserva.getFechaHoraEntrega());

            // Verifica si la reserva ocurre en el año deseado
            if (fechaRecogida.getYear() == year || fechaEntrega.getYear() == year) {
                // Itera sobre todos los días entre fecha de recogida y fecha de entrega
                LocalDate fechaActual = fechaRecogida;
                while (!fechaActual.isAfter(fechaEntrega)) {
                    // Verifica si el vehículo está disponible en este día
                    if (vehiculoEstaDisponible(reserva.getCodigoVehiculo(), fechaActual)) {
                        vehiculosDisponibles++;
                    }
                    // Incrementa un día,es el i++
                    fechaActual = fechaActual.plusDays(1);
                }
            }
        }

        return vehiculosDisponibles;
    }
    
    //este metodo es el ultimo que comprueba y retorna si si o si no, 
    //para que la otra funcion decida si sumarle o no sumarle a los vehiculos dispomibles
    private boolean vehiculoEstaDisponible(String placaVehiculo, LocalDate fecha) {
        // Obtener la lista de vehículos disponibles
        List<Vehiculo> carrosDisponibles = filtrarCarrosDisponibles(this.listaVehiculos);

        // Verificar si la placa está entre los vehículos disponibles
        for (Vehiculo vehiculo : carrosDisponibles) {
            if (vehiculo.getPlaca().equals(placaVehiculo)) {
                return true; // La placa está entre los vehículos disponibles
            }
        }

        return false; // La placa no está entre los vehículos disponibles
    }

    public static List<Vehiculo> filtrarCarrosDisponibles(List<Vehiculo> listaCarros) {
        List<Vehiculo> carrosDisponibles = new ArrayList<>();

        // Recorrer la lista de carros y filtrar aquellos con estado DISPONIBLE
        for (Vehiculo carro : listaCarros) {
            if (carro.getEstados() == Estados.DISPONIBLE) {
                carrosDisponibles.add(carro);
            }
        }
        return carrosDisponibles;
    }
	/**
	 * <!-- GETTERS AND SETTERS -->
	 * @generated
	 */
	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public String getHorarioAtencion() {
		return horarioAtencion;
	}


	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}


	public ArrayList<Vehiculo> getListaVehiculos() {
		return listaVehiculos;
	}


	public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
		this.listaVehiculos = listaVehiculos;
	}

	public String getCodigoSede() {
		return codigoSede;
	}

	public void setCodigoSede(String codigoSede) {
		this.codigoSede = codigoSede;
	}



	public HashMap<String, Reserva> getMapaReservas() {
		return mapaReservas;
	}



	public void setMapaReservas(HashMap<String, Reserva> mapaReservas) {
		this.mapaReservas = mapaReservas;
	}
	
	


	
}

