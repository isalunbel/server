import java.io.*;
import java.net.*;

class Server {
    public static void main(String args[]) throws IOException {
        int port = 8080;

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Порт сервера: " + port);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Новое соединение установлено");

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String name = in.readLine();
        System.out.println("Получено сообщение от клиента: " + name);

        out.println(String.format("Привет, %s, номер вашего порта: %d", name, clientSocket.getPort()));

        serverSocket.close();
    }
}
