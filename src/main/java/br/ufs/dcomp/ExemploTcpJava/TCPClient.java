/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient{
    public static void main(String[] args){
        try {
            //System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            //System.out.println("[OK] ]");
            
            while(true) {
                System.out.print("Você: ");
                Scanner teclado = new Scanner(System.in);
                String msg = teclado.nextLine();
                
                InputStream is = sock.getInputStream(); // Canal de entrada de dados
                OutputStream os = sock.getOutputStream(); // Canal de saída de dados
                //String msg = "Olá, DCOMP!!!";
                byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem

                //System.out.print("[ Enviando mensagem    ..............................  ");
                os.write(buf);
                //System.out.println("[OK] ]");
            
                // -------------------------------
                
                byte[] bufrec = new byte[50];
                is.read(bufrec); // Operação bloqueante (aguardando chegada de dados)
                String msgrec = new String(bufrec); // Mapeando vetor de bytes recebido para String
                System.out.println("Mensagem: "+ msgrec);
            }
            
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}