package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.sound.midi.SysexMessage;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Signup_surname;

    @FXML
    private TextField Signup_Login;

    @FXML
    private PasswordField Signup_Password;

    @FXML
    private Button Signup_button;

    @FXML
    private Button Singup_button;

    @FXML
    private PasswordField Signup_PasswordRepeat;

    @FXML
    private TextField Signup_name;

    @FXML
    private TextField Signup_Email;
    @FXML
    private Label lblStatus;


    @FXML
    public void ChangeScreenButtonPushedSignIn(ActionEvent event) throws IOException {
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/SignIn.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }


    public SignUpController()
    {
        con = ConnectionUtil.conDB();
    }
    Connection con = null;
    PreparedStatement preparedStatement;
    ResultSet resultSet = null;
    public boolean validateEmail(){
        boolean isValid = false;
        try {
            InternetAddress internetAddress = new InternetAddress(Signup_Email.getText(), true); // strict
            internetAddress.validate();
            isValid = true;
        } catch (AddressException e) {
            System.out.println("Bad eMail address: " + Signup_Email.getText());

        }

        return isValid;
    }

    @FXML
    private void RegisterButtonAction(ActionEvent event) throws IOException{


        if(validateEmail() == true) {
            if (Signup_Login.getText().isEmpty() || Signup_surname.getText().isEmpty() || Signup_surname.getText().isEmpty() || Signup_Password.getText().isEmpty() || Signup_PasswordRepeat.getText().isEmpty()) {
                lblStatus.setTextFill(Color.RED);
                lblStatus.setText("Enter all details");

            } else {
                if (Signup_PasswordRepeat.getText().toString().equals(Signup_Password.getText().toString())) {

                    saveData();
                    Parent SigInParrent = FXMLLoader.load(getClass().getResource("../View/Keyboard.fxml"));
                    Scene SignInScene = new Scene(SigInParrent);
                    Stage SigInStage;
                    SigInStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    SigInStage.setScene(SignInScene);
                    SigInStage.show();

                } else {
                    lblStatus.setTextFill(Color.RED);
                    lblStatus.setText("Wrong passwords");
                }

            }
        }
        else {
            lblStatus.setTextFill(Color.RED);
            lblStatus.setText("Wrong email");
        }
    }

    private String saveData() {

        try {
            String AddNewUserSql = "INSERT INTO users (login, name, surname, password, Email) VALUES (?,?,?,?,?)";
            preparedStatement = (PreparedStatement) con.prepareStatement(AddNewUserSql);
            preparedStatement.setString(1, Signup_Login.getText());
            preparedStatement.setString(2, Signup_name.getText());
            preparedStatement.setString(3, Signup_surname.getText());
            preparedStatement.setString(4, Signup_Password.getText());
            preparedStatement.setString(5, Signup_Email.getText());

            preparedStatement.executeUpdate();
            lblStatus.setTextFill(Color.GREEN);
            lblStatus.setText("Added Susccsesfuly");
            return "Success";

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            lblStatus.setTextFill(Color.RED);
            lblStatus.setText(ex.getMessage());
            return "Exception";
        }

    }
}
