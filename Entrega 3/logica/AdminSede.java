package logica;

import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * <!-- ACA DOCUMENTACION -->
 * TODO Implementar los metodos. -->
 */

public class AdminSede extends Usuario {
	
	public String codigoSede;
	protected Roles cargo;
	public Sede sede;
	
	/**
	 * <!-- CONSTRUCTOR -->
	 */

	public AdminSede(String username, String password, String codigoSede, Roles cargo) {
		super(username, password, cargo);
		this.codigoSede = codigoSede;
		this.cargo = Roles.EMPLEADO;
		}
	
	/**
	 * <!-- METODOS DEL ADMIN DE SEDE -->
	 */
	
	

    /*public void addVehiculo(String categoria, String placa, String marca, String codigoReservaActual, String modelo, String color, String tipoTransmision, Estados estados) {
        Vehiculo nuevoVehiculo = new Vehiculo(categoria, placa, marca, codigoReservaActual, modelo, color, tipoTransmision, estados);

        sede.listaVehiculos.add(nuevoVehiculo);
    }*/
	
	public void addEmpleado(String username, String password, Roles cargo) {
		sede.addEmpleado(username, password, cargo);
	}
    public void deleteEmpleado(String username) {
        sede.deleteEmpleado(username);
    }

			
        		
        		
        /**
    	 * <!-- GETTERS  y SETTERS -->
    	 */

	public String getCodigoSede() {
		return codigoSede;
	}

	public void setCodigoSede(String codigoSede) {
		this.codigoSede = codigoSede;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}
	
	/**
	 * <!-- GETTERS SETTERS -->
	 */

	
	//NO se necesita getters ni setters para el cargo, ya que solo hay un admin general.
}

