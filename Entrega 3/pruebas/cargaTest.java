package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import logica.Cliente;
import logica.Roles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vista.CargaDinamica;
import vista.MMetodosDePago;

class cargaTest {

    Cliente cliente;
    int monto;
    int numTransaccion;
    String recibo;

    @BeforeEach
    void setUp() {
        // Configuración común para cada prueba
        cliente = new Cliente("jj.diazo1", "amoDpo", Roles.CLIENTE ,"Juan Jose", "jj.diazo1@uniandes.edu.co", "3177689922", "24/12/2004", "Colombia",
                "miCedula.png", "miLicencia.png", "debito", "240120412", "24/12/21");
        monto = 100; // Monto para las pruebas
        numTransaccion = 123; // Número de transacción para las pruebas
        recibo = "Recibo de prueba"; // Recibo para las pruebas
    }

    @Test
    void testPagoExitoso() {
        // Prueba para verificar que el pago se realiza correctamente

        // Simulación de la creación de un objeto MMetodosDePago a través de CargaDinamica
        CargaDinamica carga = new CargaDinamica("vista.MMetodosDePago", cliente, monto, numTransaccion, recibo);

        assertNotNull(carga.pagos); // Verifica si se creó correctamente el objeto MMetodosDePago

        // Realiza el pago y verifica si fue exitoso
        MMetodosDePago metodoPago = carga.pagos;
        boolean resultadoPago = metodoPago.Pagar();
        assertTrue(resultadoPago); // Verifica que el pago se realizó exitosamente
    }

    @Test
    void testPagoFallido() {
        // Prueba para verificar que el pago falla cuando no hay saldo suficiente

        // Simulación de la creación de un objeto MMetodosDePago a través de CargaDinamica
        CargaDinamica carga = new CargaDinamica("vista.MMetodosDePago", cliente, monto, numTransaccion, recibo);

        assertNotNull(carga.pagos); // Verifica si se creó correctamente el objeto MMetodosDePago

        // Redefine el monto para simular un saldo insuficiente
        monto = 1000000; // Monto superior al saldo disponible

        // Asigna el nuevo monto y realiza el pago
        carga.pagos.setMonto(monto);
        boolean resultadoPago = carga.pagos.Pagar();

        assertFalse(resultadoPago); // Verifica que el pago falló debido a saldo insuficiente
    }
	}
