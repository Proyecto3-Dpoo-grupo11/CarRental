package vista;

import java.util.Random;

import logica.Cliente;

public class MPayPal extends MMetodosDePago {
	int saldo;
	int nombre;
	public MPayPal(Cliente cliente, int monto, int numCuenta, int numTransaccion) {
		super(cliente, monto, numCuenta, numTransaccion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void realizarPago() {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		boolean pobreza = random.nextBoolean();
		
		if (pobreza==true) {
			
			saldo=0;
			} 
		if (pobreza==false) {
			
			saldo=1000000;
		
		int randomEntre1y1000 = new Random().nextInt(100) + 1;
			}
	}
	}




