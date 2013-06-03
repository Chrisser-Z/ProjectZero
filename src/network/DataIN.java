package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DataIN extends Thread {

	DatagramSocket udpSocket = null;
	byte[] data = null;

	public DataIN() {
		try {
			udpSocket = new DatagramSocket(52012);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data = new byte[100];
	}

	DatagramPacket datagram = new DatagramPacket(data, data.length);

	public void run() {

		try {
			udpSocket.receive(datagram);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
