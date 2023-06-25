package edu.itpu.fopjava_course_work.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Medication implements Serializable {
   private int id;
   private String name;
   private List<String> categories;
   private double price;
   private int quantity;

   private String expirationDate;


   public Medication(){
       super();
   }

    public int getId(){
        return id;
    }//end of getID

    public String getName() {
        return name;
    }//end of getName

    public List<String> getCategories(){
         return categories;
    }//end of getCategories

    public double getPrice(){
        return price;
    }//end of getPrice
    public int getQuantity(){
        return quantity;
    }//end of getQuantity

    public String getExpirationDate(){return expirationDate;}//end of getDate

    public Medication setId(int id) {
        this.id = id;
        return this;
    }//end of setID

    public Medication setName(String name) {
        this.name = name;
        return this;
    }//end of setName

    public Medication setCategories(List<String> categories) {
        this.categories = categories;
        return this;
    }//end of setCategories

    public Medication setPrice(double price) {
        this.price = price;
        return this;
    }//end of setPrice

    public Medication setQuantity(int quantity) {
        this.quantity = quantity;
    return this;
    }//end of setQuantity

    public Medication setDate(String exdate){
        this.expirationDate = exdate;
        return this;
    }

    @Override
    public String toString() {
        return "[id: "+id+", name: "+name+", category: "+
                categories+", price: "+price+", quantity: "+quantity+
                ", expiration date: "+expirationDate+"]";
    }//end of toString

    @Override
    public int hashCode() {
        return Objects.hash(id, name, categories,price, quantity,expirationDate);
    }//end of hashCode

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;

        Medication other = (Medication) obj;
        return id == other.id && Objects.equals(name, other.name)
               && this.categories.equals(other.categories)
               && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
               && quantity == other.quantity && Objects.equals(expirationDate, other.expirationDate);
    }//end of equals
}//end of Medication