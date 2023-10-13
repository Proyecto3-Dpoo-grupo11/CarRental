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
		super(username, password);
		this.codigoSede = codigoSede;
		this.cargo = Roles.EMPLEADO;
		}
	
	/**
	 * <!-- METODOS DEL ADMIN DE SEDE -->
	 */
	
	public void addEmpleado() {
		// TODO implement me	
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

