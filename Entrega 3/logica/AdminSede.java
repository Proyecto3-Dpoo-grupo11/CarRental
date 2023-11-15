package logica;

/**
 * <!-- ACA DOCUMENTACION -->
 * TODO Implementar los metodos. -->
 */

public class AdminSede extends Usuario {
	
	private static final long serialVersionUID = 2L;
	public String codigoSede;
	
	public Sede sede;
	public EmpresaAlquiler empresa;
	
	/**
	 * <!-- CONSTRUCTOR -->
	 */

	
	public AdminSede(String username, String password, Roles rol, String codigoSede, Sede sede,EmpresaAlquiler empresa) {
		super(username, password, rol);
		this.codigoSede = codigoSede;
		this.sede = sede;
		this.empresa = empresa;
	}
	
	
	/**
	 * <!-- METODOS DEL ADMIN DE SEDE -->
	 */
	
	

    /*public void addVehiculo(String categoria, String placa, String marca, String codigoReservaActual, String modelo, String color, String tipoTransmision, Estados estados) {
        Vehiculo nuevoVehiculo = new Vehiculo(categoria, placa, marca, codigoReservaActual, modelo, color, tipoTransmision, estados);

        sede.listaVehiculos.add(nuevoVehiculo);
    }*/
	
	public void addEmpleado(String username, String password, Roles cargo) {
		for (Sede sedes:empresa.listaSedes ) {
			if(sedes.codigoSede.equals(codigoSede)) {
		Usuario u = new Empleado(username, password, codigoSede, Roles.EMPLEADO, sedes);
		empresa.mapaUsuarios.put(username,u);
		sedes.addEmpleado(username, password, cargo);
		}
	}
}
	public void deleteEmpleado(String username) {
    	for (Sede sedes:empresa.listaSedes ) {
			if(sedes.codigoSede.equals(codigoSede)) {
		empresa.mapaUsuarios.remove(username);		
		sedes.deleteEmpleado(username);
		}
    	}
    }
	public Sede BuscadorSedesede() {
		for (Sede sedes:empresa.listaSedes ) {
			if(sedes.codigoSede.equals(codigoSede)) {
				return sedes;
		}
	}
		return null;
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

