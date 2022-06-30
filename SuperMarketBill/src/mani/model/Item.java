package mani.model;

public class Item {
    private String itemName;
    private double itemPrice;
    private int itemNo;
    private double itemQuantity;
    private double itemDiscount;


    public Item(){

    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemQuantity(double itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setItemDiscount(double itemDiscount) {
        this.itemDiscount = itemDiscount;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemNo() {
        return itemNo;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public double getItemQuantity() {
        return itemQuantity;
    }

    public double getItemDiscount() {
        return itemDiscount;
    }

}
