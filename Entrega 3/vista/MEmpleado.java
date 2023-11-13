package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import control.Control;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MEmpleado extends JPanel implements IOpciones {
    private static final long serialVersionUID = 1L;
    private JPanel empleadoPanel;
    private JTextField placaField;
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
	            	add(new JLabel("Ingrese la placa del vehículo:"));
	                placaField = new JTextField();
	                add(placaField);
	                String placaMan = placaField.getText();
	                control.mandarMantenimiento(placaMan, username);
                }
            }
        });
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
    public Component getVisualComponent() {
        return this;
    }
}
