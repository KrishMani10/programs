package mani.utils;

import mani.collection.DataList;
import mani.model.Item;

public class GenerateData {
    public void generateData(DataList<Item> items){

        System.out.println("========================================================================");
        System.out.printf("%1$-8s%2$-15s%3$-15s%4$-15s%5$-15s\n","ItemNo","ItemName","ItemQuantity","ItemPrice",
                "ItemDiscount");
        System.out.println("========================================================================");
        System.out.println();
        for(int i=0;i< items.size();i++){
            System.out.printf("%1$-8s%2$-15s%3$-15s%4$-15s%5$-15s\n",items.get(i).getItemNo(),items.get(i).getItemName(),
                    items.get(i).getItemQuantity(),items.get(i).getItemPrice(),items.get(i).getItemDiscount());
        }
    }

}
