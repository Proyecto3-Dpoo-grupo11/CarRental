package vista;

import javax.swing.*;

import control.Control;
import logica.Estados;
import logica.Roles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MAdminGeneral extends JPanel implements IOpciones {
    private static final long serialVersionUID = 1L;
    private JPanel adminGeneralPanel;

    public MAdminGeneral() {
    	    	
    	setLayout(new BorderLayout());

        adminGeneralPanel = new JPanel();
        adminGeneralPanel.setLayout(new GridLayout(7, 1, 5, 5));

        // Crear botones para cada opción
        JButton btnCrearAdminSede = new JButton("Crear Nuevo Administrador de la Sede");
        JButton btnEliminarAdminSede = new JButton("Eliminar Administrador de la Sede");
        JButton btnNuevoVehiculo = new JButton("Añadir Nuevo Vehículo");
        JButton btnBorrarVehiculo = new JButton("Borrar Vehículo");
        JButton btnNuevaSede = new JButton("Añadir Nueva Sede");
        JButton btnEliminarSede = new JButton("Eliminar Sede");
        JButton btnModificarSeguro = new JButton("Modificar Seguros");

        // Agregar botones al panel
        adminGeneralPanel.add(btnCrearAdminSede);
        adminGeneralPanel.add(btnEliminarAdminSede);
        adminGeneralPanel.add(btnNuevoVehiculo);
        adminGeneralPanel.add(btnBorrarVehiculo);
        adminGeneralPanel.add(btnNuevaSede);
        adminGeneralPanel.add(btnEliminarSede);
        adminGeneralPanel.add(btnModificarSeguro);

        // Configurar listeners para cada botón
        btnCrearAdminSede.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//datos = popDialogCrearAdminSede();
            	JButton botonPresionado = (JButton) e.getSource();
                String coordenada = botonPresionado.getActionCommand();
                
                //opcion 1:
                if(coordenada.equals("Crear Nuevo Administrador de la Sede")) {
                	String[] res=dialogCrearAdminSede(adminGeneralPanel);
                	if (res!=null) {
                	((logica.AdminGeneral) Control.usuarioActual).crearAdminSede(res[0], res[1],res[2], Roles.ADMINISTRADORSEDE);
                	}
                } 	
            }
        });
        btnEliminarAdminSede.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//datos = popDialogCrearAdminSede();
            	JButton botonPresionado = (JButton) e.getSource();
                String coordenada = botonPresionado.getActionCommand();
                
                //opcion 1:
                if(coordenada.equals("Eliminar Administrador de la Sede")) {
                	String[] res=dialogEliminarAdminSede(adminGeneralPanel);
                	if (res!=null) {
                	((logica.AdminGeneral) Control.usuarioActual).eliminarAdminSede(res[0], res[1]);
                	}
                } 	
            }
        });
        btnNuevoVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//datos = popDialogCrearAdminSede();
            	JButton botonPresionado = (JButton) e.getSource();
                String coordenada = botonPresionado.getActionCommand();
                
                //opcion 1:
                if(coordenada.equals("Añadir Nuevo Vehículo")) {
                	String[] res=dialogAñadirVehiculo(adminGeneralPanel);
                	if (res!=null) {
                	//String categoria, String placa, String marca, String codigoReservaActual, String modelo,
        			//String color, String tipoTransmision, Estados estados, String codigoSede
                	
                	//textFieldCategoriaVehiculo.getText().isEmpty()11 || textFieldPlacaVehiculo.getText().isEmpty()11 || textFieldMarcaVehiculo.getText().isEmpty()33 
            		//|| textFieldModeloVehiculo.getText().isEmpty()44 || textFieldColorVehiculo.getText().isEmpty()55 || textFieldTipoTransmisionVehiculo.getText().isEmpty()66	
            		//|| textFieldCodigoSede.getText().isEmpty())77
                	((logica.AdminGeneral) Control.usuarioActual).nuevoVehiculo(res[0], res[1],res[2], "0", res[3], res[4], res[5], Estados.DISPONIBLE, res[6]);
                	}
                } 	
            }
        });
        btnBorrarVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//datos = popDialogCrearAdminSede();
            	JButton botonPresionado = (JButton) e.getSource();
                String coordenada = botonPresionado.getActionCommand();
                
                //opcion 1:
                if(coordenada.equals("Borrar Vehículo")) {
                	String[] res=dialogEliminarVehiculo(adminGeneralPanel);
                	if (res!=null) {
                	((logica.AdminGeneral) Control.usuarioActual).borrarVehiculo(res[0],res[1]);
                	}
                } 	
            }
        });
        btnNuevaSede.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//datos = popDialogCrearAdminSede();
            	JButton botonPresionado = (JButton) e.getSource();
                String coordenada = botonPresionado.getActionCommand();
                
                //opcion 1:
                if(coordenada.equals("Añadir Nueva Sede")) {
                	String[] res=dialogAñadirNuevaSede(adminGeneralPanel);
                	if (res!=null) {
                	((logica.AdminGeneral) Control.usuarioActual).addSede(res[0], res[1],res[2]);
                	}
                } 	
            }
        });
        btnEliminarSede.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//datos = popDialogCrearAdminSede();
            	JButton botonPresionado = (JButton) e.getSource();
                String coordenada = botonPresionado.getActionCommand();
                
                //opcion 1:
                if(coordenada.equals("Eliminar Sede")) {
                	String[] res=dialogEliminarSede(adminGeneralPanel);
                	if (res!=null) {
                	((logica.AdminGeneral) Control.usuarioActual).eliminarSedes(res[0]);
                	}
                } 	
            }
        });
        btnModificarSeguro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	//datos = popDialogCrearAdminSede();
            	JButton botonPresionado = (JButton) e.getSource();
                String coordenada = botonPresionado.getActionCommand();
                
                //opcion 1:
                if(coordenada.equals("Modificar Seguros")) {
                	String[] res=dialogModificarSeguros(adminGeneralPanel);
                	if (res!=null) {
                	((logica.AdminGeneral) Control.usuarioActual).modificarSeguro(res[0], res[1], Integer.parseInt(res[2]));
                	}
                } 	
            }
        });
        
        
        

        // Repite lo mismo para los demás botones...
        
        add(adminGeneralPanel, BorderLayout.CENTER);
    }
    
    
    
    
    public static String[] dialogCrearAdminSede(JPanel parent) {
        // Create the JDialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Enter Values");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout(4, 2));
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(parent));

        // Create text fields
        JTextField textFieldUsuario = new JTextField();
        JTextField textFieldContraseña = new JTextField();
        JTextField textFieldCodigoSede = new JTextField();

        // Create labels for warnings
        JLabel warningLabelUsuario = new JLabel(" ");
        JLabel warningLabelContraseña = new JLabel(" ");
        JLabel warningLabelCodigoSede = new JLabel(" ");

        // Add labels and text fields to the dialog
        dialog.add(new JLabel("Nombre de usuario:"));
        dialog.add(textFieldUsuario);
        dialog.add(warningLabelUsuario);

        dialog.add(new JLabel("Contraseña:"));
        dialog.add(textFieldContraseña);
        dialog.add(warningLabelContraseña);

        dialog.add(new JLabel("Código de la sede:"));
        dialog.add(textFieldCodigoSede);
        dialog.add(warningLabelCodigoSede);

        // Set preferred size for text fields
        textFieldUsuario.setPreferredSize(new Dimension(150, 25));
        textFieldContraseña.setPreferredSize(new Dimension(150, 25));
        textFieldCodigoSede.setPreferredSize(new Dimension(200, 25));  // Increased size for "Código de la sede"

        // Create buttons
        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        // Add action listeners to the buttons
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any of the text fields is empty
                if (textFieldUsuario.getText().isEmpty() || textFieldContraseña.getText().isEmpty() || textFieldCodigoSede.getText().isEmpty()) {
                    // Display a warning message near the text fields
                    warningLabelUsuario.setText(textFieldUsuario.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelContraseña.setText(textFieldContraseña.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelCodigoSede.setText(textFieldCodigoSede.getText().isEmpty() ? "Llene este espacio!" : " ");
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
        dialog.setSize(400, 200);  // Increased size for the dialog
        dialog.setVisible(true);

        // Check which button was clicked and return values accordingly
        if (textFieldUsuario.getText().isEmpty() || textFieldContraseña.getText().isEmpty() || textFieldCodigoSede.getText().isEmpty()) {
            return null; // Return null if any of the text fields is empty (Cancel clicked)
        } else {
            // Return values entered in the text fields (Accept clicked)
            return new String[]{textFieldUsuario.getText(), textFieldContraseña.getText(), textFieldCodigoSede.getText()};
        }
    }


    
    
    public static String[] dialogEliminarAdminSede(JPanel parent) {
        // Create the JDialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Eliminar Administrador de Sede");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout(0, 3, 10, 10)); // Updated GridLayout with increased gaps

        // Create text fields
        JTextField textFieldUsuario = new JTextField();
        JTextField textFieldCodigoSede = new JTextField();

        // Create labels for warnings
        JLabel warningLabelUsuario = new JLabel(" ");
        JLabel warningLabelCodigoSede = new JLabel(" ");

        // Add title, text field, and label for username
        dialog.add(new JLabel("<html>Ingrese el username<br>del administrador que desea borrar:</html>"));
        dialog.add(textFieldUsuario);
        dialog.add(warningLabelUsuario);

        // Add title, text field, and label for sede code
        dialog.add(new JLabel("<html>Ingrese el código de la sede<br>del administrador que desea borrar:</html>"));
        dialog.add(textFieldCodigoSede);
        dialog.add(warningLabelCodigoSede);

        // Create buttons
        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        // Add action listeners to the buttons
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any of the text fields is empty
                if (textFieldUsuario.getText().isEmpty() || textFieldCodigoSede.getText().isEmpty()) {
                    // Display a warning message near the text fields
                    warningLabelUsuario.setText(textFieldUsuario.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelCodigoSede.setText(textFieldCodigoSede.getText().isEmpty() ? "Llene este espacio!" : " ");

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
        if (textFieldUsuario.getText().isEmpty() || textFieldCodigoSede.getText().isEmpty()) {
            return null; // Return null if any of the text fields is empty (Cancel clicked)
        } else {
            // Return values entered in the text fields (Accept clicked)
            return new String[]{textFieldUsuario.getText(), textFieldCodigoSede.getText()};
        }
    }


    
    public static String[] dialogAñadirVehiculo(JPanel parent) {
        // Create the JDialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Enter Values");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout(0, 3, 5, 5)); // Updated GridLayout
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(parent));

        // Create text fields
        JTextField textFieldCategoriaVehiculo = new JTextField();
        JTextField textFieldPlacaVehiculo = new JTextField();
        JTextField textFieldMarcaVehiculo = new JTextField();
        JTextField textFieldModeloVehiculo = new JTextField();
        JTextField textFieldColorVehiculo = new JTextField();
        JTextField textFieldTipoTransmisionVehiculo = new JTextField();
        JTextField textFieldCodigoSede = new JTextField();

        // Create labels for warnings
        JLabel warningLabelCategoriaVehiculo = new JLabel(" ");
        JLabel warningLabelPlacaVehiculo = new JLabel(" ");
        JLabel warningLabelMarcaVehiculo = new JLabel(" ");
        JLabel warningLabelModeloVehiculo = new JLabel(" ");
        JLabel warningLabelColorVehiculo = new JLabel(" ");
        JLabel warningLabelTipoTransmisionVehiculo = new JLabel(" ");
        JLabel warningLabelCodigoSede = new JLabel(" ");

        // Add title, text field, and label for categoria
        dialog.add(new JLabel("Ingrese la categoria del vehiculo:"));
        dialog.add(textFieldCategoriaVehiculo);
        dialog.add(warningLabelCategoriaVehiculo);

        // Add title, text field, and label for placa
        dialog.add(new JLabel("Ingrese la placa del vehiculo:"));
        dialog.add(textFieldPlacaVehiculo);
        dialog.add(warningLabelPlacaVehiculo);

        // Add title, text field, and label for marca
        dialog.add(new JLabel("Ingrese la marca del vehiculo:"));
        dialog.add(textFieldMarcaVehiculo);
        dialog.add(warningLabelMarcaVehiculo);

        // Add title, text field, and label for modelo
        dialog.add(new JLabel("Ingrese el modelo del vehiculo:"));
        dialog.add(textFieldModeloVehiculo);
        dialog.add(warningLabelModeloVehiculo);

        // Add title, text field, and label for color
        dialog.add(new JLabel("Ingrese el color del vehiculo:"));
        dialog.add(textFieldColorVehiculo);
        dialog.add(warningLabelColorVehiculo);

        // Add title, text field, and label for tipo transmision
        dialog.add(new JLabel("Ingrese el tipo de transmision del vehiculo:"));
        dialog.add(textFieldTipoTransmisionVehiculo);
        dialog.add(warningLabelTipoTransmisionVehiculo);

        // Add title, text field, and label for codigo sede
        dialog.add(new JLabel("Ingrese el codigo de la sede:"));
        dialog.add(textFieldCodigoSede);
        dialog.add(warningLabelCodigoSede);

        // Create buttons
        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        // Add action listeners to the buttons
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any of the text fields is empty
                if (textFieldCategoriaVehiculo.getText().isEmpty() || textFieldPlacaVehiculo.getText().isEmpty() ||
                    textFieldMarcaVehiculo.getText().isEmpty() || textFieldModeloVehiculo.getText().isEmpty() ||
                    textFieldColorVehiculo.getText().isEmpty() || textFieldTipoTransmisionVehiculo.getText().isEmpty() ||
                    textFieldCodigoSede.getText().isEmpty()) {
                    // Display a warning message near the text fields
                    warningLabelCategoriaVehiculo.setText(textFieldCategoriaVehiculo.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelPlacaVehiculo.setText(textFieldPlacaVehiculo.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelMarcaVehiculo.setText(textFieldMarcaVehiculo.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelModeloVehiculo.setText(textFieldModeloVehiculo.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelColorVehiculo.setText(textFieldColorVehiculo.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelTipoTransmisionVehiculo.setText(textFieldTipoTransmisionVehiculo.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelCodigoSede.setText(textFieldCodigoSede.getText().isEmpty() ? "Llene este espacio!" : " ");
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
        dialog.setSize(700, 700);
        dialog.setVisible(true);

        // Check which button was clicked and return values accordingly
        if (textFieldCategoriaVehiculo.getText().isEmpty() || textFieldPlacaVehiculo.getText().isEmpty() ||
            textFieldMarcaVehiculo.getText().isEmpty() || textFieldModeloVehiculo.getText().isEmpty() ||
            textFieldColorVehiculo.getText().isEmpty() || textFieldTipoTransmisionVehiculo.getText().isEmpty() ||
            textFieldCodigoSede.getText().isEmpty()) {
            return null; // Return null if any of the text fields is empty (Cancel clicked)
        } else {
            // Return values entered in the text fields (Accept clicked)
            return new String[]{textFieldCategoriaVehiculo.getText(), textFieldPlacaVehiculo.getText(), textFieldMarcaVehiculo.getText(),
                    textFieldModeloVehiculo.getText(), textFieldColorVehiculo.getText(), textFieldTipoTransmisionVehiculo.getText(),
                    textFieldCodigoSede.getText()};
        }
    }

    public static String[] dialogEliminarVehiculo(JPanel parent) {
        // Create the JDialog
    	 JDialog dialog = new JDialog();
         dialog.setTitle("Enter Values");
         dialog.setModal(true);
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setLayout(new GridLayout(0, 3, 5, 5)); // Updated GridLayout
         dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(parent));
         

        // Create text fields
        JTextField textFieldPlaca = new JTextField();
        JTextField textFieldCodigoSede = new JTextField();
        

        // Create labels for warnings
        JLabel warningLabelPlaca = new JLabel(" ");
        JLabel warningLabelCodigoSede = new JLabel(" ");
        

        // Add labels and text fields to the dialog
        dialog.add(new JLabel("Ingrese la placa del vehiculo que desea eliminar:"));
        dialog.add(textFieldPlaca);
        dialog.add(warningLabelPlaca);

        dialog.add(new JLabel("Ingrese el codigo de la sede: "));
        dialog.add(textFieldCodigoSede);
        dialog.add(warningLabelCodigoSede);

        

        // Create buttons
        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        // Add action listeners to the buttons
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any of the text fields is empty
                if (textFieldPlaca.getText().isEmpty() || textFieldCodigoSede.getText().isEmpty()) {
                    // Display a warning message near the text fields
                    warningLabelPlaca.setText(textFieldPlaca.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelCodigoSede.setText(textFieldCodigoSede.getText().isEmpty() ? "Llene este espacio!" : " ");
                     
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
        if (textFieldPlaca.getText().isEmpty() || textFieldCodigoSede.getText().isEmpty()) {
            return null; // Return null if any of the text fields is empty (Cancel clicked)
        } else {
            // Return values entered in the text fields (Accept clicked)
            return new String[]{textFieldPlaca.getText(), textFieldCodigoSede.getText()};
        }
    }
    
    public static String[] dialogAñadirNuevaSede(JPanel parent) {
        // Create the JDialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Añadir Nueva Sede");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout(4, 2, 10, 10)); // Updated GridLayout with increased gaps
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(parent));

        // Create text fields
        JTextField textFieldCodigoSede = new JTextField();
        JTextField textFieldUbicacionSede = new JTextField();
        JTextField textFieldHorarioAtencion = new JTextField();

        // Create labels for warnings
        JLabel warningLabelCodigoSede = new JLabel(" ");
        JLabel warningLabelUbicacionSede = new JLabel(" ");
        JLabel warningLabelHorarioAtencion = new JLabel(" ");

        // Add labels and text fields to the dialog
        dialog.add(new JLabel("<html>Ingrese el código de la sede:</html>"));
        dialog.add(textFieldCodigoSede);
        dialog.add(warningLabelCodigoSede);

        dialog.add(new JLabel("<html>Ingrese la ubicación de la sede:</html>"));
        dialog.add(textFieldUbicacionSede);
        dialog.add(warningLabelUbicacionSede);

        dialog.add(new JLabel("<html>Ingrese el horario de atención de la sede:</html>"));
        dialog.add(textFieldHorarioAtencion);
        dialog.add(warningLabelHorarioAtencion);

        // Create buttons
        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        // Add action listeners to the buttons
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any of the text fields is empty
                if (textFieldCodigoSede.getText().isEmpty() || textFieldUbicacionSede.getText().isEmpty() || textFieldHorarioAtencion.getText().isEmpty()) {
                    // Display a warning message near the text fields
                    warningLabelCodigoSede.setText(textFieldCodigoSede.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelUbicacionSede.setText(textFieldUbicacionSede.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelHorarioAtencion.setText(textFieldHorarioAtencion.getText().isEmpty() ? "Llene este espacio!" : " ");
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
        dialog.setSize(400, 200); // Adjusted size
        dialog.setVisible(true);

        // Check which button was clicked and return values accordingly
        if (textFieldCodigoSede.getText().isEmpty() || textFieldUbicacionSede.getText().isEmpty() || textFieldHorarioAtencion.getText().isEmpty()) {
            return null; // Return null if any of the text fields is empty (Cancel clicked)
        } else {
            // Return values entered in the text fields (Accept clicked)
            return new String[]{textFieldCodigoSede.getText(), textFieldUbicacionSede.getText(), textFieldHorarioAtencion.getText()};
        }
    }

    public static String[] dialogEliminarSede(JPanel parent) {
        // Create the JDialog
    	 JDialog dialog = new JDialog();
         dialog.setTitle("Enter Values");
         dialog.setModal(true);
         dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
         dialog.setLayout(new GridLayout(5, 2));
         dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(parent));
         

        // Create text fields
        JTextField textFieldCodigoSede = new JTextField();
        
        

        // Create labels for warnings
        JLabel warningLabelCodigoSede = new JLabel(" ");
       
        

        // Add labels and text fields to the dialog
        dialog.add(new JLabel("Ingrese el codigo de la sede que desea eliminar:"));
        dialog.add(textFieldCodigoSede);
        dialog.add(warningLabelCodigoSede);

        

        

        // Create buttons
        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        // Add action listeners to the buttons
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any of the text fields is empty
                if (textFieldCodigoSede.getText().isEmpty() ) {
                    // Display a warning message near the text fields
                    warningLabelCodigoSede.setText(textFieldCodigoSede.getText().isEmpty() ? "Llene este espacio!" : " ");
                    
                     
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
        if (textFieldCodigoSede.getText().isEmpty() ) {
            return null; // Return null if any of the text fields is empty (Cancel clicked)
        } else {
            // Return values entered in the text fields (Accept clicked)
            return new String[]{textFieldCodigoSede.getText()};
        }
    }
    
    public static String[] dialogModificarSeguros(JPanel parent) {
        // Create the JDialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Modificar Seguros");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout(5, 2, 10, 10)); // Updated GridLayout with increased gaps
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(parent));

        // Create text fields
        JTextField textFieldNombreSeguro = new JTextField();
        JTextField textFieldNuevoNombreSeguro = new JTextField();
        JTextField textFieldTarifaSeguro = new JTextField();

        // Create labels for warnings
        JLabel warningLabelNombreSeguro = new JLabel(" ");
        JLabel warningLabelNuevoNombreSeguro = new JLabel(" ");
        JLabel warningLabelTarifaSeguro = new JLabel(" ");

        // Add labels and text fields to the dialog
        dialog.add(new JLabel("<html>Ingrese el nombre del seguro<br>que desea modificar:</html>"));
        dialog.add(textFieldNombreSeguro);
        dialog.add(warningLabelNombreSeguro);

        dialog.add(new JLabel("<html>Ingrese el nombre del seguro nuevamente o<br>escriba uno nuevo si desea cambiar el nombre:</html>"));
        dialog.add(textFieldNuevoNombreSeguro);
        dialog.add(warningLabelNuevoNombreSeguro);

        dialog.add(new JLabel("<html>Ingrese la nueva tarifa del seguro:</html>"));
        dialog.add(textFieldTarifaSeguro);
        dialog.add(warningLabelTarifaSeguro);

        // Create buttons
        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        // Add action listeners to the buttons
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any of the text fields is empty
                if (textFieldNombreSeguro.getText().isEmpty() || textFieldNuevoNombreSeguro.getText().isEmpty() || textFieldTarifaSeguro.getText().isEmpty()) {
                    // Display a warning message near the text fields
                    warningLabelNombreSeguro.setText(textFieldNombreSeguro.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelNuevoNombreSeguro.setText(textFieldNuevoNombreSeguro.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelTarifaSeguro.setText(textFieldTarifaSeguro.getText().isEmpty() ? "Llene este espacio!" : " ");
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
        dialog.setSize(400, 550); // Adjusted size
        dialog.setVisible(true);

        // Check which button was clicked and return values accordingly
        if (textFieldNombreSeguro.getText().isEmpty() || textFieldNuevoNombreSeguro.getText().isEmpty() || textFieldTarifaSeguro.getText().isEmpty()) {
            return null; // Return null if any of the text fields is empty (Cancel clicked)
        } else {
            // Return values entered in the text fields (Accept clicked)
            return new String[]{textFieldNombreSeguro.getText(), textFieldNuevoNombreSeguro.getText(), textFieldTarifaSeguro.getText()};
        }
    }


    protected void popDialogCrearAdminSede() {
    	
    	//new CrearCuentaDialog(frame);
		
		
	}

	@Override
    public Component getVisualComponent() {
        return this;
    }
}
