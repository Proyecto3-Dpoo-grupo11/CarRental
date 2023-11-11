package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MEmpleado extends JPanel implements IOpciones {
    private static final long serialVersionUID = 1L;
    private JPanel empleadoPanel;

    public MEmpleado() {
        setLayout(new BorderLayout());

        empleadoPanel = new JPanel();
        empleadoPanel.setLayout(new GridLayout(7, 1, 5, 5));

        // Crear botones para cada opción
        JButton btnMandarMantenimiento = new JButton("Mandar Vehículo a Mantenimiento");
        JButton btnCrearCliente = new JButton("Crear Cliente");
        JButton btnIniciarReserva = new JButton("Iniciar Reserva");
        JButton btnCerrarGuardarReserva = new JButton("Cerrar y Guardar Reserva");
        JButton btnGenerarReporte = new JButton("Generar Reporte de Vehículos en Mantenimiento");
        JButton btnGenerarEntrega = new JButton("Generar Entrega");
        JButton btnAgregarConductorAdicional = new JButton("Añadir Conductor Adicional");

        // Agregar botones al panel
        empleadoPanel.add(btnMandarMantenimiento);
        empleadoPanel.add(btnCrearCliente);
        empleadoPanel.add(btnIniciarReserva);
        empleadoPanel.add(btnCerrarGuardarReserva);
        empleadoPanel.add(btnGenerarReporte);
        empleadoPanel.add(btnGenerarEntrega);
        empleadoPanel.add(btnAgregarConductorAdicional);

        // Configurar listeners para cada botón
        btnMandarMantenimiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Mandar Vehículo a Mantenimiento"
                // Puedes abrir un nuevo cuadro de diálogo para ingresar la información necesario
            }
        });

        // Repite lo mismo para los demás botones...

        add(empleadoPanel, BorderLayout.CENTER);
    }

    @Override
    public Component getVisualComponent() {
        return this;
    }
}
