package client;

import tools.Data_Object;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.TimerTask;

public class PushIp extends Thread{
	DatagramSocket datagramSocket;
	DatagramPacket ack;
	String Server_Address;
	Integer Server_Port;
	Boolean stop = false;


	PushIp(DatagramSocket datagramSocket, String Server_Address, Integer Server_Port) {
		this.datagramSocket = datagramSocket;
		this.Server_Address = Server_Address;
		this.Server_Port = Server_Port;
	}

	public void run() {
		Data_Object data_Object = new Data_Object("My_UserName", "update", "false", null, null, "My_Password",null);
		while (true && stop != true) {
			try {
				byte[] sending_data;
				ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(bytestream);
				objectOutputStream.writeObject(data_Object);
				sending_data = bytestream.toByteArray();
				datagramSocket.send(new DatagramPacket(sending_data, sending_data.length, InetAddress.getByName(Server_Address), Server_Port));

				Thread.sleep(5000);
			} catch (IOException e) {
				e.printStackTrace();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
