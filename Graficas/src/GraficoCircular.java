import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoCircular{

public static void main(String[] args) {

// Creamos el dataset
DefaultPieDataset dataset = new DefaultPieDataset();
dataset.setValue("Categoria 1", 20.5);
dataset.setValue("Categoria 2", 60.7);
dataset.setValue("Categoria 3", 18.8);

// Creamos el gr�fico
JFreeChart chart = ChartFactory.createPieChart(
"Grafico circular",
dataset,
true,
true, 
false  );

// Mostramos el gr�fico
ChartFrame frame = new ChartFrame("Test", chart);
frame.pack();
frame.setVisible(true);
}
}

