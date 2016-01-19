package rpg_apo;


public class Item {

	private String name;
	private int weight;
	private Effect itemEffect;
        private String itemExplaination;
                
        public Item(String nom, int poid, Effect effet, String itExplaination)
        {
            this.name = nom;
            this.weight = poid;
            this.itemEffect = effet;
            this.itemExplaination = itExplaination;
        }
        
        public Item(String nom, int poid, String itExplaination)
        {
            this.name = nom;
            this.weight = poid;
            this.itemEffect = null;
            this.itemExplaination = itExplaination;
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
        
        public String getItemInfos(){
            return this.name + " ( poids : " + this.weight + " action : " + this.itemExplaination + ")";
        }
        
        public String itemString(){
            return "\nL'item "+this.name+" qui pese "+this.weight+" permet : "+this.itemEffect.effectString();
        }
}