package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class itemInfo{//class to store name, how many of each item, and the prices of each item.
    String[] itemName = new String[5];
    String[] itemAmount = new String[5];
    Double[] itemCost = new Double[5];
    double total;

}

class custInfo //Holds sample account data to be used in demo
{
    String pNum; //Phone
    String memPin; //Pin
    int cP; //Loyalty points

    public custInfo(String pNum, String memPin, int cP)
    {
        this.pNum = pNum;
        this.memPin = memPin;
        this.cP = cP;
    }
}

class Card
{
    Boolean isCredit; //if card is debit or credit
    String cPin; //Card pin
    double balance; //card balance

    public Card(Boolean isCredit, String cPin, double balance)
    {
        this.isCredit = isCredit;
        this.cPin = cPin;
        this.balance = balance;
    }
}

public class Project{//---------------------------------------------------------------Start


    //parses file and puts into 2d array
    String[][] parser() throws FileNotFoundException {//Reads file and returns a 2D array listArray[item-ID][item amount]
        int linecount = linecounter();
        File file = new File(System.getProperty("user.dir") + "/list.txt");;
        Scanner scan = new Scanner(file);

        //int linecount = linecounter();
        int i = 0;
        int m = 0;
        String[][] listArray = new String[5][2];

        while(i < linecount){
            listArray[i][m] = scan.next();
            m++;
            listArray[i][m] = scan.next();
            m--;
            i++;
        }
        scan.close();
        return listArray;
    }
    //----------------------------------------------------------------------------------------
    //counts the number of lines in the file
    int linecounter() throws FileNotFoundException{//reads file and returns the number of lines there are.
        int count = 0;
        File file = new File(System.getProperty("user.dir") + "/list.txt"); //point to users file
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()) {
            sc.nextLine();
            count++;
        }
        sc.close();
        return count;
    }
    //----------------------------------------------------------------------------------------
    //returns an object that contains the individual costs of the items and
    sample.itemInfo calculateCosts(String[][] listArray) throws FileNotFoundException {//detects what items are in the list and stores them into a double array then returns the object

        sample.itemInfo iteminfo = new sample.itemInfo();//create object to store double array.
        int i = 0;
        int m = 0;
        double total = 0.00;
        double temp = 0;

        double breadPrice = 4.50;
        double sodaPrice = 2.50;
        double blanketPrice = 30.00;
        double meatPrice = 10.00;
        double applesPrice = 1.00;

        String amount;
        int linecount = linecounter();

        String bread = "123456";//create variables to store item-ID.
        String soda = "234567";
        String blanket = "345678";
        String meat = "456789";
        String apples = "567891";


        while (i < linecount) {
            if (listArray[i][m].equals(bread)) { //check if ID matches.
                m++;
                amount = listArray[i][m];
                temp = Double.parseDouble(amount);
                temp = temp * breadPrice;
                iteminfo.total += temp;
                iteminfo.itemCost[i] = breadPrice;

                i++;
                m--;

            }
            else if (listArray[i][m].equals(soda)) {//check if ID matches.
                m++;
                amount = listArray[i][m];
                temp = Double.parseDouble(amount);
                temp = temp * sodaPrice;
                iteminfo.total += temp;
                iteminfo.itemCost[i] = sodaPrice;

                i++;
                m--;

            }
            else if (listArray[i][m].equals(blanket)) {//check if ID matches.
                m++;
                amount = listArray[i][m];
                temp = Double.parseDouble(amount);
                temp = temp * blanketPrice;
                iteminfo.total += temp;
                iteminfo.itemCost[i] = blanketPrice;

                i++;
                m--;

            }
            else if (listArray[i][m].equals(meat)) {//check if ID matches.
                m++;
                amount = listArray[i][m];
                temp = Double.parseDouble(amount);
                temp = temp * meatPrice;
                iteminfo.total += temp;
                iteminfo.itemCost[i] = meatPrice;

                i++;
                m--;

            }
            else if (listArray[i][m].equals(apples)) {//check if ID matches.
                m++;
                amount = listArray[i][m];
                temp = Double.parseDouble(amount);
                temp = temp * applesPrice;
                iteminfo.total += temp;
                iteminfo.itemCost[i] = applesPrice;

                i++;
                m--;

            }
        }
        return iteminfo;


    }
    sample.itemInfo getDescription(String[][] listArray) throws FileNotFoundException {//returns object containing the name of items in array... itemName[name1,name2...]
        sample.itemInfo iteminfo = new sample.itemInfo();
        int i = 0;
        int count = 0;
        // String[][] tempArray = new String[0][0];
        int linecount = linecounter();
        String bread = "123456";
        String soda = "234567";
        String blanket = "345678";
        String meat = "456789";
        String apples = "567891";

        while (i < linecount) {
            if(listArray[i][0].equals(bread)){
                iteminfo.itemName[count] = "Bread";
                //m++;

                iteminfo.itemAmount[count] = listArray[i][1];//get amount from listArray
                //n++;
                count++;
                i++;

            }
            else if (listArray[i][0].equals(soda)){
                iteminfo.itemName[count] = "Soda";

                iteminfo.itemAmount[count] = listArray[i][1];
                count++;
                i++;


            }
            else if (listArray[i][0].equals(blanket)){
                iteminfo.itemName[count] = "blanket";

                iteminfo.itemAmount[count] = listArray[i][1];
                count++;
                i++;


            }
            else if (listArray[i][0].equals(meat)){
                iteminfo.itemName[count] = "meat";

                iteminfo.itemAmount[count] = listArray[i][1];
                count++;
                i++;


            }
            else if (listArray[i][0].equals(apples)){
                iteminfo.itemName[count] = "apples";

                iteminfo.itemAmount[count] = listArray[i][1];
                count++;
                i++;


            }
        }
        return iteminfo;

    }

}//-----------------------------------------------------------------------End

