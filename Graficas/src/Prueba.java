import java.util.Scanner;

import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;


/**
 * Clase para la prueba de las clases de gráficos creadas para
 * el trabajo de Programación Aplicada.
 * Se implementan unas funciones auxiliares de tipo static y el
 * main del programa.
 * 
 * @author David Checa Hidalgo
 *
 */

public class Prueba {

	/**
	 * Realiza el proceso completo de creación de un gráfico circular
	 * así como el control de errores al introducir los parámetros
	 * de entrada solicitados.
	 * 
	 * @param pgGrafico un objeto de tipo PieGraphic para trabajar con éste
	 */

	static public void startGraphicPie(PieGraphic pgGrafico){
		String strOpcion = null;
		Scanner scRead = new Scanner(System.in);
		JFreeChart jfcChart;
		ChartFrame cfFrame;
		boolean bCategories;
		
		System.out.println("¿Desea nombrar las categorías? (Si|No)");
		strOpcion = scRead.nextLine();
		
		bCategories = Errors.yesNoError(strOpcion,"¿Desea nombrar las categorías? (Si|No)");
		
		if(bCategories)			
			pgGrafico.defineValuesAndNames();
		else
			pgGrafico.defineValues();
		
		jfcChart = pgGrafico.createChart();
		cfFrame = pgGrafico.createFrame(jfcChart);
		pgGrafico.setFrameVisible(cfFrame);
	}
	

	/**
	 * Realiza el proceso completo de creación de un gráfico de barras
	 * así como el control de errores al introducir los parámetros
	 * de entrada solicitados.
	 * 
	 * @param bgGrafico un objeto de tipo BarsGraphic para trabajar con éste
	 */

	static public void startGraphicBars(BarsGraphic bgGrafico){
		String strOpcion = null;
		Scanner scRead = new Scanner(System.in);
		JFreeChart jfcChart;
		ChartFrame cfFrame;
		boolean bCategories;
		
		System.out.println("¿Desea nombrar las categorías? (Si|No)");
		strOpcion = scRead.nextLine();
		
		bCategories = Errors.yesNoError(strOpcion,"¿Desea nombrar las categorías? (Si|No)");
		
		if(bCategories)		
			bgGrafico.defineValuesAndNames();
		else
			bgGrafico.defineValues();
		
		jfcChart = bgGrafico.createChart();
		cfFrame = bgGrafico.createFrame(jfcChart);
		bgGrafico.setFrameVisible(cfFrame);
	}
	

	/**
	 * Realiza el proceso completo de creación de un gráfico de líneas
	 * así como el control de errores al introducir los parámetros
	 * de entrada solicitados.
	 * 
	 * @param lgGrafico un objeto de tipo LineChart para trabajar con éste
	 */

	static public void startLineGraphic(LineGraphic lgGrafico){
		String strOpcion = null;
		Scanner scRead = new Scanner(System.in);
		JFreeChart jfcChart;
		ChartFrame cfFrame;
		boolean bCategories;
		
		System.out.println("¿Desea nombrar las categorías? (Si|No)");
		strOpcion = scRead.nextLine();
		
		bCategories = Errors.yesNoError(strOpcion,"¿Desea nombrar las categorías? (Si|No)");
		
		if(bCategories)		
			lgGrafico.defineValuesAndNames();
		else
			lgGrafico.defineValues();
		
		jfcChart = lgGrafico.createChart();
		cfFrame = lgGrafico.createFrame(jfcChart);
		lgGrafico.setFrameVisible(cfFrame);
	}
	

	/**
	 * Main de la clase de prueba que define los gráficos según lo
	 * desee el usuario
	 * 
	 * @param strArgs no es necesario ningún argumento
	 * 
	 */

	public static void main(String[] strArgs) {
		String strOpcion = null;
		Scanner scRead = new Scanner(System.in);
		boolean bFlag = true;
		
		while(bFlag){
System.out.println("Introduce el tipo de gráfico que deseas:\nbarras | circular | lineas");
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
System.out.println("Error al introducir el tipo de gráfico.\n");
			}
		}
		
	}

}
