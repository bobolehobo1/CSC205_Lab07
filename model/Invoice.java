package model;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.geometry.*;
import javafx.stage.*;
import java.util.*;

import views.LoginView;

public class Invoice extends Application {

    @Override
    public void start(Stage Window) {
        // invoke loginView
        //loginView(Window);

        // invoke invoiceView
        invoiceView(Window);

        Window.show();
    }

    /*
    // LoginView ----------------------------------------------------------------------
    public void loginView(Stage Window) {   // this is my idea but i'm not sure yet!
        
        LoginView loginView = new LoginView();
        Scene scene1 = new Scene(loginView);
        Window.setScene(scene1);

        // invoke processLogin()
    }

    public void processLogin(Properties props) {

        // the list of authorized users (ArrayList)
        ArrayList<AccountHolder> accounts = new ArrayList<>();

        accounts.add(new AccountHolder("trao", "RaoT1", "T M Rao"));
        accounts.add(new AccountHolder("smitra", "MitraS1", "S Mitra"));
        accounts.add(new AccountHolder("mcoleman", "Melissa1", "M Coleman"));
        accounts.add(new AccountHolder("smitra", "MitraS1", "S Mitra"));
        accounts.add(new AccountHolder("rnsmith", "Rebekah1", "R Smith"));

        // looking through the list of authorized users and logging in
        String un = props.getProperty("ID");
        boolean userFound = false;
        for (int i = 0; i < accounts.size(); i++) {
            String unInList = accounts.get(i).username;
            if (unInList.equals(un)) {
                String pwSent = props.getProperty("Password");
                String uPwd = accounts.get(i).password;
                if (uPwd.equals(pwSent)) {
                    userFound = true;
                    break;
                }
            }
        }
        if (userFound) {    // login successfully

        }
        else {
            loginView.updateState("LoginError", "Login failed!");
        }
    }

    */

    // Invoice View -------------------------------------------------------------------
    public void invoiceView(Stage Window) {

        // VBox - containing the Text (title), GridPane (TextField), and Buttons
        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);

        // Text
        vBox.getChildren().add(new Text("Mom and Pop’s Clothing Store"));

        // GridPane
        GridPane gPane = new GridPane();

        // TextField
        TextField shirtsTF = new TextField();
        TextField pantsTF = new TextField();
        TextField tiesTF = new TextField();
        TextField shoesTF = new TextField();
        TextField billTF = new TextField();
        billTF.setEditable(false);

        gPane.add(new Label("Shirts"), 0, 0);        gPane.add(shirtsTF, 1, 0);
        gPane.add(new Label("Pants"), 0, 1);         gPane.add(pantsTF, 1, 1);
        gPane.add(new Label("Ties"), 0, 2);          gPane.add(tiesTF, 1, 2);
        gPane.add(new Label("Shoes"), 0, 3);         gPane.add(shoesTF, 1, 3);
        gPane.add(new Label("Sales Tax"), 0, 4);
        // ComboBox for Sales Tax
        ComboBox<Double> cmb = new ComboBox<>();
        for (double i = 3.00; i <= 9.5; i += 0.25) {cmb.getItems().add(i);}
        gPane.add(cmb, 1, 4);

        gPane.add(new Label("Total Bill"), 0, 5);    gPane.add(billTF, 1, 5);

        // Add TextField into vBox
        vBox.getChildren().add(gPane);

        // Buttons
        Button calculateBT = new Button("Calculate");
        Button backBT = new Button("Back");

        calculateBT.setOnAction(e -> {
            String total="0.00";
            total = Double.parseDouble(shirtsTF.getText())
                + Double.parseDouble(pantsTF.getText()) 
                + Double.parseDouble(tiesTF.getText()) 
                + Double.parseDouble(shoesTF.getText())
                + cmb.getValue()
                + "";
            billTF.setText(total);
            gPane.add(billTF, 1, 5);
        });
        //backBT.setOnAction(e -> {loginView(Window);});

        // Add Buttons into vBox
        
        vBox.getChildren().addAll(new HBox(calculateBT, backBT));

        // Display nodes
        Scene scene2 = new Scene(vBox);
        Window.setScene(scene2);
    }

    // main method---------------------------
    public static void main(String[] args) {
        launch();
    }
    // --------------------------------------
}
