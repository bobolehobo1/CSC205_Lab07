package model;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.geometry.*;
import javafx.stage.*;
import views.LoginView;

public class Invoice extends Application {

    @Override
    public void start(Stage Window) {
        // invoke loginView
        loginView(Window);

        // invoke invoiceView
        invoiceView(Window);

        Window.show();
    }

    public void loginView(Stage Window) {   // this is my idea but i'm not sure yet!
        // LoginView ----------------------------------------------------------------------
        LoginView loginView = new LoginView();
        Scene scene1 = new Scene(loginView);
        Window.setScene(scene1);
    }

    public void invoiceView(Stage Window) {
        // Invoice View -------------------------------------------------------------------
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

        gPane.add(new Label("Shirts"), 0, 0);        gPane.add(shirtsTF, 1, 0);
        gPane.add(new Label("Pants"), 0, 1);         gPane.add(pantsTF, 1, 1);
        gPane.add(new Label("Ties"), 0, 2);          gPane.add(tiesTF, 1, 2);
        gPane.add(new Label("Shoes"), 0, 3);         gPane.add(shoesTF, 1, 3);
        gPane.add(new Label("Sales Tax"), 0, 4);     
        // ComboBox for Sales Tax
        ComboBox<Double> cmb = new ComboBox<>();
        for (double i = 3.00; i <= 9.5; i += 0.25) {cmb.getItems().add(i);}
        
        gPane.add(new Label("Total Bill"), 0, 5);    gPane.add(cmb, 1, 4);

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
            gPane.add(new Text(total), 1, 5);
        });
        backBT.setOnAction(e -> {loginView(Window);});

        // Add Buttons into vBox
        vBox.getChildren().addAll(calculateBT, backBT);

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
