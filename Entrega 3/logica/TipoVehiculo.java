package logica;

public enum TipoVehiculo {
    AUTOMOVIL(0.0), 
    MOTO(0.1), 
    ATV(0.15), 
    BICICLETA(0.2), 
    BICICLETA_ELECTRICA(0.25), 
    PATINETA_ELECTRICA(0.3);

    private final double porcentajeComision;

    TipoVehiculo(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }
    
    //Para acceder al porcentaje de comision por ej: 
    //TipoVehiculo tipoVehiculo = TipoVehiculo.BICICLETA_ELECTRICA;
    //double porcentajeComision = tipoVehiculo.getPorcentajeComision();
}
