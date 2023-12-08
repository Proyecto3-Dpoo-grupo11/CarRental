package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    int numTarjeta;

    @BeforeEach
    void setUp() {
        // Configuración común para cada prueba
        cliente = new Cliente("jj.diazo1", "amoDpo", Roles.CLIENTE ,"Juan Jose", "jj.diazo1@uniandes.edu.co", "3177689922", "24/12/2004", "Colombia",
                "miCedula.png", "miLicencia.png", "debito", "240120412", "24/12/21");
        monto = 100; // Monto para las pruebas
        numTransaccion = 123; // Número de transacción para las pruebas
        recibo = "Recibo de prueba"; // Recibo para las pruebas
        numTarjeta=100;
    }

    @Test
    void testPagoExitosoPayU() {
        // Prueba para verificar que el pago se realiza correctamente

        // Simulación de la creación de un objeto MMetodosDePago a través de CargaDinamica
        CargaDinamica carga = new CargaDinamica("vista.MPayU", cliente, monto, numTransaccion, recibo);

        assertNotNull(carga.pagos); // Verifica si se creó correctamente el objeto MMetodosDePago

        // Realiza el pago y verifica si fue exitoso
      
    }

    @Test
    void testPagoExitosoPayPal() {
        // Prueba para verificar que el pago falla cuando no hay saldo suficiente

        // Simulación de la creación de un objeto MMetodosDePago a través de CargaDinamica
        CargaDinamica carga = new CargaDinamica("vista.MPayPal", cliente, monto, numTransaccion, recibo);

        assertNotNull(carga.pagos); // Verifica si se creó correctamente el objeto MMetodosDePago

        // Redefine el monto para simular un saldo insuficiente
       
    }
    @Test
    void testClassNotFoundException() {
        // Prueba para verificar que se maneja correctamente la ClassNotFoundException

        // Captura la salida impresa en la consola
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));

        // Simulación de la creación de un objeto MMetodosDePago a través de CargaDinamica
        CargaDinamica carga = new CargaDinamica("ClaseNoExistente", cliente, monto, numTransaccion, recibo);

        // Restaurar System.out
        System.setOut(oldOut);

        // Obtener la salida impresa
        String consoleOutput = outputStreamCaptor.toString().trim();

        // Realizar la aserción
        assertTrue(consoleOutput.contains("Class not found"), "Se esperaba la impresión 'Class not found'");
    }@Test
    void testGenericException() {
        // Prueba para verificar que se maneja correctamente una Exception genérica

        // Captura la salida impresa en la consola
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;
        System.setOut(new PrintStream(outputStreamCaptor));

        // Simulación de la creación de un objeto MMetodosDePago a través de CargaDinamica
        CargaDinamica carga = new CargaDinamica("vista.MPayU", cliente, monto,numTransaccion, recibo);

        // Redefine el monto para simular un error durante la construcción del objeto
        monto = -1;

        // Restaurar System.out
        System.setOut(oldOut);

        // Obtener la salida impresa
        String consoleOutput = outputStreamCaptor.toString().trim();

        // Realizar la aserción
        assertTrue(consoleOutput.contains("Error constructing the payment method"), "Se esperaba la impresión 'Error constructing the payment method'");
    }

    
    }
	
