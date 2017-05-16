package br.pit.sd.lab1b.soquete;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer
{
    public static void main(String args[]) throws Exception
    {
        String clientSentence;
        String capitalizedSentence;
        String port = args.length > 0 ? args[0] : "5001";
        ServerSocket welcomeSocket = new ServerSocket(Integer.parseInt(port));
        System.out.println("Server started at port: " + port);

        while (true)
        {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            System.out.println("Received from client: " + clientSentence);
            capitalizedSentence = clientSentence.toUpperCase() + '\n';
            outToClient.writeBytes(capitalizedSentence);
            System.out.println("Received from client: " + clientSentence);
            if (clientSentence.equals("close"))
            {
                break;
            }
        }
        welcomeSocket.close();
    }
}
