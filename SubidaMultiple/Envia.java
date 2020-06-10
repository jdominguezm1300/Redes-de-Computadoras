import javax.swing.JFileChooser;
import java.io.*;
import java.net.*;

public class Envia {
  public static void enviarArchivos(JFileChooser jf, File f, Socket cl){
    try {
      System.out.println("Iniciando envio con socket " + cl);
      String nombre = f.getName();
      long tam = f.length();
      String path = f.getAbsolutePath();
      System.out.println("Reparando para enviar archivo: " + path + " de " + tam + " bytes");
      long e = 0;
      int n = 0, porcentaje = 0;
      DataOutputStream dos = new DataOutputStream(cl.getOutputStream());
      DataInputStream dis = new DataInputStream(new FileInputStream(path));

        dos.writeUTF(nombre);
        dos.flush();
        dos.writeLong(tam);
        dos.flush();

      while(e < tam){
        byte[] b = new byte[2000];
        n = dis.read(b);
        e = e + n;
        dos.write(b,0,n);
        dos.flush();
        porcentaje = (int)((e*100) / tam);
        System.out.print("\r Enviando " + porcentaje + "%");
      }
      System.out.println("\n Archivo enviado");
      dis.close();
      dos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args){
    try {
      int pto = 9000;
      String host = "127.0.0.1";
      //Socket cl = new Socket(host,pto);
      System.out.println("Conexión establecida...mostrando caja de diálogo");
      JFileChooser jf = new JFileChooser();
      jf.setMultiSelectionEnabled(true);
      jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      int r = jf.showOpenDialog(null);
      if(r == JFileChooser.APPROVE_OPTION){
        System.out.println("Slection mode: " + jf.getFileSelectionMode());
        System.out.println("Modo de selección activo " + jf.isMultiSelectionEnabled() + " and " + jf.isDirectorySelectionEnabled());
        File[] f = jf.getSelectedFiles();
        for(int i = 0; i < f.length ; i++){
          Socket cl = new Socket(host,pto);
          DataOutputStream dos = new DataOutputStream(cl.getOutputStream());
          System.out.println("Socket " + cl);
          enviarArchivos(jf, f[i], cl);
          System.out.println("Iniciando envio con socket " + cl);
          cl.close();
        }
        //System.out.println("Cerrando Socket....");
      }
      //cl.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
