import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Clase para la implementación del tipo de dato PieGraphic el cual
 * define a un gráfico circular e implementa los métodos necesarios
 * para su tratamiento.
 * 
 * El tipo de dato PieGraphic creado en esta clase será denominado pg
 * a la hora del nombrado en notación húngara, así¬ como:<br/>
 * DefaultPieDataset será dpd<br/>
 * JFreeChart será jfc<br/>
 * ChartFrame será cf
 * 
 * @author David Checa Hidalgo
 *
 */
public class PieGraphic implements IGrafico {
	
	private DefaultPieDataset dpdDataset;
	
	/**
	 * Constructor de la clase PieGraphic y cuya función es
	 * reservar memoria para la variable privada dpdDataset.
	 */

	public PieGraphic(){
		this.dpdDataset = new DefaultPieDataset();
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
		String strName = null;
		boolean bLegend = false;
		
		System.out.println("¿Desea leyenda? (Si|No)");
		strName = scRead.nextLine();
		
		bLegend = Errors.yesNoError(strName,"¿Desea leyenda? (Si|No)");
		
		System.out.println("Introduce el titulo del gráfico: ");
		strName = scRead.nextLine();
		
		JFreeChart jfcChart = ChartFactory.createPieChart( strName , this.dpdDataset, bLegend, true, false);
		return jfcChart;
	}


	/**
	 * Este método se encarga de la creación del frame o ventana en el que
	 * mostraremos posteriormente nuestro gráfico circular.
	 * 
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
	 * gráfico circular con nombres por defecto en las categorías.
	 * 
	 * @return el dataset inicializado con los valores del gráfico
	 * a representar
	 * 
	 */
	public void defineValues() {
		int iCategories;
		
		iCategories = Errors.readPositiveInteger("Introduce el número de categorías :");
		
		if(iCategories<1)
			do{
				System.out.println("El número de categorías no puede ser menor que 1.");
				iCategories = Errors.readPositiveInteger("Introduce el número de categorías :");
			}while(iCategories<1);
		
		Double[] dValues = new Double[iCategories];
		
		for(int i=0; i<iCategories; i++){
			dValues[i]=Errors.readPositiveDouble("Introduce el valor de la categoría "+ (i+1)+" :");
		}
		
		Errors.errorPieValues(dValues,iCategories);
		
		for(int i=0; i<iCategories; i++){
			this.dpdDataset.setValue("Categoría "+ (i+1),dValues[i]);
		}
	}


	/**
	 * Método encargado de activar la impresión por pantalla
	 * de nuestro gráfico.
	 * 
	 * @param cfFrame el frame o ventana correctamente inicializada
	 * 
	 */
	public void setFrameVisible(ChartFrame cfFrame) {
		cfFrame.pack();
		cfFrame.setVisible(true);	
	}


	/**
	 * Este metodo se encarga de inicializar el dataset con el
	 * conjunto de datos que queremos representar en nuestro 
	 * gráfico circular dándole un nombrado personalizado a
	 * las categorías.
	 * 
	 * @return el dataset inicializado con los valores del gráfico
	 * a representar
	 */
	public void defineValuesAndNames() {
		int iCategories;
		Scanner scRead = new Scanner(System.in);
		
		iCategories = Errors.readPositiveInteger("Introduce el número de categorías :");
		
		if(iCategories<1)
			do{
				System.out.println("El número de categorías no puede ser menor que 1.");
				iCategories = Errors.readPositiveInteger("Introduce el número de categorías :");
			}while(iCategories<1);
		
		Double[] dValues = new Double[iCategories];
		
		String[] strNames = new String[iCategories];
		
		for(int i=0; i<iCategories; i++){
			scRead.nextLine();
			System.out.println("Introduzca el nombre de la categoría"+ (i+1)+" :");
			strNames[i] = scRead.nextLine();
			dValues[i]=Errors.readPositiveDouble("Introduzca el valor de la categoría "+ (i+1)+" :");
		}
		
		for(int i=0; i<iCategories; i++){
			this.dpdDataset.setValue(strNames[i],dValues[i]);
		}		
	}
}

