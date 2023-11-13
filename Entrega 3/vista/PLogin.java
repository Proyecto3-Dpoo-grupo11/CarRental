	package vista;

import javax.swing.*;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import control.Control;

public class PLogin extends JPanel {
    private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton createAccountButton;
    public Control control;
    private PropertyChangeSupport propertyChangeSupport;

    public PLogin() {
    	
    	this.control = new Control();
    	
    	this.propertyChangeSupport = new PropertyChangeSupport(this);
    	
    	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    	JLabel usernameLabel = new JLabel("Username");
        usernameField = new JTextField();
        
        usernameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        JLabel passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField();
        
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        
        loginButton = new JButton("      Iniciar Sesión     ");
        createAccountButton = new JButton("Crear Usuario Nuevo");

        add(usernameLabel);
        add(usernameField);
        add(Box.createVerticalStrut(30)); // Agrega un espacio de 30 píxeles
        add(passwordLabel);
        add(passwordField);
        add(Box.createVerticalStrut(30)); // Agrega otro espacio de 30 píxeles
        add(loginButton);
        add(createAccountButton);
     

        // Set up action listeners
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle login button click
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();
                autenticarUsuario(username, password);
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearUsuario();
            }
        });
    }


	protected void autenticarUsuario(String username, char[] password) {
		
		int numConfirmacion = 0;
		
		numConfirmacion = this.control.iniciarSesion(username, password);
		
		if (numConfirmacion != 0) {
            propertyChangeSupport.firePropertyChange("usuarioAutenticado", null, numConfirmacion);  // Notifica a PMenuOpciones

        } else {
        	//TODO ACA DEBE MANDAR UN POPOUT DICIENDO NOO SE ENCONOTRO EL USUARIO
        }
	}
	
	
	protected void crearUsuario() {
		//propertyChangeSupport.firePropertyChange("dialogoCrearUsuario", false, true); //si se quisiera decir algo al view
		propertyChangeSupport.firePropertyChange("usuarioAutenticado", null, 5); //El 5 esta predispuesto para poner el menu crearUsuario
		
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
	
	public JTextField getUsernameField() {
		return usernameField;
	}
}
