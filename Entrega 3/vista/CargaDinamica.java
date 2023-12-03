package vista;

import java.io.IOException;
import logica.Cliente;

public class CargaDinamica {
    public MMetodosDePago pagos;

    public CargaDinamica(String clasePago, Cliente cliente, int monto, int numCuenta, int numTransaccion) {
        try {
            // 1. Dado el nombre completo (claseAgenda), encontramos un objeto de la clase
            // Class
            Class clase = Class.forName(clasePago);

            // 2. Le pedimos a la clase un constructor con los parámetros adecuados
            Class[] parameterTypes = {Cliente.class, int.class, int.class, int.class};
            this.pagos = (MMetodosDePago) clase.getDeclaredConstructor(parameterTypes).newInstance(cliente, monto, numCuenta, numTransaccion);

            // Rest of your code...
        } catch (ClassNotFoundException e) {
            System.out.println("No existe la clase " + clasePago);
        } catch (Exception e) {
            System.out.println("Hubo otro error construyendo la agenda telefónica: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
