package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class itemInfo{
 String[] itemName = new String[5];
 String[] itemAmount = new String[5];
 Double[] itemCost = new Double[5];
 double total;
 double temp = 0.0;

}


public class Project{//---------------------------------------------------------------Start


    //parses file and puts into 2d array
    String[][] parser() throws FileNotFoundException {
        int linecount = linecounter();
        File file = new File("C:/Users/Alex/IdeaProjects/SoftEngProject/src/sample/list.txt");
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
    private int linecounter() throws FileNotFoundException{
        int count = 0;
        File file = new File("C:/Users/Alex/IdeaProjects/SoftEngProject/src/sample/list.txt"); //point to users file
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
    itemInfo calculateCosts(String[][] listArray) throws FileNotFoundException {

        itemInfo iteminfo = new itemInfo();
        int i = 0;
        int m = 0;
        double total = 0.00;
        double temp = 0;
        double breadPrice = 4.50;
        double sodaPrice = 1.50;
        String amount;
        int linecount = linecounter();

        String bread = "123456";
        String soda = "234567";

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
            else if (listArray[i][m].equals(soda)) {
                m++;
                amount = listArray[i][m];
                temp = Double.parseDouble(amount);
                temp = temp * sodaPrice;
                iteminfo.total += temp;
                iteminfo.itemCost[i] = sodaPrice;

                i++;
                m--;

            }
        }
        return iteminfo;


    }
     itemInfo getDescription(String[][] listArray) throws FileNotFoundException {
         itemInfo iteminfo = new itemInfo();
        int i = 0;
        int count = 0;
       // String[][] tempArray = new String[0][0];
        int linecount = linecounter();
        String bread = "123456";
        String soda = "234567";

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
        }
        return iteminfo;

    }

}//-----------------------------------------------------------------------End
