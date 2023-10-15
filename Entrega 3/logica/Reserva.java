package logica;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

//TODO Y HAY MAS QUE IMPROTAR

/**
 * <!-- ACA VA LA DOCUMENTACION -->
 * TODO constructor, un monton, implementar las relaciones y demas cosas, los metodos etc. 
 * 
 *  PERO ES MEJOR que empiecen desde implementar el metodo crear reserva en cliente y empleado y ahi trabajen 
 *  con esta clase como quieran.-->
 */
//Esta se llamaria cuando se inicie la reserva desde cliente o desde empleado


public class Reserva
{
	
	public String codigoReserva;
	public ArrayList<String> listaConductoresAdicionales;
	public String tipoDeCarro; // yo sugiero cambiarlo a una enum, depende de si se pueden agregar mas tipos de vehiculos
	public int sedeRecogida;
	public int sedeEntrega;
	public int nuevaSedeEntrega;
	public String fechaHoraRecogida;
	public String fechaHoraEntrega;
	public String placaVehiculo;
	public String usernameCliente;
	public Tarifa tarifa;
	public Seguro seguro;
	public Vehiculo vehiculo;
	
	/**
	 * <!-- CONSTRUCTOR -->
	 */
	
	public Reserva(String codigoReserva, ArrayList<String> listaConductoresAdicionales, String tipoDeCarro,
			int sedeRecogida, int sedeEntrega, int nuevaSedeEntrega, String fechaHoraRecogida, String fechaHoraEntrega,
			String placaVehiculo, String usernameCliente, Tarifa tarifa, Seguro seguro, Vehiculo vehiculo) {
		super();
		this.codigoReserva = codigoReserva;
		this.listaConductoresAdicionales = listaConductoresAdicionales;
		this.tipoDeCarro = tipoDeCarro;
		this.sedeRecogida = sedeRecogida;
		this.sedeEntrega = sedeEntrega;
		this.nuevaSedeEntrega = nuevaSedeEntrega;
		this.fechaHoraRecogida = fechaHoraRecogida;
		this.fechaHoraEntrega = fechaHoraEntrega;
		this.placaVehiculo = placaVehiculo;
		this.usernameCliente = usernameCliente;
		this.tarifa = tarifa;
		this.seguro = seguro;
		this.vehiculo = vehiculo;
	}
	
	

	/**
	 * <!-- METODOS DE LA RESERVA -->
	 */
	
	// TODO ACA DEBERIA IR LO DE COMPROBAR EL USUARIO, 
			//si es empleado entonces si puede anadir esto, o si es usuario tambien (no se, miren documentacion)	
			//if usuario.cargo = ROLES.EMPLEADO ||  usuario.cargo = ROLES.CLIENTE
			// then crear el conductor adicional y guardarlo en la reserva, no se si este metodo deberia
			//ir aqui o la reserva, ahi miramos cuando lo implementemos
	public void addConductorAdicional(String rutaImagen) {
		listaConductoresAdicionales.add(rutaImagen);
		
		// TODO implement me
		//Va a pedir direccion de la imagen y se guarda como str en lista conductores adicionales
	}
	


