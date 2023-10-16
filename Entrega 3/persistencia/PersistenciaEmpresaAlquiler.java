package persistencia;

import logica.EmpresaAlquiler;
import java.io.*;


public class PersistenciaEmpresaAlquiler {

	private static final String archivoEmpresaAlquiler = "empresaAlquiler.dat";

    public static void guardarEmpresaAlquiler(EmpresaAlquiler empresaAlquiler) {
        File carpetaData = new File("datos");
        if (!carpetaData.exists()) {
            carpetaData.mkdir();
        }

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivoEmpresaAlquiler))) {
            outputStream.writeObject(empresaAlquiler);
            System.out.println("EmpresaAlquiler guardada con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static EmpresaAlquiler cargarEmpresaAlquiler() {
    	
    	EmpresaAlquiler empresaAlquiler = null;
        File archivo = new File(archivoEmpresaAlquiler);
        
        if (archivo.exists()) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivoEmpresaAlquiler))) {
                empresaAlquiler = (EmpresaAlquiler) inputStream.readObject();
                System.out.println("EmpresaAlquiler cargada con éxito.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            // Si el archivo no existe, crea uno nuevo
            empresaAlquiler = new EmpresaAlquiler();
            guardarEmpresaAlquiler(empresaAlquiler); // Guarda la instancia en el archivo
            System.out.println("Nuevo archivo de EmpresaAlquiler creado.");
        }

        return empresaAlquiler;
    }
}