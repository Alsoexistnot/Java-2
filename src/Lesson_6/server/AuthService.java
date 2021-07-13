package Lesson_6.server;

import java.sql.*;
import java.util.Vector;

public class AuthService {
    private static Connection connection;
    private static Statement stmt;

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:main.db");
            stmt = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static String getNickByLoginAndPass(String login, String pass) {
//        String sql = String.format("SELECT nickname FROM users WHERE login = '%s' AND password = '%s'", login, pass);
//        try {
//            ResultSet rs = stmt.executeQuery(sql);
//            if (rs.next()) {
//                return rs.getString(1);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
//    }

    public static void addUser(String login, String pass, String nick) {
        try {
            String query = "INSERT INTO users (login, password, nickname) VALUES (?, ?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, login);
            ps.setInt(2, pass.hashCode());
            ps.setString(3, nick);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void addToBlacklist(int id, String nickname) {
        try {
            String query = "INSERT INTO blacklist (users_id, blacklist_nick) VALUES (?, ?);";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.setString(2, nickname);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static String getNickByLoginAndPass(String login, String pass) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT nickname, password FROM users WHERE login = '" + login + "'");
            int myHash = pass.hashCode();
            // 106438208
            if (rs.next()) {
                String nick = rs.getString(1);
                int dbHash = rs.getInt(2);
                if (myHash == dbHash) {
                    return nick;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isNicknameExists(int id) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT nickname FROM users WHERE id = '" + id + "'");
            String temp = rs.getString("nickname");
            if (temp != null) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return false;
    }

    public static boolean isNicknameExistsInBlacklist(int id, String nick) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT blacklist_nick FROM blacklist WHERE id = '" + id + "'");
           while (rs.next()){
                String temp = rs.getString("blacklist_nick");
                if (nick.equals(temp)){
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return false;
    }


    public static int getIdByNickname(String nickname) {
        try {
            ResultSet rs = stmt.executeQuery("SELECT id FROM users WHERE nickname = '" + nickname + "'");
            return rs.getInt("id");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
