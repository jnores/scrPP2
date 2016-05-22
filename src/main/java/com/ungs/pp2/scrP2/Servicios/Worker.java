package com.ungs.pp2.scrP2.Servicios;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Worker implements Runnable
{
      private Socket client;

Worker(Socket client) 
{
   this.client = client;
}

public void run()
{

   DataInputStream dataCliente = null;
   try
   {
      dataCliente = new DataInputStream(client.getInputStream()); //Obteno el input stream del socket cliente
     //in = new BufferedReader(new InputStreamReader(client.getInputStream()));
     //out = new PrintWriter(client.getOutputStream(), true);
   } catch (IOException e) {
     System.out.println("in or out failed");
     System.exit(-1);
   }
   try
   {
      String from = dataCliente.readUTF();
      String pass = dataCliente.readUTF();
      String to = dataCliente.readUTF();
      String subject = dataCliente.readUTF();
      String body = dataCliente.readUTF();
        
      new Mail(from, pass, to, subject, body); //envio mail con los datos del socket cliente
        
        
      //Send data back to client
      //out.println(line);
      //Append data to text area
      // textArea.append(line);
      dataCliente.close(); // cierro el input strem socket
      }catch (IOException e) 
      {
         e.printStackTrace();
      }catch (Exception e)
      {
         //devolver error al socket cliente
      }

}

}
