package br.pit.sd.lab1b.soquete;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TcpClient
{
    public static void main(String argv[]) throws Exception
    {
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        String server = argv[0];
        String port = argv[1];
        Socket clientSocket = new Socket(server, Integer.parseInt(port));
        System.out.println("Connecting to server: " + server + ":" + port);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');
        System.out.println("Sent to server: " + sentence);
        modifiedSentence = inFromServer.readLine();
        System.out.println("Received from server: " + modifiedSentence);
        clientSocket.close();
    }
}
