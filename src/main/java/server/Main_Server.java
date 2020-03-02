package server;

import tools.Data_Object;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.*;
public class Main_Server{
    public static void main(String[] args){
        try {
            DatagramSocket datagramSocket = new DatagramSocket(6969);
            byte[] receive_data = new byte[8192];
            while(true){
                DatagramPacket datagramPacket = new DatagramPacket(receive_data,receive_data.length);
                datagramSocket.receive(datagramPacket);
                Packet_Handler packet_handler = new Packet_Handler(datagramPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}