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
	private InetSocketAddress inetSocket = null;
	private DatagramPacket datagram = null;

	public void buildDataPacket(String payloadString) {

	}
	
	public void sendData(String payloadString) {
		byte[] payload = payloadString.getBytes();
		try {
			datagram = new DatagramPacket(payload, payload.length, inetSocket);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			udpSocket.send(datagram);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setInetsocket(String ip) {
		inetSocket = new InetSocketAddress(ip, 52012);
	}

}
