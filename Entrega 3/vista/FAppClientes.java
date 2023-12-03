package vista;

import javax.swing.*;

import control.Control;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FAppClientes {
    private JFrame frame;
    private PLogin loginPanel;
    private PMenuOpciones menuOpcionesPanel;
    private JLabel statusLabel;

    public FAppClientes() {
    	
    	Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                // Llamar al método deseado antes de cerrar la aplicación
            	end();
            }
        });
    	
        frame = new JFrame("Alquiler App Clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        
        //Crea el Label que va abajo
        if (Control.usuarioActual == null) {
        	statusLabel = new JLabel("Usuario actual: Invitado");
        } else {
        	statusLabel = new JLabel("Usuario actual: " + Control.usuarioActual.getUsername()); 
        }       

        loginPanel = new PLogin(1);
                
        menuOpcionesPanel = new PMenuOpciones(1);        
        loginPanel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("usuarioAutenticado".equals(evt.getPropertyName())) {
                    int tipoUsuario = (int) evt.getNewValue();
                    
                    String mensaje = "Lo sentimos pero el usuario actual no puede ser autenticado como cliente.";
                    
                    if (tipoUsuario == 1) {
                        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (tipoUsuario == 2) {
                        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (tipoUsuario == 3) {
                        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (tipoUsuario == 4) {
                        menuOpcionesPanel.setMenu(new MCliente(loginPanel.control, loginPanel.getUsernameField().getText()));
                    } else if (tipoUsuario == 5) {
                        menuOpcionesPanel.setMenu(new MCrearCliente(loginPanel.control)); 
                        //Solo se le pasa a este porque es el unico que tendra que acceder directamente a los metodos de la empresa
                    }
                    
                    menuOpcionesPanel.mostrarMenu();
                    
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