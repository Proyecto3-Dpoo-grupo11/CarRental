package vista;

import javax.swing.*;

import control.Control;
import logica.EmpresaAlquiler;
import logica.Entrega;
import logica.Sede;
import logica.TipoVehiculo;
import logica.Vehiculo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.NumericShaper;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MCliente extends JPanel implements IOpciones {
	private static final long serialVersionUID = 1L;
	private JPanel clientePanel;

	private int numeroTarjeta;

	private TipoVehiculo tipoVehiculo;
	public String[] respuestas;
	public String recibo="";
	public JButton botonReserva;
	public boolean descuento=false;
	

	public MCliente(Control control, String username) {

		numeroTarjeta = 0;
		setLayout(new BorderLayout());

		clientePanel = new JPanel();
		clientePanel.setLayout(new GridLayout(4, 1, 5, 5));

		// Crear botones para cada opción
		JButton btnIniciarReserva = new JButton("Iniciar Reserva");
		JButton btnDisponibilad = new JButton("Ver Disponibilidad de vehiculos");
		JButton btnCerrarGuardarReserva = new JButton("Cerrar y Guardar Reserva");
		JButton btnVerMetodoPago = new JButton("Ver Método de Pago");
		JButton btnSalir = new JButton("Salir");

		// Agregar botones al panel
		clientePanel.add(btnIniciarReserva);
		clientePanel.add(btnDisponibilad);
		clientePanel.add(btnCerrarGuardarReserva);
		clientePanel.add(btnVerMetodoPago);
		clientePanel.add(btnSalir);
		
		this.botonReserva=btnIniciarReserva;

		// Configurar listeners para cada botón
		btnIniciarReserva.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Lógica para la opción "Iniciar Reserva"
				JButton btnPress = (JButton) e.getSource();
				String coordenada = btnPress.getActionCommand();
				if (coordenada.equals("Iniciar Reserva")) {
					
					String[] res = IniciarReserva();
					MCliente.this.respuestas = res;// res[1 es tipo de vehiculo

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
							MCliente.this.tipoVehiculo = TipoVehiculo.BICICLETA;
							break;
						case "Bicicleta Eléctrica":
							MCliente.this.tipoVehiculo = TipoVehiculo.BICICLETA_ELECTRICA;
							break;
						case "Patineta Eléctrica":
							MCliente.this.tipoVehiculo = TipoVehiculo.PATINETA_ELECTRICA;
							break;
						}	

					
						
					MCliente.this.recibo=((logica.Cliente) Control.usuarioActual).iniciarReserva(tipoVehiculo, res[0], res[1], res[2],
							res[3], res[4], res[5], res[6], Integer.parseInt(res[7]),
							Entrega.ESPERANDOASERENTREGADOACLIENTE, control.getEmpresa().BuscarSede(res[0]),descuento);}

					
					String filePath = "data/metodosDePago.txt";
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

							// Find the index of "vista.M"
							int startIndex = line.indexOf("vista.M");

							// Extract everything after "vista.M"
							String result = (startIndex != -1) ? line.substring(startIndex + "vista.M".length()) : line;

							if (result != null) {
								JButton botonNuevo = new JButton(result);
								botonNuevo.addActionListener(botonesListener);
								dialog.add(botonNuevo);

							}
						}
					} else {
						System.out.println("An error occurred while reading the file.");
					}
					dialog.setSize(600, 600); // Ajusta el tamaño según tus necesidades
					dialog.setVisible(true);

				}
			}

			ActionListener botonesListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton botonPresionado = (JButton) e.getSource();
					String coordenada = botonPresionado.getActionCommand();
					String filePath = "data/metodosDePago.txt";
					ArrayList<String> lines = readLinesFromFile(filePath);
					if (lines != null) {
						// Print the lines read from the file

						if (coordenada.equals("PayU")) {
							CargaDinamica carga = new CargaDinamica("vista.MPayU",
									((logica.Cliente) Control.usuarioActual),
									((logica.Cliente) Control.usuarioActual).
									getPrecioFinal(),
									
									((logica.Cliente) Control.usuarioActual).
									getNumeroTransaccion(),MCliente.this.recibo);
							carga.pagos.realizarPago();
							;

						}

						if (coordenada.equals("PayPal")) {
							CargaDinamica carga = new CargaDinamica("vista.MPayPal",
									((logica.Cliente) Control.usuarioActual),
									((logica.Cliente) Control.usuarioActual).
									getPrecioFinal(),
									
									((logica.Cliente) Control.usuarioActual)
									.getNumeroTransaccion(),MCliente.this.recibo);
							carga.pagos.realizarPago();
							;

						}

					} else {
						System.out.println("An error occurred while reading the file.");
					}

				}
			};
		});
		
		btnDisponibilad.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// Lógica para la opción "Cerrar y Guardar Reserva"
				JButton btnPress = (JButton) e.getSource();
				String coordenada = btnPress.getActionCommand();
				if (coordenada.equals("Ver Disponibilidad de vehiculos")) {
					
					
					
					String[] res=dialogBuscarDisponiblidad(clientePanel);
					
					
					java.util.List<Vehiculo> vehiculos = control.getEmpresa().BuscarSede(res[0])
					        .getAvailableVehiclesBetweenDates(LocalDate.parse(res[1], DateTimeFormatter.ofPattern("yyyy/MM/dd")),
					                                           LocalDate.parse(res[2], DateTimeFormatter.ofPattern("yyyy/MM/dd")));
					
					JDialog dialog = new JDialog();
			        dialog.setTitle("Metodos de pago");
			        dialog.setModal(true);
			        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			        dialog.setLayout(new GridLayout(19, 2, 15, 5)); // 19 filas para 19 parámetros

			        JLabel labelDisponibilidad = new JLabel(" ");
			        dialog.add(labelDisponibilidad);

			        JTextArea textAreaVehiculos = new JTextArea(20, 40); // Set rows and columns
			        textAreaVehiculos.setEditable(false); // Make it non-editable
			        JScrollPane scrollPane = new JScrollPane(textAreaVehiculos);
			        dialog.add(scrollPane);
			        if (vehiculos == null) {
			            labelDisponibilidad.setText("No hay vehiculos disponibles");
			        } else {
			            String infoVehiculo = " ";
			            for (Vehiculo vehiculoActual : vehiculos) {
			                infoVehiculo += " " + "Marca: " + vehiculoActual.marca + " Modelo: " + vehiculoActual.marca + " Tipo: " + vehiculoActual.getTipoVehiculo().name() + "\n";
			            }
			            labelDisponibilidad.setText("Estos son los vehículos disponibles: ");
			            textAreaVehiculos.setText(infoVehiculo); // Set the text in JTextArea
			            dialog.add(botonReserva);
			            MCliente.this.descuento = true;
			        }
					
					

					
					
			        dialog.setSize(800, 800); // Ajusta el tamaño según tus necesidades
			        dialog.setVisible(true);	
				}
			}
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
		dialog.add(new JLabel("Nueva Sede De entrega:"));
		dialog.add(nuevaSedeEntregaField);

		JTextField fechaHoraRecogidaField = new JTextField();
		dialog.add(new JLabel("Fecha y Hora de Recogida:"));
		dialog.add(fechaHoraRecogidaField);

		JLabel warningLabelFRecogida = new JLabel(" ");
		dialog.add(warningLabelFRecogida);

		JTextField fechaHoraEntregaField = new JTextField();
		dialog.add(new JLabel("Fecha y Hora de Entrega:"));
		dialog.add(fechaHoraEntregaField);

		JLabel warningLabelFEntrega = new JLabel(" ");
		dialog.add(warningLabelFEntrega);

		JTextField usernameClienteField = new JTextField();
		dialog.add(new JLabel("Nombre de Usuario del Cliente:"));
		dialog.add(usernameClienteField);

		JTextField rutaImagenConductorAdicionesField = new JTextField();
		dialog.add(new JLabel("Ruta Imagen Conductor Adicional:"));
		dialog.add(rutaImagenConductorAdicionesField);

		JTextField cantidadConductoresAdiccionales = new JTextField();
		dialog.add(new JLabel("Cantidad Conductores adicionales:"));
		dialog.add(cantidadConductoresAdiccionales);

	

		// Crear botones
		JButton acceptButton = new JButton("Aceptar");
		JButton cancelButton = new JButton("Cancelar");

		// Agregar ActionListener a los botones
		acceptButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
				if (fechaHoraRecogidaField.getText().isEmpty() || fechaHoraEntregaField.getText().isEmpty()) {
					// Display a warning message near the text fields
					warningLabelFEntrega
							.setText(fechaHoraEntregaField.getText().isEmpty() ? "Llene este espacio!" : " ");
					warningLabelFRecogida
							.setText(fechaHoraRecogidaField.getText().isEmpty() ? "Llene este espacio!" : " ");

				}
				String[] partesRecogida = fechaHoraRecogidaField.getText().split("/");
				String[] partesEntrega = fechaHoraEntregaField.getText().split("/");
				if (partesEntrega.length == 3 || partesRecogida.length == 3) {
					if (Integer.parseInt(partesEntrega[2]) < 30 || Integer.parseInt(partesEntrega[2]) == 0
					// Para Meses
							|| Integer.parseInt(partesEntrega[1]) < 12 || Integer.parseInt(partesEntrega[1]) == 0

							|| Integer.parseInt(partesRecogida[2]) < 30 || Integer.parseInt(partesRecogida[2]) == 0
							|| Integer.parseInt(partesRecogida[1]) < 12 || Integer.parseInt(partesRecogida[1]) == 0
							|| ((Integer.parseInt(partesRecogida[2]) + Integer.parseInt(partesRecogida[1])
									+ Integer.parseInt(partesRecogida[0])) < (Integer.parseInt(partesEntrega[2])
											+ Integer.parseInt(partesEntrega[1])
											+ Integer.parseInt(partesEntrega[0])))) {

						// Display a warning message near the text fields
						warningLabelFRecogida
								.setText((partesRecogida.length < 3) ? "Ingrese una fecha valida (YY/MM/DD)" : " ");
						warningLabelFEntrega
								.setText((partesEntrega.length < 3) ? "Ingrese una fecha valida (YY/MM/DD)" : " ");

						warningLabelFRecogida.setText(
								(Integer.parseInt(partesRecogida[1]) > 12 || Integer.parseInt(partesRecogida[1]) == 0)
										? "Ingrese un mes valido"
										: " ");
						warningLabelFRecogida.setText(
								(Integer.parseInt(partesRecogida[2]) > 30 || Integer.parseInt(partesRecogida[2]) == 0)
										? "Ingrese un dia valido"
										: " ");

						warningLabelFEntrega.setText(
								(Integer.parseInt(partesEntrega[2]) > 30 || Integer.parseInt(partesEntrega[2]) == 0)
										? "Ingrese un dia valido"
										: " ");
						warningLabelFEntrega.setText(
								(Integer.parseInt(partesEntrega[1]) > 12 || Integer.parseInt(partesEntrega[1]) == 0)
										? "Ingrese un mes valido"
										: " ");
						warningLabelFEntrega.setText(
								((Integer.parseInt(partesRecogida[2]) + Integer.parseInt(partesRecogida[1])
								+ Integer.parseInt(partesRecogida[0])) > (Integer.parseInt(partesEntrega[2])
										+ Integer.parseInt(partesEntrega[1])
										+ Integer.parseInt(partesEntrega[0])))
										? "Ingrese un mes valido"
										: " ");
						warningLabelFRecogida.setText(
								((Integer.parseInt(partesRecogida[2]) + Integer.parseInt(partesRecogida[1])
								+ Integer.parseInt(partesRecogida[0])) > (Integer.parseInt(partesEntrega[2])
										+ Integer.parseInt(partesEntrega[1])
										+ Integer.parseInt(partesEntrega[0])))
										? "Ingrese un mes valido"
										: " ");
					}

				} else {
					// Close the dialog if all text fields are filled
					dialog.dispose();
				}
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

		String[] partesRecogida = fechaHoraRecogidaField.getText().split("/");
		String[] partesEntrega = fechaHoraEntregaField.getText().split("/");
		// Retornar valores ingresados en los campos de texto
		if (sedeRecogidaField.getText().isEmpty() || sedeEntregaField.getText().isEmpty()
				|| nuevaSedeEntregaField.getText().isEmpty() || fechaHoraRecogidaField.getText().isEmpty()
				|| partesRecogida.length > 3 || fechaHoraEntregaField.getText().isEmpty() || partesEntrega.length < 3
				|| usernameClienteField.getText().isEmpty() || rutaImagenConductorAdicionesField.getText().isEmpty()
				|| cantidadConductoresAdiccionales.getText().isEmpty() || 
				 Integer.parseInt(partesRecogida[1]) > 12 || Integer.parseInt(partesRecogida[1])==0 
				||Integer.parseInt(partesRecogida[2]) > 30 || Integer.parseInt(partesRecogida[2]) == 0 
				||Integer.parseInt(partesEntrega[2]) > 30 || Integer.parseInt(partesEntrega[2]) == 0
				||Integer.parseInt(partesEntrega[1]) > 12 || Integer.parseInt(partesEntrega[1]) == 0
				||(Integer.parseInt(partesRecogida[2]) + Integer.parseInt(partesRecogida[1])
				+ Integer.parseInt(partesRecogida[0])) > (Integer.parseInt(partesEntrega[2])
						+ Integer.parseInt(partesEntrega[1])
						+ Integer.parseInt(partesEntrega[0]))
				
				) {

			return null; // Retornar null si algún campo está vacío (cancelado)

		} else {
			// Retornar valores ingresados en los campos de texto (aceptado)
			return new String[] { sedeRecogidaField.getText(), // 0

					sedeEntregaField.getText(), // 1

					nuevaSedeEntregaField.getText(), // 2

					fechaHoraRecogidaField.getText(), // 3

					fechaHoraEntregaField.getText(), // 4

					usernameClienteField.getText(), // 5

					rutaImagenConductorAdicionesField.getText(), // 6

					cantidadConductoresAdiccionales.getText(), // 7

					(String) tipoVehiculoComboBox.getSelectedItem(), // 8
					 };
		}
	}
	public static String[] dialogBuscarDisponiblidad(JPanel parent) {
        // Create the JDialog
        JDialog dialog = new JDialog();
        dialog.setTitle("Enter Values");
        dialog.setModal(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setLayout(new GridLayout(4, 2));
        dialog.setLocationRelativeTo(SwingUtilities.getWindowAncestor(parent));

        // Create text fields
        JTextField textFieldSede = new JTextField();
        JTextField textFieldFechaRecogida = new JTextField();
        JTextField textFieldFechaEntrega = new JTextField();

        // Create labels for warnings
        JLabel warningLabelUsuario = new JLabel(" ");
        JLabel warningLabelContraseña = new JLabel(" ");
        JLabel warningLabelCodigoSede = new JLabel(" ");

        // Add labels and text fields to the dialog
        dialog.add(new JLabel("Ingrese la sede sobre la cual desea ver la disponibilidad:"));
        dialog.add(textFieldSede);
        dialog.add(warningLabelUsuario);

        dialog.add(new JLabel("Fecha de recogida"));
        dialog.add(textFieldFechaRecogida);
        dialog.add(warningLabelContraseña);

        dialog.add(new JLabel("Fecha de entrega"));
        dialog.add(textFieldFechaEntrega);
        dialog.add(warningLabelCodigoSede);

        // Set preferred size for text fields
        textFieldSede.setPreferredSize(new Dimension(150, 25));
        textFieldFechaRecogida.setPreferredSize(new Dimension(150, 25));
        textFieldFechaEntrega.setPreferredSize(new Dimension(200, 25));  // Increased size for "Código de la sede"

        // Create buttons
        JButton acceptButton = new JButton("Aceptar");
        JButton cancelButton = new JButton("Cancelar");

        // Add action listeners to the buttons
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if any of the text fields is empty
                if (textFieldSede.getText().isEmpty() || textFieldFechaRecogida.getText().isEmpty() || textFieldFechaEntrega.getText().isEmpty()) {
                    // Display a warning message near the text fields
                    warningLabelUsuario.setText(textFieldSede.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelContraseña.setText(textFieldFechaRecogida.getText().isEmpty() ? "Llene este espacio!" : " ");
                    warningLabelCodigoSede.setText(textFieldFechaEntrega.getText().isEmpty() ? "Llene este espacio!" : " ");
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
        if (textFieldSede.getText().isEmpty() || textFieldFechaRecogida.getText().isEmpty() || textFieldFechaEntrega.getText().isEmpty()) {
            return null; // Return null if any of the text fields is empty (Cancel clicked)
        } else {
            // Return values entered in the text fields (Accept clicked)
            return new String[]{textFieldSede.getText(), textFieldFechaRecogida.getText(), textFieldFechaEntrega.getText()};
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

	public String cargar(String nombreArchivo) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine();
		return linea;
	}

	@Override
	public Component getVisualComponent() {
		// TODO Auto-generated method stub
		return this;
	}
}
