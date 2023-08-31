/*

/**
 * JavaFX Financial Calculator
 * Calculates Future Value of Principle with Compounded Interest
 * @author jennifermiller
 */

/*************************************************
 *  Import JavaFX libraries
 **************************************************/

//import java.awt.Event;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.text.DecimalFormat;


/********************************************************
    New java class FinancialCalculator
    extends imported JavaFX application class
*********************************************************/

public class FinancialCalculator extends Application{
   // Button b1;
    

/************************************************
*************************************************
              Primary Stage
*************************************************
*************************************************/
    
@Override
public void start(Stage args){
    
    /************************************************
                Create Application Window 
    ************************************************/      

    FlowPane pane = new FlowPane();
    pane.setHgap(2); // Set space between label and text field
    pane.setAlignment(Pos.CENTER); // Center in Window
   
    
    /*************************************************
         Create User Input Boxes and Labels
    *************************************************/  
    
    TextField Principle = new TextField(); // Create TextFields
    TextField Years = new TextField();
    TextField Interest = new TextField();
    TextField FutureValue = new TextField();
    FutureValue.setEditable(false); // Cannot Edit Result
    
    Principle.setPrefColumnCount(5); // Set width of TextFields
    Years.setPrefColumnCount(5); 
    Interest.setPrefColumnCount(5); 
    FutureValue.setPrefColumnCount(5); 
    
    Label label1 = new Label("Investment Amount: "); // Set Labels for TextFields
    Label label2 = new Label("Number of Years: "); 
    Label label3 = new Label("Annual Interest Rate: "); 
    Label label4 = new Label("Future Value: "); 
    
    pane.getChildren().addAll(label1, Principle, label2, Years, label3, Interest, label4, FutureValue);
    // Add all Labels and TextFields to Window
   
    /************************************************
              Create Button to set Action
    *************************************************/
    
    Button btcalculate = new Button("Calculate");
    
     /************************************************
                  Format Window
    *************************************************/
    
    VBox vbox = new VBox();
    vbox.setAlignment(Pos.CENTER);
    vbox.getChildren().addAll(btcalculate);
    
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(pane);
    borderPane.setBottom(vbox);
    Scene scene = new Scene(borderPane, 350, 400); // Window Size
    args.setTitle("Financial Calculator"); // Title Bar
    args.setScene(scene);
    args.show(); // Display Window
  
    /***************************************************
            Calculate Future Value      
    ***************************************************/
    
    btcalculate.setOnAction(e -> {
    Double initialValue = Double.parseDouble(Principle.getText()); // Convert Input to Double for Calculation
    Double monthsCompounded = 12.0; // Months per year interest is compounded
    Double monthlyInterest = Double.parseDouble(Interest.getText()) / 1200; // Convert Input to Double, Convert Yearly Interest to Monthly Interest
    Double Base = 1 + monthlyInterest; // Set Base amount for Math.pow function
    Double Power = Double.parseDouble(Years.getText()) * monthsCompounded; // Set Power amount for Math.pow function
    Double total = (initialValue * Math.pow(Base, Power)); // Calculate Future Value(total) of Principle with Compounded Interest
    DecimalFormat f = new DecimalFormat("#.##"); // Set Decimal Format to Round to two decimal places
    String roundedTotal = f.format(total); // Create string to hold rounded total amount
    FutureValue.setText(roundedTotal); // Set FutureValue TextField to Calculated amount
    });
   
};

 /********************************************************
   Main function only used to launch application.
  ********************************************************/   
  
    public static void main(String[] args){
        Application.launch(args);
    };

}