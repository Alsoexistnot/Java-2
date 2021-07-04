import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MainServ {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.startServer();
        server.clientConnection();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    String text = null;
                    try {
                        text = server.in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (text.equals("/end")) {
                        try {
                            server.close();
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    } else if (text != null) {
                        System.out.println("Client: " + text);
                    }
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    server.writeToConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread1.start();

    }
}


class Server {
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    BufferedReader in = null;
    PrintWriter out = null;
    private BufferedReader console = null;


    void startServer() {
        try {
            serverSocket = new ServerSocket(8189);
            System.out.println("Сервер подключен!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void clientConnection() throws IOException {
        try {
            socket = serverSocket.accept();
            System.out.println("Клиент подключился!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    void close() throws IOException {
        in.close();
        out.close();
        socket.close();
        serverSocket.close();
    }

    void writeToConsole() throws IOException {
        while (true) {
            console = new BufferedReader(new InputStreamReader(System.in));
            String text = console.readLine();
            out.println("Server: " + text);
        }
    }
}
