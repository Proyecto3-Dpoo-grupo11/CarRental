package vista;

import javax.swing.*;

import control.Control;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class FPrincipal {
    private JFrame frame;
    private PLogin loginPanel;
    private PMenuOpciones menuOpcionesPanel;
    private JLabel statusLabel;

    public FPrincipal() {
        frame = new JFrame("Empresa Alquiler");
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
        loginPanel = new PLogin();
        
     // Crea el panel menu, que a su vez contiene todos los menus de usuarios
        menuOpcionesPanel = new PMenuOpciones();        
        loginPanel.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("usuarioAutenticado".equals(evt.getPropertyName())) {
                    int tipoUsuario = (int) evt.getNewValue();
                    
                    if (tipoUsuario == 1) {
                        menuOpcionesPanel.setMenu(new MAdminGeneral());
                    } else if (tipoUsuario == 2) {
                        menuOpcionesPanel.setMenu(new MAdminSede());
                    } else if (tipoUsuario == 3) {
                        menuOpcionesPanel.setMenu(new MEmpleado(loginPanel.control, loginPanel.getUsernameField().getText()));
                    } else if (tipoUsuario == 4) {
                    	
                        menuOpcionesPanel.setMenu(new MCliente(loginPanel.control, loginPanel.getUsernameField().getText()));
                    } else if (tipoUsuario == 5) {
                        menuOpcionesPanel.setMenu(new MCrearCliente(loginPanel.control)); 
                        //Solo se le pasa a este porque es el unico que tendra que acceder directamente a los metodos de la empresa
                    }
                    
                    menuOpcionesPanel.mostrarMenu();
                    
                    revalidarFrame();
                }
            }
        });
        
//        statusLabel.addPropertyChangeListener(new PropertyChangeListener() {
//        	@Override
//            public void propertyChange(PropertyChangeEvent evt) {
//                if ("dialogoCrearUsuario".equals(evt.getPropertyName()) && (Boolean) evt.getNewValue()) {
//                	
//                    revalidarFrame();
//                }
//            }
//        });
//        
        
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	FPrincipal lightsOutApp = new FPrincipal();
                lightsOutApp.start();
            }
        });
    }
}