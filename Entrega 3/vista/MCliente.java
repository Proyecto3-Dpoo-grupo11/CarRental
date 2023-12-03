package vista;

import javax.swing.*;

import control.Control;
import logica.Entrega;
import logica.Roles;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MCliente extends JPanel implements IOpciones {
    private static final long serialVersionUID = 1L;
    private JPanel clientePanel;

    public MCliente(Control control, String username) {
    	
    	
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
             
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Iniciar Reserva"
            	JButton btnPress = (JButton) e.getSource();
                String coordenada = btnPress.getActionCommand();
                if(coordenada.equals("Iniciar Reserva")){
                	String[] res = IniciarReserva();
                	
                	((logica.Cliente)Control.usuarioActual).iniciarReserva(res[0],res[1], res[2],res[3], res[4], res[5], res[6], res[7], res[8], res[9],Integer.parseInt( res[11]));
                	((logica.Cliente)Control.usuarioActual).getPrecioFinal();
                }
            }
        });
        btnCerrarGuardarReserva.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Cerrar y Guardar Reserva"
            	JButton btnPress = (JButton) e.getSource();
                String coordenada = btnPress.getActionCommand();
                if(coordenada.equals("Cerrar y Guardar Reserva")){
                	control.getCerrarSesion(username);
                }
            }
        });
        btnVerMetodoPago.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
            	// Lógica para la opción "Ver Metodo de Pago"
            	JButton btnPress = (JButton) e.getSource();
                String coordenada = btnPress.getActionCommand();
                if(coordenada.equals("Ver Método de Pago")){
                	control.getMetodoDePago(username);
                }
            }
        });
        btnSalir.addActionListener(new ActionListener() {
             
            public void actionPerformed(ActionEvent e) {
                // Lógica para la opción "Salir"
            	JButton btnPress = (JButton) e.getSource();
                String coordenada = btnPress.getActionCommand();
                if(coordenada.equals("Salir")){
                	
                }
            }
        });

        add(clientePanel, BorderLayout.CENTER);
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
     
        JTextField codigoReservaField = new JTextField();
        dialog.add(new JLabel("Código de Reserva:"));
        dialog.add(codigoReservaField);

        JTextField tipoDeCarroField = new JTextField();
        dialog.add(new JLabel("Tipo de Carro:"));
        dialog.add(tipoDeCarroField);

        JTextField sedeRecogidaField = new JTextField();
        dialog.add(new JLabel("Sede de Recogida:"));
        dialog.add(sedeRecogidaField);

        JTextField sedeEntregaField = new JTextField();
        dialog.add(new JLabel("Sede de Entrega:"));
        dialog.add(sedeEntregaField);

        JTextField nuevaSedeEntregaField = new JTextField();
        dialog.add(new JLabel("Nueva Sede de Entrega:"));
        dialog.add(nuevaSedeEntregaField);

        JTextField fechaHoraRecogidaField = new JTextField();
        dialog.add(new JLabel("Fecha y Hora de Recogida:"));
        dialog.add(fechaHoraRecogidaField);

        JTextField fechaHoraEntregaField = new JTextField();
        dialog.add(new JLabel("Fecha y Hora de Entrega:"));
        dialog.add(fechaHoraEntregaField);

        JTextField placaVehiculoField = new JTextField();
        dialog.add(new JLabel("Placa del Vehículo:"));
        dialog.add(placaVehiculoField);

        JTextField usernameClienteField = new JTextField();
        dialog.add(new JLabel("Nombre de Usuario del Cliente:"));
        dialog.add(usernameClienteField);

        JTextField rutaImagenConductorAdicionesField = new JTextField();
        dialog.add(new JLabel("Ruta Imagen Conductor Adicional:"));
        dialog.add(rutaImagenConductorAdicionesField);

        JTextField calculoPrecioFinalField = new JTextField();
        dialog.add(new JLabel("Cálculo del Precio Final:"));
        dialog.add(calculoPrecioFinalField);

        JTextField cantidadConductoresAdicionalesField = new JTextField();
        dialog.add(new JLabel("Cantidad de Conductores Adicionales:"));
        dialog.add(cantidadConductoresAdicionalesField);

        JTextField duracionPorDiaField = new JTextField();
        dialog.add(new JLabel("Duración por Día:"));
        dialog.add(duracionPorDiaField);

        JTextField textoFacturaField = new JTextField();
        dialog.add(new JLabel("Texto de la Factura:"));
        dialog.add(textoFacturaField);
        
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
        if (codigoReservaField.getText().isEmpty() || tipoDeCarroField.getText().isEmpty() || 
            sedeRecogidaField.getText().isEmpty() || sedeEntregaField.getText().isEmpty() || 
            nuevaSedeEntregaField.getText().isEmpty() || fechaHoraRecogidaField.getText().isEmpty() || 
            fechaHoraEntregaField.getText().isEmpty() || placaVehiculoField.getText().isEmpty() || 
            usernameClienteField.getText().isEmpty() || rutaImagenConductorAdicionesField.getText().isEmpty() || 
            calculoPrecioFinalField.getText().isEmpty() || cantidadConductoresAdicionalesField.getText().isEmpty() || 
            duracionPorDiaField.getText().isEmpty() || textoFacturaField.getText().isEmpty()) {
        	
        	
            return null; // Retornar null si algún campo está vacío (cancelado)
            
            
            
        } else {
            // Retornar valores ingresados en los campos de texto (aceptado)
            return new String[]{
                codigoReservaField.getText(),//0
                tipoDeCarroField.getText(),//1
                sedeRecogidaField.getText(),//2
                sedeEntregaField.getText(),//3
                nuevaSedeEntregaField.getText(),//4
                fechaHoraRecogidaField.getText(),//5
                fechaHoraEntregaField.getText(),//6
                placaVehiculoField.getText(),//7
                usernameClienteField.getText(),//8
                rutaImagenConductorAdicionesField.getText(),//9
                calculoPrecioFinalField.getText(),//10
                cantidadConductoresAdicionalesField.getText(),//11
                duracionPorDiaField.getText(),//12
                textoFacturaField.getText()//13
            };
        }
    }
     
    public Component getVisualComponent() {
        return this;
    }
}
