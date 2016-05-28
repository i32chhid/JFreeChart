import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;


/**
 * Interfaz implementada para las clases de gráficos creadas para este trabajo
 * y que define así una convención de nombrado.
 * 
 * @author David Checa Hidalgo
 *
 */
public interface IGrafico {

	/**
	 * Crea el objeto JFreeChart encargado de representar el gráfico por pantalla
	 * 
	 * @return el objeto correctamente inicializado
	 * 
	 */
	public JFreeChart createChart();

	/**
	* Crea el frame o ventana donde se imprime el gráfico
	* 
* @param jfcChart el objeto de tipo JFreeChart con los datos del gráfico   a   representar.
	 * @return el frame o ventana correctamente creada
	 */
	public ChartFrame createFrame(JFreeChart jfcChart);
	
	/**
	 * Define los valores del dataset del gráfico correspondiente.
	 */
	public void defineValues();
	
	/**
	 * Define los valores del dataset y los nombres de las categorías del			
	 * gráfico correspondiente.
	 */
	public void defineValuesAndNames();
	
	/**
	 * Hace visible la venta con el correspondiente gráfico
	 * 
	 * @param cfFrame el frame o ventana a representar
	 */
	public void setFrameVisible(ChartFrame cfFrame);	
}



