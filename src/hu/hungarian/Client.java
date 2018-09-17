package hu.hungarian;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        // Connecter til serveren
        try {
            System.out.println("Tilkobler sig nu til serveren.");
            Socket socket = new Socket("127.0.0.1",8000);
            System.out.println("Er tilsluttet serveren.");

            DataOutputStream tilServer = new DataOutputStream(socket.getOutputStream());
            DataInputStream  fraServer = new DataInputStream(socket.getInputStream());

            // tilServer.writeUTF("Her er jeg, klientnissen Pøllemand.");

            while (true) {
                System.out.print( "Skriv en besked: ");
                Scanner scanner = new Scanner(System.in);
                String beskedTilServernissen = "";
                beskedTilServernissen = scanner.nextLine();
                tilServer.writeUTF(beskedTilServernissen);
                //System.out.println(fraServer.readUTF());
            }
        }

        catch (IOException e) {
            System.out.println("Fejl, kunne ikke forbinde til serveren. \n " + e);
        }
    }

}
