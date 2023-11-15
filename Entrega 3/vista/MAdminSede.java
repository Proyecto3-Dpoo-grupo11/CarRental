package vista;

import javax.swing.*;

import control.Control;
import logica.Roles;
import logica.Sede;
import logica.Vehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        JButton btnGrafica = new JButton("Grafica");

        // Agregar botones al panel
        adminSedePanel.add(btnCrearEmpleado);
        adminSedePanel.add(btnEliminarEmpleado);
        adminSedePanel.add(btnGrafica);

        // Configurar listeners para cada botón
        btnCrearEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Crear Nuevo Empleado"
                // Puedes abrir un nuevo cuadro de diálogo para ingresar la información necesario
            	JButton botonPresionado = (JButton) e.getSource();
                String coordenada = botonPresionado.getActionCommand();
                
                //opcion 1:
                if(coordenada.equals("Crear Nuevo Empleado")) {
                	String[] res=dialogCrearEmpleado(adminSedePanel);
                	if (res!=null) {
                	((logica.AdminSede) Control.usuarioActual).addEmpleado(res[0], res[1], Roles.EMPLEADO);
                	}
                } 	
            }
        });

        btnEliminarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Eliminar Empleado"
                // Puedes abrir un nuevo cuadro de diálogo para ingresar la información necesario
            	//datos = popDialogCrearAdminSede();
            	// Lógica para la opción "Crear Nuevo Empleado"
                // Puedes abrir un nuevo cuadro de diálogo para ingresar la información necesario
            	JButton botonPresionado = (JButton) e.getSource();
                String coordenada = botonPresionado.getActionCommand();
                
                //opcion 1:
                if(coordenada.equals("Grafica")) {
                	String[] res=dialogEliminarEmpleado(adminSedePanel);
                	Sede sede=((logica.AdminSede) Control.usuarioActual).BuscadorSedesede();
                	ArrayList<Vehiculo> lista =sede.listaVehiculos;
                	
                	CarAvailabilityGraph graph= new CarAvailabilityGraph(coordenada, sede,lista);
                	graph.setVisible(true);
                } 
            }
        });
        

        add(adminSedePanel, BorderLayout.CENTER);
    }
    public static String[] dialogCrearEmpleado(JPanel parent) {
        // Create the JDialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Eliminar Administrador de Sede");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout(0, 3, 10, 10)); // Updated GridLayout with increased gaps

        // Create text fields
        JTextField textFieldUsuario = new JTextField();
        JTextField textFieldContraseña = new JTextField();

        // Create labels for warnings
        JLabel warningLabelUsuario = new JLabel(" ");
        JLabel warningLabelContraseña = new JLabel(" ");

        // Add title, text field, and label for username
        dialog.add(new JLabel("<html>Ingrese el username<br>del empleado que desea agregar:</html>"));
        dialog.add(textFieldUsuario);
        dialog.add(warningLabelUsuario);

        // Add title, text field, and label for sede code
        dialog.add(new JLabel("<html>Ingrese la contraseña del <br>del empleado que desea agregar:</html>"));
        dialog.add(textFieldContraseña);
        dialog.add(warningLabelContraseña);

        // Create buttons
        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        // Add action listeners to the buttons
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any of the text fields is empty
                if (textFieldUsuario.getText().isEmpty() || textFieldContraseña.getText().isEmpty()) {
                    // Display a warning message near the text fields
                    warningLabelUsuario.setText(textFieldUsuario.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelContraseña.setText(textFieldContraseña.getText().isEmpty() ? "Llene este espacio!" : " ");

                } else {
                    // Close the dialog if all text fields are filled
                    dialog.dispose();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Close the dialog
            }
        });

        // Add buttons to the dialog
        dialog.add(acceptButton);
        dialog.add(cancelButton);

        // Set the size and make the dialog visible
        dialog.setSize(600, 300); // Adjusted size
        dialog.setVisible(true);

        // Check which button was clicked and return values accordingly
        if (textFieldUsuario.getText().isEmpty() || textFieldContraseña.getText().isEmpty()) {
            return null; // Return null if any of the text fields is empty (Cancel clicked)
        } else {
            // Return values entered in the text fields (Accept clicked)
            return new String[]{textFieldUsuario.getText(), textFieldContraseña.getText()};
        }
    }
    
    public static String[] dialogEliminarEmpleado(JPanel parent) {
        // Create the JDialog
    	 JDialog dialog = new JDialog();
         dialog.setTitle("Enter Values");
         dialog.setModal(true);
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setLayout(new GridLayout(5, 2));
         dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(parent));
         

        // Create text fields
        JTextField textFieldUserNameEmpleado = new JTextField();
        
        

        // Create labels for warnings
        JLabel warningLabelUserNameEmpleado = new JLabel(" ");
       
        

        // Add labels and text fields to the dialog
        dialog.add(new JLabel("Ingrese el nombre de usuario del empleado que desea eliminar:"));
        dialog.add(textFieldUserNameEmpleado);
        dialog.add(warningLabelUserNameEmpleado);

        

        

        // Create buttons
        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        // Add action listeners to the buttons
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any of the text fields is empty
                if (textFieldUserNameEmpleado.getText().isEmpty() ) {
                    // Display a warning message near the text fields
                    warningLabelUserNameEmpleado.setText(textFieldUserNameEmpleado.getText().isEmpty() ? "Llene este espacio!" : " ");
                    
                     
                } else {
                    // Close the dialog if all text fields are filled
                    dialog.dispose();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Close the dialog
            }
        });

        // Add buttons to the dialog
        dialog.add(acceptButton);
        dialog.add(cancelButton);

        // Set the size and make the dialog visible
        dialog.setSize(1000, 300);
        dialog.setVisible(true);

        // Check which button was clicked and return values accordingly
        if (textFieldUserNameEmpleado.getText().isEmpty() ) {
            return null; // Return null if any of the text fields is empty (Cancel clicked)
        } else {
            // Return values entered in the text fields (Accept clicked)
            return new String[]{textFieldUserNameEmpleado.getText()};
        }
    }

    
    
    

    @Override
    public Component getVisualComponent() {
        return this;
    }
}
