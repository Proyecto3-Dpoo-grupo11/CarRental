package vista;

public class Cuenta {
	private int saldo;
	private int numTP;
	private int numTR;
	private int limiteDiario;
	private int montoTransacciones;
	private EstadoTarjeta estadoCuenta;

	public Cuenta(int saldo, int numTP, int limiteDiario,EstadoTarjeta estadoCuenta) {
		this.saldo = saldo;
		this.numTP = numTP;
		this.numTR = 0;
		this.limiteDiario = limiteDiario;
		this.montoTransacciones = 0;
		this.estadoCuenta=estadoCuenta;
	}

	public void retirar(double valor) throws MiExcepcion {
		if(valor > this.saldo) {
			throw new MiExcepcion(MiExcepcion.NO_SALDO);
		}else if(this.numTR == this.numTP) {
			throw new MiExcepcion(MiExcepcion.NUM_T);
		}else if(this.montoTransacciones + valor > this.limiteDiario) {
			throw new MiExcepcion(MiExcepcion.SUP_L);
		}else if(estadoCuenta==EstadoTarjeta.BLOQUEADA) {
			throw new MiExcepcion(MiExcepcion.BLOQ_C);
		}
		else {
			this.saldo -= valor;
			this.numTR++;
			this.montoTransacciones += valor;					
		}
	}
}
