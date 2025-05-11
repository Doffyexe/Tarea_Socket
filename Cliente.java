import java.awt.Container;
import java.io.*;
import java.net.*;
import javax.swing.*;
class TCPClient {
 public static void main(String argv[]) throws Exception
 {
 // Crear la ventana principal
    JFrame.setDefaultLookAndFeelDecorated(true);
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    UIManager.put("swing.boldMetal", Boolean.FALSE);
  JFrame frame = new JFrame("Cálcular la nota fina del curso de calculo ");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    Container contentPane = frame.getContentPane();
    contentPane.setLayout(null);

    JLabel labelTitulo = new JLabel("Ingrese la nota final del curso de calculo:");
    labelTitulo.setBounds(10, 10, 300, 20);
    contentPane.add(labelTitulo);

    JLabel  label_P1 = new JLabel("NIngrese del parcial #1:");
    label_P1.setBounds(10, 40, 300, 20);



    
 String sentence;
 String modifiedSentence;
 BufferedReader inFromUser =
 new BufferedReader(new InputStreamReader(System.in));
 Socket clientSocket = new Socket("hostname", 6789);
 DataOutputStream outToServer =
 new DataOutputStream(clientSocket.getOutputStream());
 BufferedReader inFromServer =
 new BufferedReader(new
 InputStreamReader(clientSocket.getInputStream()));
 sentence = inFromUser.readLine();
 outToServer.writeBytes(sentence + '\n');
 modifiedSentence = inFromServer.readLine();
 System.out.println("FROM SERVER: " + modifiedSentence);
 clientSocket.close();

 }
}
