package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.Cliente;

public abstract class MMetodosDePago extends JDialog {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	protected Cliente cliente;
	protected double monto;
	protected int NumCuenta;
	protected int NumTransaccion;
	protected int saldo;
	protected Banco banco = new Banco();
	protected String recibo;

	private JTextField texFieldNumTarjeta;
	
	private JLabel labelRecibo = new JLabel(" ");

	public MMetodosDePago(Cliente cliente, double monto, int numCuenta, int numTransaccion,String recibo) {
		super();
		this.cliente = cliente;
		this.monto = monto;
		NumCuenta = numCuenta;
		NumTransaccion = numTransaccion;
		this.recibo=recibo;

	}

	public void realizarPago() {

		this.setTitle("Iniciar Reserva");
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(19, 2, 15, 5)); // 19 filas para 19 parámetros
		this.add(new JLabel("Numero de su Tarjeta"));
		this.texFieldNumTarjeta = new JTextField();
		this.add(this.texFieldNumTarjeta);
		JButton botonPagar = new JButton("Pagar");
		botonPagar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Pagar();
				labelRecibo.setText(recibo);
				repaint();
			}
		});
		this.add(labelRecibo);
		this.add(botonPagar);
		this.setSize(600, 600); // Ajusta el tamaño según tus necesidades
		this.setVisible(true);
		repaint();
	}

	public void Pagar() {
		try {
			this.banco.retirar(this.texFieldNumTarjeta.getText(), monto);
			JOptionPane.showMessageDialog(this, "Transaccion Exitosa", "Exito", JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Debe digitar un valor numerico", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (MiExcepcion e) {
			if (e.getCodigo() == MiExcepcion.NO_SALDO) {
				JOptionPane.showMessageDialog(this, "No hay saldo", "Error", JOptionPane.ERROR_MESSAGE);
			} else if (e.getCodigo() == MiExcepcion.NUM_T) {
				JOptionPane.showMessageDialog(this, "Supero numero de transacciones", "Informacion",
						JOptionPane.INFORMATION_MESSAGE);
			} else if (e.getCodigo() == MiExcepcion.SUP_L) {
				JOptionPane.showMessageDialog(this, "Supero limite de monto diario", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
			else if (e.getCodigo() == MiExcepcion.BLOQ_C) {
				JOptionPane.showMessageDialog(this, "Su cuenta esta bloqueada", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public int getNumCuenta() {
		return NumCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		NumCuenta = numCuenta;
	}

	public int getNumTransaccion() {
		return NumTransaccion;
	}

	public void setNumTransaccion(int numTransaccion) {
		NumTransaccion = numTransaccion;
	}

}
