package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearCuentaDialog extends JDialog {
    private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;
    // Agrega aquí todos los campos necesarios...

    public CrearCuentaDialog(Frame parent) {
        super(parent, "Crear Cuenta", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));

        panel.add(new JLabel("Nombre de Usuario:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Contraseña:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Agrega aquí todos los campos necesarios...

        JButton crearCuentaButton = new JButton("Crear Cuenta");
        crearCuentaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para crear la cuenta con los datos ingresados
                // Puedes obtener los valores de los campos llamando a getText() o getPassword() en los campos correspondientes
                dispose(); // Cierra el diálogo después de crear la cuenta
            }
        });

        panel.add(crearCuentaButton);

        add(panel);
    }
    
    //TODO LO que tocaria hacer aqui es lograr pasarle por parametros no solo los textos si no los campos. Para no tener que 
    //crear uno cada vez que toca.
    
    
    
    
    
    
    

    // Agrega aquí métodos para obtener los valores de los campos si es necesario

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                JFrame frame = new JFrame("Ejemplo de Crear Cuenta");
//                frame.setSize(800, 600);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//                JButton mostrarDialogButton = new JButton("Mostrar Crear Cuenta");
//                mostrarDialogButton.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        CrearCuentaDialog dialog = new CrearCuentaDialog(frame);
//                        dialog.setVisible(true);
//                    }
//                });
//
//                frame.add(mostrarDialogButton);
//                frame.setVisible(true);
//            }
//        });
//    }
}
