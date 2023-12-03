package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import control.Control;
import logica.TipoVehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MEmpleado extends JPanel implements IOpciones {
    private static final long serialVersionUID = 1L;
    private JPanel empleadoPanel;
    private JTextField entregaCode;
    private JTextField rutaImagen;
    private JTextField sedeCode;
    private JTextField entregaCode2;
    private JTable table;

    public MEmpleado(Control control, String username) {
    	
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
        JButton btnSalir = new JButton("Salir del menu");

        // Agregar botones al panel
        empleadoPanel.add(btnMandarMantenimiento);
        empleadoPanel.add(btnCrearCliente);
        empleadoPanel.add(btnIniciarReserva);
        empleadoPanel.add(btnCerrarGuardarReserva);
        empleadoPanel.add(btnGenerarReporte);
        empleadoPanel.add(btnGenerarEntrega);
        empleadoPanel.add(btnAgregarConductorAdicional);
        empleadoPanel.add(btnSalir);

        // Configurar listeners para cada botón
        btnMandarMantenimiento.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            	JButton btnPress = (JButton) e.getSource();
                String coordenada = btnPress.getActionCommand();
                // Lógica para la opción "Mandar Vehículo a Mantenimiento"
                if(coordenada.equals("Mandar Vehículo a Mantenimiento")){
                	
                	String[] res = mandarVehiculoMantenimiento();
                	((logica.Empleado)Control.usuarioActual).mandarMantenimiento(res[0]);
	            	
                }
            }
        });
        
        //ESTO SE VA
        
        btnCrearCliente.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            	JButton btnPress = (JButton)e.getSource();
                String coordenada = btnPress.getActionCommand();
                // Lógica para la opción "Crear Cliente"
                if(coordenada.equals("Crear Cliente")){
                	MCrearCliente menuCrearCli = new MCrearCliente(control);
                	 add(menuCrearCli, BorderLayout.CENTER);
                }
            }
        });

        btnIniciarReserva.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            	JButton btnPress = (JButton)e.getSource();
                String coordenada = btnPress.getActionCommand();
                // Lógica para la opción "Iniciar Reserva"
                if(coordenada.equals("Iniciar Reserva")){
                	
                	String[] res = IniciarReserva(); //res[1 es tipo de vehiculo
                	
                	if (res!=null) {                		
                		TipoVehiculo tipo = null;
                        switch (res[7]) {
                            case "Automóvil":
                                tipo = TipoVehiculo.AUTOMOVIL;
                                break;
                            case "Moto":
                                tipo = TipoVehiculo.MOTO;
                                break;
                            case "ATV":
                                tipo = TipoVehiculo.ATV;
                                break;
                            case "Bicicleta":
                                tipo = TipoVehiculo.BICICLETA;
                                break;
                            case "Bicicleta Eléctrica":
                                tipo = TipoVehiculo.BICICLETA_ELECTRICA;
                                break;
                            case "Patineta Eléctrica":
                                tipo = TipoVehiculo.PATINETA_ELECTRICA;
                                break;
                        }
                	
                    	((logica.Empleado)Control.usuarioActual).iniciarReserva(tipo, res[0], res[1],res[2], res[3], res[4], res[5], Integer.parseInt(res[6]));
                }
                }
            }
        });

        btnCerrarGuardarReserva.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            	JButton btnPress = (JButton)e.getSource();
                String coordenada = btnPress.getActionCommand();
                // Lógica para la opción "Cerrar y Guardar Reserva"
                if(coordenada.equals("Cerrar y Guardar Reserva")){
                	control.cerrarGuardarReserva(username);
                }
            }
        });

        btnGenerarReporte.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            	JButton btnPress = (JButton)e.getSource();
                String coordenada = btnPress.getActionCommand();
                // Lógica para la opción "Generar Reporte de Vehículos en Mantenimiento"
                if(coordenada.equals("Generar Reporte de Vehículos en Mantenimiento")){
                	List<List<String>> resp = control.reporteCarrosMantenimiento(username);
                	List<String> columnNames = List.of("Placa", "Marca", "Modelo", "Categoría");
                	ListaPanelReporte(resp, columnNames);
                }
            }
        });

        btnGenerarEntrega.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            	JButton btnPress = (JButton)e.getSource();
                String coordenada = btnPress.getActionCommand();
                // Lógica para la opción "Generar Entrega"
                if(coordenada.equals("Generar Entrega")){
	            	add(new JLabel("Ingrese el código de reserva:"));
	                entregaCode = new JTextField();
	                add(entregaCode);
	                String code = entregaCode.getText();
	                control.generarEntrega(code, username);
                }
            }
        });

        btnAgregarConductorAdicional.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            	JButton btnPress = (JButton)e.getSource();
                String coordenada = btnPress.getActionCommand();
                // Lógica para la opción "Añadir Conductor Adicional"
                if(coordenada.equals("Añadir Conductor Adicional")){
	            	add(new JLabel("Ingrese la ruta de la imagen:"));
	                rutaImagen = new JTextField();
	                add(rutaImagen);
	                String imagen = rutaImagen.getText();
	                add(new JLabel("Ingrese el código de la sede donde se realizó la reserva:"));
	                sedeCode = new JTextField();
	                add(sedeCode);
	                String code = sedeCode.getText();
	                add(new JLabel("Ingrese el código de reserva:"));
	                entregaCode2 = new JTextField();
	                add(entregaCode2);
	                String code2 = entregaCode2.getText();
	                control.addConductorAdicional(imagen, code, code2, username);
	                }
            }
        });
        btnSalir.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Salir"
            }
        });

        add(empleadoPanel, BorderLayout.CENTER);
    }
    
	public void ListaPanelReporte(List<List<String>> data, List<String> columnNames) {
        setLayout(new BorderLayout());
        
        String[] columnArray = new String[columnNames.size()];
        columnNames.toArray(columnArray);

        // Crea un modelo de tabla
        DefaultTableModel model = new DefaultTableModel(columnArray, 0);

        // Agrega filas al modelo de la tabla
        for (List<String> row : data) {
            model.addRow(row.toArray());
        }
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        // Agrega el JScrollPane al panel
        add(scrollPane, BorderLayout.CENTER);
    }
    
	protected String[] mandarVehiculoMantenimiento() {
    	String[] res = dialogVehiculoMantenimiento(this);
    	return res;
	}
	
    public static String[] dialogVehiculoMantenimiento(JPanel parent) {
        // Create the JDialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Añadir Vehiculo Mantenimiento");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout(4, 2, 10, 10)); // Updated GridLayout with increased gaps
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(parent));
        
        JLabel warningLabelMantenimiento = new JLabel(" ");
        dialog.add(warningLabelMantenimiento);
     
        JTextField placaField;
        dialog.add(new JLabel("Ingrese la placa del vehículo:"));
        placaField = new JTextField();
        dialog.add(placaField);        

        // Create buttons
        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        // Add action listeners to the buttons
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any of the text fields is empty
                if (placaField.getText().isEmpty()) {
                    // Display a warning message near the text fields
                    warningLabelMantenimiento.setText(placaField.getText().isEmpty() ? "Llene este espacio!" : " ");
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
        if (placaField.getText().isEmpty()) {
            return null; // Return null if any of the text fields is empty (Cancel clicked)
        } else {
            // Return values entered in the text fields (Accept clicked)
            return new String[]{placaField.getText()};
        }
    }
    
    protected String[] IniciarReserva() {
    	String[] res = dialogIniciarReserva(this);
    	return res;
	}
    
    public static String[] dialogIniciarReserva(JPanel parent) {
        // Crear el JDialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Iniciar Reserva");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout(19, 2, 15, 5)); // 19 filas para 19 parámetros
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(parent));
        
        dialog.add(new JLabel("Seleccione el tipo de vehículo:"));
        String[] tiposVehiculo = {"Automóvil", "Moto", "ATV", "Bicicleta", "Bicicleta Eléctrica", "Patineta Eléctrica"};
        JComboBox<String> tipoVehiculoComboBox = new JComboBox<>(tiposVehiculo);
        dialog.add(tipoVehiculoComboBox);

        JTextField sedeRecogidaField = new JTextField();
        dialog.add(new JLabel("Sede de Recogida:"));
        dialog.add(sedeRecogidaField);

        JTextField sedeEntregaField = new JTextField();
        dialog.add(new JLabel("Sede de Entrega:"));
        dialog.add(sedeEntregaField);

        JTextField fechaHoraRecogidaField = new JTextField();
        dialog.add(new JLabel("Fecha y Hora de Recogida:"));
        dialog.add(fechaHoraRecogidaField);

        JTextField fechaHoraEntregaField = new JTextField();
        dialog.add(new JLabel("Fecha y Hora de Entrega:"));
        dialog.add(fechaHoraEntregaField);

        JTextField usernameClienteField = new JTextField();
        dialog.add(new JLabel("Nombre de Usuario del Cliente:"));
        dialog.add(usernameClienteField);

        JTextField rutaImagenConductorAdicionesField = new JTextField();
        dialog.add(new JLabel("Ruta Imagen Conductor Adicional:"));
        dialog.add(rutaImagenConductorAdicionesField);   

        JTextField duracionPorDiaField = new JTextField();
        dialog.add(new JLabel("Duración por Día:"));
        dialog.add(duracionPorDiaField);
        
        JLabel warningLabel = new JLabel(" ");
        dialog.add(warningLabel);
        
        JLabel warningLabel2 = new JLabel(" ");
        dialog.add(warningLabel2);

        // Crear botones
        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        // Agregar ActionListener a los botones
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dialog.dispose();	
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Cerrar el diálogo
            }
        });

        // Agregar botones al diálogo
        dialog.add(acceptButton);
        dialog.add(cancelButton);

        // Establecer tamaño y hacer visible el diálogo
        dialog.setSize(600, 600); // Ajusta el tamaño según tus necesidades
        dialog.setVisible(true);

        // Retornar valores ingresados en los campos de texto
        if ( sedeRecogidaField.getText().isEmpty() || sedeEntregaField.getText().isEmpty() || 
             fechaHoraRecogidaField.getText().isEmpty() || 
            fechaHoraEntregaField.getText().isEmpty() ||
            usernameClienteField.getText().isEmpty() || rutaImagenConductorAdicionesField.getText().isEmpty() || 
            duracionPorDiaField.getText().isEmpty()) {
        	
        	
            return null; // Retornar null si algún campo está vacío (cancelado)
            
            
            
        } else {
            // Retornar valores ingresados en los campos de texto (aceptado)
            return new String[]{
                sedeRecogidaField.getText(),
                sedeEntregaField.getText(),
                fechaHoraRecogidaField.getText(),
                fechaHoraEntregaField.getText(),
                usernameClienteField.getText(),
                rutaImagenConductorAdicionesField.getText(),
                duracionPorDiaField.getText(),
                (String) tipoVehiculoComboBox.getSelectedItem()
            };
        }
    }
    
    public Component getVisualComponent() {
        return this;
    }
}