	public double iniciarReserva() {
		//inicializaciones:
		
		HashMap<String, Tarifa> mapaTarifa = tarifa.getMapaTarifa();
		Tarifa res=mapaTarifa.get(tarifa.categoria);
		
		
		// Formato Fecha:YY//MM//DD//HH//MIN//SEG
		
		//String EjemploFecha = "23/10/25/13/34/01";
		
		//CalculoFecha:
		String[] partesRecogida = fechaHoraRecogida.split("/");
		String[] partesEntrega = fechaHoraEntrega.split("/");
		
		
		LocalDate startDate = LocalDate.of(Integer.parseInt(partesRecogida[0]),Integer.parseInt(partesRecogida[1]),Integer.parseInt(partesRecogida[2]));
        LocalDate endDate = LocalDate.of(Integer.parseInt(partesEntrega[0]),Integer.parseInt(partesEntrega[1]),Integer.parseInt(partesEntrega[2]));
        Period period = Period.between(startDate, endDate);
        int days = period.getDays();
		
        
        
        
		//cantidad_listaConductoresAdd:
		int cantidad_listaConductoresAdd=listaConductoresAdicionales.size();
		//Tarifa por entregar en otra sede:
		if (nuevaSedeEntrega==0) {
			res.valorPorEntregaOtraSede=0;
		}
		
		
		//Calculo Total Precio
		double calculo=(days*res.tarifaPorDia)+(cantidad_listaConductoresAdd*res.valorExtraConductorAdicional)+res.valorPorEntregaOtraSede;
		
		ocuparVehiculo(days);
		/*System.out.println("Felicidades!!! "+ usernameCliente+ "Usted ha reservado el vehiculo con placa"+placaVehiculo);
		System.out.println("Su codigo de reserva es: ");
		System.out.println(codigoReserva);
		System.out.println();
		System.out.println();
		System.out.println("Usted registro"+listaConductoresAdicionales.size()+"conductores adicionales");
		System.out.println();
		System.out.println();
		System.out.println("Su vehiculo es del tipo: ");
		System.out.println(tipoDeCarro);
		System.out.println();
		System.out.println();
		System.out.println("Su vehiculo sera recogido en la sede: ");
		System.out.println(sedeRecogida);
		System.out.println();
		System.out.println("En la fecha: ");
		System.out.println(fechaHoraRecogida); 
		System.out.println();
		System.out.println();
		System.out.println("Su vehiculo sera entregado en: ");
		System.out.println(sedeEntrega);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Su factura es");*/
		
		

		;
		
		
		
		return calculo;
		
		
		//ESTO NO SE PASA A CODIGO HASTA QUE resuelvan el formato de fechas y todo eso.
		//duracion = fechaHoraEntrega - fechaHoraRecogida
		//ocuparVehiculo(duracion);
	
		
	} //imprimir la factura al final de pronto osea llamar metodo generarfactura, la fecha y todo lo demas.
	
	
	// al terminar la reserva ya se deberia hacer eso automaticamente
	private void ocuparVehiculo(int duracion) {
		// TODO implement me	
		//ACA SOLO SE CAMBIARIA EL ESTADO USANDO EL ENUM
		
		vehiculo.setEstados(Estados.NODISPONIBLE);
		
	}
	
	//importantisimo, con los getters y setters sale, solo es que formateen el texto
	public void generarFactura(double calculo) {
		// TODO implement me	
		System.out.println("Su precio a pagar es: ");
		System.out.println(calculo);
		
		return "Su factura fue blablabla ";
	}
	
	/**
	 * <!-- GETTERS SETTERS -->
	 */

	public String getCodigoReserva() {
		return codigoReserva;
	}

	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public ArrayList<String> getListaConductoresAdicionales() {
		return listaConductoresAdicionales;
	}

	public void setListaConductoresAdicionales(ArrayList<String> listaConductoresAdicionales) {
		this.listaConductoresAdicionales = listaConductoresAdicionales;
	}

	public String getTipoDeCarro() {
		return tipoDeCarro;
	}

	public void setTipoDeCarro(String tipoDeCarro) {
		this.tipoDeCarro = tipoDeCarro;
	}

	public int getSedeRecogida() {
		return sedeRecogida;
	}

	public void setSedeRecogida(int sedeRecogida) {
		this.sedeRecogida = sedeRecogida;
	}

	public int getSedeEntrega() {
		return sedeEntrega;
	}

	public void setSedeEntrega(int sedeEntrega) {
		this.sedeEntrega = sedeEntrega;
	}

	public String getFechaHoraRecogida() {
		return fechaHoraRecogida;
	}

	public void setFechaHoraRecogida(String fechaHoraRecogida) {
		this.fechaHoraRecogida = fechaHoraRecogida;
	}

	public String getFechaHoraEntrega() {
		return fechaHoraEntrega;
	}

	public void setFechaHoraEntrega(String fechaHoraEntrega) {
		this.fechaHoraEntrega = fechaHoraEntrega;
	}

	public String getCodigoVehiculo() {
		return placaVehiculo;
	}

	public void setCodigoVehiculo(String codigoVehiculo) {
		this.placaVehiculo = codigoVehiculo;
	}

	public String getUsernameCliente() {
		return usernameCliente;
	}

	public void setUsernameCliente(String usernameCliente) {
		this.usernameCliente = usernameCliente;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	
	
	
	
}

