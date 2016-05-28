import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.Scanner;

/**
 * Clase para la implementación del tipo de dato BarsGraphic el cual
 * define a un gráfico de barras e implementa los métodos necesarios
 * para su tratamiento.
 * 
 * El tipo de dato BarsGraphic creado en esta clase será denominado bg
 * a la hora del nombrado en notación húngara, así como:<br/>
 * DefaultCategoryDataset será dcd<br/>
 * JFreeChart será jfc<br/>
 * ChartFrame será cf
 * 
 * @author David Checa Hidalgo
 *
 */
public class BarsGraphic implements IGrafico{

	private DefaultCategoryDataset dcdDataset;
	
	/**
	 * Constructor de la clase BarsGraphic y cuya función es
	 * reservar memoria para la variable privada dcdDataset.
	 */

	public BarsGraphic(){
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
		
		System.out.println("Introduce el titulo del gráfico: ");
		strName = scRead.nextLine();
		System.out.println("Introduce el nombre del eje X: ");
		axeX = scRead.nextLine();
		System.out.println("Introduce el nombre del eje Y: ");
		axeY = scRead.nextLine();
		System.out.println("¿Desea orientación vertical u horizontal para las columnas? ");
		strOrientation = scRead.nextLine();
		
		strOrientation = Errors.Orientation(strOrientation,"¿Desea orientación vertical u horizontal para las columnas? ");
		
		if(strOrientation.toLowerCase().equals("vertical"))
jfcChart = ChartFactory.createBarChart(strName, axeX, axeY , this.dcdDataset, PlotOrientation.VERTICAL, bLegend, false, false);
		else
jfcChart = ChartFactory.createBarChart(strName, axeX, axeY , this.dcdDataset, PlotOrientation.HORIZONTAL, bLegend,false, false);
		
		return jfcChart;
	}
	

	/**
	 * Este método se encarga de la creación del frame o ventana en el que
	 * mostraremos posteriormente nuestro gráfico de barras 
	 * @param jfcChart recibe el objeto de tipo JFreeChart con los datos 	
	 * del gráfico a representar.
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
	 * gráfico de barras con nombres por defecto en las categorías.
	 * 
	 * @return el dataset inicializado con los valores del gráfico
	 * a representar
	 * 
	 */
	public void defineValues() {
		int iColumns, iRows;
		
		iRows = Errors.readPositiveInteger("Introduzca el número de filas: (número de barras por grupo)");
		
		if(iRows<1)
			do{
				System.out.println("El número de filas no puede ser menor que 1.");
				iRows = Errors.readPositiveInteger("\nIntroduzca el número de filas: (número de barras por grupo)");
			}while(iRows<1);
		
		iColumns = Errors.readPositiveInteger("Introduzca el número de columnas: (número de grupos de barras)");
		
		if(iColumns<1)
			do{
System.out.println("El número de columnas no puede ser menor que 1.");
iColumns = Errors.readPositiveInteger("\nIntroduzca el número de columnas: (número de grupos de barras)");
			}while(iColumns<1);
		
		Double[][] dValues = new Double[iRows][iColumns];
		
		for(int i=0; i<iColumns; i++){
			for(int j=0; j<iRows; j++){
System.out.println("Introduzca los valores del grupo "+ (i+1)+" de columnas:");
				dValues[j][i] = Errors.readDouble("Introduzca el valor de l a columna "+ (j+1) + " :");
			}
		}

		for(int i=0; i<iRows; i++){
			for(int j=0; j<iColumns; j++){
this.dcdDataset.addValue(dValues[i][j],"Fila "+ (i+1),"Columna "+(j+1));
			}
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
	 * gráfico circular dándole un nombrado personalizado a
	 * las categorías.
	 * 
	 * @return el dataset inicializado con los valores del gráfico
	 * a representar
	 * 
	 */

	public void defineValuesAndNames() {
		int iColumns, iRows;
		Scanner scRead = new Scanner(System.in);
		
		iRows = Errors.readPositiveInteger("Introduzca el númerode filas: (número de barras por grupo)");
		
		if(iRows<1)
			do{
System.out.println("El número de filas no puede ser menor que 1.");
iRows = Errors.readPositiveInteger("\nIntroduzca el número de filas: (número de barras por grupo)");
			}while(iRows<1);
		
		iColumns = Errors.readPositiveInteger("Introduzca el número de columnas: (número de grupos de barras)");
		
		if(iColumns<1)
			do{
System.out.println("El número de columnas no puede ser menor que 1.");
				iColumns = Errors.readPositiveInteger("\nIntroduzca el número de columnas: (número de grupos de barras)");
			}while(iColumns<1);
		
		Double[][] dValues = new Double[iRows][iColumns];
		String[] strNames = new String[iRows];
		
		for(int i=0; i<iRows; i++){
System.out.println("Introduzca el nombre del grupo "+ (i+1)+" de columnas:");
			strNames[i] = scRead.nextLine();
			
			for(int j=0; j<iColumns; j++){
System.out.println("Introduzca los valores del grupo "+ (i+1)+" de columnas:");
				dValues[i][j] = Errors.readDouble("Introduzca el valor de l a columna "+ (j+1) + " :");
			}
		}
		


		for(int i=0; i<iRows; i++){
			for(int j=0; j<iColumns; j++){
this.dcdDataset.addValue(dValues[i][j],"Fila "+ (i+1),strNames[i]);
			}
		}
		
	}

}
