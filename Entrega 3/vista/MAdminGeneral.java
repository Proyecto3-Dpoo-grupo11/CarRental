package vista;

import javax.swing.*;

import control.Control;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MAdminGeneral extends JPanel implements IOpciones {
    private static final long serialVersionUID = 1L;
    private JPanel adminGeneralPanel;

    public MAdminGeneral() {
    	    	
    	setLayout(new BorderLayout());

        adminGeneralPanel = new JPanel();
        adminGeneralPanel.setLayout(new GridLayout(7, 1, 5, 5));

        // Crear botones para cada opción
        JButton btnCrearAdminSede = new JButton("Crear Nuevo Administrador de la Sede");
        JButton btnEliminarAdminSede = new JButton("Eliminar Administrador de la Sede");
        JButton btnNuevoVehiculo = new JButton("Añadir Nuevo Vehículo");
        JButton btnBorrarVehiculo = new JButton("Borrar Vehículo");
        JButton btnNuevaSede = new JButton("Añadir Nueva Sede");
        JButton btnEliminarSede = new JButton("Eliminar Sede");
        JButton btnModificarSeguro = new JButton("Modificar Seguros");

        // Agregar botones al panel
        adminGeneralPanel.add(btnCrearAdminSede);
        adminGeneralPanel.add(btnEliminarAdminSede);
        adminGeneralPanel.add(btnNuevoVehiculo);
        adminGeneralPanel.add(btnBorrarVehiculo);
        adminGeneralPanel.add(btnNuevaSede);
        adminGeneralPanel.add(btnEliminarSede);
        adminGeneralPanel.add(btnModificarSeguro);

        // Configurar listeners para cada botón
        btnCrearAdminSede.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//datos = popDialogCrearAdminSede();
            	((logica.AdminGeneral) Control.usuarioActual).crearAdminSede("hola", "hola", "", null);
            	//Este es un ejemplo de como se haria, con el casting, para acceder a los metodos del usuario admingeneral 
            	//y crear asi uno de sede
            }
        });

        // Repite lo mismo para los demás botones...
        
        add(adminGeneralPanel, BorderLayout.CENTER);
    }

    protected void popDialogCrearAdminSede() {
    	
    	//new CrearCuentaDialog(frame);
		
		
	}

	@Override
    public Component getVisualComponent() {
        return this;
    }
}
