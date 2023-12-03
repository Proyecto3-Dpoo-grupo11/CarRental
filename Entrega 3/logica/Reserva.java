package logica;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;


public class Reserva implements Serializable
{
	
	private static final long serialVersionUID = 5L;
	public String codigoReserva;
	public ArrayList<String> listaConductoresAdicionales;
	public TipoVehiculo tipoDeCarro; //enum
	public String sedeRecogida;
	public String sedeEntrega;
	public String nuevaSedeEntrega;
	public String fechaHoraRecogida;
	public String fechaHoraEntrega;
	public String placaVehiculo;
	public String usernameCliente;
	public Tarifa tarifa;
	public Seguro seguro;
	public Vehiculo vehiculo;
	public String rutaImagenConductorAdiciones;
	public double calculoPrecioFinal;
	public int cantidadConductoresAdicionales;
	public int duracionPorDia;
	public String textoFactura;
	public Entrega estadoEntrega;
	
	/**
	 * <!-- CONSTRUCTOR -->
	 */
	public Reserva(String codigoReserva, ArrayList<String> listaConductoresAdicionales, TipoVehiculo tipoDeCarro,
			String sedeRecogida,String sedeEntrega,String fechaHoraRecogida, String fechaHoraEntrega,
		    String usernameCliente, String rutaImagenConductorAdiciones, int cantidadConductoresAdicionales,
			int duracionPorDia, Entrega estadoEntrega) {
		super();
		this.codigoReserva = codigoReserva;
		this.listaConductoresAdicionales = listaConductoresAdicionales;
		this.tipoDeCarro = tipoDeCarro;
		this.sedeRecogida = sedeRecogida;
		this.sedeEntrega = sedeEntrega;
		this.fechaHoraRecogida = fechaHoraRecogida;
		this.fechaHoraEntrega = fechaHoraEntrega;
		this.usernameCliente = usernameCliente;
		this.rutaImagenConductorAdiciones = rutaImagenConductorAdiciones;
		this.cantidadConductoresAdicionales = cantidadConductoresAdicionales;
		this.duracionPorDia = duracionPorDia;
		this.estadoEntrega = estadoEntrega;
	}
	
	/**
	 * <!-- METODOS DE LA RESERVA -->
	 */
	

	public void addConductorAdicional(String rutaImagen) {
		listaConductoresAdicionales.add(rutaImagen);
		
		// TODO implement me
		//Va a pedir direccion de la imagen y se guarda como str en lista conductores adicionales
	}
	
	public String iniciarReserva() {
		//inicializaciones:
		
		
		
		HashMap<String, Tarifa> mapaTarifa = tarifa.getMapaTarifa();
		Tarifa valuesMapaTarifa=mapaTarifa.get(tarifa.categoria);
		
		
		// Formato Fecha:YY//MM//DD//HH//MIN//SEG
		
		//String EjemploFecha = "23/10/25/13/34/01";
		
		//CalculoFecha:
		String[] partesRecogida = fechaHoraRecogida.split("/");
		String[] partesEntrega = fechaHoraEntrega.split("/");
		
		
		LocalDate startDate = LocalDate.of(Integer.parseInt(partesRecogida[0]),Integer.parseInt(partesRecogida[1]),Integer.parseInt(partesRecogida[2]));
        LocalDate endDate = LocalDate.of(Integer.parseInt(partesEntrega[0]),Integer.parseInt(partesEntrega[1]),Integer.parseInt(partesEntrega[2]));
        Period period = Period.between(startDate, endDate);
        this.duracionPorDia = period.getDays();
        Duration duracionTotal = Duration.between(startDate, endDate);
		
		//cantidad_listaConductoresAdd:
		this.cantidadConductoresAdicionales=listaConductoresAdicionales.size();
		//Tarifa por entregar en otra sede:
		//Si nuevaSedeEntrega es igual a 0 es por que se entrega en la misma no hay cambio de sede
		if (nuevaSedeEntrega=="") {
			valuesMapaTarifa.valorPorEntregaOtraSede=0;
		}
		
		double calculoPrecioAntesDePrima = (duracionPorDia*valuesMapaTarifa.tarifaPorDia)+(cantidadConductoresAdicionales*valuesMapaTarifa.valorExtraConductorAdicional)+(valuesMapaTarifa.valorPorEntregaOtraSede);
				
		double porcentajePrima = this.tipoDeCarro.getPorcentajeComision();
		this.calculoPrecioFinal= calculoPrecioAntesDePrima  + calculoPrecioAntesDePrima * porcentajePrima;
		
		ocuparVehiculo(duracionPorDia);
		
		String factura30Porciento=generarFactura(30);
		
		String retorno="Felicidades!!! "+ usernameCliente+ "Usted ha reservado el vehiculo con placa"+placaVehiculo+"\n."
		+"Su codigo de reserva es: "
		+codigoReserva+"\n."
		
		+"Usted registro"+listaConductoresAdicionales.size()+"conductores adicionales"+"\n."
		
		+"Su vehiculo es del tipo: "+"\n."
		+tipoDeCarro+"\n."
		
		+"Su vehiculo sera recogido en la sede: "
		+sedeRecogida+"\n."
		
		+"En la fecha: "
		+fechaHoraRecogida+"\n."
		
		+"Su vehiculo sera entregado en la sede: "
		+sedeEntrega+"\n."
		
		+"Por un total de: "
		+duracionPorDia
		+" dias."
		+"Duracion general de: "
		+duracionTotal
		+"En la fecha: "
		+fechaHoraEntrega+"\n."
		+"Recuerde que debe pagar el 30% del valor del alquiler \n. "
		+"Su factura por el 30% es"
		+factura30Porciento;
		
		

		;
		return retorno;
		
	} //imprimir la factura al final de pronto osea llamar metodo generarfactura, la fecha y todo lo demas.
	
	
	// al terminar la reserva ya se deberia hacer eso automaticamente
	
