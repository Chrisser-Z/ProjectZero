package core;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public  class DataOUT {
	
	private  DatagramSocket udpSocket; 
	private  InetSocketAddress inetSocket;
	private  DatagramPacket datagram;

	public DataOUT() {
		try {
			udpSocket  = new DatagramSocket(52013);
			inetSocket = new InetSocketAddress("127.0.0.1", 52012); 
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public  void sendData(byte[] data) {
		try {
			datagram = new DatagramPacket(data, data.length, inetSocket);
			udpSocket.send(datagram);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setInetsocket(String ip) {
		inetSocket = new InetSocketAddress(ip, 52012);
	}

}
