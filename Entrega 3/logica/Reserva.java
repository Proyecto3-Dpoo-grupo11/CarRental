package logica;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType3Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;


import vista.MCliente;

public class Reserva implements Serializable {

	private static final long serialVersionUID = 5L;
	public String codigoReserva;
	public ArrayList<String> listaConductoresAdicionales;
	public TipoVehiculo tipoDeCarro; // enum
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
	public int numeroTransaccion;
	public EmpresaAlquiler empresaAlquiler;
	public Sede sede;
	public boolean descuento;

	/**
	 * <!-- CONSTRUCTOR -->
	 */

	public Reserva(String codigoReserva, TipoVehiculo tipoDeCarro, String sedeRecogida, String sedeEntrega,
			String nuevaSedeEntrega, String fechaHoraRecogida, String fechaHoraEntrega, String usernameCliente,
			String rutaImagenConductorAdiciones, int cantidadConductoresAdicionales, Entrega estadoEntrega, Sede sede,
			boolean descuento) {
		super();
		this.codigoReserva = codigoReserva;
		this.tipoDeCarro = tipoDeCarro;
		this.sedeRecogida = sedeRecogida;
		this.sedeEntrega = sedeEntrega;
		this.nuevaSedeEntrega = nuevaSedeEntrega;
		this.fechaHoraRecogida = fechaHoraRecogida;
		this.fechaHoraEntrega = fechaHoraEntrega;

		this.usernameCliente = usernameCliente;
		this.rutaImagenConductorAdiciones = rutaImagenConductorAdiciones;
		this.cantidadConductoresAdicionales = cantidadConductoresAdicionales;
		this.estadoEntrega = estadoEntrega;
		this.sede = sede;
		this.descuento = descuento;
	}

	/**
	 * <!-- METODOS DE LA RESERVA -->
	 */

	// TODO ACA DEBERIA IR LO DE COMPROBAR EL USUARIO,
	// si es empleado entonces si puede anadir esto, o si es usuario tambien (no se,
	// miren documentacion)
	// if usuario.cargo = ROLES.EMPLEADO || usuario.cargo = ROLES.CLIENTE
	// then crear el conductor adicional y guardarlo en la reserva, no se si este
	// metodo deberia
	// ir aqui o la reserva, ahi miramos cuando lo implementemos
	public void addConductorAdicional(String rutaImagen) {
		listaConductoresAdicionales.add(rutaImagen);

		// TODO implement me
		// Va a pedir direccion de la imagen y se guarda como str en lista conductores
		// adicionales
	}

	public String iniciarReserva() {
		// inicializaciones:

		HashMap<String, Tarifa> mapaTarifa = new HashMap<String, Tarifa>();
		Tarifa tarifaPredeterminada = new Tarifa("predeterminada", 10000, 1000, 1000, mapaTarifa);

		// Formato Fecha:YY//MM//DD//HH//MIN//SEG

		// String EjemploFecha = "23/10/25/13/34/01";

		// CalculoFecha:
		String[] partesRecogida = fechaHoraRecogida.split("/");
		String[] partesEntrega = fechaHoraEntrega.split("/");

		LocalDate startDate = LocalDate.of(Integer.parseInt(partesRecogida[0]), Integer.parseInt(partesRecogida[1]),
				Integer.parseInt(partesRecogida[2]));
		LocalDate endDate = LocalDate.of(Integer.parseInt(partesEntrega[0]), Integer.parseInt(partesEntrega[1]),
				Integer.parseInt(partesEntrega[2]));
		Period period = Period.between(startDate, endDate);
		this.duracionPorDia = period.getDays();

		// cantidad_listaConductoresAdd:
		if (listaConductoresAdicionales != null) {
			this.cantidadConductoresAdicionales = listaConductoresAdicionales.size();
		} else {
			this.cantidadConductoresAdicionales = 0;
		}
		// Tarifa por entregar en otra sede:
		// Si nuevaSedeEntrega es igual a 0 es por que se entrega en la misma no hay
		// cambio de sede
		if (nuevaSedeEntrega == "") {
			tarifaPredeterminada.valorPorEntregaOtraSede = 0;
		}

		double calculoPrecioAntesDePrima = (duracionPorDia * tarifaPredeterminada.tarifaPorDia)
				+ (cantidadConductoresAdicionales * tarifaPredeterminada.valorExtraConductorAdicional)
				+ (tarifaPredeterminada.valorPorEntregaOtraSede);

		double porcentajePrima = this.tipoDeCarro.getPorcentajeComision();

		if (descuento == true) {
			this.calculoPrecioFinal = (calculoPrecioAntesDePrima + calculoPrecioAntesDePrima * porcentajePrima)
					- ((calculoPrecioAntesDePrima + calculoPrecioAntesDePrima * porcentajePrima) * 0.1);
		} else {
			this.calculoPrecioFinal = (calculoPrecioAntesDePrima + calculoPrecioAntesDePrima * porcentajePrima);
		}

		if (sede != null) {
			List<Vehiculo> listaVehiculosDisponibles = sede.getAvailableVehiclesBetweenDates(startDate, endDate);

			Vehiculo vehiculoEscogido = escogerVehiculo(listaVehiculosDisponibles, tipoDeCarro);
			if (vehiculoEscogido != null) {
				setVehiculo(vehiculoEscogido);

				ocuparVehiculo();
			}
		}

		int randomNumber = new Random().nextInt(100) + 1;
		this.numeroTransaccion = randomNumber;

		List<String> texto = new ArrayList<>();

		texto = generarFactura(30);

		try {
			PDDocument documento = new PDDocument();
			PDPage pagina = new PDPage(PDRectangle.A6);
			documento.addPage(pagina);
			PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

			contenido.beginText();
			contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - 52);
			contenido.setFont(PDType1Font.TIMES_BOLD, 12);
			contenido.showText("Felicidades!!! " + usernameCliente);
			contenido.endText();

			contenido.beginText();
			contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - 104);
			contenido.setFont(PDType1Font.HELVETICA, 8);
			contenido.showText("Usted ha reservado el vehiculo con placa" + placaVehiculo);
			contenido.endText();

