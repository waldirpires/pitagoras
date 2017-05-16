package br.pit.sd.lab.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import br.pit.sd.lab.utils.NumberUtils;

/**
 * mvn clean compile exec:java -Dexec.mainClass="br.pit.sd.lab.udp.UdpClient" -Dexec.args="localhost 9867"
 * mvn clean compile exec:java -Dexec.mainClass="br.pit.sd.lab.udp.UdpServer" -Dexec.args="9867"
 * @author wrpires
 *
 */

class UdpServer
{
    public static void main(String args[]) throws Exception
    {
        if (args.length != 1 || !NumberUtils.isNumber(args[0]))
        {
            System.out.println("Usage: UDPServer <port>");
            System.exit(0);
        }

        DatagramSocket serverSocket = new DatagramSocket(Integer.parseInt(args[0]));
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while (true)
        {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            System.out.println("RECEIVED: " + sentence);
            System.out.println("INFO: receiving UDP packets from IP address " + IPAddress.getHostAddress() + "/" + IPAddress.getHostName());
            int port = receivePacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
            if (sentence.equals("close"))
            {
                System.out.println("INFO: closing UDP server socket.");
                break;
            }
        }
        serverSocket.close();
    }
}
