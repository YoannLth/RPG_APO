package rpg_apo;

public class Effect {

	private Characteristic c;
	private int value;
	private int permanent;
        
        //Create an effect with 
        //is characteristique (STRENGTH,DEXTERITY...) 
        //value (puissance) 
        //and is duration (nomber of turn)
        public Effect(Characteristic c, int v, int d){
            this.c=c;
            this.value=v;
            this.permanent=d;
        }
        
        
        
        //Lifetime of effect can be more than 1 turn
        //That why at the end of turn we reduce to 1
        
        //Un effet peut duré plusieur tour. 
        //A chaque fin de tour on le réduit de 1
        public void reduceDuration(){
            this.permanent--;
        }
        public int getDuration(){
            return this.permanent;
        }
        
        public int getValue(){
            return this.value;
        }
        
        public void applyEffect(Effect e, Character c){
            Characteristic characteristicToAlter = e.getCharacteristique();
            int valueAlteration = e.getValue();

            c.alterCharacteristic(characteristicToAlter, valueAlteration);
        }
        
        public Characteristic getCharacteristique(){
            return this.c;
        }
        
        public String effectString(){
            return "\n agit sur la Characteristique "+this.c+" avec une efficacité de " +this.value;
        }
}