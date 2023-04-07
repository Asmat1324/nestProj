package nestProj;

import nestProj.Exceptions.InsufficientQuantityException;
import nestProj.Exceptions.ElementNotFoundException;
import nestProj.Exceptions.EmptyListException;
import nestProj.Lists.ArrayUnorderedList;
import nestProj.Lists.ArrayOrderedList;

import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner;
public class NestProjAPP
{
    public static void main(String[] args)
    {
/**
 * When a donation is made. The category will be checked for an item with the expiration date given.
 * If an item is found, then the quantity will increase by the given number. If an item is not found
 * a new item with the given expiration will be made in the given category with the quantity written.
 *
 * When an item is taken. The program will first check if the item exists and then check if the quantity
 * requested is less than or equal the current number of the item. If these turn out to be true, then the
 * amount taken will be removed from the quantity with the closest expiration date first. If the quantity
 * taken is the same as the quantity available, then the category will completely be removed. If the
 * quantity requested is more than what is available, then all of the available quantity is given and
 * an exception is thrown.
 *
 * When a removal takes place. All categories will be checked for expiration dates that are equal to or
 * earlier than the given date. If they do end up being earlier, the item will completely be removed.
 */
        try
        {
            ArrayUnorderedList<FoodCategory> inventory = new ArrayUnorderedList<FoodCategory>();
            File inv = new File("/Users/asmatullahkhan/eclipse-workspace/eclipse-workspace-new/NestProj/src/main/java/nestProj/inventory.txt");
            File log = new File("/Users/asmatullahkhan/eclipse-workspace/eclipse-workspace-new/NestProj/src/main/java/nestProj/dailylog.txt");
            Scanner inventoryFile = new Scanner(inv);
            Scanner logFile = new Scanner(log);
            //Following while will read in item data from the inventory.txt file and add items to an inventory.
            while(inventoryFile.hasNextLine())
            {
                FoodCategory addCat= new FoodCategory(inventoryFile.next());
                int quan = inventoryFile.nextInt();                  //reads in quantity of item.
                String expDate = inventoryFile.next();               // Reads in expiration date.
                Date tempDate = new Date(expDate);                   //Stores expiration date as Date object.
                FoodItem temp = new FoodItem(quan, tempDate);        //Creates a new FoodItem object.
                itemAdd(addCat, temp, inventory);    //Calls itemAdd method to add the FoodItem and category into
                                                    //the inventory ArrayUnorderedList.
            }
            System.out.println(inventory);

            while(logFile.hasNextLine())
            {
                String firstLetter = logFile.next();
                if(firstLetter.equals("a"))
                {
                    itemAdd(new FoodCategory(logFile.next()), new FoodItem(logFile.nextInt(), new Date(logFile.next())), inventory);
                    System.out.println("******\nItem Added\n******");
                }
                else if(firstLetter.equals("c"))
                {
                    System.out.println("******************************\nI N V E N T O R Y   E X P I R A T I O N   C H E C K \n******************************\nThe following items have been removed due to expiration:");
                    Date expDate = new Date(logFile.next());
                    for(int i = 0; i < inventory.size(); i++)
                    {
                        ArrayOrderedList<FoodItem> invList = inventory.get(i).deleteExpiredItems(expDate);
                        if( invList.size() !=0 )
                            System.out.println("Expired items that have been removed from category: " + inventory.get(i).getCategoryName() + "\n" + invList );

                    }
                    System.out.println("Inventory after items with expiry date before or on " + expDate.toString() + " have been removed:\n");
                }
                else if(firstLetter.equals("d"))
                {
                    try
                    {
                        FoodCategory newCat = new FoodCategory(logFile.next());
                        if(inventory.contains(newCat))
                        {
                            int newQuan = logFile.nextInt();
                            int newPos = inventory.indexOf(newCat);


                            System.out.println(inventory.get(newPos).deleteItems(newQuan) + " items have been removed from the " + newCat.getCategoryName() + " category.");
                        }
                        else
                        {
                            System.out.println(newCat.getCategoryName() + " is not present.");
                            logFile.nextInt();
                        }
                    }
                    catch (InsufficientQuantityException ex)
                    {
                        System.out.println(ex);
                    }
                }
            }

            System.out.println("\nFinal state of inventory:\n"+inventory);
        }
        //Catch statement if provided file is not found
        catch(FileNotFoundException ex)
        {
            System.out.println(ex);
        }
        //
        catch(EmptyListException ex) {
            System.out.println(ex);
        }
        catch(ElementNotFoundException ex) {
            System.out.println(ex);
        }

    }
    public static void itemAdd(FoodCategory addit, FoodItem temp, ArrayUnorderedList<FoodCategory> input1)
    {
        if(input1.indexOf(addit) == -1)
        {
            input1.addToFront(addit);
            input1.first().addItem(temp);
        }
        else
        {
            int pos = input1.indexOf(addit);
            input1.get(pos).addItem(temp);
        }
    }
}
