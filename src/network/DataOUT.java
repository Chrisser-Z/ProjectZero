package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public abstract class DataOUT {

	public DataOUT() {
		
	}

	static {
		try {
			udpSocket = new DatagramSocket(52013);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static DatagramSocket udpSocket;
	private static InetSocketAddress inetSocket;
	private static DatagramPacket datagram;

	public void buildDataPacket(String payloadString) {

	}

	public static void sendData(String payloadString) {
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

	public static void setInetsocket(String ip) {
		inetSocket = new InetSocketAddress(ip, 52012);
	}

}
