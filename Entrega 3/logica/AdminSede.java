package logica;


/**
 * <!-- ACA DOCUMENTACION -->
 * TODO Implementar los metodos. -->
 */

public class AdminSede extends Usuario {
	
	public int codigoSede;
	protected Roles cargo;
	
	/**
	 * <!-- CONSTRUCTOR -->
	 */

	public AdminSede(String username, String password, int codigoSede, Roles cargo) {
		super(username, password, cargo);
		this.codigoSede = codigoSede;
		this.cargo = Roles.EMPLEADO;
		}
	
	/**
	 * <!-- METODOS DEL ADMIN DE SEDE -->
	 */
	
	public void addEmpleado(String username, String password) {
        Empleado nuevoEmpleado = new Empleado(username, password, codigoSede, Roles.EMPLEADO);
        listaEmpleados.add(nuevoEmpleado);
    }

    void deleteEmpleado(String username) {
        Iterator<Empleado> iterator = listaEmpleados.iterator();
        while (iterator.hasNext()) {
            Empleado empleado = iterator.next();
            if (empleado.getUsername().equals(username)) {
                iterator.remove();
            }
    }
}
	public void deleteEmpleado() {
		// TODO implement me	
	}
	
	/**
	 * <!-- GETTERS SETTERS -->
	 */

	public int getSede() {
		return codigoSede;
	}

	//esta seria la que use el admin generla si se quisiera implementar un cambio de sede
	public void setSede(int codigoSede) {
		this.codigoSede = codigoSede;
	}
	//NO se necesita getters ni setters para el cargo, ya que solo hay un admin general.
}

