package vista;

import java.util.Random;

import logica.Cliente;

public abstract class MMetodosDePago {
protected Cliente cliente;
protected int monto;
protected int NumCuenta;
protected int NumTransaccion;



public  MMetodosDePago(Cliente cliente, int monto, int numCuenta, int numTransaccion) {
	super();
	this.cliente = cliente;
	this.monto = monto;
	NumCuenta = numCuenta;
	NumTransaccion = numTransaccion;
}


public abstract  void realizarPago() ;


public Cliente getCliente() {
	return cliente;
}

public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}

public int getMonto() {
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
