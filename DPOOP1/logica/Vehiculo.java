package logica;


/**
 * <!-- DOCUMENTACION ACA -->
 * TODO leer comentario linea 14, sincroonizar eso con clase reserva -->
 */

public class Vehiculo
{
	public String categoria;
	public String placa;
	public String marca;
	public String codigoReservaActual; // No se si instanciar reserva sea buena opcion.. creeria que mejor crear un atributo llamado int codigoReserva
	public String modelo;
	public String color;
	public String tipoTransmision;
	public Estados Estados;
	
	/**
	 * <!-- CONSTRUCTORES -->
	 */
	
	public Vehiculo(String categoria, String placa, String marca, String codigoReservaActual, String modelo, String color,
			String tipoTransmision, logica.Estados estados) {
		super();
		this.categoria = categoria;
		this.placa = placa;
		this.marca = marca;
		this.codigoReservaActual = codigoReservaActual;
		this.modelo = modelo;
		this.color = color;
		this.tipoTransmision = tipoTransmision;
		Estados = estados;
	}
	
	/**
	 * <!-- GETTERS SETTERS -->
	 */

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getReservaActual() {
		return codigoReservaActual;
	}

	public void setReservaActual(String reservaActual) {
		this.codigoReservaActual = reservaActual;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTipoTransmision() {
		return tipoTransmision;
	}

	public void setTipoTransmision(String tipoTransmision) {
		this.tipoTransmision = tipoTransmision;
	}

	public Estados getEstados() {
		return Estados;
	}

	public void setEstados(Estados estados) {
		Estados = estados;
	}

	
}

