package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class DataOUT {

	public DataOUT() {
		try {
			udpSocket = new DatagramSocket(52013);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private DatagramSocket udpSocket = null;
	private InetSocketAddress inetSocket = new InetSocketAddress("127.0.0.1", 52012);
	private DatagramPacket datagram = null;

	public void buildDataPacket(byte[] payload) {
		try {
			datagram = new DatagramPacket(payload, payload.length, inetSocket);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendData() {
		try {
			udpSocket.send(datagram);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
