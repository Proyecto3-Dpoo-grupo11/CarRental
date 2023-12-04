package vista;

import java.util.Random;

import logica.Cliente;

public abstract class MMetodosDePago {
protected Cliente cliente;
protected double monto;
protected int NumCuenta;
protected int NumTransaccion;
protected int saldo;



public  MMetodosDePago(Cliente cliente, double monto, int numCuenta, int numTransaccion) {
	super();
	this.cliente = cliente;
	this.monto = monto;
	NumCuenta = numCuenta;
	NumTransaccion = numTransaccion;
	
	
}


public  void realizarPago() {
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


public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public double getMonto() {
	return monto;
}

public void setMonto(int monto) {
	this.monto = monto;
}

public int getNumCuenta() {
	return NumCuenta;
}

public void setNumCuenta(int numCuenta) {
	NumCuenta = numCuenta;
}

public int getNumTransaccion() {
	return NumTransaccion;
}

public void setNumTransaccion(int numTransaccion) {
	NumTransaccion = numTransaccion;
}




}
