package vista;

import javax.swing.*;

import control.Control;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FAppEmpleados {
    private JFrame frame;
    private PLogin loginPanel;
    private PMenuOpciones menuOpcionesPanel;
    private JLabel statusLabel;

    public FAppEmpleados() {
    	
    	Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                // Llamar al método deseado antes de cerrar la aplicación
            	end();
            }
        });
    	
        frame = new JFrame("Alquiler App Empleados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        
        //Crea el Label que va abajo
        if (Control.usuarioActual == null) {
        	statusLabel = new JLabel("Usuario actual: Invitado");
        } else {
        	statusLabel = new JLabel("Usuario actual: " + Control.usuarioActual.getUsername()); 
        }       

        // Crea el panel de login
        loginPanel = new PLogin(0);
                
     // Crea el panel menu, que a su vez contiene todos los menus de usuarios
        menuOpcionesPanel = new PMenuOpciones(0);        
        loginPanel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("usuarioAutenticado".equals(evt.getPropertyName())) {
                    int tipoUsuario = (int) evt.getNewValue();
                    
                    String mensaje = "Lo sentimos pero el usuario actual no puede ser autenticado como funcionario.";
                    
                    if (tipoUsuario == 1) {
                        menuOpcionesPanel.setMenu(new MAdminGeneral());
                    } else if (tipoUsuario == 2) {
                        menuOpcionesPanel.setMenu(new MAdminSede());
                    } else if (tipoUsuario == 3) {
                        menuOpcionesPanel.setMenu(new MEmpleado(loginPanel.control, loginPanel.getUsernameField().getText()));
                    } else if (tipoUsuario == 4) {
                        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                    } 
                    
                    menuOpcionesPanel.mostrarMenu();
                    
                    revalidarFrame();
                }
            }
        });
        
        
        //Anade al frame
        frame.add(menuOpcionesPanel, BorderLayout.CENTER);
        frame.add(loginPanel, BorderLayout.WEST);
        frame.add(statusLabel, BorderLayout.SOUTH);
    }

    

	protected void revalidarFrame() {
    	
        statusLabel.setText("Usuario actual: " + Control.usuarioActual.getUsername());
        frame.revalidate();
	}

	public void start() {
        frame.setVisible(true);
    }
	
	public void end() {
        frame.setVisible(false);
        loginPanel.control.GuardarEmpresa();
    }

    
}