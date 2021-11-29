package sample;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
class weights{
        String[][] weights;

        {
            weights = new String[][]{{"Bread", "0.5"},
                                    {"Soda", "0.25"},
                                    {"blanket", "2.0"},
                                    {"meat", "2.12"},
                                    {"apples", ".25"}};

        }
}
class Inventory{
    String[][] itemList;
    String[][] tempList = new String[5][2];

    {
        itemList = new String[][]{{"Bread", "10"},
                {"Soda","12"},
                {"blanket", "7"},
                {"meat","10"},
                {"apples","10"}};
    }
}
class Counter{
    int i=0;
    int m=0;
    int n=0;
    int count=0 ;
    double total;
}
public class Main extends Application {
    sample.Counter counter = new sample.Counter();
    public sample.Inventory inventory = new sample.Inventory();
    public boolean isFirst = true; //tracks first scan for loyalty acct
    public boolean isLoyal = false; //tracks the need to add loyalty points
    public boolean isCard = false; //sets the need to print card number on Reciept
    public String display = "";
    public String ItemID = "";
    public String phoneN = "";
    public String custPin = "";
    custInfo Jim = new custInfo("1234567890", "1234", 11); //sample acct
    Card jimCard = new Card(false, "1234", "1234567980123456", 999999999, "12");

    public void run() {
        launch();
    }

    Stage primaryStage;

    public void start(Stage stage) throws FileNotFoundException {
        primaryStage = stage;
        changeStage(stage, 0);
    }


