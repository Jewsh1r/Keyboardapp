package sample.Controllers;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.Tables.Users;
import javafx.fxml.FXML;
import sample.Controllers.ConnectionUtil;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class AdminPanel  implements Initializable {

    @FXML
    private TableView<Users> table_users;

    @FXML
    private TableColumn<Users, Integer> column_users_id;

    @FXML
    private TableColumn<Users, String> column_users_login;

    @FXML
    private TableColumn<Users, String> column_users_name;

    @FXML
    private TableColumn<Users, String> column_users_surname;

    @FXML
    private TableColumn<Users, String> column_users_password;

    @FXML
    private TableColumn<Users, String> column_users_email;

    @FXML
    private TextField login_field;

    @FXML
    private TextField name_field;

    @FXML
    private TextField surname_field;

    @FXML
    private TextField password_field;

    @FXML
    private TextField email_field;
    @FXML
    private TextField id_field;
    @FXML
    private Label label_info;

    @FXML
    private Button button_add;

    @FXML
    private Button button_update;

    @FXML
    private Button button_delete;

    ObservableList<Users> listM;
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public void Select_user (MouseEvent event){
        index =table_users.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;

        }
        id_field.setText(column_users_id.getCellData(index).toString());
        login_field.setText(column_users_login.getCellData(index).toString());
        name_field.setText(column_users_name.getCellData(index).toString());
        surname_field.setText(column_users_surname.getCellData(index).toString());
        password_field.setText(column_users_password.getCellData(index).toString());
        email_field.setText(column_users_email.getCellData(index).toString());
    }
    public  void Add_users(){
        conn = ConnectionUtil.conDB();
        String sql = "insert into users (login,name,surname,password,email)values(?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, login_field.getText());
            pst.setString(2, name_field.getText());
            pst.setString(3, surname_field.getText());
            pst.setString(4, password_field.getText());
            pst.setString(5, email_field.getText());
            pst.execute();
            label_info.setTextFill(Color.GREEN);
            label_info.setText("Пользователь добавлен!");
            Update_Users_Table();

        }
        catch (Exception ex){
            label_info.setTextFill(Color.RED);
            label_info.setText(String.valueOf(ex));
        }
    }
public void Edit_users() {
    try {
        conn = ConnectionUtil.conDB();
        String id1 = id_field.getText();
        String login1 = login_field.getText();
        String name1 = name_field.getText();
        String surname1 = surname_field.getText();
        String password1 = password_field.getText();
        String email1 = email_field.getText();

        String sql = "update users set id= '"+id1+"', login= '"+login1+"', name= '"+name1+"',surname= '"+surname1+"',password= '"+password1+"',email= '"+email1+"' where id='"+id1+"'";



        pst = conn.prepareStatement(sql);
        pst.execute();
        label_info.setTextFill(Color.GREEN);
        label_info.setText("Данные изменены!");
        Update_Users_Table();

    }
    catch (Exception ex) {
        label_info.setTextFill(Color.RED);
        label_info.setText(String.valueOf(ex));

    }
}
    public void Delete_user(){
        conn = ConnectionUtil.conDB();
        String sql = "delete from users where id= ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, id_field.getText());
            pst.execute();
            label_info.setTextFill(Color.GREEN);
            label_info.setText("Данные удалены!");
            Update_Users_Table();
        }
        catch (Exception ex){
            label_info.setTextFill(Color.RED);
            label_info.setText(String.valueOf(ex));
        }

    }

    public void Update_Users_Table(){
        column_users_id.setCellValueFactory(new PropertyValueFactory<Users, Integer>("id"));
        column_users_login.setCellValueFactory(new PropertyValueFactory<Users, String>("login"));
        column_users_name.setCellValueFactory(new PropertyValueFactory<Users, String>("name"));
        column_users_surname.setCellValueFactory(new PropertyValueFactory<Users, String>("surname"));
        column_users_password.setCellValueFactory(new PropertyValueFactory<Users, String>("password"));
        column_users_email.setCellValueFactory(new PropertyValueFactory<Users, String>("email"));
        listM = ConnectionUtil.getDatausers();
        table_users.setItems(listM);

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Update_Users_Table();
    }
    public void BacktoBack(ActionEvent event) throws IOException {

                Parent SigInParrent = FXMLLoader.load(getClass().getResource("../View/SignIn.fxml"));
                Scene SignInScene = new Scene(SigInParrent);
                Stage SigInStage;
                SigInStage = (Stage)((Node)event.getSource()).getScene().getWindow();

                SigInStage.setScene(SignInScene);
                SigInStage.show();

            }


}
