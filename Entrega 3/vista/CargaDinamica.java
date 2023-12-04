package vista;

import java.io.IOException;
import logica.Cliente;

public class CargaDinamica {
    public MMetodosDePago pagos;

    public CargaDinamica(String clasePago, Cliente cliente, double monto, int numCuenta, int numTransaccion) {
        try {
            // 1. Given the fully qualified name (clasePago), find a Class object
            Class<?> clase = Class.forName(clasePago);

            // 2. Request a constructor with the appropriate parameters from the class
            Class<?>[] parameterTypes = {Cliente.class, double.class, int.class, int.class,};
            this.pagos = (MMetodosDePago) clase.getDeclaredConstructor(parameterTypes).newInstance(cliente, monto, numCuenta, numTransaccion);

            // Rest of your code...
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + clasePago);
        } catch (Exception e) {
            System.out.println("Error constructing the payment method: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
