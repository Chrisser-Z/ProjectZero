package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DataIN extends Thread {

	private DatagramSocket udpSocket = null;
	private byte[] data = new byte[100];
	private DatagramPacket datagram = new DatagramPacket(data, data.length);
	private boolean run = true;

	public DataIN() {
		try {
			udpSocket = new DatagramSocket(52012);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (run) {
			try {
				udpSocket.receive(datagram);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(new String(data));
		}
	}
	
	public void stopThread() {
		run = false;
	}

	public byte[] getNewData() {
		return data;
	}
}
