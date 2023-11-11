package presentacion;
import javax.swing.*;

import java.awt.*;

public class prueba extends JFrame {
	

	private JFrame frame;
    private JPanel menuPanel;
    private JPanel contentPanel;
    private JLabel usuarioLabel;

    public prueba() {
        // Configurar la ventana principal
    	frame = new JFrame("Empresa de Alquiler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
       
        frame.setTitle("Empresa de Alquiler");

        // Panel de menú
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(8, 1));

        JButton iniciarSesionButton = new JButton("Iniciar Sesión");
        JButton crearCuentaButton = new JButton("Crear Cuenta");

        // Agregar componentes al panel de menú
        menuPanel.add(iniciarSesionButton);
        menuPanel.add(crearCuentaButton);

        // Panel de contenido
        contentPanel = new JPanel();
        contentPanel.setLayout(new CardLayout()); // Puedes usar CardLayout para cambiar el contenido dinámicamente

        // Label para mostrar el usuario actual
        usuarioLabel = new JLabel("Usuario Actual: ");
        contentPanel.add(usuarioLabel);

        // Agregar los paneles a la ventana principal
        getContentPane().add(menuPanel, BorderLayout.WEST);
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        // Manejar eventos de los botones
        iniciarSesionButton.addActionListener(e -> mostrarPanelIniciarSesion());
        crearCuentaButton.addActionListener(e -> mostrarPanelCrearCuenta());

        // Mostrar la ventana
        setVisible(true);
    }

    private void mostrarPanelIniciarSesion() {
        // Lógica para mostrar el panel de inicio de sesión
        // Debes crear un nuevo JPanel con los campos de usuario y contraseña
        // y agregarlo al contentPanel
    }

    private void mostrarPanelCrearCuenta() {
        // Lógica para mostrar el panel de creación de cuenta
        // Debes crear un nuevo JPanel con los campos para crear una cuenta
        // y agregarlo al contentPanel
	    }
    
    public void start() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                prueba main = new prueba();
                main.start();
            }
        });
    }
}
