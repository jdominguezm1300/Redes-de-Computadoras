import java.net.*;
import java.io.*;
import java.util.Scanner;
public class Cliente {


    public static void main(String[] args) {
        try
        {
            int pto=10004;
            int nivel;
	        char option;
            String host="127.0.0.1";
            Scanner reader= new Scanner(System.in);
            Socket cl= new Socket(host,pto);
            DataInputStream s_read;
			DataOutputStream s_write;
            System.out.println("Conexion con servidor establecida ... recibiendo informacion");
            s_write = new DataOutputStream (cl.getOutputStream ());
      		s_read = new DataInputStream (cl.getInputStream ());

	        do {
          int c = s_read.readInt();
          c = Integer.reverseBytes(c);
          System.out.println("RECIBIDO " + c);
	       	System.out.println("Bienvenido a buscaminas.");
	       	System.out.println("Niveles de dificultad");
	       	System.out.println("1.Principiante 8x8 con 10 minas");
	       	System.out.println("2.Principiante 16x16 con 40 minas");
	       	System.out.println("3.Principiante 16x30 con 99 minas");
	        nivel=reader.nextInt();
          nivel = Integer.reverseBytes(nivel);
	        s_write.writeInt(nivel);
          s_write.flush();
	        long r = 0;
	        int tam=s_read.readInt();
          tam = Integer.reverseBytes(tam);
	        System.out.println(tam);
	       	int n = 0, porcentaje = 0;
	        DataOutputStream dos = new DataOutputStream(new FileOutputStream("Tablero.txt"));
	        while(r < tam){
	          byte[] b = new byte[1024];
	          n = s_read.read(b);
	          r = r + n;
	          dos.write(b,0,n);
	          dos.flush();
	        }
	        System.out.println("Si desea Jugar de nuevo presione S ");
	        option=reader.next().charAt(0);

	        }while(option=='S');

              s_write.writeInt(Integer.reverseBytes(1));
              s_write.flush();
              s_write.writeUTF("Charly");
              s_write.flush();
              s_write.writeInt(Integer.reverseBytes(10));
	            cl.close();

	        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
