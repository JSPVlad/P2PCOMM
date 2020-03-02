package client;
import tools.Data_Object;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.Timer;


public class Main_Client {
    public static void main(String[] args) {
        try {

            DatagramSocket datagramSocket = new DatagramSocket(7070);

            PushIp pushIp = new PushIp(datagramSocket,"localhost",6969);
            pushIp.start();

            byte[] receive_data = new byte[8192];
            while(true){
                DatagramPacket datagramPacket = new DatagramPacket(receive_data, receive_data.length);
                datagramSocket.receive(datagramPacket);
                Packet_Handler packet_handler = new Packet_Handler(datagramPacket);
                for(int i = 0 ; i < receive_data.length ; i ++){
                    receive_data[i] = 0 ;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}