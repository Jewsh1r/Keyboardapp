package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class SignInController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Email_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signinbutton;

    @FXML
    private Button forgotpasswordbutton;

    @FXML
    private Button Singupbutton;
    @FXML
    private Button Admin;

    @FXML
    private Label lblErrors;
    @FXML
    private Label lbl_close;

    public void ChangeScreenButtonPushedSignUp(ActionEvent event) throws IOException {
       Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/SignUp.fxml"));
       Scene SingUpScene = new Scene(SignUpParent);
       Stage SignUpStage;
       SignUpStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

   }
    public void ForgotPasswordButtonAction(ActionEvent event) throws IOException {
        Parent ForgotPasswordParent = FXMLLoader.load(getClass().getResource("../View/ForgotPasswordController.fxml"));
        Scene ForgotPasswordScene = new Scene(ForgotPasswordParent);
        Stage ForgotPasswordStage;
        ForgotPasswordStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        ForgotPasswordStage.setScene(ForgotPasswordScene);
        ForgotPasswordStage.show();

    }
    public void SigInhandlebuttonaction(ActionEvent event) throws IOException {

        if (event.getSource() == lbl_close){
            System.exit(0);

        }
        if (event.getSource() == signinbutton){
            if(SignIn().equals("Success"))
            {


                    Parent SigInParrent = FXMLLoader.load(getClass().getResource("../View/Keyboard.fxml"));
                    Scene SignInScene = new Scene(SigInParrent);
                    Stage SigInStage;
                    SigInStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    SigInStage.setResizable(false);
                    SigInStage.setScene(SignInScene);
                    SigInStage.show();

            };
        }
    }

    public SignInController()
    {
        con = ConnectionUtil.conDB();
    }
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public  void Adminhandle(ActionEvent event) throws IOException {
    String email = Email_field.getText().toString();
    System.out.println(email);
        if (event.getSource() == lbl_close) {
            System.exit(0);

        }
        if(Objects.equals(email, "admin@1337.moscow")) {
        if (event.getSource() == Admin ) {
            if (SignIn().equals("Success")) {

                Parent AdminMenu = FXMLLoader.load(getClass().getResource("../View/AdminPanel.fxml"));
                Scene AdminMenuScene = new Scene(AdminMenu);
                Stage AdminMenuStage;
                AdminMenuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                AdminMenuStage.setScene(AdminMenuScene);
                AdminMenuStage.show();
            }
            }
        }
    }
    private String SignIn(){

    String email = Email_field.getText().toString();
    String password = password_field.getText().toString();
    String sql = "SELECT * FROM users WHERE Email = ? and password =?";

        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
            {
                lblErrors.setTextFill(Color.RED);
                lblErrors.setText("Неверная почта/пароль");
                //System.err.println("Wrong Logins");
                return "Error";
            }
            else
                {
                    lblErrors.setTextFill(Color.GREEN);
                    lblErrors.setText("Успех");
                    //'System.out.println("Succssesfull");
                    return "Success";
                }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return "Exception";
        }

    }


    }



