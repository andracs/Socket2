package hu.hungarian;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {



    public static void main(String[] args) {
        DataInputStream in;
        DataOutputStream out;

        System.out.println("Serveren er startet! Nissen går ned og lytter på port 8000.");
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            Socket socket = serverSocket.accept();
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

            System.out.println("Fordbindelse er modtaget på port 8000 via TCP, så det super!");

            //out.writeUTF("Hallo pølseven! Du har tilkoblet dig til den helt rigtige server.");
            //String besked = in.readUTF();
            // besked = in.readUTF();

            while (true) {
                String besked = in.readUTF();
                System.out.println("Modtaget besked: " + besked);
                //out.writeUTF("Jeg hører, hvad du siger, klientnisse. Du siger: " + besked);
            }

    } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println("Serveren er gået kold...");
    }
}
