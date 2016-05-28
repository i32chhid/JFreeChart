import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class EjemploBarras {

public static void main(String[] args) {
 
// Creamos el dataset
DefaultCategoryDataset dataset = new DefaultCategoryDataset();
   	 
dataset.addValue(2.0, "Fila 1", "Columna 1");
dataset.addValue(3.0, "Fila 1", "Columna 2");
dataset.addValue(5.2, "Fila 1", "Columna 3");
dataset.addValue(1.7, "Fila 2", "Columna 1");
dataset.addValue(2.4, "Fila 2", "Columna 2");
dataset.addValue(2.8, "Fila 2", "Columna 3");
   		 
// Creamos el gráfico
JFreeChart chart = ChartFactory.createBarChart("Primer grafico de barras." ,	"Datos","Valor",dataset, PlotOrientation.VERTICAL, true, true, false);

// Mostramos el gráfico
ChartFrame frame = new ChartFrame("Primer grafico de barras.",chart);

frame.pack();
frame.setVisible(true);
}
}











