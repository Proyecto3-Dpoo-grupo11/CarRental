package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MAdminSede extends JPanel implements IOpciones {
    private static final long serialVersionUID = 1L;
    private JPanel adminSedePanel;

    public MAdminSede() {
        setLayout(new BorderLayout());

        adminSedePanel = new JPanel();
        adminSedePanel.setLayout(new GridLayout(2, 1, 5, 5));

        // Crear botones para cada opción
        JButton btnCrearEmpleado = new JButton("Crear Nuevo Empleado");
        JButton btnEliminarEmpleado = new JButton("Eliminar Empleado");

        // Agregar botones al panel
        adminSedePanel.add(btnCrearEmpleado);
        adminSedePanel.add(btnEliminarEmpleado);

        // Configurar listeners para cada botón
        btnCrearEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Crear Nuevo Empleado"
                // Puedes abrir un nuevo cuadro de diálogo para ingresar la información necesario
            }
        });

        btnEliminarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Eliminar Empleado"
                // Puedes abrir un nuevo cuadro de diálogo para ingresar la información necesario
            }
        });

        add(adminSedePanel, BorderLayout.CENTER);
    }

    @Override
    public Component getVisualComponent() {
        return this;
    }
}
