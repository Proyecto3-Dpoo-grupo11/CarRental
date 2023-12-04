package logica;

import java.io.Serializable;

/**
 * <!-- DOCUMENTACION ACA -->
 * TODO leer comentario linea 14, sincroonizar eso con clase reserva -->
 */

public class Vehiculo implements Serializable
{
	private static final long serialVersionUID = 4L;
	public String categoria;
	public String placa;
	public String marca;
	public String codigoReservaActual; // Ya no se  instancia reserva sea buena opcion
	public String color;
	public String tipoTransmision;
	public Estados Estados;
	private String modelo;
	private String codigoSede;
	private TipoVehiculo tipoVehiculo;
	
	/**
	 * <!-- CONSTRUCTORES -->
	 */
	
	public Vehiculo(String categoria, String placa, String marca, String codigoReservaActual, String color,
			String tipoTransmision, logica.Estados estados, String modelo, String codigoSede, TipoVehiculo tipoVehiculo) {
		super();
		this.categoria = categoria;
		this.placa = placa;
		this.marca = marca;
		this.codigoReservaActual = codigoReservaActual;
		this.color = color;
		this.tipoTransmision = tipoTransmision;
		Estados = estados;
		this.modelo = modelo;
		this.codigoSede = codigoSede;
		this.tipoVehiculo = tipoVehiculo;
	}
	
	
	public void buscarVehiculo(String modelo) {
		
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


	public String getCodigoReservaActual() {
		return codigoReservaActual;
	}


	public void setCodigoReservaActual(String codigoReservaActual) {
		this.codigoReservaActual = codigoReservaActual;
	}


	public String getCodigoSede() {
		return codigoSede;
	}


	public void setCodigoSede(String codigoSede) {
		this.codigoSede = codigoSede;
	}


	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}


	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	

	
}

