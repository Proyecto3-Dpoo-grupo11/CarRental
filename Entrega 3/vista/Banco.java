package vista;

import java.util.HashMap;
import vista.Cuenta;

public class Banco {
	private HashMap<String, Cuenta> cuentas;
	
	public Banco() {
		this.cuentas = new HashMap<String, Cuenta>();
		this.cuentas.put("10", new Cuenta(100000, 3, 80000,EstadoTarjeta.HABILITADA));//TIENE PLATA
		this.cuentas.put("20", new Cuenta(0, 2, 100000,EstadoTarjeta.HABILITADA));//NO TIENE PLATA
		this.cuentas.put("30", new Cuenta(200000, 2, 100000,EstadoTarjeta.BLOQUEADA));//CUENTA BLOAQUEADA
	}

	public void retirar(String numero, double valor) throws Exception {
		if(this.cuentas.containsKey(numero)) {
			this.cuentas.get(numero).retirar(valor);
		}else {
			throw new Exception("La cuenta no existe");
		}
		
	}

}
