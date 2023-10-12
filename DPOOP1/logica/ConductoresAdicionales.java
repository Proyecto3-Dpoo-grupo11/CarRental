package logica;


/**
 * <!-- ACA VA DOCUMENTACION -->
 * TODO  -->
 */

public class ConductoresAdicionales extends Cliente
{
	/**
	 * <!-- CONSTRUCTOR -->
	 */

	public ConductoresAdicionales(String username, String password, Roles cargo, String nombreCliente, String email, String telefono, String fechaNacimiento, String nacionalidad, String imagenCedula,String imagenLicencia, String metodoDePago, String numeroTarjeta, String fechaVencimiento) {
		super(username, password, cargo, nombreCliente, email, telefono, fechaNacimiento, nacionalidad, imagenCedula, imagenLicencia, metodoDePago, numeroTarjeta, fechaVencimiento);
	}
	
	public void conductorAdicional() {
		// TODO ACA DEBERIA IR LO DE COMPROBAR EL USUARIO, 
		//si es empleado entonces si puede anadir esto, o si es usuario tambien (no se, miren documentacion)	
		//if usuario.cargo = ROLES.EMPLEADO ||  usuario.cargo = ROLES.CLIENTE
		// then crear el conductor adicional y guardarlo en la reserva, no se si este metodo deberia
		//ir aqui o la reserva, ahi miramos cuando lo implementemos
	}
	
}

