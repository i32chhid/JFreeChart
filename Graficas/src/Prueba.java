import java.util.Scanner;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;


/**
 * Clase para la prueba de las clases de gr�ficos creadas para
 * el trabajo de Programaci�n Aplicada.
 * Se implementan unas funciones auxiliares de tipo static y el
 * main del programa.
 * 
 * @author David Checa Hidalgo
 *
 */

public class Prueba {

	/**
	 * Realiza el proceso completo de creaci�n de un gr�fico circular
	 * as� como el control de errores al introducir los par�metros
	 * de entrada solicitados.
	 * 
	 * @param pgGrafico un objeto de tipo PieGraphic para trabajar con �ste
	 */

	static public void startGraphicPie(PieGraphic pgGrafico){
		String strOpcion = null;
		Scanner scRead = new Scanner(System.in);
		JFreeChart jfcChart;
		ChartFrame cfFrame;
		boolean bCategories;
		
		System.out.println("�Desea nombrar las categor�as? (Si|No)");
		strOpcion = scRead.nextLine();
		
		bCategories = Errors.yesNoError(strOpcion,"�Desea nombrar las categor�as? (Si|No)");
		
		if(bCategories)			
			pgGrafico.defineValuesAndNames();
		else
			pgGrafico.defineValues();
		
		jfcChart = pgGrafico.createChart();
		cfFrame = pgGrafico.createFrame(jfcChart);
		pgGrafico.setFrameVisible(cfFrame);
	}
	

	/**
	 * Realiza el proceso completo de creaci�n de un gr�fico de barras
	 * as� como el control de errores al introducir los par�metros
	 * de entrada solicitados.
	 * 
	 * @param bgGrafico un objeto de tipo BarsGraphic para trabajar con �ste
	 */

	static public void startGraphicBars(BarsGraphic bgGrafico){
		String strOpcion = null;
		Scanner scRead = new Scanner(System.in);
		JFreeChart jfcChart;
		ChartFrame cfFrame;
		boolean bCategories;
		
		System.out.println("�Desea nombrar las categor�as? (Si|No)");
		strOpcion = scRead.nextLine();
		
		bCategories = Errors.yesNoError(strOpcion,"�Desea nombrar las categor�as? (Si|No)");
		
		if(bCategories)		
			bgGrafico.defineValuesAndNames();
		else
			bgGrafico.defineValues();
		
		jfcChart = bgGrafico.createChart();
		cfFrame = bgGrafico.createFrame(jfcChart);
		bgGrafico.setFrameVisible(cfFrame);
	}
	

	/**
	 * Realiza el proceso completo de creaci�n de un gr�fico de l�neas
	 * as� como el control de errores al introducir los par�metros
	 * de entrada solicitados.
	 * 
	 * @param lgGrafico un objeto de tipo LineChart para trabajar con �ste
	 */

	static public void startLineGraphic(LineGraphic lgGrafico){
		String strOpcion = null;
		Scanner scRead = new Scanner(System.in);
		JFreeChart jfcChart;
		ChartFrame cfFrame;
		boolean bCategories;
		
		System.out.println("�Desea nombrar las categor�as? (Si|No)");
		strOpcion = scRead.nextLine();
		
		bCategories = Errors.yesNoError(strOpcion,"�Desea nombrar las categor�as? (Si|No)");
		
		if(bCategories)		
			lgGrafico.defineValuesAndNames();
		else
			lgGrafico.defineValues();
		
		jfcChart = lgGrafico.createChart();
		cfFrame = lgGrafico.createFrame(jfcChart);
		lgGrafico.setFrameVisible(cfFrame);
	}
	

	/**
	 * Main de la clase de prueba que define los gr�ficos seg�n lo
	 * desee el usuario
	 * 
	 * @param strArgs no es necesario ning�n argumento
	 * 
	 */

	public static void main(String[] strArgs) {
		String strOpcion = null;
		Scanner scRead = new Scanner(System.in);
		boolean bFlag = true;
		
		while(bFlag){
System.out.println("Introduce el tipo de gr�fico que deseas:\nbarras | circular | lineas");
			System.out.println("Introduce salir para terminar el programa:");
			strOpcion = scRead.nextLine();
			
			if(strOpcion.toLowerCase().equals("barras")){
				BarsGraphic bgGrafico = new BarsGraphic();
				startGraphicBars(bgGrafico);
			}
			else if(strOpcion.toLowerCase().equals("circular")){
				PieGraphic pgGrafico = new PieGraphic();
				startGraphicPie(pgGrafico);
			}
			else if(strOpcion.toLowerCase().equals("salir")){
				System.out.println("\nAdios.");
				bFlag=false;
			}
			else if(strOpcion.toLowerCase().equals("lineas")){
				LineGraphic lgGrafico = new LineGraphic();
				startLineGraphic(lgGrafico);
			}
			else{
System.out.println("Error al introducir el tipo de gr�fico.\n");
			}
		}
		
	}

}
