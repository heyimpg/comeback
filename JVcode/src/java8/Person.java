package java8;

public class Person {
   private int ID;
   private String Name;
   private float Price;

   public Person(int ID, String name, float price) {
      this.ID = ID;
      Name = name;
      Price = price;
   }

   public int getID() {
      return ID;
   }

   public void setID(int ID) {
      this.ID = ID;
   }

   public String getName() {
      return Name;
   }

   public void setName(String name) {
      Name = name;
   }

   public float getPrice() {
      return Price;
   }

   public void setPrice(float price) {
      Price = price;
   }

   @Override
   public String toString() {
      return "Person{" +
              "ID=" + ID +
              ", Name='" + Name + '\'' +
              ", Price=" + Price +
              '}';
   }
}
