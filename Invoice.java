import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;


public class Invoice extends Application {

    @Override
    public void start(Stage Window) {


        //create nodes-----------------------------------
        //-pane
        GridPane Gpane = new GridPane();
        //-TextFields
        TextField shirtField = new TextField();
        TextField pantsField = new TextField();
        TextField tiesField = new TextField();
        TextField shoesField = new TextField();
        TextField salestaxField = new TextField();
        TextField totalbillField = new TextField();
        //-Buttons
        Button calculateBT = new Button("Calculate");
        Button backBT = new Button("Back"); 
        //------------------------------------------------
        

        //configure nodes--------------------------------------------------------------------------------------------------------
        Scene scene = new Scene(Gpane);
        Gpane.add(new Label("Shirts"), 0, 0); Gpane.add(shirtField, 1, 0);
        Gpane.add(new Label("Pants"), 0, 1); Gpane.add(pantsField, 1, 1);
        Gpane.add(new Label("Ties"), 0, 2); Gpane.add(tiesField, 1, 2);
        Gpane.add(new Label("Shoes"), 0, 3); Gpane.add(shoesField, 1, 3);
        Gpane.add(new Label("Sales Tax"), 0, 4); Gpane.add(salestaxField, 1, 4);
        Gpane.add(new Label("Total Bill:"), 0, 5); Gpane.add(totalbillField, 1, 5);
        //-----------------------------------------------------------------------------------------------------------------------
        
        
        //display nodes-------------
        Window.setScene(scene);
        Window.show();
        //--------------------------

    }
    //main method---------------------------
    public static void main(String[] args) {
        launch();
    }
    //--------------------------------------
}
