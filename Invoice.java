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
        VBox Vpane = new VBox();
        //-TextFields
        TextField shirtField = new TextField();
        TextField pantsField = new TextField();
        TextField tiesField = new TextField();
        TextField shoesField = new TextField();
        TextField salestaxField = new TextField();
        TextField totalbillField = new TextField();
        //-TextField Labels
        Label shirtLabel = new Label("Shirts");
        Label pantsLabel = new Label("Pants");
        Label tiesLabel = new Label("Ties");
        Label shoesLabel = new Label("Shoes");
        Label salestaxLabel = new Label("Sales Tax");
        Label totalbillLabel = new Label("Total Bill:");
        //-Buttons
        Button calculateBT = new Button();
        Button backBT = new Button(); 
        //------------------------------------------------
        

        //configure nodes--------------------------------------------------------------------------------------------------------
        Scene scene = new Scene(Vpane);
        Vpane.getChildren().addAll(shirtField, pantsField, tiesField, shoesField, salestaxField, totalbillField, shirtLabel, pantsLabel, tiesLabel, shoesLabel, salestaxLabel, totalbillLabel, calculateBT, backBT);
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
