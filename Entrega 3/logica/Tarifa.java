package logica;


/**
 * <!-- DOCUMENTACION -->
 * TODO Nada solo implementar los metodos y relacionarlo desde reserva  -->
 * @generated
 */

public class Tarifa
{
	public String categoria;
	public int tarifaPorDia;
	public int valorExtraConductorAdicional;
	public int valorPorEntregaOtraSede;
	
	/**
	 * <!- CONSTURCTOR -->
	 */
	
	public Tarifa(String categoria, int tarifaPorDia, int valorExtraConductorAdicional, int valorPorEntregaOtraSede) {
		super();
		this.categoria = categoria;
		this.tarifaPorDia = tarifaPorDia;
		this.valorExtraConductorAdicional = valorExtraConductorAdicional;
		this.valorPorEntregaOtraSede = valorPorEntregaOtraSede;
	}

	/**
	 * <!-- METODOS DE LA TARIFA -->
	 */
	
	
	public void registrarTarifa() {
		// TODO implement me	
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

	public int getTarifaPorDia() {
		return tarifaPorDia;
	}

	public void setTarifaPorDia(int tarifaPorDia) {
		this.tarifaPorDia = tarifaPorDia;
	}

	public int getValorExtraConductorAdicional() {
		return valorExtraConductorAdicional;
	}

	public void setValorExtraConductorAdicional(int valorExtraConductorAdicional) {
		this.valorExtraConductorAdicional = valorExtraConductorAdicional;
	}

	public int getValorPorEntregaOtraSede() {
		return valorPorEntregaOtraSede;
	}

	public void setValorPorEntregaOtraSede(int valorPorEntregaOtraSede) {
		this.valorPorEntregaOtraSede = valorPorEntregaOtraSede;
	}
}

