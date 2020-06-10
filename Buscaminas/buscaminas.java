import java.net.*;
import java.util.Stack;
import java.io.*;
import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class buscaminas {
	static char [][] tablero;
	static char [][] tablerovisual;
    static int movimientos;
    static int nfila;
    static int mcolumna;
    static boolean Perdiste=false;
	public static char [][] buildMatriz(String name, int n, int m){
		char [][] matriz= new char [n][m] ;
		File archivo = null;
     	FileReader fr = null;
     	BufferedReader br = null;
	      try {
	         archivo = new File (name);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         String linea=br.readLine();
	         int contador=0;
	         while(linea!=null){
	         	String[] values = linea.split(" ");
	            for (int i = 0; i<values.length; i++) {
	                matriz[contador][i] = values[i].charAt(0);
	            }
	            linea=br.readLine();
	            contador++;
	        }
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	      finally
	      {
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }

	      return matriz;
	}

	public static int min(int a,int b){
		int min;
		if (a<b) {
			min=a;
		}
		else min =b;
		return min;
	}
	public static int max(int a,int b){
		int max;
		if (a>b) {
			max=a;
		}
		else
			max=b;
		return max;
	}
	/*public static void destapar(int fila,int columna){
		if(tablero[fila][columna]=='0'){
		tablerovisual[fila][columna]=tablero[fila][columna];
		int fila2=0, columna2=0;
			for (fila2=max(0,fila-1);fila2<min(nfila,fila+1);fila2++) {
				for (columna2=max(0,columna-1);columna2<min(mcolumna,columna+1); columna2++ ) {
					if(tablero[fila2][columna2]!='M')
						destapar(fila2,columna2);
				}
			}
		}		
	}*/
	public static void  tirada(int fila, int columna)
	{
		int aux[]={fila,columna};
		Stack<int[]> pila = new Stack<int[]>();

		if (tablero[fila][columna]=='M'){
			System.out.println("Perdiste");
			Perdiste=true;
		}
		else if(tablero[fila][columna]!='0')
		   		tablerovisual[fila][columna]=tablero[fila][columna];
		else if(tablero[fila][columna]=='0'){
			tablerovisual[fila][columna]=tablero[fila][columna];
			pila.push(aux);
			while(!pila.empty()){
				int aux1[]= new int [2];
				int aux2[]=new int[2];
				aux1=pila.pop();
				int fila2=aux1[0];
				int columna2=aux1[1];
				System.out.println(fila2);
				System.out.println(columna2);
				if (fila2==0&&columna2==0) {

					//1 Caso
					if((tablero[fila2][columna2+1]!='0') && (tablero[fila2][columna2+1]!='M') 
						&& (tablerovisual[fila2][columna2+1]!='F') && (tablerovisual[fila2][columna2+1]=='*')){

		   				tablerovisual[fila2][columna2+1]=tablero[fila2][columna2+1];
					}
					else if(tablero[fila2][columna2+1]=='0'&& (tablerovisual[fila2][columna2+1]=='*')){
						aux2[0]=fila2;
						aux2[1]=columna2+1;
						tablerovisual[fila2][columna2+1]=tablero[fila2][columna2+1];
						pila.push(aux2);
					}
					// 2 Caso
					if((tablero[fila2+1][columna2]!='0') && (tablero[fila2+1][columna2]!='M')
					   &&(tablerovisual[fila2+1][columna2]!='F')&&(tablerovisual[fila2+1][columna2]=='*')){

		   				tablerovisual[fila2+1][columna2]=tablero[fila2+1][columna2];
					}
					else if(tablero[fila2+1][columna2]=='0'&&(tablerovisual[fila2+1][columna2]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2;
						tablerovisual[fila2+1][columna2]=tablero[fila2+1][columna2];
						pila.push(aux2);
					}
					// 3 Caso
					if((tablero[fila2+1][columna2+1]!='0') && (tablero[fila2+1][columna2+1]!='M')
					  &&(tablerovisual[fila2+1][columna2+1]!='F')&&(tablerovisual[fila2+1][columna2+1]=='*')){

		   				tablerovisual[fila2+1][columna2+1]=tablero[fila2+1][columna2+1];
					}
					else if(tablero[fila2+1][columna2+1]=='0'&&(tablerovisual[fila2+1][columna2+1]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2+1;
						tablerovisual[fila2+1][columna2+1]=tablero[fila2+1][columna2+1];
						pila.push(aux2);
					}
				}

				else if(fila2==(nfila-1)&&columna2==0){
					//1 Caso
					if((tablero[fila2][columna2+1]!='0') && (tablero[fila2][columna2+1]!='M') 
						&& (tablerovisual[fila2][columna2+1]!='F') && (tablerovisual[fila2][columna2+1]=='*')){

		   				tablerovisual[fila2][columna2+1]=tablero[fila2][columna2+1];
					}
					else if(tablero[fila2][columna2+1]=='0'&& (tablerovisual[fila2][columna2+1]=='*')){
						aux2[0]=fila2;
						aux2[1]=columna2+1;
						tablerovisual[fila2][columna2+1]=tablero[fila2][columna2+1];
						pila.push(aux2);
					}
					// 2 Caso
					if((tablero[fila2-1][columna2]!='0') && (tablero[fila2-1][columna2]!='M')
					   &&(tablerovisual[fila2-1][columna2]!='F')  &&(tablerovisual[fila2-1][columna2]=='*')){

		   				tablerovisual[fila2-1][columna2]=tablero[fila2-1][columna2];
					}
					else if(tablero[fila2-1][columna2]=='0' &&(tablerovisual[fila2-1][columna2]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2;
						tablerovisual[fila2-1][columna2]=tablero[fila2-1][columna2];
						pila.push(aux2);
					}
					// 3 Caso
					if((tablero[fila2-1][columna2+1]!='0') && (tablero[fila2+1][columna2+1]!='M')
					  &&(tablerovisual[fila2-1][columna2+1]!='F')&&(tablerovisual[fila2-1][columna2+1]=='*')){

		   				tablerovisual[fila2-1][columna2+1]=tablero[fila2-1][columna2+1];
					}
					else if(tablero[fila2-1][columna2+1]=='0'&&(tablerovisual[fila2-1][columna2+1]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2+1;
						tablerovisual[fila2-1][columna2+1]=tablero[fila2-1][columna2+1];
						pila.push(aux2);
					}

				}

				else if(fila2==0&&columna2==(mcolumna-1)){
					//1 Caso
					if((tablero[fila2][columna2-1]!='0') && (tablero[fila2][columna2-1]!='M') 
						&& (tablerovisual[fila2][columna2-1]!='F')&& (tablerovisual[fila2][columna2-1]=='*')){

		   				tablerovisual[fila2][columna2-1]=tablero[fila2][columna2-1];
					}
					else if(tablero[fila2][columna2-1]=='0'&& (tablerovisual[fila2][columna2-1]=='*')){
						aux2[0]=fila2;
						aux2[1]=columna2-1;
						tablerovisual[fila2][columna2-1]=tablero[fila2][columna2-1];
						pila.push(aux2);
					}
					// 2 Caso
					if((tablero[fila2+1][columna2]!='0') && (tablero[fila2+1][columna2]!='M')
					   &&(tablerovisual[fila2+1][columna2]!='F')&&(tablerovisual[fila2+1][columna2]=='*')){

		   				tablerovisual[fila2+1][columna2]=tablero[fila2+1][columna2];
					}
					else if(tablero[fila2+1][columna2]=='0'&&(tablerovisual[fila2+1][columna2]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2;
						tablerovisual[fila2+1][columna2]=tablero[fila2+1][columna2];
						pila.push(aux2);
					}
					// 3 Caso
					if((tablero[fila2+1][columna2-1]!='0') && (tablero[fila2+1][columna2-1]!='M')
					  &&(tablerovisual[fila2+1][columna2-1]!='F')&&(tablerovisual[fila2+1][columna2-1]=='*')){

		   				tablerovisual[fila2+1][columna2-1]=tablero[fila2+1][columna2-1];
					}
					else if(tablero[fila2+1][columna2-1]=='0'&&(tablerovisual[fila2+1][columna2-1]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2-1;
						tablerovisual[fila2+1][columna2-1]=tablero[fila2+1][columna2-1];
						pila.push(aux2);
					}


				}
				else if (fila2==(nfila-1)&&columna2==(mcolumna-1)) {
					//1 Caso
					if((tablero[fila2][columna2-1]!='0') && (tablero[fila2][columna2-1]!='M') 
						&& (tablerovisual[fila2][columna2-1]!='F')&& (tablerovisual[fila2][columna2-1]=='*')){

		   				tablerovisual[fila2][columna2-1]=tablero[fila2][columna2-1];
					}
					else if(tablero[fila2][columna2-1]=='0'&& (tablerovisual[fila2][columna2-1]=='*')){
						aux2[0]=fila2;
						aux2[1]=columna2-1;
						tablerovisual[fila2][columna2-1]=tablero[fila2][columna2-1];
						pila.push(aux2);
					}
					// 2 Caso
					if((tablero[fila2-1][columna2]!='0') && (tablero[fila2-1][columna2]!='M')
					   &&(tablerovisual[fila2-1][columna2]!='F')&&(tablerovisual[fila2-1][columna2]=='*')){

		   				tablerovisual[fila2-1][columna2]=tablero[fila2-1][columna2];
					}
					else if(tablero[fila2-1][columna2]=='0'&&(tablerovisual[fila2-1][columna2]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2;
						tablerovisual[fila2-1][columna2]=tablero[fila2-1][columna2];
						pila.push(aux2);
					}
					// 3 Caso
					if((tablero[fila2-1][columna2-1]!='0') && (tablero[fila2-1][columna2-1]!='M')
					  &&(tablerovisual[fila2-1][columna2-1]!='F')&&(tablerovisual[fila2-1][columna2-1]=='*')){

		   				tablerovisual[fila2-1][columna2-1]=tablero[fila2-1][columna2-1];
					}
					else if(tablero[fila2-1][columna2-1]=='0'&&(tablerovisual[fila2-1][columna2-1]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2-1;
						tablerovisual[fila2-1][columna2-1]=tablero[fila2-1][columna2-1];
						pila.push(aux2);
					}
				}

				else if (fila2==0 && columna2<(mcolumna-1)) 
				{
					
					if((tablero[fila2][columna2-1]!='0') && (tablero[fila2][columna2-1]!='M') 
						&& (tablerovisual[fila2][columna2-1]!='F')&& (tablerovisual[fila2][columna2-1]=='*')){

		   				tablerovisual[fila2][columna2-1]=tablero[fila2][columna2-1];
					}
					else if(tablero[fila2][columna2-1]=='0'&& (tablerovisual[fila2][columna2-1]=='*')){
						aux2[0]=fila2;
						aux2[1]=columna2-1;
						tablerovisual[fila2][columna2-1]=tablero[fila2][columna2-1];
						pila.push(aux2);
					}

					//caso2
					if((tablero[fila2][columna2+1]!='0') && (tablero[fila2][columna2+1]!='M') 
						&& (tablerovisual[fila2][columna2+1]!='F')&& (tablerovisual[fila2][columna2+1]=='*')){

		   				tablerovisual[fila2][columna2+1]=tablero[fila2][columna2+1];
					}
					else if(tablero[fila2][columna2+1]=='0'&& (tablerovisual[fila2][columna2+1]=='*')){
						aux2[0]=fila2;
						aux2[1]=columna2+1;
						tablerovisual[fila2][columna2+1]=tablero[fila2][columna2+1];
						pila.push(aux2);
					}
					//caso3
					if((tablero[fila2+1][columna2-1]!='0') && (tablero[fila2+1][columna2-1]!='M') 
						&& (tablerovisual[fila2+1][columna2-1]!='F')&& (tablerovisual[fila2+1][columna2-1]=='*')){

		   				tablerovisual[fila2+1][columna2-1]=tablero[fila2+1][columna2-1];
					}
					else if(tablero[fila2+1][columna2-1]=='0'&& (tablerovisual[fila2+1][columna2-1]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2-1;
						tablerovisual[fila2+1][columna2-1]=tablero[fila2+1][columna2-1];
						pila.push(aux2);
					}
					//caso4
					if((tablero[fila2+1][columna2]!='0') && (tablero[fila2+1][columna2]!='M') 
						&& (tablerovisual[fila2+1][columna2]!='F')&& (tablerovisual[fila2+1][columna2]=='*')){

		   				tablerovisual[fila2+1][columna2]=tablero[fila2+1][columna2];
					}
					else if(tablero[fila2+1][columna2]=='0'&& (tablerovisual[fila2+1][columna2]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2;
						tablerovisual[fila2+1][columna2]=tablero[fila2+1][columna2];
						pila.push(aux2);
					}
					//caso5
					if((tablero[fila2+1][columna2+1]!='0') && (tablero[fila2+1][columna2+1]!='M') 
						&& (tablerovisual[fila2+1][columna2+1]!='F')&& (tablerovisual[fila2+1][columna2+1]=='*')){

		   				tablerovisual[fila2+1][columna2+1]=tablero[fila2+1][columna2+1];
					}
					else if(tablero[fila2+1][columna2+1]=='0'&& (tablerovisual[fila2+1][columna2+1]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2+1;
						tablerovisual[fila2+1][columna2+1]=tablero[fila2+1][columna2+1];
						pila.push(aux2);
					}
				}

				else if (fila2>=1&&columna2==(mcolumna-1)) 
				{
					if((tablero[fila2-1][columna2]!='0') && (tablero[fila2-1][columna2]!='M') 
						&& (tablerovisual[fila2-1][columna2]!='F')&& (tablerovisual[fila2-1][columna2]=='*')){

		   				tablerovisual[fila2-1][columna2]=tablero[fila2-1][columna2];
					}
					else if(tablero[fila2-1][columna2]=='0'&& (tablerovisual[fila2-1][columna2]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2;
						tablerovisual[fila2-1][columna2]=tablero[fila2-1][columna2];
						pila.push(aux2);
					}

					//caso2
					if((tablero[fila2-1][columna2-1]!='0') && (tablero[fila2-1][columna2-1]!='M') 
						&& (tablerovisual[fila2-1][columna2-1]!='F')&& (tablerovisual[fila2-1][columna2-1]=='*')){

		   				tablerovisual[fila2-1][columna2-1]=tablero[fila2-1][columna2-1];
					}
					else if(tablero[fila2-1][columna2-1]=='0'&& (tablerovisual[fila2-1][columna2-1]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2-1;
						tablerovisual[fila2-1][columna2-1]=tablero[fila2-1][columna2-1];
						pila.push(aux2);
					}
					//caso3
					if((tablero[fila2][columna2-1]!='0') && (tablero[fila2][columna2-1]!='M') 
						&& (tablerovisual[fila2][columna2-1]!='F')&& (tablerovisual[fila2][columna2-1]=='*')){

		   				tablerovisual[fila2][columna2-1]=tablero[fila2][columna2-1];
					}
					else if(tablero[fila2][columna2-1]=='0'&& (tablerovisual[fila2][columna2-1]=='*')){
						aux2[0]=fila2;
						aux2[1]=columna2-1;
						tablerovisual[fila2][columna2-1]=tablero[fila2][columna2-1];
						pila.push(aux2);
					}
					//caso4
					if((tablero[fila2+1][columna2]!='0') && (tablero[fila2+1][columna2]!='M') 
						&& (tablerovisual[fila2+1][columna2]!='F')&& (tablerovisual[fila2+1][columna2]=='*')){

		   				tablerovisual[fila2+1][columna2]=tablero[fila2+1][columna2];
					}
					else if(tablero[fila2+1][columna2]=='0'&& (tablerovisual[fila2+1][columna2]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2;
						tablerovisual[fila2+1][columna2]=tablero[fila2+1][columna2];
						pila.push(aux2);
					}
					//caso5
					if((tablero[fila2+1][columna2-1]!='0') && (tablero[fila2+1][columna2-1]!='M') 
						&& (tablerovisual[fila2+1][columna2-1]!='F')&& (tablerovisual[fila2+1][columna2-1]=='*')){

		   				tablerovisual[fila2+1][columna2-1]=tablero[fila2+1][columna2-1];
					}
					else if(tablero[fila2+1][columna2-1]=='0'&& (tablerovisual[fila2+1][columna2-1]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2-1;
						tablerovisual[fila2+1][columna2-1]=tablero[fila2+1][columna2-1];
						pila.push(aux2);
					}
					
				}

				else if (fila2>=1 && fila2<(nfila-1)&&columna2==0) 
				{
					if((tablero[fila2-1][columna2]!='0') && (tablero[fila2-1][columna2]!='M') 
						&& (tablerovisual[fila2-1][columna2]!='F')&& (tablerovisual[fila2-1][columna2]=='*')){

		   				tablerovisual[fila2-1][columna2]=tablero[fila2-1][columna2];
					}
					else if(tablero[fila2-1][columna2]=='0'&& (tablerovisual[fila2-1][columna2]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2;
						tablerovisual[fila2-1][columna2]=tablero[fila2-1][columna2];
						pila.push(aux2);
					}

					//caso2
					if((tablero[fila2-1][columna2+1]!='0') && (tablero[fila2-1][columna2+1]!='M') 
						&& (tablerovisual[fila2-1][columna2+1]!='F')&& (tablerovisual[fila2-1][columna2+1]=='*')){

		   				tablerovisual[fila2-1][columna2+1]=tablero[fila2-1][columna2+1];
					}
					else if(tablero[fila2-1][columna2+1]=='0'&& (tablerovisual[fila2-1][columna2+1]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2+1;
						tablerovisual[fila2-1][columna2+1]=tablero[fila2-1][columna2+1];
						pila.push(aux2);
					}
					//caso3
					if((tablero[fila2][columna2+1]!='0') && (tablero[fila2][columna2+1]!='M') 
						&& (tablerovisual[fila2][columna2+1]!='F')&& (tablerovisual[fila2][columna2+1]=='*')){

		   				tablerovisual[fila2][columna2+1]=tablero[fila2][columna2+1];
					}
					else if(tablero[fila2][columna2+1]=='0'&& (tablerovisual[fila2][columna2+1]=='*')){
						aux2[0]=fila2;
						aux2[1]=columna2+1;
						tablerovisual[fila2][columna2+1]=tablero[fila2][columna2+1];
						pila.push(aux2);
					}
					//caso4
					if((tablero[fila2+1][columna2]!='0') && (tablero[fila2+1][columna2]!='M') 
						&& (tablerovisual[fila2+1][columna2]!='F')&& (tablerovisual[fila2+1][columna2]=='*')){

		   				tablerovisual[fila2+1][columna2]=tablero[fila2+1][columna2];
					}
					else if(tablero[fila2+1][columna2]=='0'&& (tablerovisual[fila2+1][columna2]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2;
						tablerovisual[fila2+1][columna2]=tablero[fila2+1][columna2];
						pila.push(aux2);
					}
					//caso5
					if((tablero[fila2+1][columna2+1]!='0') && (tablero[fila2+1][columna2+1]!='M') 
						&& (tablerovisual[fila2+1][columna2+1]!='F')&& (tablerovisual[fila2+1][columna2+1]=='*')){

		   				tablerovisual[fila2+1][columna2+1]=tablero[fila2+1][columna2+1];
					}
					else if(tablero[fila2+1][columna2+1]=='0'&& (tablerovisual[fila2+1][columna2+1]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2+1;
						tablerovisual[fila2+1][columna2+1]=tablero[fila2+1][columna2+1];
						pila.push(aux2);
					}
					
				}

				else if (fila2==(nfila-1)&&columna2>=1&&columna2<(mcolumna-1)) 
				{
					if((tablero[fila2-1][columna2]!='0') && (tablero[fila2-1][columna2]!='M') 
						&& (tablerovisual[fila2-1][columna2]!='F')&& (tablerovisual[fila2-1][columna2]=='*')){

		   				tablerovisual[fila2-1][columna2]=tablero[fila2-1][columna2];
					}
					else if(tablero[fila2-1][columna2]=='0'&& (tablerovisual[fila2-1][columna2]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2;
						tablerovisual[fila2-1][columna2]=tablero[fila2-1][columna2];
						pila.push(aux2);
					}

					//caso2
					if((tablero[fila2-1][columna2-1]!='0') && (tablero[fila2-1][columna2-1]!='M') 
						&& (tablerovisual[fila2-1][columna2-1]!='F')&& (tablerovisual[fila2-1][columna2-1]=='*')){

		   				tablerovisual[fila2-1][columna2-1]=tablero[fila2-1][columna2-1];
					}
					else if(tablero[fila2-1][columna2-1]=='0'&& (tablerovisual[fila2-1][columna2-1]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2-1;
						tablerovisual[fila2-1][columna2-1]=tablero[fila2-1][columna2-1];
						pila.push(aux2);
					}
					//caso3
					if((tablero[fila2][columna2-1]!='0') && (tablero[fila2][columna2-1]!='M') 
						&& (tablerovisual[fila2][columna2-1]!='F')&& (tablerovisual[fila2][columna2-1]=='*')){

		   				tablerovisual[fila2][columna2-1]=tablero[fila2][columna2-1];
					}
					else if(tablero[fila2][columna2-1]=='0'&& (tablerovisual[fila2][columna2-1]=='*')){
						aux2[0]=fila2;
						aux2[1]=columna2-1;
						tablerovisual[fila2][columna2-1]=tablero[fila2][columna2-1];
						pila.push(aux2);
					}
					//caso4
					if((tablero[fila2-1][columna2+1]!='0') && (tablero[fila2-1][columna2+1]!='M') 
						&& (tablerovisual[fila2-1][columna2]+1!='F')&& (tablerovisual[fila2-1][columna2+1]=='*')){

		   				tablerovisual[fila2-1][columna2+1]=tablero[fila2-1][columna2+1];
					}
					else if(tablero[fila2-1][columna2+1]=='0'&& (tablerovisual[fila2-1][columna2+1]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2+1;
						tablerovisual[fila2-1][columna2+1]=tablero[fila2-1][columna2+1];
						pila.push(aux2);
					}
					//caso5
					if((tablero[fila2][columna2+1]!='0') && (tablero[fila2][columna2+1]!='M') 
						&& (tablerovisual[fila2][columna2+1]!='F')&& (tablerovisual[fila2][columna2+1]=='*')){

		   				tablerovisual[fila2][columna2+1]=tablero[fila2][columna2+1];
					}
					else if(tablero[fila2][columna+1]=='0'&& (tablerovisual[fila2][columna2+1]=='*')){
						aux2[0]=fila2;
						aux2[1]=columna2+1;
						tablerovisual[fila2][columna2+1]=tablero[fila2][columna2+1];
						pila.push(aux2);
					}
					
				}
				else
				{
					//caso1
					if((tablero[fila2][columna2+1]!='0') && (tablero[fila2][columna2+1]!='M') 
						&& (tablerovisual[fila2][columna2+1]!='F')&& (tablerovisual[fila2][columna2+1]=='*')){

		   				tablerovisual[fila2][columna2+1]=tablero[fila2][columna2+1];
					}
					else if(tablero[fila2][columna+1]=='0'&& (tablerovisual[fila2][columna2+1]=='*')){
						aux2[0]=fila2;
						aux2[1]=columna2+1;
						tablerovisual[fila2][columna2+1]=tablero[fila2][columna2+1];
						pila.push(aux2);
					}
					//caso2
					if((tablero[fila2][columna2-1]!='0') && (tablero[fila2][columna2-1]!='M') 
						&& (tablerovisual[fila2][columna2-1]!='F')&& (tablerovisual[fila2][columna2-1]=='*')){

		   				tablerovisual[fila2][columna2-1]=tablero[fila2][columna2-1];
					}
					else if(tablero[fila2][columna2-1]=='0'&& (tablerovisual[fila2][columna2-1]=='*')){
						aux2[0]=fila2;
						aux2[1]=columna2-1;
						tablerovisual[fila2][columna2-1]=tablero[fila2][columna2-1];
						pila.push(aux2);
					}
					//caso3
					if((tablero[fila2+1][columna2]!='0') && (tablero[fila2+1][columna2]!='M') 
						&& (tablerovisual[fila2+1][columna2]!='F')&& (tablerovisual[fila2+1][columna2]=='*')){

		   				tablerovisual[fila2+1][columna2]=tablero[fila2+1][columna2];
					}
					else if(tablero[fila2+1][columna]=='0'&& (tablerovisual[fila2+1][columna2]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2;
						tablerovisual[fila2+1][columna2]=tablero[fila2+1][columna2];
						pila.push(aux2);
					}
					//caso4
					if((tablero[fila2+1][columna2+1]!='0') && (tablero[fila2+1][columna2+1]!='M') 
						&& (tablerovisual[fila2+1][columna2+1]!='F')&& (tablerovisual[fila2+1][columna2+1]=='*')){

		   				tablerovisual[fila2+1][columna2+1]=tablero[fila2+1][columna2+1];
					}
					else if(tablero[fila2+1][columna2+1]=='0'&& (tablerovisual[fila2+1][columna2+1]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2+1;
						tablerovisual[fila2+1][columna2+1]=tablero[fila2+1][columna2+1];
						pila.push(aux2);
					}
					
					//casp5
					if((tablero[fila2+1][columna2-1]!='0') && (tablero[fila2+1][columna2-1]!='M') 
						&& (tablerovisual[fila2+1][columna2-1]!='F')&& (tablerovisual[fila2+1][columna2-1]=='*')){

		   				tablerovisual[fila2+1][columna2-1]=tablero[fila2+1][columna2-1];
					}
					else if(tablero[fila2+1][columna2-1]=='0'&& (tablerovisual[fila2+1][columna2-1]=='*')){
						aux2[0]=fila2+1;
						aux2[1]=columna2-1;
						tablerovisual[fila2+1][columna2-1]=tablero[fila2+1][columna2-1];
						pila.push(aux2);
					}
					//caso6
					if((tablero[fila2-1][columna2+1]!='0') && (tablero[fila2-1][columna2+1]!='M') 
						&& (tablerovisual[fila2-1][columna2+1]!='F')&& (tablerovisual[fila2-1][columna2+1]=='*')){

		   				tablerovisual[fila2-1][columna2+1]=tablero[fila2-1][columna2+1];
					}
					else if(tablero[fila2-1][columna2+1]=='0'&& (tablerovisual[fila2-1][columna2+1]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2+1;
						tablerovisual[fila2-1][columna2+1]=tablero[fila2-1][columna2+1];
						pila.push(aux2);
					}
					//caso7
					if((tablero[fila2-1][columna2]!='0') && (tablero[fila2-1][columna2]!='M') 
						&& (tablerovisual[fila2-1][columna2]!='F')&& (tablerovisual[fila2-1][columna2]=='*')){

		   				tablerovisual[fila2-1][columna2]=tablero[fila2-1][columna2];
					}
					else if(tablero[fila2-1][columna2]=='0'&& (tablerovisual[fila2-1][columna2]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2;
						tablerovisual[fila2-1][columna2]=tablero[fila2-1][columna2];
						pila.push(aux2);
					}
					//caso8
				
					if((tablero[fila2-1][columna2-1]!='0') && (tablero[fila2-1][columna2-1]!='M') 
						&& (tablerovisual[fila2-1][columna2-1]!='F')&& (tablerovisual[fila2-1][columna2-1]=='*')){

		   				tablerovisual[fila2-1][columna2-1]=tablero[fila2-1][columna2-1];
					}
					else if(tablero[fila2-1][columna2-1]=='0'&& (tablerovisual[fila2-1][columna2-1]=='*')){
						aux2[0]=fila2-1;
						aux2[1]=columna2-1;
						tablerovisual[fila2-1][columna2-1]=tablero[fila2-1][columna2-1];
						pila.push(aux2);
					}
				}
			}

		}
				
	}

	public static void imprimirtablero(){
		int filas = tablerovisual.length;
		int columnas = tablerovisual[0].length;

		for (int i=0;i<filas ;i++ ) {
            System.out.print("\t"+i);
        }
        System.out.println();
		for (int i=0;i<filas ;i++ ) {
			System.out.print(i + "\t");
            for (int j=0;j<columnas;j++ ) {
                System.out.print(tablerovisual[i][j] + "\t");
            }
            System.out.println();
        }
	}

	public static int destapados ()
	{
		int dest=0;
		for (int i=0;i<nfila;i++ ) {
            for (int j=0;j<mcolumna;j++ ) {
            	if ( tablerovisual [i][j]=='*' || tablerovisual [i][j]=='B' ) {
            		dest++;
            	}
               
            }
        }
        return dest;
	}

    public static void main(String[] args) {
    	int n=0,m=0, numbombas=0;
    	char op;
    	int nivel;
    	int fil,col;
    	Scanner reader= new Scanner(System.in);
   		System.out.println("Bienvenido a buscaminas.");
	    System.out.println("Niveles de dificultad");
	    System.out.println("1.Principiante 8x8 con 10 minas");
	    System.out.println("2.Principiante 16x16 con 40 minas");
	    System.out.println("3.Principiante 16x30 con 99 minas");
	    nivel=reader.nextInt();
	    if (nivel==1){
	    	n=8;
	    	m=8;
	    	numbombas=10;
	    }
	    if (nivel==2) {
	    	n=16;
	    	m=16;
	    	numbombas=40;
	    }
	    if (nivel==3){
	    	n=16;
	    	m=30;
	    	numbombas=99;
	    }
	    nfila=n;
	    mcolumna=m;
	    tablero= new char [n][m] ;
	    tablerovisual= new char [n][m] ;
	    tablero=buildMatriz("tablero.txt",n,m);
	   /* for (int i=0;i<n ;i++ ) {
            for (int j=0;j<m;j++ ) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }*/

   		for (int i=0;i<n;i++ ) {
            for (int j=0;j<m;j++ ) {
                tablerovisual [i][j]='*';
            }
        }
        int intentos=0;
        while(Perdiste==false || numbombas==destapados()){
        imprimirtablero();

        System.out.println("Ingresa una fila");
        fil=reader.nextInt();
	    System.out.println("Ingresa una columna");
	    col=reader.nextInt();
	    System.out.println("Deseas poner una bandera? S/N");
	    op=reader.next().charAt(0);
	    if (op=='S') {
	    	tablerovisual [fil][col]='F';
	    }
	    else
	    tirada(fil,col);
	    intentos++;

		}

		if (Perdiste==false) {
			System.out.println("Felicidades ganaste");
		}
		
    
   
}


} 
 