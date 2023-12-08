package vista;

import java.io.IOException;
import logica.Cliente;

public class CargaDinamica {
    public MMetodosDePago pagos;

    public CargaDinamica(String clasePago, Cliente cliente,
    		double monto, int numTransaccion,String recibo) {
        try {
            
            Class<?> clase = Class.forName(clasePago);

            
            Class<?>[] parameterTypes = {Cliente.class, double.class, 
            		int.class,String.class};
            this.pagos = (MMetodosDePago) clase.getDeclaredConstructor
            		(parameterTypes).newInstance(cliente, 
            		monto, numTransaccion,recibo);

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + clasePago);
            this.pagos = null;
        } catch (Exception e) {
            System.out.println("Error constructing the payment method: " 
        + e.getMessage());
            e.printStackTrace();
            this.pagos = null;
        }
    }
}
