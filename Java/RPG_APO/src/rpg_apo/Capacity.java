package rpg_apo;

public interface Capacity {

	/**
	 * 
	 * @param src
	 * @param target
	 */
	Effect effect(Character src, Character target);

	/**
	 * 
	 * @param src
	 */
	double probaReussite(Character src);

}