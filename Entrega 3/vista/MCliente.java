package vista;

import javax.swing.*;

import control.Control;
import logica.Entrega;
import logica.TipoVehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MCliente extends JPanel implements IOpciones {
	private static final long serialVersionUID = 1L;
	private JPanel clientePanel;

	private int numeroTarjeta;
	
	private TipoVehiculo tipoVehiculo;

	public MCliente(Control control, String username) {

		numeroTarjeta = 0;
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
				if (coordenada.equals("Iniciar Reserva")) {

					String[] res = IniciarReserva(); // res[1 es tipo de vehiculo

					if (res != null) {
						MCliente.this.tipoVehiculo = null;
						switch (res[8]) {
						case "Automóvil":
							MCliente.this.tipoVehiculo = TipoVehiculo.AUTOMOVIL;
							break;
						case "Moto":
							MCliente.this.tipoVehiculo = TipoVehiculo.MOTO;
							break;
						case "ATV":
							MCliente.this.tipoVehiculo = TipoVehiculo.ATV;
							break;
						case "Bicicleta":
							MCliente.this.tipoVehiculo= TipoVehiculo.BICICLETA;
							break;
						case "Bicicleta Eléctrica":
							MCliente.this.tipoVehiculo = TipoVehiculo.BICICLETA_ELECTRICA;
							break;
						case "Patineta Eléctrica":
							MCliente.this.tipoVehiculo = TipoVehiculo.PATINETA_ELECTRICA;
							break;
						}

						
					}

					((logica.Cliente) Control.usuarioActual).iniciarReserva(tipoVehiculo, res[0], res[1], res[2], res[3],
							res[4], res[5], res[6], Integer.parseInt(res[7]),Entrega.ESPERANDOASERENTREGADOACLIENTE);

					MCliente.this.numeroTarjeta = Integer.parseInt(res[11]);
					String filePath = "data/metodos de pago.txt";
					ArrayList<String> lines = readLinesFromFile(filePath);

					JDialog dialog = new JDialog();
					dialog.setTitle("Metodos de pago");
					dialog.setModal(true);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLayout(new GridLayout(19, 2, 15, 5)); // 19 filas para 19 parámetros

					// Check if lines are successfully read
					if (lines != null) {
						// Print the lines read from the file
						for (String line : lines) {
							CargaDinamica carga = new CargaDinamica(line, ((logica.Cliente) Control.usuarioActual),
									((logica.Cliente) Control.usuarioActual).getPrecioFinal(),
									Integer.parseInt(res[11]),
									((logica.Cliente) Control.usuarioActual).getNumeroTransaccion());
							String nombreClase = carga.pagos.nombre;
							if (nombreClase != null) {
								JButton botonNuevo = new JButton(nombreClase);
								botonNuevo.addActionListener(botonesListener);
								dialog.add(botonNuevo);

							}
						}
					} else {
						System.out.println("An error occurred while reading the file.");
					}

				}
			}

			ActionListener botonesListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton botonPresionado = (JButton) e.getSource();
					String coordenada = botonPresionado.getActionCommand();

					if (coordenada.equals("PayU")) {
						CargaDinamica carga = new CargaDinamica("MPayU.java", ((logica.Cliente) Control.usuarioActual),
								((logica.Cliente) Control.usuarioActual).getPrecioFinal(), MCliente.this.numeroTarjeta,
								((logica.Cliente) Control.usuarioActual).getNumeroTransaccion());
						carga.pagos.realizarPago();
						;

					}

				}
			};
		});

		btnCerrarGuardarReserva.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Lógica para la opción "Cerrar y Guardar Reserva"
				JButton btnPress = (JButton) e.getSource();
				String coordenada = btnPress.getActionCommand();
				if (coordenada.equals("Cerrar y Guardar Reserva")) {
					control.getCerrarSesion(username);
				}
			}
		});
		btnVerMetodoPago.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Lógica para la opción "Ver Metodo de Pago"
				JButton btnPress = (JButton) e.getSource();
				String coordenada = btnPress.getActionCommand();
				if (coordenada.equals("Ver Método de Pago")) {
					control.getMetodoDePago(username);
				}
			}
		});
		btnSalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Lógica para la opción "Salir"
				JButton btnPress = (JButton) e.getSource();
				String coordenada = btnPress.getActionCommand();
				if (coordenada.equals("Salir")) {

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

		dialog.add(new JLabel("Seleccione el tipo de vehículo:"));
		String[] tiposVehiculo = { "Automóvil", "Moto", "ATV", "Bicicleta", "Bicicleta Eléctrica",
				"Patineta Eléctrica" };
		JComboBox<String> tipoVehiculoComboBox = new JComboBox<>(tiposVehiculo);
		dialog.add(tipoVehiculoComboBox);

		JTextField sedeRecogidaField = new JTextField();
		dialog.add(new JLabel("Sede de Recogida:"));
		dialog.add(sedeRecogidaField);

		JTextField sedeEntregaField = new JTextField();
		dialog.add(new JLabel("Sede de Entrega:"));
		dialog.add(sedeEntregaField);

		JTextField nuevaSedeEntregaField = new JTextField();
		dialog.add(new JLabel("Duración por Día:"));
		dialog.add(nuevaSedeEntregaField);
		
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
		
		JTextField cantidadConductoresAdiccionales = new JTextField();
		dialog.add(new JLabel("Ruta Imagen Conductor Adicional:"));
		dialog.add(cantidadConductoresAdiccionales );


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
		if (sedeRecogidaField.getText().isEmpty() || sedeEntregaField.getText().isEmpty() ||nuevaSedeEntregaField.getText().isEmpty()
				|| fechaHoraRecogidaField.getText().isEmpty() || fechaHoraEntregaField.getText().isEmpty()
				|| usernameClienteField.getText().isEmpty() || rutaImagenConductorAdicionesField.getText().isEmpty()
				|| cantidadConductoresAdiccionales.getText().isEmpty()) {

			return null; // Retornar null si algún campo está vacío (cancelado)

		} else {
			// Retornar valores ingresados en los campos de texto (aceptado)
			return new String[] { 
					sedeRecogidaField.getText(), //0
					
					sedeEntregaField.getText(),//1
					
					nuevaSedeEntregaField.getText(),//2
					
					fechaHoraRecogidaField.getText(), //3
					
					fechaHoraEntregaField.getText(), //4
					
					usernameClienteField.getText(),//5
					
					rutaImagenConductorAdicionesField.getText(), //6
					
					cantidadConductoresAdiccionales.getText(),//7
					
					(String) tipoVehiculoComboBox.getSelectedItem() };//8
		}
	}

	
	

	

	public static ArrayList<String> readLinesFromFile(String filePath) {
		Path path = Paths.get(filePath);

		try {
			// Read all lines from the file into an ArrayList of Strings
			return new ArrayList<>(Files.readAllLines(path));
		} catch (IOException e) {
			// Handle the case where an exception occurs during file reading
			e.printStackTrace();
			return null; // Or handle the error as needed
		}
	}

	@Override
	public Component getVisualComponent() {
		// TODO Auto-generated method stub
		return this;
	}
}

