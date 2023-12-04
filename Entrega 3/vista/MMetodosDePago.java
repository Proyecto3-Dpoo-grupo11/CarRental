package vista;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import logica.Cliente;

public abstract class MMetodosDePago extends JDialog {
    private static final long serialVersionUID = 1L;
    protected Cliente cliente;
    protected double monto;
    protected int NumCuenta;
    protected int NumTransaccion;
    protected int saldo;
    protected Banco banco = new Banco();
    protected String recibo;

    private JLabel labelNumeroTarjeta = new JLabel("Numero de su Tarjeta");
    private JTextField textFieldNumTarjeta;
    private JTextArea textAreaRecibo = new JTextArea(10, 40); // Adjust rows and columns as needed

    public MMetodosDePago(Cliente cliente, double monto, int numCuenta, int numTransaccion, String recibo) {
        super();
        this.cliente = cliente;
        this.monto = monto;
        NumCuenta = numCuenta;
        NumTransaccion = numTransaccion;
        this.recibo = recibo;
    }

    public void realizarPago() {
        this.setTitle("Iniciar Reserva");
        this.setModal(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout()); // Set the layout manager to FlowLayout

        this.add(labelNumeroTarjeta);
        this.textFieldNumTarjeta = new JTextField(20); // Adjust the columns as needed
        this.add(this.textFieldNumTarjeta);

        JButton botonPagar = new JButton("Pagar");
        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean imprimirRecibo = Pagar();
                if (imprimirRecibo) {
                    textAreaRecibo.setText(recibo);
                    JOptionPane.showMessageDialog(MMetodosDePago.this, new JScrollPane(textAreaRecibo),
                            "Recibo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        this.add(botonPagar);

        pack(); // Adjust the size of the dialog to fit the content
        this.setVisible(true);
    }

    public boolean Pagar() {
        try {
            this.banco.retirar(this.textFieldNumTarjeta.getText(), monto);
            JOptionPane.showMessageDialog(this, "Transaccion Exitosa", "Exito", JOptionPane.INFORMATION_MESSAGE);
            return true; // Transaction successful
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
            } else if (e.getCodigo() == MiExcepcion.BLOQ_C) {
                JOptionPane.showMessageDialog(this, "Su cuenta esta bloqueada", "Advertencia",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return false; // Transaction failed
    }

    // Getters and setters...



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
