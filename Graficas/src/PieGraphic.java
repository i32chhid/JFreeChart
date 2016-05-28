import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Clase para la implementaci�n del tipo de dato PieGraphic el cual
 * define a un gr�fico circular e implementa los m�todos necesarios
 * para su tratamiento.
 * 
 * El tipo de dato PieGraphic creado en esta clase ser� denominado pg
 * a la hora del nombrado en notaci�n h�ngara, as� como:<br/>
 * DefaultPieDataset ser� dpd<br/>
 * JFreeChart ser� jfc<br/>
 * ChartFrame ser� cf
 * 
 * @author David Checa Hidalgo
 *
 */
public class PieGraphic implements IGrafico {
	
	private DefaultPieDataset dpdDataset;
	
	/**
	 * Constructor de la clase PieGraphic y cuya funci�n es
	 * reservar memoria para la variable privada dpdDataset.
	 */

	public PieGraphic(){
		this.dpdDataset = new DefaultPieDataset();
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
		String strName = null;
		boolean bLegend = false;
		
		System.out.println("�Desea leyenda? (Si|No)");
		strName = scRead.nextLine();
		
		bLegend = Errors.yesNoError(strName,"�Desea leyenda? (Si|No)");
		
		System.out.println("Introduce el titulo del gr�fico: ");
		strName = scRead.nextLine();
		
		JFreeChart jfcChart = ChartFactory.createPieChart( strName , this.dpdDataset, bLegend, true, false);
		return jfcChart;
	}


	/**
	 * Este m�todo se encarga de la creaci�n del frame o ventana en el que
	 * mostraremos posteriormente nuestro gr�fico circular.
	 * 
	 * @param jfcChart recibe el objeto de tipo JFreeChart con los datos			 
	 * del gr�fico a representar.
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
	 * gr�fico circular con nombres por defecto en las categor�as.
	 * 
	 * @return el dataset inicializado con los valores del gr�fico
	 * a representar
	 * 
	 */
	public void defineValues() {
		int iCategories;
		
		iCategories = Errors.readPositiveInteger("Introduce el n�mero de categor�as :");
		
		if(iCategories<1)
			do{
				System.out.println("El n�mero de categor�as no puede ser menor que 1.");
				iCategories = Errors.readPositiveInteger("Introduce el n�mero de categor�as :");
			}while(iCategories<1);
		
		Double[] dValues = new Double[iCategories];
		
		for(int i=0; i<iCategories; i++){
			dValues[i]=Errors.readPositiveDouble("Introduce el valor de la categor�a "+ (i+1)+" :");
		}
		
		Errors.errorPieValues(dValues,iCategories);
		
		for(int i=0; i<iCategories; i++){
			this.dpdDataset.setValue("Categor�a "+ (i+1),dValues[i]);
		}
	}


	/**
	 * M�todo encargado de activar la impresi�n por pantalla
	 * de nuestro gr�fico.
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
	 * gr�fico circular d�ndole un nombrado personalizado a
	 * las categor�as.
	 * 
	 * @return el dataset inicializado con los valores del gr�fico
	 * a representar
	 */
	public void defineValuesAndNames() {
		int iCategories;
		Scanner scRead = new Scanner(System.in);
		
		iCategories = Errors.readPositiveInteger("Introduce el n�mero de categor�as :");
		
		if(iCategories<1)
			do{
				System.out.println("El n�mero de categor�as no puede ser menor que 1.");
				iCategories = Errors.readPositiveInteger("Introduce el n�mero de categor�as :");
			}while(iCategories<1);
		
		Double[] dValues = new Double[iCategories];
		
		String[] strNames = new String[iCategories];
		
		for(int i=0; i<iCategories; i++){
			scRead.nextLine();
			System.out.println("Introduzca el nombre de la categor�a"+ (i+1)+" :");
			strNames[i] = scRead.nextLine();
			dValues[i]=Errors.readPositiveDouble("Introduzca el valor de la categor�a "+ (i+1)+" :");
		}
		
		for(int i=0; i<iCategories; i++){
			this.dpdDataset.setValue(strNames[i],dValues[i]);
		}		
	}
}

