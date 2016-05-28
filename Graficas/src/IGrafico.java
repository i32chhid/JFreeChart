import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;


/**
 * Interfaz implementada para las clases de gr�ficos creadas para este trabajo
 * y que define as� una convenci�n de nombrado.
 * 
 * @author David Checa Hidalgo
 *
 */
public interface IGrafico {

	/**
	 * Crea el objeto JFreeChart encargado de representar el gr�fico por pantalla
	 * 
	 * @return el objeto correctamente inicializado
	 * 
	 */
	public JFreeChart createChart();

	/**
	* Crea el frame o ventana donde se imprime el gr�fico
	* 
* @param jfcChart el objeto de tipo JFreeChart con los datos del gr�fico   a   representar.
	 * @return el frame o ventana correctamente creada
	 */
	public ChartFrame createFrame(JFreeChart jfcChart);
	
	/**
	 * Define los valores del dataset del gr�fico correspondiente.
	 */
	public void defineValues();
	
	/**
	 * Define los valores del dataset y los nombres de las categor�as del			
	 * gr�fico correspondiente.
	 */
	public void defineValuesAndNames();
	
	/**
	 * Hace visible la venta con el correspondiente gr�fico
	 * 
	 * @param cfFrame el frame o ventana a representar
	 */
	public void setFrameVisible(ChartFrame cfFrame);	
}



