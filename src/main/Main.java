package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main("main.Main");
	}

	private Socket socketcito;
	private BufferedReader reader;

	private int r, g, b;
	private int posX, posY;

	private String mov;

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		background(255);
		initServer();
	}

	public void draw() {
		background(255);

		fill(r, g, b);
		ellipse(posX, posY, 20, 20);
	}

	public void initServer() {
		new Thread(

				() -> {
					try {
						// Paso 1: Esperar una conexion
						ServerSocket server = new ServerSocket(2021);
						System.out.println("Esperando conexión....");
						socketcito = server.accept();
						// Paso 3: Cliente y Server conectados
						System.out.println("Cliente conectado!!!");

						InputStream is = socketcito.getInputStream();
						InputStreamReader isr = new InputStreamReader(is);

						OutputStream os = socketcito.getOutputStream();
						BufferedReader reader = new BufferedReader(isr);

						while (true) {
							System.out.println("Esperando mensaje....");
							String line = reader.readLine();
							System.out.println("Recibido: " + line);

						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

		).start();
	}

	public void movBol(String msg) {
		switch (mov) {
		case "up":

			break;
			
		case "down":

			break;
			
		case "right":

			break;
			
		case "left":

			break;

		default:
			break;
		}
	}
}
