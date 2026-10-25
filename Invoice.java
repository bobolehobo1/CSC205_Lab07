import javafx.application.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class Invoice extends Application {

    @Override
    public void start(Stage Window) {

        // create nodes-----------------------------------
        // -pane
        GridPane Gpane = new GridPane();
        // -TextFields
        new TextField();

        // -Buttons
        Button calculateBT = new Button("Calculate");
        Button backBT = new Button("Back");
        // ------------------------------------------------

        // configure
        // nodes--------------------------------------------------------------------------------------------------------
        Scene scene = new Scene(Gpane);
        Gpane.add(new Label("Shirts"), 0, 0);
        Gpane.add(new TextField(), 1, 0);
        Gpane.add(new Label("Pants"), 0, 1);
        Gpane.add(new TextField(), 1, 1);
        Gpane.add(new Label("Ties"), 0, 2);
        Gpane.add(new TextField(), 1, 2);
        Gpane.add(new Label("Shoes"), 0, 3);
        Gpane.add(new TextField(), 1, 3);
        Gpane.add(new Label("Sales Tax"), 0, 4);
        Gpane.add(new TextField(), 1, 4); // Needed to change into ComboBox
        ComboBox<Double> cmb = new ComboBox<>();
        for (double i = 3.00; i <= 9.5; i += 0.25) {
            cmb.getItems().add(i);
        }
        Gpane.add(cmb, 0, 5);
        Gpane.add(new TextField(), 1, 5);
        // -----------------------------------------------------------------------------------------------------------------------

        // display nodes-------------
        Window.setScene(scene);
        Window.show();
        // --------------------------

    }

    // main method---------------------------
    public static void main(String[] args) {
        launch();
    }
    // --------------------------------------
}
