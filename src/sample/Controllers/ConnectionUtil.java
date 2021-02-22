package sample.Controllers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Tables.Users;

import java.sql.*;

public class ConnectionUtil {

    Connection conn = null;
    public static Connection conDB()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/keyboardapp", "root", "1337.moscow");
            System.out.println("WORK");
            return con;
        } catch (Exception ex) {
            System.err.println("ConnectionUtil: "+ex.getMessage());
            return null;
        }

    }
    public static ObservableList<Users> getDatausers(){
        Connection conn = conDB();
        ObservableList<Users>list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Users(Integer.parseInt(rs.getString("id")),
                        rs.getString("login"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("password"),
                        rs.getString("email")));
            }
        } catch (Exception ex) {
            System.err.println("ConnectionUtil: "+ex.getMessage());
        }
        return list;
    }

}
