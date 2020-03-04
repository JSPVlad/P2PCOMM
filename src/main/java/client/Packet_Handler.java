package client;

import tools.Data_Object;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;

public class Packet_Handler {
	DatagramPacket datagramPacket;
	Packet_Handler(DatagramPacket datagramPacket) throws IOException, ClassNotFoundException {
		this.datagramPacket = datagramPacket;
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(datagramPacket.getData());
		ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Data_Object data_Object = (Data_Object) objectInputStream.readObject();
        String type = data_Object.getType();
        switch (type){
	        case "string":
	        	System.out.println("Message From "+data_Object.getSender()+"\nMessage :"+data_Object.getData());
	        	break;
	        case "file":
	        	System.out.println("File");
	        	break;
	        case "ACK":
	        	System.out.println("ACK received from "+datagramPacket.getAddress());
	        	break;
	        default:
	        	System.out.println("Invalid Data Recieved from "+datagramPacket.getAddress());
	        	break;
        }

	}
	public static void OnPacketReceived(){

	}
}
