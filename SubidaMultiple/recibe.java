import java.net.*;
import java.io.*;
public class recibe {
  public static void main(String [] args){
    try {
      int pto = 9000;
      ServerSocket s = new ServerSocket(pto);
      System.out.println("Servidor listo, esperando clientes...");
      for(;;){
        Socket cl = s.accept();
        DataInputStream dis = new DataInputStream(cl.getInputStream());
        String nombre = dis.readUTF();
        long tam = dis.readLong();
        System.out.println("Preparando para recibir el archivo: " +  nombre + " desde: " + cl.getInetAddress() + ":" + cl.getPort());
        long r = 0;
        int n = 0, porcentaje = 0;
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(nombre));
        while(r < tam){
          byte[] b = new byte[2000];
          n = dis.read(b);
          r = r + n;
          dos.write(b,0,n);
          dos.flush();
          porcentaje = (int)((r*100) / tam);
          System.out.println("Se ha recibido " + porcentaje + "%");
        }
        dis.close();
        dos.close();
        System.out.println("Se completó la descarga");
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