			int i = 1;

			for (String elementoDeLaLista : texto) {
				contenido.beginText();
				contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - 104 - (i * 20));
				contenido.setFont(PDType1Font.HELVETICA, 8);
				contenido.showText(elementoDeLaLista);
				contenido.endText();

				i++;
			}
			
			PDImageXObject firma = PDImageXObject.createFromFile("Entrega 3/Final.png", documento);

			contenido.drawImage(firma, 4, 2);

			contenido.close();

			documento.save("./data/factura.pdf");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage().toString());
		}

		;
		return "";

	} // imprimir la factura al final de pronto osea llamar metodo generarfactura, la
		// fecha y todo lo demas.

	public Sede BuscarSede(String codigoSede) {
		Sede res = null;
		for (Sede sedes : empresaAlquiler.listaSedes) {
			if (sedes.codigoSede == codigoSede) {
				res = sedes;
			}
		}
		return res;
	}
	// al terminar la reserva ya se deberia hacer eso automaticamente

	public Vehiculo escogerVehiculo(List<Vehiculo> listaVehiculosDisponibles, TipoVehiculo tipo) {
		for (Vehiculo vehiculo : listaVehiculosDisponibles) {

			if (vehiculo.getTipoVehiculo() == tipo) {

				return vehiculo;
			}
		}
		return null;
	}
	// al terminar la reserva ya se deberia hacer eso automaticamente

	public void entregaACliente() {
		generarFactura(70);
		estadoEntrega = Entrega.ENTREGADOACIENTE;

	}

	public static String generarNumeroReserva() {
		// Create a Random object
		Random random = new Random();

		// Generate a random integer between 1 and 100 (inclusive)
		int randomNumber = random.nextInt(100) + 1;

		// Convert the random number to a string
		return String.valueOf(randomNumber);
	}

	private void ocuparVehiculo() {
		// TODO implement me
		// ACA SOLO SE CAMBIARIA EL ESTADO USANDO EL ENUM
		if (vehiculo != null) {
			vehiculo.setEstados(Estados.NODISPONIBLE);
		}

	}

	public List<String> generarFactura(float porcentaje) {
		// TODO implement me
		porcentaje = porcentaje / 100;
		String PrintConductoresAdicionales = "";
		String PrintEntregarOtraSede = "";

		HashMap<String, Tarifa> mapaTarifa = new HashMap<String, Tarifa>();
		Tarifa tarifaPredeterminada = new Tarifa("predeterminada", 10000, 1000, 1000, mapaTarifa);

		List<String> texto = new ArrayList<>();
		texto.add("Su codigo de reserva es: " + codigoReserva);
		texto.add(" Usted registro " + cantidadConductoresAdicionales + " conductores adicionales");
		texto.add("Su vehiculo es del tipo:" + tipoDeCarro);
		texto.add("Su vehiculo sera recogido en la sede: " + sedeRecogida);
		texto.add("En la fecha: " + fechaHoraRecogida);
		texto.add("Su vehiculo sera entregado en la sede: " + sedeEntrega);
		texto.add("Por un total de: " + duracionPorDia + " dias.");
		texto.add("Hasta la fecha: " + fechaHoraEntrega);
		texto.add("Recuerde que debe pagar el 30% del valor del alquiler");

		// logica Print conductores addicionales
		if (cantidadConductoresAdicionales != 0) {
			PrintConductoresAdicionales = "Tarifa por conductor adicional: "
					+ (porcentaje * tarifaPredeterminada.valorExtraConductorAdicional) + " $";

			texto.add(PrintConductoresAdicionales);
		}

		if (tarifaPredeterminada.valorPorEntregaOtraSede != 0) {
			PrintEntregarOtraSede = "Tarifa por Entregar en otra sede: "
					+ (porcentaje * tarifaPredeterminada.valorPorEntregaOtraSede) + " $.";

			texto.add(PrintEntregarOtraSede);

		}

		texto.add("Tarifa por dia: " + (porcentaje * tarifaPredeterminada.tarifaPorDia) + " $");
		texto.add(duracionPorDia + " Dias");
		float redondeo=Math.round((porcentaje * calculoPrecioFinal) * 100.0)/100;
		texto.add("Total: " + redondeo + " $.");

		return texto;
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

	public double getCalculoPrecioFinal() {
		return calculoPrecioFinal;
	}

	public void setCalculoPrecioFinal(int calculoPrecioFinal) {
		this.calculoPrecioFinal = calculoPrecioFinal;
	}

	public int getNumeroTransaccion() {
		return numeroTransaccion;
	}

	public void setNumeroTransaccion(int numeroTransaccion) {
		this.numeroTransaccion = numeroTransaccion;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}