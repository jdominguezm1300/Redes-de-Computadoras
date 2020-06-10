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
