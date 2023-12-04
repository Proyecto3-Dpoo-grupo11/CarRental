package vista;

public class MiExcepcion extends Exception {
	private int codigo;
	
	public static final int NO_SALDO = 1;
	public static final int NUM_T = 2;
	public static final int SUP_L = 3;
	public static final int BLOQ_C=4;

	public int getCodigo() {
		return this.codigo;
	}
	
	public MiExcepcion(int codigo) {
		this.codigo = codigo;
	}

}
