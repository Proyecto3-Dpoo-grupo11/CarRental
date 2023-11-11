package vista;

import javax.swing.*;

import control.Control;

import java.awt.*;


public class PMenuOpciones extends JPanel {
    private static final long serialVersionUID = 1L;
    private IOpciones menu;
    private JLabel welcomeLabel;
    private JLabel userLabel;

    public PMenuOpciones() {
        setBackground(Color.GRAY);
        // Agregar un mensaje de bienvenida
        this.welcomeLabel = new JLabel("Bienvenido a la empresa de alquiler. Por favor, inicie sesión.");
        this.welcomeLabel.setFont(new Font("Montserrat", Font.PLAIN, 17));
        this.welcomeLabel.setForeground(Color.WHITE);
        
        this.userLabel = null;
        
        add(welcomeLabel);
    }

    public void setMenu(IOpciones menu) {
        this.menu = menu;
    }

    public void mostrarMenu() {
        if (menu != null) {
            // Si deseas cambiar el mensaje después de iniciar sesión, puedes hacerlo aquí.
        	removeAll();
            setLayout(new BorderLayout());
        	
            try {
                this.userLabel = new JLabel("Bienvenido a la empresa de alquiler señor " + Control.usuarioActual.getUsername() + ".");
            } catch (Exception e) {
                // Manejar la excepción
                e.printStackTrace(); // O imprime un mensaje de error
                this.userLabel = new JLabel("Bienvenido a la empresa de alquiler, Invitado.");
            }
        	
        	this.userLabel.setFont(new Font("Montserrat", Font.PLAIN, 17));
        	this.userLabel.setForeground(Color.WHITE);

            add(this.userLabel, BorderLayout.NORTH);
            
            // Obtener el componente visual del menu y agregarlo al panel
            add(menu.getVisualComponent(), BorderLayout.CENTER);
            
            // Revalidar y repintar el panel
            revalidate();
            repaint();
        }
    }
}
