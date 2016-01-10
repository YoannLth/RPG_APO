/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg_apo;

//import me.grea.antoine.utils.Menu;
import view.Game;

/**
 *
 * @author Matthieu
 */
public class RPG_APO {

    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
//        String title = "Prison Life";
//        String leave = "";
//        String[] choices = new String[3];
// 
//        choices[0] = "Nouvelle Partie";
//        choices[1] = "Charger une Partie";
//        choices[2] = "Quitter";
//        
//        Menu m = new Menu(title, leave, choices) {
//
//            @Override
//            protected void on(int i) {  
//                switch (i)
//                {
//                    case 0:
//                        System.getProperty("line.separator");
//                        System.out.println(items[0]);
//                        break;
//                    case 1:
//                        System.getProperty("line.separator");
//                        System.out.println(items[1]);
//                        break;
//                    case 2:
//                        System.getProperty("line.separator");
//                        System.out.println(items[2]);
//                        break;
//                    default:
//                        clearConsole();
//                        //this.display();
//                }
//            }
//            
//        };
//        
//        m.display();
        
        Game g = new Game("Prison Life");
        g.launchGame();
    }
    
}