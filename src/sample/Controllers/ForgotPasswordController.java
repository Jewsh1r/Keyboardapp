package sample.Controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.xml.transform.Result;

public class ForgotPasswordController {


    @FXML
    private TextField Email_field;

    @FXML
    private Button signinbutton;

    @FXML
    private Button Singupbutton;

    @FXML
    private Button ResetCodeButton;

    @FXML
    private TextField Verifycode;

    @FXML
    private Button CheckCode;

    int RandomCode;


    public void ButtonResetAction(ActionEvent event) throws IOException, Exception {

        Random rand = new Random();
        RandomCode = rand.nextInt(999999);
        String host = "smtp.migadu.com";
        String user = "jewsh1r@1337.moscow";
        String password = "23121964Re";
        String recepient = Email_field.getText();
        String subject = "Reseting Code";
        String messagerand = "Your reset code is"+RandomCode;

        boolean sessionDebug = false;
        Properties pros = System.getProperties();
        pros.put("mail.smtp.starttls.enable", "true");
        pros.put("mail.smtp.host", host);
        pros.put("mail.smtp.port", "465");
        pros.put("mail.smtp.auth", "true");
        pros.put("mail.smtp.starttls.required", "true");

        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        };
    Session session = Session.getInstance(pros, auth);
    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress(user));
    InternetAddress[] toAddresses = { new InternetAddress(recepient) };
    msg.setRecipients(Message.RecipientType.TO, toAddresses);
    msg.setSubject(subject);
    msg.setSentDate(new Date());
    msg.setText(messagerand);

    Transport.send(msg);
    System.out.println("Work done message away");
    }


    public void SignInButtonAction(ActionEvent event) throws IOException {
        Parent SignInParent = FXMLLoader.load(getClass().getResource("../View/SignIn.fxml"));
        Scene SingInScene = new Scene(SignInParent);
        Stage SignInStage;
        SignInStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        SignInStage.setScene(SingInScene);
        SignInStage.show();

    }
    public void SignUpButtonAction(ActionEvent event) throws IOException {
        Parent SignUpParent = FXMLLoader.load(getClass().getResource("../View/SignUp.fxml"));
        Scene SingUpScene = new Scene(SignUpParent);
        Stage SignUpStage;
        SignUpStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        SignUpStage.setScene(SingUpScene);
        SignUpStage.show();

    }
}
