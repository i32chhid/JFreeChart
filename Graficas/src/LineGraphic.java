import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.Scanner;

/**
 * Clase para la implementaci�n del tipo de dato LineGraphic el cual
 * define a un gr�fico de l�neas e implementa los m�todos necesarios
 * para su tratamiento.
 * 
 * El tipo de dato LineGraphic creado en esta clase ser� denominado lg
 * a la hora del nombrado en notaci�n h�ngara, as� como:<br/>
 * DefaultCategoryDataset ser� dcd<br/>
 * JFreeChart ser� jfc<br/>
 * ChartFrame ser� cf
 * 
 * @author David Checa Hidalgo
 *
 */
public class LineGraphic implements IGrafico{

	private DefaultCategoryDataset dcdDataset;
	
	/**
	 * Constructor de la clase LineGraphic y cuya funci�n es
	 * reservar memoria para la variable privada dcdDataset.
	 */
	public LineGraphic(){
		this.dcdDataset = new DefaultCategoryDataset();
	}
	

	/**
	 * Crea el objeto de tipo JFreeChart que es el encargado de
	 * dibujar las gr�ficas y que posteriormente situaremos en 
	 * una ventana.
	 * 
	 * @return el objeto de tipo JFreeChart inicializado con los datos
	 * y la correspondiente personalizaci�n.
	 * 
	 */

	public JFreeChart createChart() {
		Scanner scRead = new Scanner(System.in);
		String strName = null,axeX,axeY, strOrientation;
		boolean bLegend = false;
		JFreeChart jfcChart;
		
		System.out.println("�Desea leyenda? (Si|No)");
		strName = scRead.nextLine();
		
		bLegend = Errors.yesNoError(strName,"�Desea leyenda? (Si|No)");
		
		System.out.println("Introduce el t�tulo del gr�fico: ");
		strName = scRead.nextLine();
		System.out.println("Introduce el nombre del eje X: ");
		axeX = scRead.nextLine();
		System.out.println("Introduce el nombre del eje Y: ");
		axeY = scRead.nextLine();
		System.out.println("�Desea orientaci�n vertical u horizontal para las columnas? ");
		strOrientation = scRead.nextLine();
		
		strOrientation = Errors.Orientation(strOrientation,"�Desea orientaci�n vertical u horizontal para las columnas? ");
		
		if(strOrientation.toLowerCase().equals("vertical"))
jfcChart = ChartFactory.createLineChart(strName, axeX, axeY , this.dcdDataset, PlotOrientation.VERTICAL, bLegend, false, false);
		else
jfcChart = ChartFactory.createLineChart(strName, axeX, axeY , this.dcdDataset, PlotOrientation.HORIZONTAL, bLegend,false, false);
		
		return jfcChart;
	}
	

	/**
	 * Este m�todo se encarga de la creaci�n del frame o ventana en el que
	 * mostraremos posteriormente nuestro gr�fico de l�neas.
	 * 
	 * @param jfcChart recibe el objeto de tipo JFreeChart con los datos del            		 
	 * * gr�fico a representar.
	 * @return el frame inicializado con los datos del gr�fico y el
	 * t�tulo de la ventana
	 */
	public ChartFrame createFrame(JFreeChart jfcChart) {
		Scanner scRead = new Scanner(System.in);
		String strName = null;
		
		System.out.println("Introduce el t�tulo de la ventana: ");
		strName = scRead.nextLine();
		
		ChartFrame cfFrame = new ChartFrame(strName, jfcChart);
		return cfFrame;
	}


	/**
	 * Este m�todo se encarga de inicializar el dataset con el
	 * conjunto de datos que queremos representar en nuestro 
	 * gr�fico de l�neas con nombres por defecto en las categor�as.
	 * 
	 * @return el dataset inicializado con los valores del gr�fico
	 * a representar
	 * 
	 */
	public void defineValues() {
		int iPoints; 
		
		iPoints = Errors.readInteger("Introduzca el n�mero de puntos a representar: ");
		
		if(iPoints<1)
			do{
System.out.println("El n�mero de puntos no puede ser menor que 1.");
iPoints = Errors.readPositiveInteger("Introduzca el n�mero de puntos a representar: ");
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
	 * M�todo encargado de activar la impresi�n por pantalla
	 * de nuestro gr�fico.
	 * 
	 * @param cfFrame el frame o ventana correctamente inicializado
	 * 
	 */
	public void setFrameVisible(ChartFrame cfFrame) {
		cfFrame.pack();
		cfFrame.setVisible(true);		
	}


	/**
	 * Este m�todo se encarga de inicializar el dataset con el
	 * conjunto de datos que queremos representar en nuestro 
	 * gr�fico de l�neas d�ndole un nombrado personalizado a
	 * las categor�as.
	 * 
	 * @return el dataset inicializado con los valores del gr�fico
	 * a representar
	 * 
	 */

	public void defineValuesAndNames() {
		int iPoints;
		Scanner scRead = new Scanner(System.in);
		
		iPoints = Errors.readInteger("Introduzca el n�mero de puntos a representar: ");
		
		if(iPoints<1)
			do{
System.out.println("El n�mero de puntos no puede ser menor que 1.");
iPoints = Errors.readPositiveInteger("Introduzca el n�mero de puntos a representar: ");
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


