package vista;

import javax.swing.*;

import control.Control;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MCliente extends JPanel implements IOpciones {
    private static final long serialVersionUID = 1L;
    private JPanel clientePanel;

    public MCliente(Control control, String username) {
    	
    	
        setLayout(new BorderLayout());

        clientePanel = new JPanel();
        clientePanel.setLayout(new GridLayout(4, 1, 5, 5));

        // Crear botones para cada opción
        JButton btnIniciarReserva = new JButton("Iniciar Reserva");
        JButton btnCerrarGuardarReserva = new JButton("Cerrar y Guardar Reserva");
        JButton btnVerMetodoPago = new JButton("Ver Método de Pago");
        JButton btnSalir = new JButton("Salir");

        // Agregar botones al panel
        clientePanel.add(btnIniciarReserva);
        clientePanel.add(btnCerrarGuardarReserva);
        clientePanel.add(btnVerMetodoPago);
        clientePanel.add(btnSalir);

        // Configurar listeners para cada botón
        btnIniciarReserva.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Iniciar Reserva"
            	JButton btnPress = (JButton) e.getSource();
                String coordenada = btnPress.getActionCommand();
                if(coordenada.equals("Iniciar Reserva")){
                
                }
            }
        });
        btnCerrarGuardarReserva.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Cerrar y Guardar Reserva"
            	JButton btnPress = (JButton) e.getSource();
                String coordenada = btnPress.getActionCommand();
                if(coordenada.equals("Cerrar y Guardar Reserva")){
                	control.getCerrarSesion(username);
                }
            }
        });
        btnVerMetodoPago.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            	// Lógica para la opción "Ver Metodo de Pago"
            	JButton btnPress = (JButton) e.getSource();
                String coordenada = btnPress.getActionCommand();
                if(coordenada.equals("Ver Método de Pago")){
                	control.getMetodoDePago(username);
                }
            }
        });
        btnSalir.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Salir"
            	JButton btnPress = (JButton) e.getSource();
                String coordenada = btnPress.getActionCommand();
                if(coordenada.equals("Salir")){
                	
                }
            }
        });

        add(clientePanel, BorderLayout.CENTER);
    }

     
    public Component getVisualComponent() {
        return this;
    }
}
