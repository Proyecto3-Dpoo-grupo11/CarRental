package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logica.Cliente;
import logica.EmpresaAlquiler;
import logica.Entrega;
import logica.Reserva;
import logica.Sede;
import logica.TipoVehiculo;


class reservaTest {
	
	EmpresaAlquiler empresa;
//	AdminGeneral admin;
	Sede sede;
//	AdminSede adminSede;
//	Empleado empleado;
	Cliente cliente;
	Reserva reserva; 
	
	 @BeforeEach
	    public void setUp() {
	    	
//		 	this.empresa =  new EmpresaAlquiler();
//		    this.admin = new AdminGeneral("a", "0", Roles.ADMINISTRADORGENERAL, empresa);	
		    this.sede = new Sede(null, null, null, null, null, null);
//		    this.adminSede = new AdminSede("as", "0", Roles.ADMINISTRADORSEDE, "0", sede, empresa);
//		    
		    this.reserva = new Reserva("R001", TipoVehiculo.AUTOMOVIL, "0", "1", "0", "2023/11/10", "2023/11/15",
	                "cliente1", "ruta/imagen.jpg", 2, Entrega.ESPERANDOASERENTREGADOACLIENTE, null, true);
		    
		    this.sede = reserva.BuscarSede("0"); //De una vez probamos este metodo.
		    
		    this.reserva.sede = this.sede;
		    
		    this.reserva.iniciarReserva();	    
		    
		    
	    }

	    

	 @Test
	    public void testGenerarFacturaPDF() {
	        // Ejemplo de ruta del archivo de la factura PDF
	        String rutaFactura = "./data/factura.pdf";

	        Path archivoFactura = Paths.get(rutaFactura);

	        // Verificar si el archivo existe
	        boolean existeFactura = Files.exists(archivoFactura);
	        
	        assertTrue(existeFactura);
	    }
	 
	 @Test
	    public void testAddConductorAdicional() {
	        reserva.addConductorAdicional("ruta/conductor1.jpg");
	        ArrayList<String> conductoresAdicionales = reserva.getListaConductoresAdicionales();
	        assertEquals(1, conductoresAdicionales.size());
	        assertEquals("ruta/conductor1.jpg", conductoresAdicionales.get(0));
	    }
	 
	 @Test
	    public void testGenerarFactura() {
	        List<String> facturaGenerada = reserva.generarFactura(30);

	        assertEquals("Su codigo de reserva es: R001", facturaGenerada.get(0));
	        assertEquals(" Usted registro 2 conductores adicionales", facturaGenerada.get(1));
	        assertEquals("Su vehiculo es del tipo:AUTOMOVIL", facturaGenerada.get(2));
	        assertEquals("Su vehiculo sera recogido en la sede: 0", facturaGenerada.get(3));
	        assertEquals("En la fecha: 2023/11/10", facturaGenerada.get(4));
	        assertEquals("Su vehiculo sera entregado en la sede: 1", facturaGenerada.get(5));
	        assertEquals("Por un total de: 5 dias.", facturaGenerada.get(6));
	        assertEquals("Hasta la fecha: 2023/11/15", facturaGenerada.get(7));
	        assertEquals("Recuerde que debe pagar el 30% del valor del alquiler", facturaGenerada.get(8));
	        assertEquals("Tarifa por conductor adicional: 600.0 $", facturaGenerada.get(9));
	        assertEquals("Tarifa por Entregar en otra sede: 3000.0 $.", facturaGenerada.get(10));
	        assertEquals("Tarifa por dia: 3000.0 $", facturaGenerada.get(11));
	        assertEquals("5 Dias", facturaGenerada.get(12));
	        assertEquals("Total: 10500.0 $.", facturaGenerada.get(13));

	        assertNotNull(facturaGenerada);
	        assertEquals(14, facturaGenerada.size()); // Verifica el tamaño de la lista de la factura generada
	    }
}
