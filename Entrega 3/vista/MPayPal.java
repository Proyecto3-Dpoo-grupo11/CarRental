package vista;

import java.util.Random;

import logica.Cliente;

public class MPayPal extends MMetodosDePago {
	int saldo=0;
	String nombre="PayPal";
	public MPayPal(Cliente cliente, double monto, int numCuenta, int numTransaccion) {
		super(cliente, monto, numCuenta, numTransaccion);
		this.nombre="PayPal";
		// TODO Auto-generated constructor stub
	}

	
	}




