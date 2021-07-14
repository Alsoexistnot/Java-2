package Lesson_6.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MainServ {
    private Vector<ClientHandler> clients;

    public MainServ() {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            AuthService.connect();
//            AuthService.addUser("login1", "pass1", "nick1");
//            AuthService.addUser("login2", "pass2", "nick2");
//            AuthService.addUser("login3", "pass3", "nick3");

            server = new ServerSocket(8400);
            System.out.println("Сервер запущен!");
            while (true) {
                //String login = AuthService.getNickByLoginAndPass("login1", "pass1");
                socket = server.accept();
                System.out.println("Клиент подключился!");
                new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
        broadcastClientsList();
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
        broadcastClientsList();
    }

    public void broadcastMsg(ClientHandler from, String msg, String nick) {
        for (ClientHandler o : clients) {
            if (!AuthService.isNicknameExistsInBlacklist(AuthService.getIdByNickname(o.getNick()), nick)) {
                o.sendMsg(msg);
            }
        }
    }

    public boolean isNickBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public void sendPersonalMsg(ClientHandler from, String nickTo, String msg, String nick) {
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nickTo)) {
                if (!AuthService.isNicknameExistsInBlacklist(AuthService.getIdByNickname(o.getNick()), nick)) {
                    o.sendMsg("from " + from.getNick() + ": " + msg);
                    from.sendMsg("to " + nickTo + ": " + msg);
                    return;
                }
            }
        }
        from.sendMsg("Клиент с ником " + nickTo + " не найден в чате, либо Вы у него в черном списке");
    }

    public void broadcastClientsList() {
        StringBuilder sb = new StringBuilder();
        sb.append("/clientslist ");
        for (ClientHandler o : clients) {
            sb.append(o.getNick() + " ");
        }
        String out = sb.toString();
        for (ClientHandler o : clients) {
            o.sendMsg(out);
        }
    }

    public Vector<ClientHandler> getClients() {
        return clients;
    }
}
