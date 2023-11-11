package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MCliente extends JPanel implements IOpciones {
    private static final long serialVersionUID = 1L;
    private JPanel clientePanel;

    public MCliente() {
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
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Iniciar Reserva"
                // Puedes abrir un nuevo cuadro de diálogo para ingresar la información necesario
            }
        });

        // Repite lo mismo para los demás botones...

        add(clientePanel, BorderLayout.CENTER);
    }

    @Override
    public Component getVisualComponent() {
        return this;
    }
}
