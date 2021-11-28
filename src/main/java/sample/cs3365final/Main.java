package sample.cs3365final;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
//comment
import java.io.FileNotFoundException;
//comment
class Counter{
    int i=0;
    int m=0;
    int count=0 ;
    double total;
}
public class Main extends Application{
    Counter counter = new Counter();
    public boolean isFirst = true; //tracks first scan for loyalty rewards
    public String display = "";
    public String ItemID = "";
    custInfo Jim = new custInfo("1234567890", "1234", 11);
    public void run(){launch();}

    Stage primaryStage;
    public void start(Stage stage) throws FileNotFoundException {
        primaryStage = stage;
        changeStage(stage,0);
    }

    public void loyalCustomer()
    {

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


            ITEM_ID.setOnAction(e -> {
                try {
                    btn_ITEM_ID();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            });


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

            grid.getChildren().addAll(Scan, ITEM_ID, Scale,lblCashierDisplay,lblCustomerDisplay);
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

            ITEM_ID.setOnAction(e -> {
                try {
                    btn_ITEM_ID();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            });



            Button Scale = new Button("Scale");
            Scale.setStyle("-fx-background-color: MediumSeaGreen");
            Scale.setMinSize(60, 45);
            GridPane.setConstraints(Scale, 4, 3);
            //Scan.setOnAction(e -> btn_Scale());

//--------------------------------------------------------------------displays
            Label lblCashierDisplay = new Label("---Cashier Display---");
            GridPane.setConstraints(lblCashierDisplay, 7, 3);

            Label lblitem = new Label(display); //prints name of item to cashier display
            GridPane.setConstraints(lblitem, 7, 5);


            double temp2 = costInfo.itemCost[counter.i]; //calculates total and prints total.
            //System.out.println(""+costInfo.itemCost[counter.i]);
            counter.total += temp2;
            //System.out.println(""+costInfo.temp);
            Label lbltotal = new Label("Total: $"+counter.total);
            GridPane.setConstraints(lbltotal, 7, 10);


            Label lblCustomerDisplay = new Label("---Customer Display---");
            GridPane.setConstraints(lblCustomerDisplay, 20, 3);

            Label lblCustomerItem = new Label(display);
            GridPane.setConstraints(lblCustomerItem, 20, 5);



            counter.count++; //increment counters
            counter.i++;
            counter.m++;

            grid.getChildren().addAll(Scan, ITEM_ID, Scale,lblCashierDisplay,lblCustomerDisplay,lblitem,lblCustomerItem,lbltotal);
            Scene scene = new Scene(grid, 1000, 1000);
            stage.setScene(scene);
            stage.show();

        }

        //--------------------------------------------------------------------------------------ITEM-ID
        else if(newStage == 2){
            stage.setTitle("Enter Item ID With the Numpad");
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(25, 25, 25, 25));
            grid.setVgap(18);
            grid.setHgap(10);


            Button Scale = new Button("Scale");
            Scale.setStyle("-fx-background-color: MediumSeaGreen");
            Scale.setMinSize(60, 45);
            GridPane.setConstraints(Scale, 2, 3);
            //Scan.setOnAction(e -> btn_Scale());
            Button Enter = new Button("Enter:");
            Enter.setStyle("-fx-background-color: MediumSeaGreen");
            Enter.setMinSize(60, 45);
            GridPane.setConstraints(Enter, 4, 3);
            Enter.setOnAction(e -> {
                try {
                    btn_numpadEnter();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            });


//---------------------------------------------------------------------numpad -->
            Label lblNumpad = new Label("NUMPAD:");
            GridPane.setConstraints(lblNumpad, 3, 9);
            Label lblNumber = new Label(ItemID);
            GridPane.setConstraints(lblNumber, 4,9 );


            Button num1 = new Button("1");
            num1.setStyle("-fx-background-color: MediumSeaGreen");
            num1.setMinSize(60, 45);
            GridPane.setConstraints(num1, 2, 5);
            num1.setOnAction(e -> btn_Numpad(1));

            Button num2 = new Button("2");
            num2.setStyle("-fx-background-color: MediumSeaGreen");
            num2.setMinSize(60, 45);
            GridPane.setConstraints(num2, 3, 5);
            num2.setOnAction(e -> btn_Numpad(2));

            Button num3 = new Button("3");
            num3.setStyle("-fx-background-color: MediumSeaGreen");
            num3.setMinSize(60, 45);
            GridPane.setConstraints(num3, 4, 5);
            num3.setOnAction(e -> btn_Numpad(3));

            Button num4 = new Button("4");
            num4.setStyle("-fx-background-color: MediumSeaGreen");
            num4.setMinSize(60, 45);
            GridPane.setConstraints(num4, 2, 6);
            num4.setOnAction(e -> btn_Numpad(4));

            Button num5 = new Button("5");
            num5.setStyle("-fx-background-color: MediumSeaGreen");
            num5.setMinSize(60, 45);
            GridPane.setConstraints(num5, 3, 6);
            num5.setOnAction(e -> btn_Numpad(5));

            Button num6 = new Button("6");
            num6.setStyle("-fx-background-color: MediumSeaGreen");
            num6.setMinSize(60, 45);
            GridPane.setConstraints(num6, 4, 6);
            num6.setOnAction(e -> btn_Numpad(6));

            Button num7 = new Button("7");
            num7.setStyle("-fx-background-color: MediumSeaGreen");
            num7.setMinSize(60, 45);
            GridPane.setConstraints(num7, 2, 7);
            num7.setOnAction(e -> btn_Numpad(7));

            Button num8 = new Button("8");
            num8.setStyle("-fx-background-color: MediumSeaGreen");
            num8.setMinSize(60, 45);
            GridPane.setConstraints(num8, 3, 7);
            num8.setOnAction(e -> btn_Numpad(8));

            Button num9 = new Button("9");
            num9.setStyle("-fx-background-color: MediumSeaGreen");
            num9.setMinSize(60, 45);
            GridPane.setConstraints(num9, 4, 7);
            num9.setOnAction(e -> btn_Numpad(9));

            Button num0 = new Button("0");
            num0.setStyle("-fx-background-color: MediumSeaGreen");
            num0.setMinSize(60, 45);
            GridPane.setConstraints(num0, 3, 8);
            num0.setOnAction(e -> btn_Numpad(0));

            grid.getChildren().addAll(Scale,lblNumpad,lblNumber,Enter, num1, num2, num3, num4, num5, num6, num7, num8, num9, num0);
            Scene scene = new Scene(grid, 1000, 1000);
            stage.setScene(scene);
            stage.show();
        }

    }

    private void btn_Scan() throws FileNotFoundException {
        Project project = new Project();
        String[][] newArray = project.parser();
        itemInfo costInfo = project.calculateCosts(newArray);
        itemInfo itemdescription = project.getDescription(newArray);
        System.out.println(itemdescription.itemName[counter.count]);
        System.out.println(itemdescription.itemAmount[counter.count]);
        display = display +itemdescription.itemName[counter.count] +" "+ itemdescription.itemAmount[counter.count]+"\n";

        changeStage(primaryStage, 1);

    }

    private void btn_Numpad(int number){//passes whatever number is pressed
        ItemID = ItemID + Integer.toString(number);
        try {
            changeStage(primaryStage,2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void btn_ITEM_ID() throws FileNotFoundException {
        if(isFirst == true)
        {
            //method
        }

        changeStage(primaryStage, 2);
    }
    private void btn_numpadEnter() throws FileNotFoundException {
        Project project = new Project();
        String[][] newArray = project.parser();
        itemInfo itemdescription = project.getDescription(newArray);
        int i = 0;
        int m = 0;
        String bread = "123456";//create variables to store item-ID.
        String soda = "234567";
        int linecount = project.linecounter();
        while(i < linecount){
            if(newArray[i][m] == ItemID){
                if(ItemID == bread){
                    m++;
                    display = display + "Bread" + " "+ newArray[i][m]+"\n";
                    i++;
                }
                else if(ItemID == soda){
                    m++;
                    display = display + "Soda" + " "+ newArray[i][m]+"\n";
                    i++;
                }
            }
            else{i++;}

        }
        ItemID = "";
        changeStage(primaryStage,1);
    }




}

