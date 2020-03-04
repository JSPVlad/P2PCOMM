package server;

import tools.Data_Object;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Packet_Handler {
	DatagramPacket datagramPacket;
	DatagramSocket datagramSocket;
	Packet_Handler(DatagramPacket datagramPacket, DatagramSocket datagramSocket) throws IOException, ClassNotFoundException {
		this.datagramPacket = datagramPacket;
		this.datagramSocket = datagramSocket;
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(datagramPacket.getData());
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
		Data_Object data_Object = (Data_Object) objectInputStream.readObject();
		String type = data_Object.getType();
		switch (type) {
			case "string":
				System.out.println("Message From " + data_Object.getSender() + "\nMessage :" + data_Object.getData());
				break;
			case "file":
				System.out.println("File");
				break;
			case "update":
				System.out.println("Recieved Ip Update from " + datagramPacket.getAddress());
				send_ACK();
				System.out.println("Ack Sent");
				break;
			default:
				System.out.println("Invalid Data Recieved from " + datagramPacket.getAddress() + data_Object.getData());
				break;
		}
	}
	private void send_ACK() throws IOException {
		datagramSocket.send(getACKDatagramPacket());
	}
	private DatagramPacket getACKDatagramPacket() throws IOException {
		Data_Object data_object = new Data_Object("MainServer","ACK",null,null,null,"Data Received !",null);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		objectOutputStream.writeObject(data_object);
		byte[] ack_data = byteArrayOutputStream.toByteArray();
		return new DatagramPacket(ack_data,ack_data.length,datagramPacket.getAddress(),datagramPacket.getPort());
	}

}
