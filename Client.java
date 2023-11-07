import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Client {
    public static void main(String args[]) throws IOException {
        String host = "localhost";
        int port = 8080;

        Socket socket = new Socket(host, port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("John");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = in.readLine();

        System.out.println("Получен ответ от сервера: " + response);

        socket.close();
    }
}
