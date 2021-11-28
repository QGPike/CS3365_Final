package sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

class Counter{
    int i=0;
    int m=0;
    int count=5 ;
    double total;
}
public class Main extends Application{
    Counter counter = new Counter();

    public void run(){launch();}

    Stage primaryStage;
    public void start(Stage stage) throws FileNotFoundException {
        primaryStage = stage;
        changeStage(stage,0);
    }

    public void changeStage(Stage stage, int newStage) throws FileNotFoundException {

        Project project = new Project();
        String[][] newArray = project.parser();
        itemInfo costInfo = project.calculateCosts(newArray);
        itemInfo itemdescription = project.getDescription(newArray);

        if(newStage == 0) {
            stage.setTitle("Cash Register");
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(25, 25, 25, 25));
            grid.setVgap(18);
            grid.setHgap(10);
            Button Scan = new Button("Scan");
            Scan.setStyle("-fx-background-color: MediumSeaGreen");
            Scan.setMinSize(60, 45);
            GridPane.setConstraints(Scan, 2, 3);
            Scan.setOnAction(e -> {
                try {
                    btn_Scan();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            });

            Button ITEM_ID = new Button("ITEM-ID");
            ITEM_ID.setStyle("-fx-background-color: MediumSeaGreen");
            ITEM_ID.setMinSize(60, 45);
            GridPane.setConstraints(ITEM_ID, 3, 3);
            //Scan.setOnAction(e -> btn_ITEM_ID());

            Button Scale = new Button("Scale");
            Scale.setStyle("-fx-background-color: MediumSeaGreen");
            Scale.setMinSize(60, 45);
            GridPane.setConstraints(Scale, 4, 3);
            //Scan.setOnAction(e -> btn_Scale());

//--------------------------------------------------------------------displays
            Label lblCashierDisplay = new Label("---Cashier Display---");
            GridPane.setConstraints(lblCashierDisplay, 7, 3);
            Label lblCustomerDisplay = new Label("---Customer Display---");
            GridPane.setConstraints(lblCustomerDisplay, 25, 3);
//---------------------------------------------------------------------numpad -->

            Button num1 = new Button("1");
            num1.setStyle("-fx-background-color: MediumSeaGreen");
            num1.setMinSize(60, 45);
            GridPane.setConstraints(num1, 2, 5);
            //Scan.setOnAction(e -> btn_Scale());

            Button num2 = new Button("2");
            num2.setStyle("-fx-background-color: MediumSeaGreen");
            num2.setMinSize(60, 45);
            GridPane.setConstraints(num2, 3, 5);
            //Scan.setOnAction(e -> btn_Scale());

            Button num3 = new Button("3");
            num3.setStyle("-fx-background-color: MediumSeaGreen");
            num3.setMinSize(60, 45);
            GridPane.setConstraints(num3, 4, 5);
            //Scan.setOnAction(e -> btn_Scale());

            Button num4 = new Button("4");
            num4.setStyle("-fx-background-color: MediumSeaGreen");
            num4.setMinSize(60, 45);
            GridPane.setConstraints(num4, 2, 6);
            //Scan.setOnAction(e -> btn_Scale());

            Button num5 = new Button("5");
            num5.setStyle("-fx-background-color: MediumSeaGreen");
            num5.setMinSize(60, 45);
            GridPane.setConstraints(num5, 3, 6);
            //Scan.setOnAction(e -> btn_Scale());

            Button num6 = new Button("6");
            num6.setStyle("-fx-background-color: MediumSeaGreen");
            num6.setMinSize(60, 45);
            GridPane.setConstraints(num6, 4, 6);
            //Scan.setOnAction(e -> btn_Scale());

            Button num7 = new Button("7");
            num7.setStyle("-fx-background-color: MediumSeaGreen");
            num7.setMinSize(60, 45);
            GridPane.setConstraints(num7, 2, 7);
            //Scan.setOnAction(e -> btn_Scale());

            Button num8 = new Button("8");
            num8.setStyle("-fx-background-color: MediumSeaGreen");
            num8.setMinSize(60, 45);
            GridPane.setConstraints(num8, 3, 7);
            //Scan.setOnAction(e -> btn_Scale());

            Button num9 = new Button("9");
            num9.setStyle("-fx-background-color: MediumSeaGreen");
            num9.setMinSize(60, 45);
            GridPane.setConstraints(num9, 4, 7);
            //Scan.setOnAction(e -> btn_Scale());

            Button num0 = new Button("0");
            num0.setStyle("-fx-background-color: MediumSeaGreen");
            num0.setMinSize(60, 45);
            GridPane.setConstraints(num0, 3, 8);
            //Scan.setOnAction(e -> btn_Scale());

            grid.getChildren().addAll(Scan, ITEM_ID, Scale,lblCashierDisplay,lblCustomerDisplay, num1, num2, num3, num4, num5, num6, num7, num8, num9, num0);
            Scene scene = new Scene(grid, 1000, 1000);
            stage.setScene(scene);
            stage.show();

        }
        //-----------------------------------> If stage 1 then item is automatically scanned and displayed
        else if(newStage == 1){
            

            stage.setTitle("Cash Register");
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(25, 25, 25, 25));
            grid.setVgap(18);
            grid.setHgap(10);
            Button Scan = new Button("Scan");
            Scan.setStyle("-fx-background-color: MediumSeaGreen");
            Scan.setMinSize(60, 45);
            GridPane.setConstraints(Scan, 2, 3);
            Scan.setOnAction(e -> {
                try {
                    btn_Scan();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            });

            Button ITEM_ID = new Button("ITEM-ID");
            ITEM_ID.setStyle("-fx-background-color: MediumSeaGreen");
            ITEM_ID.setMinSize(60, 45);
            GridPane.setConstraints(ITEM_ID, 3, 3);
            //Scan.setOnAction(e -> btn_ITEM_ID());

            Button Scale = new Button("Scale");
            Scale.setStyle("-fx-background-color: MediumSeaGreen");
            Scale.setMinSize(60, 45);
            GridPane.setConstraints(Scale, 4, 3);
            //Scan.setOnAction(e -> btn_Scale());

//--------------------------------------------------------------------displays
            Label lblCashierDisplay = new Label("---Cashier Display---");
            GridPane.setConstraints(lblCashierDisplay, 7, 3);

            Label lblitem = new Label("Item: "+itemdescription.itemName[counter.i]); //prints name of item to cashier display
            GridPane.setConstraints(lblitem, 7, counter.count);


            Label lblitemAmount = new Label("Amount: "+itemdescription.itemAmount[counter.m]); //prints amount of item to cashier display
            GridPane.setConstraints(lblitemAmount, 8, counter.count);

            double temp2 = costInfo.itemCost[counter.i]; //calculates total and prints total.
            //System.out.println(""+costInfo.itemCost[counter.i]);
            counter.total += temp2;
            //System.out.println(""+costInfo.temp);
            Label lbltotal = new Label("Total: $"+counter.total);
            GridPane.setConstraints(lbltotal, 7, 10);


            Label lblCustomerDisplay = new Label("---Customer Display---");
            GridPane.setConstraints(lblCustomerDisplay, 20, 3);

            Label lblCustomerItem = new Label("Item: "+itemdescription.itemName[counter.i]);
            GridPane.setConstraints(lblCustomerItem, 20, counter.count);


            Label lblCustomerItemAmount = new Label("Amount: "+itemdescription.itemAmount[counter.m]);
            GridPane.setConstraints(lblCustomerItemAmount, 21, counter.count);
            counter.count++;
            counter.i++;
            counter.m++;

//---------------------------------------------------------------------numpad -->

            Button num1 = new Button("1");
            num1.setStyle("-fx-background-color: MediumSeaGreen");
            num1.setMinSize(60, 45);
            GridPane.setConstraints(num1, 2, 5);
            //Scan.setOnAction(e -> btn_Scale());

            Button num2 = new Button("2");
            num2.setStyle("-fx-background-color: MediumSeaGreen");
            num2.setMinSize(60, 45);
            GridPane.setConstraints(num2, 3, 5);
            //Scan.setOnAction(e -> btn_Scale());

            Button num3 = new Button("3");
            num3.setStyle("-fx-background-color: MediumSeaGreen");
            num3.setMinSize(60, 45);
            GridPane.setConstraints(num3, 4, 5);
            //Scan.setOnAction(e -> btn_Scale());

            Button num4 = new Button("4");
            num4.setStyle("-fx-background-color: MediumSeaGreen");
            num4.setMinSize(60, 45);
            GridPane.setConstraints(num4, 2, 6);
            //Scan.setOnAction(e -> btn_Scale());

            Button num5 = new Button("5");
            num5.setStyle("-fx-background-color: MediumSeaGreen");
            num5.setMinSize(60, 45);
            GridPane.setConstraints(num5, 3, 6);
            //Scan.setOnAction(e -> btn_Scale());

            Button num6 = new Button("6");
            num6.setStyle("-fx-background-color: MediumSeaGreen");
            num6.setMinSize(60, 45);
            GridPane.setConstraints(num6, 4, 6);
            //Scan.setOnAction(e -> btn_Scale());

            Button num7 = new Button("7");
            num7.setStyle("-fx-background-color: MediumSeaGreen");
            num7.setMinSize(60, 45);
            GridPane.setConstraints(num7, 2, 7);
            //Scan.setOnAction(e -> btn_Scale());

            Button num8 = new Button("8");
            num8.setStyle("-fx-background-color: MediumSeaGreen");
            num8.setMinSize(60, 45);
            GridPane.setConstraints(num8, 3, 7);
            //Scan.setOnAction(e -> btn_Scale());

            Button num9 = new Button("9");
            num9.setStyle("-fx-background-color: MediumSeaGreen");
            num9.setMinSize(60, 45);
            GridPane.setConstraints(num9, 4, 7);
            //Scan.setOnAction(e -> btn_Scale());

            Button num0 = new Button("0");
            num0.setStyle("-fx-background-color: MediumSeaGreen");
            num0.setMinSize(60, 45);
            GridPane.setConstraints(num0, 3, 8);
            //Scan.setOnAction(e -> btn_Scale());

            grid.getChildren().addAll(Scan, ITEM_ID, Scale,lblCashierDisplay,lblCustomerDisplay,lblitem,lblitemAmount,lblCustomerItemAmount,lblCustomerItem,lbltotal, num1, num2, num3, num4, num5, num6, num7, num8, num9, num0);
            Scene scene = new Scene(grid, 1000, 1000);
            stage.setScene(scene);
            stage.show();

        }

    }

    private void btn_Scan() throws FileNotFoundException {

        changeStage(primaryStage, 1);

    }
    /*
    private void btn_ITEM_ID(){
        changeStage(primaryStage, 2);
    }
    private void btn_Scale(){
        changeStage(primaryStage, 3);
    }

    public void main(String[] args) {
        launch(args);
    }
*/
}


