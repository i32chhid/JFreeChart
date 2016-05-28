import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;


public class GraficoLineas {

    	public static void main(String[] args) {
    
// Creamos el dataset   	 
DefaultCategoryDataset dataset = new DefaultCategoryDataset();
   	 
dataset.addValue(212, "Clave Leyenda", "Columna 1");   	 dataset.addValue(504, "Clave Leyenda", "Columna 2");
dataset.addValue(1520, "Clave Leyenda", "Columna 3");
dataset.addValue(1842, "Clave Leyenda", "Columna 4");
dataset.addValue(2991, "Clave Leyenda", "Columna 5");
   	 
//Creamos el gráfico   	 
JFreeChart chart = ChartFactory.createLineChart(
"Grafico de Lineas", 	 
"Eje de la x",    
"Eje de la y",	 
dataset,    	 
PlotOrientation.VERTICAL,
true, 	 
true,  	 
false);
   	 
// Mostramos el gráfico   	 
ChartFrame frame = new ChartFrame("Prueba", chart);
   	 
frame.pack();
frame.setVisible(true);    
}
}
















