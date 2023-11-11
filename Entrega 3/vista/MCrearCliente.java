package vista;

import javax.swing.*;

import control.Control;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MCrearCliente extends JPanel implements IOpciones {

    private static final long serialVersionUID = 1L;
    
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField nombreField;
    private JTextField emailField;
    private JTextField telefonoField;
    private JTextField fechaNacimientoField;
    private JTextField nacionalidadField;
    private JTextField imagenCedulaField;
    private JTextField imagenLicenciaField;
    private JTextField metodoDePagoField;
    private JTextField numeroTarjetaField;
    private JTextField fechaVencimientoField;

    public MCrearCliente(Control control) {
        setLayout(new GridLayout(0, 2, 10, 10));

        add(new JLabel("Nombre de Usuario:"));
        usernameField = new JTextField();
        add(usernameField);

        add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        add(passwordField);

        add(new JLabel("Nombre del Cliente:"));
        nombreField = new JTextField();
        add(nombreField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        add(telefonoField);

        add(new JLabel("Fecha de Nacimiento:"));
        fechaNacimientoField = new JTextField();
        add(fechaNacimientoField);

        add(new JLabel("Nacionalidad:"));
        nacionalidadField = new JTextField();
        add(nacionalidadField);

        add(new JLabel("Imagen de Cédula:"));
        imagenCedulaField = new JTextField();
        add(imagenCedulaField);

        add(new JLabel("Imagen de Licencia:"));
        imagenLicenciaField = new JTextField();
        add(imagenLicenciaField);

        add(new JLabel("Método de Pago:"));
        metodoDePagoField = new JTextField();
        add(metodoDePagoField);

        add(new JLabel("Número de Tarjeta:"));
        numeroTarjetaField = new JTextField();
        add(numeroTarjetaField);

        add(new JLabel("Fecha de Vencimiento de Tarjeta:"));
        fechaVencimientoField = new JTextField();
        add(fechaVencimientoField);

        JButton crearClienteButton = new JButton("Crear Cliente");
        crearClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementa la lógica para crear el cliente con la información ingresada
                String nuevoUsername = usernameField.getText();
                String newPassword = new String(passwordField.getPassword());
                String nombreCliente = nombreField.getText();
                String email = emailField.getText();
                String telefono = telefonoField.getText();
                String fechaNacimiento = fechaNacimientoField.getText();
                String nacionalidad = nacionalidadField.getText();
                String imagenCedula = imagenCedulaField.getText();
                String imagenLicencia = imagenLicenciaField.getText();
                String metodoDePago = metodoDePagoField.getText();
                String numeroTarjeta = numeroTarjetaField.getText();
                String fechaVencimiento = fechaVencimientoField.getText();
                
                control.crearCliente(nuevoUsername, newPassword, nombreCliente, email, telefono,
                        fechaNacimiento, nacionalidad, imagenCedula, imagenLicencia,
                        metodoDePago, numeroTarjeta, fechaVencimiento);

                
                // Llama a la lógica para crear el cliente con estos valores
                // por ejemplo: empresa.crearCliente(nuevoUsername, newPassword, ..., fechaVencimiento);
            }
        });

        add(crearClienteButton);
    }

    @Override
    public Component getVisualComponent() {
        return this;
    }
}