	void entregaACliente() {
		generarFactura(70);
		estadoEntrega=Entrega.ENTREGADOACIENTE;
		
	}
	
	public static String generarNumeroReserva() {
        // Create a Random object
        Random random = new Random();

        // Generate a random integer between 1 and 100 (inclusive)
        int randomNumber = random.nextInt(100) + 1;

        // Convert the random number to a string
        return String.valueOf(randomNumber);
    }
	
	
	private void ocuparVehiculo(int duracion) {
		// TODO implement me	
		//ACA SOLO SE CAMBIARIA EL ESTADO USANDO EL ENUM
		
		vehiculo.setEstados(Estados.NODISPONIBLE);
		
	}
	
	public String generarFactura(int porcentaje) {
		// TODO implement me	
		porcentaje=porcentaje/100;
		String PrintConductoresAdicionales="";
		String PrintEntregarOtraSede="";
		
		HashMap<String, Tarifa> mapaTarifa = tarifa.getMapaTarifa();
		Tarifa valuesMapaTarifa=mapaTarifa.get(tarifa.categoria);
		
		//	logica Print conductores addicionales
		if (cantidadConductoresAdicionales!=0) {
				PrintConductoresAdicionales="Tarifa por conductor adicional: "+ 
				(porcentaje*valuesMapaTarifa.valorExtraConductorAdicional)+" $"
				+" x "+cantidadConductoresAdicionales + " conductores adicionales.\n" ;
		}
		
		if (valuesMapaTarifa.valorPorEntregaOtraSede!=0) {
			PrintEntregarOtraSede="Tarifa por Entregar en otra sede: "+ 
			(porcentaje*valuesMapaTarifa.valorPorEntregaOtraSede)+" $.\n";}
	
		return 	"Tarifa por dia: "
				+(porcentaje*valuesMapaTarifa.tarifaPorDia)+" $"+" x "+duracionPorDia+" Dias/n"
				+"/n"
				//Print conductores addicionales
				+ PrintConductoresAdicionales
				+ "\n"
				+ PrintEntregarOtraSede
				+ "\n"
				+ "Total: \n"
				+ (porcentaje*calculoPrecioFinal)
				+" $.";
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

	public TipoVehiculo getTipoDeCarro() {
		return tipoDeCarro;
	}

	public void setTipoDeCarro(TipoVehiculo tipoDeCarro) {
		this.tipoDeCarro = tipoDeCarro;
	}

	public String getSedeRecogida() {
		return sedeRecogida;
	}

	public void setSedeRecogida(String sedeRecogida) {
		this.sedeRecogida = sedeRecogida;
	}

	public String getSedeEntrega() {
		return sedeEntrega;
	}

	public void setSedeEntrega(String sedeEntrega) {
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