    public void changeStage(Stage stage, int newStage) throws FileNotFoundException {

        Project project = new Project();
        String[][] newArray = project.parser();
        itemInfo costInfo = project.calculateCosts(newArray);
        itemInfo itemdescription = project.getDescription(newArray);

        if (newStage == 0) {
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

            grid.getChildren().addAll(Scan, ITEM_ID, Scale, lblCashierDisplay, lblCustomerDisplay);
            Scene scene = new Scene(grid, 1000, 1000);
            stage.setScene(scene);
            stage.show();

        }
        //-----------------------------------> If stage 1 then item is automatically scanned and displayed
        else if (newStage == 1) {


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

            Button btn_total = new Button("Total: $" + counter.total);
            btn_total.setStyle("-fx-background-color: MediumSeaGreen");
            btn_total.setMinSize(60, 45);
            GridPane.setConstraints(btn_total, 7, 10);
            btn_total.setOnAction(e -> {
                try {
                    btn_total();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            });


            Label lblCustomerDisplay = new Label("---Customer Display---");
            GridPane.setConstraints(lblCustomerDisplay, 20, 3);

            Label lblCustomerItem = new Label(display);
            GridPane.setConstraints(lblCustomerItem, 20, 5);


            counter.count++; //increment counters
            counter.i++;
            counter.m++;

            grid.getChildren().addAll(Scan, ITEM_ID, Scale, lblCashierDisplay, lblCustomerDisplay, lblitem, lblCustomerItem, btn_total);
            Scene scene = new Scene(grid, 1000, 1000);
            stage.setScene(scene);
            stage.show();

        }

        //--------------------------------------------------------------------------------------ITEM-ID
        else if (newStage == 2) {
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
            GridPane.setConstraints(lblNumber, 4, 9);


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

            grid.getChildren().addAll(Scale, lblNumpad, lblNumber, Enter, num1, num2, num3, num4, num5, num6, num7, num8, num9, num0);
            Scene scene = new Scene(grid, 1000, 1000);
            stage.setScene(scene);
            stage.show();
        } else if (newStage == 3) {
            isFirst = false;
            stage.setTitle("Enter Phone Number With the Numpad");
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(25, 25, 25, 25));
            grid.setVgap(18);
            grid.setHgap(10);


///////////////////////////////////NUMPAD///////////////////////////////////
            Label lblNumpad = new Label("PHONE:");
            GridPane.setConstraints(lblNumpad, 3, 9);
            Label lblNumber = new Label(phoneN);
            GridPane.setConstraints(lblNumber, 4, 9);

            Button Verify = new Button("Verify");
            Verify.setStyle("-fx-background-color: MediumSeaGreen");
            Verify.setMinSize(60, 45);
            GridPane.setConstraints(Verify, 4, 3);
            Verify.setOnAction(e -> {
                try {
                    btn_numpadVerify();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            });

            Button num1 = new Button("1");
            num1.setStyle("-fx-background-color: MediumSeaGreen");
            num1.setMinSize(60, 45);
            GridPane.setConstraints(num1, 2, 5);
            num1.setOnAction(e -> btn_NumpadPhone(1));

            Button num2 = new Button("2");
            num2.setStyle("-fx-background-color: MediumSeaGreen");
            num2.setMinSize(60, 45);
            GridPane.setConstraints(num2, 3, 5);
            num2.setOnAction(e -> btn_NumpadPhone(2));

            Button num3 = new Button("3");
            num3.setStyle("-fx-background-color: MediumSeaGreen");
            num3.setMinSize(60, 45);
            GridPane.setConstraints(num3, 4, 5);
            num3.setOnAction(e -> btn_NumpadPhone(3));

            Button num4 = new Button("4");
            num4.setStyle("-fx-background-color: MediumSeaGreen");
            num4.setMinSize(60, 45);
            GridPane.setConstraints(num4, 2, 6);
            num4.setOnAction(e -> btn_NumpadPhone(4));

            Button num5 = new Button("5");
            num5.setStyle("-fx-background-color: MediumSeaGreen");
            num5.setMinSize(60, 45);
            GridPane.setConstraints(num5, 3, 6);
            num5.setOnAction(e -> btn_NumpadPhone(5));

            Button num6 = new Button("6");
            num6.setStyle("-fx-background-color: MediumSeaGreen");
            num6.setMinSize(60, 45);
            GridPane.setConstraints(num6, 4, 6);
            num6.setOnAction(e -> btn_NumpadPhone(6));

            Button num7 = new Button("7");
            num7.setStyle("-fx-background-color: MediumSeaGreen");
            num7.setMinSize(60, 45);
            GridPane.setConstraints(num7, 2, 7);
            num7.setOnAction(e -> btn_NumpadPhone(7));

            Button num8 = new Button("8");
            num8.setStyle("-fx-background-color: MediumSeaGreen");
            num8.setMinSize(60, 45);
            GridPane.setConstraints(num8, 3, 7);
            num8.setOnAction(e -> btn_NumpadPhone(8));

            Button num9 = new Button("9");
            num9.setStyle("-fx-background-color: MediumSeaGreen");
            num9.setMinSize(60, 45);
            GridPane.setConstraints(num9, 4, 7);
            num9.setOnAction(e -> btn_NumpadPhone(9));

            Button num0 = new Button("0");
            num0.setStyle("-fx-background-color: MediumSeaGreen");
            num0.setMinSize(60, 45);
            GridPane.setConstraints(num0, 3, 8);
            num0.setOnAction(e -> btn_NumpadPhone(0));

            grid.getChildren().addAll(Verify, lblNumpad, lblNumber, num1, num2, num3, num4, num5, num6, num7, num8, num9, num0);
            Scene scene = new Scene(grid, 1000, 1000);
            stage.setScene(scene);
            stage.show();
        } else if (newStage == 4) {
            isFirst = false;
            stage.setTitle("Enter Loyalty Pin with the Numpad");
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(25, 25, 25, 25));
            grid.setVgap(18);
            grid.setHgap(10);


///////////////////////////////////NUMPAD///////////////////////////////////
            Label lblNumpad = new Label("PIN:");
            GridPane.setConstraints(lblNumpad, 3, 9);
            Label lblNumber = new Label(custPin);
            GridPane.setConstraints(lblNumber, 4, 9);

            Button Verify = new Button("Verify");
            Verify.setStyle("-fx-background-color: MediumSeaGreen");
            Verify.setMinSize(60, 45);
            GridPane.setConstraints(Verify, 4, 3);
            Verify.setOnAction(e -> {
                try {
                    btn_numpadVerify2();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            });

            Button num1 = new Button("1");
            num1.setStyle("-fx-background-color: MediumSeaGreen");
            num1.setMinSize(60, 45);
            GridPane.setConstraints(num1, 2, 5);
            num1.setOnAction(e -> btn_NumpadPin(1));

            Button num2 = new Button("2");
            num2.setStyle("-fx-background-color: MediumSeaGreen");
            num2.setMinSize(60, 45);
            GridPane.setConstraints(num2, 3, 5);
            num2.setOnAction(e -> btn_NumpadPin(2));

            Button num3 = new Button("3");
            num3.setStyle("-fx-background-color: MediumSeaGreen");
            num3.setMinSize(60, 45);
            GridPane.setConstraints(num3, 4, 5);
            num3.setOnAction(e -> btn_NumpadPin(3));

            Button num4 = new Button("4");
            num4.setStyle("-fx-background-color: MediumSeaGreen");
            num4.setMinSize(60, 45);
            GridPane.setConstraints(num4, 2, 6);
            num4.setOnAction(e -> btn_NumpadPin(4));

            Button num5 = new Button("5");
            num5.setStyle("-fx-background-color: MediumSeaGreen");
            num5.setMinSize(60, 45);
            GridPane.setConstraints(num5, 3, 6);
            num5.setOnAction(e -> btn_NumpadPin(5));

            Button num6 = new Button("6");
            num6.setStyle("-fx-background-color: MediumSeaGreen");
            num6.setMinSize(60, 45);
            GridPane.setConstraints(num6, 4, 6);
            num6.setOnAction(e -> btn_NumpadPin(6));

            Button num7 = new Button("7");
            num7.setStyle("-fx-background-color: MediumSeaGreen");
            num7.setMinSize(60, 45);
            GridPane.setConstraints(num7, 2, 7);
            num7.setOnAction(e -> btn_NumpadPin(7));

            Button num8 = new Button("8");
            num8.setStyle("-fx-background-color: MediumSeaGreen");
            num8.setMinSize(60, 45);
            GridPane.setConstraints(num8, 3, 7);
            num8.setOnAction(e -> btn_NumpadPin(8));

            Button num9 = new Button("9");
            num9.setStyle("-fx-background-color: MediumSeaGreen");
            num9.setMinSize(60, 45);
            GridPane.setConstraints(num9, 4, 7);
            num9.setOnAction(e -> btn_NumpadPin(9));

            Button num0 = new Button("0");
            num0.setStyle("-fx-background-color: MediumSeaGreen");
            num0.setMinSize(60, 45);
            GridPane.setConstraints(num0, 3, 8);
            num0.setOnAction(e -> btn_NumpadPin(0));

            grid.getChildren().addAll(Verify, lblNumpad, lblNumber, num1, num2, num3, num4, num5, num6, num7, num8, num9, num0);
            Scene scene = new Scene(grid, 1000, 1000);
            stage.setScene(scene);
            stage.show();
        }

        else if(newStage == 5){
            stage.setTitle("Pay With Cash, Check, or Card");
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(25, 25, 25, 25));
            grid.setVgap(18);
            grid.setHgap(10);

            Label lblSelectPayment = new Label("Select a Payment Option:");
            GridPane.setConstraints(lblSelectPayment, 3, 2);


            Button Cash = new Button("Cash");
            Cash.setStyle("-fx-background-color: MediumSeaGreen");
            Cash.setMinSize(60, 45);
            GridPane.setConstraints(Cash, 2, 3);
            //Cash.setOnAction(e -> btn_Cash);

            Button Check = new Button("Check");
            Check.setStyle("-fx-background-color: MediumSeaGreen");
            Check.setMinSize(60, 45);
            GridPane.setConstraints(Check, 3, 3);
            Cash.setOnAction(e -> {
                try {
                    btn_Check();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            });

            Button Card = new Button("Card");
            Card.setStyle("-fx-background-color: MediumSeaGreen");
            Card.setMinSize(60, 45);
            GridPane.setConstraints(Card, 4, 3);
            Card.setOnAction(e -> {
                try {
                    btn_Card();
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
            });



            grid.getChildren().addAll(lblSelectPayment, Cash,Card, Check);
            Scene scene = new Scene(grid, 1000, 1000);
            stage.setScene(scene);
            stage.show();
        }
        //-------------------------------------------------------RECEIPT----------------------------------
        else if(newStage == 6){
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(25, 25, 25, 25));
            grid.setVgap(18);
            grid.setHgap(10);
            double rewards = 0;

            Label lblMessage = new Label("---------------Your Printed Receipt---------------");
            GridPane.setConstraints(lblMessage, 4, 2);
            Label lblReceipt = new Label(display);
            GridPane.setConstraints(lblReceipt, 4, 3);
            Label lblTotal = new Label("Your Total: $"+counter.total);
            GridPane.setConstraints(lblTotal, 4, 5);

            if(isLoyal)
            {
                rewards = (Jim.cP + (counter.total / 10));
            }
            else
            {
                rewards = counter.total / 10;
            }

            Label lblrewardsPoints = new Label("Rewards Points: " + rewards);
            GridPane.setConstraints(lblrewardsPoints, 4, 6);

            grid.getChildren().addAll(lblMessage,lblReceipt,lblTotal, lblrewardsPoints);
            Scene scene = new Scene(grid, 1000, 1000);
            stage.setScene(scene);
            stage.show();


        }
        else if (newStage == 7) {
            isFirst = false;
            stage.setTitle("Enter Card Pin with the Numpad");
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(25, 25, 25, 25));
            grid.setVgap(18);
            grid.setHgap(10);


///////////////////////////////////NUMPAD///////////////////////////////////
            Label lblNumpad = new Label("PIN:");
            GridPane.setConstraints(lblNumpad, 3, 9);
            Label lblNumber = new Label(custPin);
            GridPane.setConstraints(lblNumber, 4, 9);

            Button Verify = new Button("Verify");
            Verify.setStyle("-fx-background-color: MediumSeaGreen");
            Verify.setMinSize(60, 45);
            GridPane.setConstraints(Verify, 4, 3);
            Verify.setOnAction(e -> {
                try {
                    btn_numpadVerifyBank();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            });

            Button num1 = new Button("1");
            num1.setStyle("-fx-background-color: MediumSeaGreen");
            num1.setMinSize(60, 45);
            GridPane.setConstraints(num1, 2, 5);
            num1.setOnAction(e -> btn_NumpadPin(1));

            Button num2 = new Button("2");
            num2.setStyle("-fx-background-color: MediumSeaGreen");
            num2.setMinSize(60, 45);
            GridPane.setConstraints(num2, 3, 5);
            num2.setOnAction(e -> btn_NumpadPin(2));

            Button num3 = new Button("3");
            num3.setStyle("-fx-background-color: MediumSeaGreen");
            num3.setMinSize(60, 45);
            GridPane.setConstraints(num3, 4, 5);
            num3.setOnAction(e -> btn_NumpadPin(3));

            Button num4 = new Button("4");
            num4.setStyle("-fx-background-color: MediumSeaGreen");
            num4.setMinSize(60, 45);
            GridPane.setConstraints(num4, 2, 6);
            num4.setOnAction(e -> btn_NumpadPin(4));

            Button num5 = new Button("5");
            num5.setStyle("-fx-background-color: MediumSeaGreen");
            num5.setMinSize(60, 45);
            GridPane.setConstraints(num5, 3, 6);
            num5.setOnAction(e -> btn_NumpadPin(5));

            Button num6 = new Button("6");
            num6.setStyle("-fx-background-color: MediumSeaGreen");
            num6.setMinSize(60, 45);
            GridPane.setConstraints(num6, 4, 6);
            num6.setOnAction(e -> btn_NumpadPin(6));

            Button num7 = new Button("7");
            num7.setStyle("-fx-background-color: MediumSeaGreen");
            num7.setMinSize(60, 45);
            GridPane.setConstraints(num7, 2, 7);
            num7.setOnAction(e -> btn_NumpadPin(7));

            Button num8 = new Button("8");
            num8.setStyle("-fx-background-color: MediumSeaGreen");
            num8.setMinSize(60, 45);
            GridPane.setConstraints(num8, 3, 7);
            num8.setOnAction(e -> btn_NumpadPin(8));

            Button num9 = new Button("9");
            num9.setStyle("-fx-background-color: MediumSeaGreen");
            num9.setMinSize(60, 45);
            GridPane.setConstraints(num9, 4, 7);
            num9.setOnAction(e -> btn_NumpadPin(9));

            Button num0 = new Button("0");
            num0.setStyle("-fx-background-color: MediumSeaGreen");
            num0.setMinSize(60, 45);
            GridPane.setConstraints(num0, 3, 8);
            num0.setOnAction(e -> btn_NumpadPin(0));

            grid.getChildren().addAll(Verify, lblNumpad, lblNumber, num1, num2, num3, num4, num5, num6, num7, num8, num9, num0);
            Scene scene = new Scene(grid, 1000, 1000);
            stage.setScene(scene);
            stage.show();
        }

    }


    private void btn_Scan() throws FileNotFoundException {
        Project project = new Project();
        String[][] newArray = project.parser();
        itemInfo itemdescription = project.getDescription(newArray);

        //System.out.println(itemdescription.itemName[counter.count]);
        //System.out.println(itemdescription.itemAmount[counter.count]);
        display = display + "Item: " + itemdescription.itemName[counter.count] + "  " + "Amount: " + itemdescription.itemAmount[counter.count] + "\n";
        //---------------------------------------------------------------------------------------Add the items to a temp array to compare to the inventory later on.
        inventory.tempList[counter.count][0] = itemdescription.itemName[counter.count];
        System.out.println(inventory.tempList[counter.count][0]);
        inventory.tempList[counter.count][1] = itemdescription.itemAmount[counter.count];
        System.out.println(inventory.tempList[counter.count][1]);




        if (isFirst) //Checks if this is the first button press
        {
            changeStage(primaryStage, 3);
        } else {
            changeStage(primaryStage, 1);
        }
    }

    private void btn_NumpadPhone(int number) //Passes in Phone Input
    {
        phoneN = phoneN + Integer.toString(number);
        try {
            changeStage(primaryStage, 3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void btn_Numpad(int number) {//passes whatever number is pressed
        ItemID = ItemID + Integer.toString(number);
        try {
            changeStage(primaryStage, 2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void btn_NumpadPin(int number) //Passes in Pin Input
    {
        custPin = custPin + Integer.toString(number);
        try {
            changeStage(primaryStage, 4);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void btn_ITEM_ID() throws FileNotFoundException {
        changeStage(primaryStage, 2);
    }

    private void btn_numpadVerify() throws FileNotFoundException //Matches Phone #
    {
        if (Jim.pNum.equals(phoneN)) {
            changeStage(primaryStage, 4);
        } else {
            changeStage(primaryStage, 1);
        }
    }

    private void btn_numpadVerify2() throws FileNotFoundException //Matches Pin #, if false it moves back to start
    {
        if (Jim.memPin.equals(custPin)) {
            isLoyal = true;
            custPin = "";
            changeStage(primaryStage, 1);
        } else {
            custPin = "";
            changeStage(primaryStage, 1);
        }
    }

    private void btn_numpadEnter() throws FileNotFoundException {
        Project project = new Project();
        String[][] newArray = project.parser();
        itemInfo itemdescription = project.getDescription(newArray);
        int i = 0;
        int m = 0;
        String bread = "123456";//create variables to store item-ID.
        String soda = "234567";
        String blanket = "345678";
        String meat = "456789";
        String apples = "567891";
        int linecount = project.linecounter();
        while (i < linecount) {
            if (newArray[i][m].equals(ItemID)) {
                if (ItemID.equals(bread)) {
                    m++;
                    display = display + "Item: " + "Bread" + " " + "Amount: " + newArray[i][m] + "\n";
                    inventory.tempList[counter.count][0] = "Bread";
                    inventory.tempList[counter.count][1] = newArray[i][m];
                    i++;
                } else if (ItemID.equals(soda)) {
                    m++;
                    display = display + "Item: " + "Soda" + " " + "Amount: " + newArray[i][m] + "\n";
                    inventory.tempList[counter.count][0] = "Soda";
                    inventory.tempList[counter.count][1] = newArray[i][m];
                    i++;
                } else if (ItemID.equals(blanket)) {
                    m++;
                    display = display + "Item: " + "Blanket" + " " + "Amount: " + newArray[i][m] + "\n";
                    inventory.tempList[counter.count][0] = "blanket";
                    inventory.tempList[counter.count][1] = newArray[i][m];
                    i++;
                } else if (ItemID.equals(meat)) {
                    m++;
                    display = display + "Item: " + "Meat" + " " + "Amount: " + newArray[i][m] + "\n";
                    inventory.tempList[counter.count][0] = "meat";
                    inventory.tempList[counter.count][1] = newArray[i][m];
                    i++;
                } else if (ItemID.equals(apples)) {
                    m++;
                    display = display + "Item: " + "Apples" + " " + "Amount: " + newArray[i][m] + "\n";
                    inventory.tempList[counter.count][0] = "apples";
                    inventory.tempList[counter.count][1] = newArray[i][m];
                    i++;
                }
            } else {
                i++;
            }

        }
        ItemID = "";

        if (isFirst) //Checks if this is first item input
        {
            changeStage(primaryStage, 3);
        } else {
            changeStage(primaryStage, 1);
        }





    }


    private void btn_numpadVerifyBank() throws FileNotFoundException
    {
        if(custPin.equals(jimCard.cPin))
        {

        }
    }

    private void btn_total() throws FileNotFoundException {
        System.out.println(inventory.tempList[0][0]);
        changeStage(primaryStage, 5);

    }

    private void btn_Card() throws FileNotFoundException {//Must check if their card is valid. Check their account balance.
        //if card is valid then...
        int i = 0;
        int temp;
        int temp2;
        int newAmount;
        boolean breakloop = true;
        String newString;
        isCard = true;

        while(i < counter.count || !breakloop) {
            if(inventory.tempList[i][0] == null){
                breakloop = false;
            }
            else if (inventory.tempList[i][0].equals(inventory.itemList[i][0])) {
                temp = Integer.parseInt(inventory.itemList[i][1]);
                temp2 = Integer.parseInt(inventory.tempList[i][1]);
                newAmount = temp - temp2;
                newString = Integer.toString(newAmount);
                inventory.itemList[i][1] = newString;
                System.out.println("New Inventory Amount for "+ inventory.itemList[i][0] + " is "+ inventory.itemList[i][1]+ "\n");

            }
            i++;
        }

        if(jimCard.isCredit)
        {
            changeStage(primaryStage, 6);

        }
        else
        {
            changeStage(primaryStage, 7);
        }


    }
    private void btn_Check() throws FileNotFoundException {//Must check if their card is valid. Check their account balance.
        //if Check is valid then...
        int i = 0;
        int temp;
        int temp2;
        int newAmount;
        boolean breakloop = true;
        String newString;
        while(i < counter.count || !breakloop) {
            if(inventory.tempList[i][0] == null){
                breakloop = false;
            }
            else if (inventory.tempList[i][0].equals(inventory.itemList[i][0])) {
                temp = Integer.parseInt(inventory.itemList[i][1]);
                temp2 = Integer.parseInt(inventory.tempList[i][1]);
                newAmount = temp - temp2;
                newString = Integer.toString(newAmount);
                inventory.itemList[i][1] = newString;
                System.out.println("New Inventory Amount for "+ inventory.itemList[i][0] + " is "+ inventory.itemList[i][1]+ "\n");

            }
            i++;
        }
        changeStage(primaryStage, 6);

    }



}
