package vista;

import java.util.Random;

import logica.Cliente;

public class MPayPal extends MMetodosDePago {
	int saldo=0;
	String nombre="PayPal";
	public MPayPal(Cliente cliente, double monto, int numTransaccion,String recibo) {
		super(cliente, monto, numTransaccion,recibo);
		this.nombre="PayPal";
		// TODO Auto-generated constructor stub
	}

	
	}




