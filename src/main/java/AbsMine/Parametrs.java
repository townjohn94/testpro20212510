package AbsMine;

public abstract class Parametrs {
	String name;
	 String price;
	 
	public String getName() {
	       return name;
	   }
	public String getPrice() {
	       return price;
	   }
	
	
	public abstract void setName(String name);
	public abstract void setPrice(String price);
}
