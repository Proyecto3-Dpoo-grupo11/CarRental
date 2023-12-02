package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FMenuInicio {
    private JFrame frame;

    public FMenuInicio() {
        frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panelPrincipal = new JPanel(new GridLayout(3, 1));

        JLabel labelTitulo = new JLabel("Elija cómo iniciar sesión:");
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 22)); 

        JButton empleadoButton = new JButton("Iniciar como Empleado");
        JButton clienteButton = new JButton("Iniciar como Cliente");

        Font buttonFont = new Font("Arial", Font.PLAIN, 18); // DTAMANO BOTONES
        empleadoButton.setFont(buttonFont);
        clienteButton.setFont(buttonFont);

        empleadoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                iniciarAppEmpleado();
            }
        });

        clienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                iniciarAppCliente();
            }
        });

        panelPrincipal.add(labelTitulo);
        panelPrincipal.add(empleadoButton);
        panelPrincipal.add(clienteButton);

        frame.add(panelPrincipal);

        // Centrar la ventana en la pantalla
        frame.setLocationRelativeTo(null);
    }

    public void mostrarMenu() {
        frame.setVisible(true);
    }

    private void iniciarAppEmpleado() {
        FAppEmpleados fEmpleados = new FAppEmpleados();
        fEmpleados.start();
    }

    private void iniciarAppCliente() {
    	FAppClientes fClientes = new FAppClientes();
    	fClientes.start();
    }

    public static void main(String[] args) {
        FMenuInicio menuInicio = new FMenuInicio();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                menuInicio.mostrarMenu();
            }
        });
    }
}
