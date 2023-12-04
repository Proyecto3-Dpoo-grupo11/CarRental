package vista;

import java.util.Random;

import logica.Cliente;

public class MPayU extends MMetodosDePago {
    int saldo;

    public MPayU(Cliente cliente, double monto, int numCuenta, int numTransaccion,String recibo) {
        super(cliente, monto, numCuenta, numTransaccion,recibo);
        // Set the nombre field to "PayU" when an instance is instantiated
        
    }

    
}
