<<<<<<< HEAD
package rpg_apo;

public class Item {

	private String name;
	private int weight;
	private Effect itemEffect;

=======
package rpg_apo;

public class Item {

	private String name;
	private int weight;
	private Effect itemEffect;
        
        public Item(String nom, int poid, Effect effet)
        {
            this.name = nom;
            this.weight = poid;
            this.itemEffect = effet;
        }
        
        public Effect getEffect(){
            return this.itemEffect;
        }
        
        public void setEffect(Effect effet){
            this.itemEffect=effet;
        }
        
        public String getName(){
            return this.name;
        }
        
        public int getWeight(){
            return this.weight;
        }
        
        
        public String itemString(){
            return "\nL'item "+this.name+" qui pese "+this.weight+" permet : "+this.itemEffect.effectString();
        }
        
>>>>>>> 9d67c8317edecf5580fa5d8354e419156e5cd81a
}