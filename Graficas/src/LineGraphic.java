import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.Scanner;

/**
 * Clase para la implementación del tipo de dato LineGraphic el cual
 * define a un gráfico de líneas e implementa los métodos necesarios
 * para su tratamiento.
 * 
 * El tipo de dato LineGraphic creado en esta clase será denominado lg
 * a la hora del nombrado en notación húngara, así como:<br/>
 * DefaultCategoryDataset será dcd<br/>
 * JFreeChart será jfc<br/>
 * ChartFrame será cf
 * 
 * @author David Checa Hidalgo
 *
 */
public class LineGraphic implements IGrafico{

	private DefaultCategoryDataset dcdDataset;
	
	/**
	 * Constructor de la clase LineGraphic y cuya función es
	 * reservar memoria para la variable privada dcdDataset.
	 */
	public LineGraphic(){
		this.dcdDataset = new DefaultCategoryDataset();
	}
	

	/**
	 * Crea el objeto de tipo JFreeChart que es el encargado de
	 * dibujar las gráficas y que posteriormente situaremos en 
	 * una ventana.
	 * 
	 * @return el objeto de tipo JFreeChart inicializado con los datos
	 * y la correspondiente personalización.
	 * 
	 */

	public JFreeChart createChart() {
		Scanner scRead = new Scanner(System.in);
		String strName = null,axeX,axeY, strOrientation;
		boolean bLegend = false;
		JFreeChart jfcChart;
		
		System.out.println("¿Desea leyenda? (Si|No)");
		strName = scRead.nextLine();
		
		bLegend = Errors.yesNoError(strName,"¿Desea leyenda? (Si|No)");
		
		System.out.println("Introduce el título del gráfico: ");
		strName = scRead.nextLine();
		System.out.println("Introduce el nombre del eje X: ");
		axeX = scRead.nextLine();
		System.out.println("Introduce el nombre del eje Y: ");
		axeY = scRead.nextLine();
		System.out.println("¿Desea orientación vertical u horizontal para las columnas? ");
		strOrientation = scRead.nextLine();
		
		strOrientation = Errors.Orientation(strOrientation,"¿Desea orientación vertical u horizontal para las columnas? ");
		
		if(strOrientation.toLowerCase().equals("vertical"))
jfcChart = ChartFactory.createLineChart(strName, axeX, axeY , this.dcdDataset, PlotOrientation.VERTICAL, bLegend, false, false);
		else
jfcChart = ChartFactory.createLineChart(strName, axeX, axeY , this.dcdDataset, PlotOrientation.HORIZONTAL, bLegend,false, false);
		
		return jfcChart;
	}
	

	/**
	 * Este método se encarga de la creación del frame o ventana en el que
	 * mostraremos posteriormente nuestro gráfico de líneas.
	 * 
	 * @param jfcChart recibe el objeto de tipo JFreeChart con los datos del            		 
	 * * gráfico a representar.
	 * @return el frame inicializado con los datos del gráfico y el
	 * título de la ventana
	 */
	public ChartFrame createFrame(JFreeChart jfcChart) {
		Scanner scRead = new Scanner(System.in);
		String strName = null;
		
		System.out.println("Introduce el título de la ventana: ");
		strName = scRead.nextLine();
		
		ChartFrame cfFrame = new ChartFrame(strName, jfcChart);
		return cfFrame;
	}


	/**
	 * Este método se encarga de inicializar el dataset con el
	 * conjunto de datos que queremos representar en nuestro 
	 * gráfico de líneas con nombres por defecto en las categorías.
	 * 
	 * @return el dataset inicializado con los valores del gráfico
	 * a representar
	 * 
	 */
	public void defineValues() {
		int iPoints; 
		
		iPoints = Errors.readInteger("Introduzca el número de puntos a representar: ");
		
		if(iPoints<1)
			do{
System.out.println("El número de puntos no puede ser menor que 1.");
iPoints = Errors.readPositiveInteger("Introduzca el número de puntos a representar: ");
			}while(iPoints<1);
		
		Double[]dValues = new Double[iPoints];
		
		for(int i=0; i<iPoints; i++){
dValues[i] = Errors.readDouble("Introduzca el valor "+(i+1)+": ");
		}
		
		for(int i=0; i<iPoints; i++){
							this.dcdDataset.addValue(dValues[i],"Clase","Punto "+(i+1));
		}
		
	}


	/**
	 * Método encargado de activar la impresión por pantalla
	 * de nuestro gráfico.
	 * 
	 * @param cfFrame el frame o ventana correctamente inicializado
	 * 
	 */
	public void setFrameVisible(ChartFrame cfFrame) {
		cfFrame.pack();
		cfFrame.setVisible(true);		
	}


	/**
	 * Este método se encarga de inicializar el dataset con el
	 * conjunto de datos que queremos representar en nuestro 
	 * gráfico de líneas dándole un nombrado personalizado a
	 * las categorías.
	 * 
	 * @return el dataset inicializado con los valores del gráfico
	 * a representar
	 * 
	 */

	public void defineValuesAndNames() {
		int iPoints;
		Scanner scRead = new Scanner(System.in);
		
		iPoints = Errors.readInteger("Introduzca el número de puntos a representar: ");
		
		if(iPoints<1)
			do{
System.out.println("El número de puntos no puede ser menor que 1.");
iPoints = Errors.readPositiveInteger("Introduzca el número de puntos a representar: ");
			}while(iPoints<1);
		
		Double[] dValues = new Double[iPoints];
		String[] strNames = new String[iPoints];
		
		for(int i=0; i<iPoints; i++){
System.out.println("Introduzca la etiqueta para el valor "+ (i+1)+" :");
			strNames[i] = scRead.nextLine();
			dValues[i] = Errors.readDouble("Introduzca el valor "+ (i+1) + " :");
		}
		
		for(int i=0; i<iPoints; i++){
				this.dcdDataset.addValue(dValues[i],"Clase",strNames[i]);
			}
		}
}


