package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DataIN extends Thread {

	private DatagramSocket udpSocket;
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
		while (run == true) {
			try {
				udpSocket.receive(datagram);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Received!");
			System.out.println(run);
		}
	}
	
	public void stopThread() {
		run = false;
	}
	
	public void startThread() {
		run = true;
	}

	public byte[] getNewData() {
		return data;
	}
}
