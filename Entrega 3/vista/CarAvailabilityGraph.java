package vista;
import javax.swing.*;

import logica.Sede;
import logica.Vehiculo;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class CarAvailabilityGraph extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sede sede;
    private List<Vehiculo> listaVehiculos;

    public CarAvailabilityGraph(String title, Sede sede, List<Vehiculo> listaVehiculos) {
        super(title);
        this.sede = sede;
        this.listaVehiculos = listaVehiculos;
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        
        int currentYear = LocalDate.now().getYear();

        
        int xAxisStart = 50;
        int yAxisStart = 500;
        int xAxisEnd = 750;
        int yAxisEnd = 500;
        int barWidth = 50;
        int barGap = 10;

        
        int maxVehicles = getMaxVehicles(sede, listaVehiculos, currentYear - 9, currentYear);

        
        g2d.drawLine(xAxisStart, yAxisStart, xAxisEnd, yAxisEnd);

        
        g2d.drawLine(xAxisStart, yAxisStart, xAxisStart, 50);

        
        int x = xAxisStart + barGap;
        for (int year = currentYear - 9; year <= currentYear; year++) {
            int carsAvailable = sede.calcularVehiculosDisponiblesEnAño(year);
            int barHeight = (int) ((double) carsAvailable / maxVehicles * (yAxisStart - 50));
            g2d.fillRect(x, yAxisStart - barHeight, barWidth, barHeight);
            g2d.drawString(String.valueOf(year), x + barWidth / 2, yAxisStart + 20);
            x += barWidth + barGap;
        }
    }

    private int getMaxVehicles(Sede sede, List<Vehiculo> listaVehiculos, int startYear, int endYear) {
        int maxVehicles = 0;
        for (int year = startYear; year <= endYear; year++) {
            int vehicles = sede.calcularVehiculosDisponiblesEnAño(year);
            maxVehicles = Math.max(maxVehicles, vehicles);
        }
        return maxVehicles;
    }
}
    

    
