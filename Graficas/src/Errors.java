import java.util.Scanner;


/**
 * Clase creada para el control de errores en la introducción de
 * parámetros por teclado.
 * 
 * @author David Checa Hidalgo
 *
 */
public class Errors {

	/**
	 * Controla que el contenido de strNname sea si o no sin atender 
	 * a mayúsculas o minúsculas, solicitando un dato mientras que                         	 
	 * no se introduzca si o no.
	 * 
	 * @param strName variable cadena para la que comprobaremos lo       
	 * descrito
	 * @param strMessage mensaje que se imprime por pantalla en caso        
	 * de error
	 * 
	 * @return la variable strName conteniendo si o no
	 * 
	 */

static public boolean yesNoError(String strName, String strMessage){
	
	Scanner strRead = new Scanner(System.in);
		
if(!strName.toLowerCase().equals("si") && !strName.toLowerCase().equals("no")){
	
		do{
System.out.println("Error al introducir el dato.");
			System.out.println(strMessage);
			strName = strRead.nextLine();
			}while(!strName.toLowerCase().equals("si") && !strName.toLowerCase().equals("no"));
		}
		
		if(strName.toLowerCase().equals("si"))
			return true;
		else
			return false;
	}


	/**
	 * Controla que el dato que se lea por teclado sea un entero,         
	 * solicitando un dato mientras que no sea convertible a entero.
	 * 
	 * @param strMessage mensaje que se imprime por pantalla en caso               
	 *   de error
	 * @return entero correctamente introducido
	 * 
	 */

	static public int readInteger(String strMessage){

		int iCategories=0;
		Scanner scRead = new Scanner(System.in);
		boolean bFlag = true;
		
		do{
			bFlag=false;
			try{
				System.out.println(strMessage);
				iCategories = scRead.nextInt();
			}
			catch(Exception InputMismatchException){
System.out.println("Error al introducir el dato. El número ha de ser un entero.\n");
				scRead.nextLine();
				bFlag = true;
			}
		}while(bFlag);
		
		return iCategories;
	}

	
	/**
	 * Controla que el dato que se lea por teclado sea un entero         
	 * positivo, solicitando un dato mientras que no sea convertible         
	 * a entero y/o no sea positivo.
	 * 
	 * @param strMessage mensaje que se imprime por pantalla en caso        
	 * de error
	 * @return entero correctamente introducido
	 * 
	 */

	static public int readPositiveInteger(String strMessage){

		int iCategories=0;
		Scanner scRead = new Scanner(System.in);
		boolean bFlag = true;
		
		do{
			bFlag=false;
			try{
				System.out.println(strMessage);
				iCategories = scRead.nextInt();
			}
			catch(Exception InputMismatchException){
System.out.println("Error al introducir el dato. El número ha de ser un entero positivo.\n");
				scRead.nextLine();
				bFlag = true;
			}
		}while(bFlag || iCategories<0);
		
		return iCategories;
	}

	
	/**
	 * Controla que el dato que se lea por teclado sea un double,        
	 * solicitando un dato mientras que no sea convertible a double.
	 * 
	 * @param strMessage mensaje que se imprime por pantalla en caso               
	 *  de error
	 * @return double correctamente introducido
	 * 
	 */

	static public double readDouble(String strMessage){

		double dCategories=0;
		Scanner scRead = new Scanner(System.in);
		boolean bFlag = true;
		
		do{
			bFlag=false;
			try{
				System.out.println(strMessage);
				dCategories = scRead.nextDouble();
			}
			catch(Exception InputMismatchException){
System.out.println("Error al introducir el dato. El número ha de ser un double o un entero convertible.\n");
				scRead.nextLine();
				bFlag = true;
			}
		}while(bFlag);
		
		return dCategories;
	}
	

	/**
	 * Controla que el dato que se lea por teclado sea un double        
	 * positivo, solicitando un dato mientras que no sea convertible        
	 * a double.
	 * 
	 * @param strMessage mensaje que se imprime por pantalla en caso               
 	 *  de error
	 * @return double correctamente introducido
	 * 
	 */

	static public double readPositiveDouble(String strMessage){

		double dCategories=0;
		Scanner scRead = new Scanner(System.in);
		boolean bFlag = true;
		
		do{
			bFlag=false;
			try{
				System.out.println(strMessage);
				dCategories = scRead.nextDouble();
			}
			catch(Exception InputMismatchException){
System.out.println("Error al introducir el dato. El número ha de ser un double o un entero convertible.\n");
				scRead.nextLine();
				bFlag = true;
			}
		}while(bFlag || dCategories<0);
		
		return dCategories;
	}

	
	/**
	 * Método que comprueba que los valores introducidos como % de        
 	 * las categorí¬as del gráfico circular sumen 100% en su totalidad, 
 	 * si esto no se cumple se piden de nuevo. Al acabar la función, el        
 	 * gráfico se encuentra con su dataset correctamente inicializado.
	 * 
	 * @param dValues valores de las categorías del gráfico circular
	 * @param iNumber entero que indica el número de categorías
	 * 
	 */

	static public void errorPieValues(Double[] dValues,int iNumber){
		
double dSuma=0;
		boolean dFlag=false;
		
		do{
			dFlag=false;
			for(int i=0; i<iNumber; i++)
				dSuma+=dValues[i];
			
			if(dSuma<100){
System.out.println("El total de las porciones del gráfico ha de sumar el 100%");
				dFlag=false;
				for(int i=0; i<iNumber; i++){
dValues[i]=Errors.readDouble("Introduce el valor de la categoría "+ (i+1)+" :");
				}
			}
			dSuma=0;
		}while(dFlag);
		
	}
	

	/**
	 * Método que comprueba si se ha introducido correctamente la orientación para    
	 * el gráfico de barras o de líneas: horizontal o vertical sin atender a mayúsculas * o minúsculas, solicitando un dato mientras que no se introduzca horizontal o 
	 * vertical.
	 * 
	 * @param strName variable cadena para la que comprobaremos lo descrito
	 * @param strMessage mensaje que se imprime por pantalla en caso de error
	 * @return varible strName correctamente con horizontal o vertical.
	 */

	static public String Orientation(String strName, String strMessage){
		
		Scanner scRead = new Scanner(System.in);
		
		if(!strName.toLowerCase().equals("horizontal") && !strName.toLowerCase().equals("vertical")){
			System.out.println("Error al introducir el dato.");
			do{
				System.out.println(strMessage);
				strName = scRead.nextLine();
}while(!strName.toLowerCase().equals("horizontal") && !strName.toLowerCase().equals("vertical"));
		}
		
		if(strName.toLowerCase().equals("horizontal"))
			return "horizontal";
		else
			return "vertical";
	}
	
}
