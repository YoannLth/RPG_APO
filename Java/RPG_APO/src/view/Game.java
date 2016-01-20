package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yoann
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import rpg_apo.Armor;
import rpg_apo.Boxer;
import rpg_apo.Highbrow;
import rpg_apo.MaleNurse;
import rpg_apo.NewCall;
import rpg_apo.Character;
import rpg_apo.CharacterType;
import rpg_apo.Characteristic; 
import rpg_apo.ConsumableItem;
import rpg_apo.ControlerUI;
import rpg_apo.EnnemyTeam;
import rpg_apo.Event;
import rpg_apo.Item;
import rpg_apo.NewDay;
import rpg_apo.NewFight;
import rpg_apo.Team;
import rpg_apo.Weapon;
import static view.Console.*;

public class Game {
    
    private ArrayList<Character> team1;
    private ArrayList<Character> team2;
    
    private Character playableCharacter;
    
//    private Map<Integer, Event> introGame;
//    private Map<Integer, Event> introContext;
//    private Map<Integer, Event> newPlayableCharacter;
//    private Map<Integer, Map<Integer, Event>> gameEvents;
    
//    private Map<Integer, Event>  introPremierJour;
    
    private ArrayList<EnnemyTeam> ennemies;
    private ArrayList<Item> itemsGame;
    private Team playerTeam;
    
    public Game(){
//        gameEvents = new HashMap();
//        introGame = new HashMap();
//        introContext = new HashMap();
//        newPlayableCharacter = new HashMap();
        ennemies = new ArrayList<EnnemyTeam>();
        playerTeam = new Team("Equipe j1");
        itemsGame = new ArrayList<Item>();
    }
    
    public void launchGame(){
        initializeGameObjects();
        //initializeEvents();
        //readEvents();
        //initializeGameObjects();
        
        //introJeu();
        introJoueur();
        //introTutorialDay();
        //introTutorialNight();
        
        newDay();
        
        //while(true){
            
        //}
        
        //testCombat();
    }
    
    
    public void introJeu(){        
        
        //Affichage du script qui introduit le contexte du jeu
        displayBlack("Vous etes sur le point de repartir d'Amerique du sud ou vous avez effectué un agréable voyage au dépend de vos ressources.");
        displayBlack("Pour rembourser les extras trop nombreux de votre voyage vous avez accepter un deal pour ramener de la drogue en France.");
        displayBlack("Vous vous rendez donc à l'aéroport de Lima, pour prendre votre vol direction Paris.");
        displayContinue();
        displayBlack("Après quelques minutes de marches dans le hall de l'aéroport, vous appercevez un controle de douane. Vous êtes nerveux...");
        displayBlack("Votre démarche vous trahi, vous transpirez et vous regardez sans arrêts derriere vous");
        displayBlack("Cela n'échappe pas au dounier, posté a 5 mètre de vous, qui vous interpelle...");
        displayContinue();
        displayBlack("Il était petit et très maigre. Il portait un uniforme vert kaki et parlait dans son talkie-walkie.");
        displayBlack("A peine apres vous être présenté a lui, son chien renifle votre valise et marque une pose au sol.");
        displayBlack("Malheur, 3 autres douanier le rejoigne et vous demande de ne plus bouger.");
        displayBlack("Appeuré, vous lui demandez ce qu'il se passe. Il vous demande de le suivre.");
        displayContinue();
        displayBlack("Vous vous trouvez maintenant dans un bureau.");
        displayBlack("Devant vous un homme assis donne l'odre d'ouvrir votre valise...");
        displayBlack("C'est avec fausse stupeur que vous découvez à l'interieur, 5 sachets de poudre blanches.");
        displayBlack("Vous les aviez pourtant bien caché à l'interieur de la doublure.");
        displayContinue();
        displayBlack("Apres de long échanges, en esseyant tant bien que mal de vous défendre, en pretextant avoir été piégé, le douanier vous explique que vous allez devoir passer quelques jours en prison.");
        displayBlack("Avant de passer au tribunal.");
        displayContinue();
        displayBlack("*4 semaines plus tard*");
        displayBlack("Votre avocat sur place a pourtant esseyé de prouver votre innocence, mais le tribunal à tranché...");
        displayContinue();
        displayBlack("Vous êtes condanné a 30 ans pour traffic de drogue.");
        displayBlack("Vous serez incarséré dès demain à la Prison de Luriguancho.");
        displayBlack("Votre aventure commence maintenant...");
        displayContinue();
    }
    
    public void introJoueur(){
        displayBlack("*Le lendemain*");
        displayBlack("Après avoir passé la nuit au poste de police, on vous a transferé dans la prison.");
        displayBlack("Vous êtes avec le gardien qui vous conduit jusqu'a votre cellule");
        displayContinue();
        
        displayBlack("\t- GARDIEN : Bienvenue chez toi le nouveau...");
        displayContinue();
        
        displayBlack("\t- HOMME 1 : Personne nous as prevenue de ton arrivé, t'es qui toi?!");
        displayRed("Entrez votre nom :");
        Scanner scanner = new Scanner(System.in);
        String pCharacterName = scanner.next();
        
        lineBreak();
        lineBreak();
        displayBlack("\t- HOMME 1 : " + pCharacterName + "... Qu'est-ce que tu faisait avant d'arriver ici?");
        displayBlack("\t1 - Boxeur");
        displayBlack("\t2 - Infirmier");
        displayBlack("\t3 - Intellectuel");
        displayRed("Choisissez une classe :");
        
        int pCharacterClass = ControlerUI.readInt("Selectionner un nombre entre 1 et 3", 1, 3);
        switch (pCharacterClass){
                case 1:
                    playableCharacter = new Boxer(pCharacterName,CharacterType.HUMAN);
                    break;
                case 2:
                    playableCharacter = new MaleNurse(pCharacterName,CharacterType.HUMAN);
                    break;
                case 3:
                    playableCharacter = new Highbrow(pCharacterName,CharacterType.HUMAN);
                    break;
        }
        playableCharacter.initCharacteristics(1);
        
        String className = playableCharacter.getClassName();
        switch (className){
            case "Boxeur":
                displayBlack("\t- PERSONNAGE : J'était boxeur, champion de France poids lourd");
                displayBlack("    On m'a choppé avec 1 kilo de Cocaïne");
                displayBlack("    Une blessure m'a tout fait arreté. J'avait aucune rentrée d'argent depuis 5 mois. Je pensait que c'était un coup facile");
                lineBreak();
                displayBlack("\t- HOMME 1 : Moi c'est Hector, lui le grand, c'est Jese, mon frère.");
                displayBlack("    On a quelque emmerdes avec des mecs du bloc C");
                displayBlack("    Si tu assure mes arrières le temps qu'il s'en remette, on te le revaudra.");
                lineBreak();
                displayBlue("Vous acceptez d'aider Hector, votre premier contact avec vos compagnons de cellule c'est bien passé");
                break;
            case "Infirmier":
                displayBlack("\t- PERSONNAGE : Heuuuu.... Je... J'était infirmier en France...");
                displayBlack("    On m'a choppé avec 1 kilo de Cocaïne");
                displayBlack("    Je voulais juste me faire un peu d'argent, mon boulot ne paye pas très bien...");
                lineBreak();
                displayBlack("\t- HOMME 1 : Moi c'est Hector, lui le grand, c'est Jese, mon frère.");
                displayBlack("    Tu tombe bien, Jese c'est fait planté hier pendant la promenade.");
                displayBlack("    Si tu veut qu'on reste ami, commence par le soigner");
                lineBreak();
                displayBlue("Vous soignez Jese, votre premier contact avec vos compagnons de cellule c'est plutôt bien passé");
                break;
            case "Intellectuel":
                displayBlack("\t- PERSONNAGE : Heuuuu.... Je... J'était étudiant en Psychologie...");
                displayBlack("    J'ai esseyé de passer l'aéroport avec 1 kilo de Cocaïne");
                displayBlack("    Je voulais juste me faire un peu d'argent, pour rembourser mon prêt étudiant...");
                lineBreak();
                displayBlack("\t- JESE : Ho ho ho... Monsieur l'étudiant en Psychologie... Je sais pas encore comment, mais tu pourrai nous être utile.");
                lineBreak();
                displayBlue("Votre premier contact avec vos compagnons de cellule c'est plutôt bien passé");
                break;
        }
        displayContinue();
        
        Character hector = new Boxer("Hector",CharacterType.HUMAN);
        hector.initCharacteristics(1);
        Character jese = new MaleNurse("Jese",CharacterType.HUMAN);
        jese.initCharacteristics(1);

        playerTeam.addMember(playableCharacter);
        playerTeam.addMember(hector);
        playerTeam.addMember(jese);
        
        displayBlue("Jese et Hector viennent de rejoindre votre équipe!");
        displayContinue();
    }
    
    public void introTutorialDay(){
        displayBlack("\t - HECTOR : Mec, viens faire un tour avec moi dans la cours, je vais t'expliquer le fonctionnement");
        displayBlack("\t - PERSONNAGE : Ok, si tu veux");
        displayContinue();
        
        displayBlack("\t - HECTOR : On y est, comme tu peux le voir, il y a peu de trucs a faire...");
        displayBlack("\t - PERSONNAGE : Wooooouah! Mais c'est surpeuplé ici!?");
        displayBlack("\t - HECTOR : *rires* On s'y habitue, tu verra...");
        displayBlack("\t   Par contre je préfère te prevenir, ici, tout s'achette. Si tu veut survivre, il te faut de l'argent.");
        displayBlack("\t - PERSONNAGE : Et comment?");
        displayBlack("\t - HECTOR : Il y a peu de choses a faire ici.");
        displayBlack("\t   Tu peut par exemple appeler tes proches, ils pourront peut etre te donner de l'argent.");
        displayBlack("\t   Tu peut aussi en gagner en travaillant, mais c'est très mal payé.");
        displayBlack("\t   Et plus simplement, tu peut faire parler tes poings pour raquetter des mecs de la prison, mais c'est plus risqué. Ici, tout le monde appartient a un Gang.");
        displayBlack("\t - PERSONNAGE : Des gangs?");
        displayBlack("\t - HECTOR : Ouais, il sont plus ou moins puissant, mais je te conseille de faire attention.");
        displayBlack("\t - PERSONNAGE : Merci du conseil...");
        displayBlack("\t - HECTOR : Une derniere chose.");
        displayBlack("\t   Vu le nombre de détenus, tu poura faire au maximum une seule activité par jour. Ensuite, retour a la cellule");
        displayContinue();
        
        displayBlue("Vous avez fini le didactitiel des activités de jour");
        displayContinue();
    }
    
    public void newDay(){
        NewDay nd = new NewDay(playableCharacter, playerTeam, ennemies);
        nd.display();
    }
    
    public void introTutorialNight(){
        displayBlack("\t - HECTOR : Maintenant que tu as vu la cours, je vais te présenter la cellule plus en details");
        displayContinue();
        
        displayBlack("\t - HECTOR : Voila, c'est ici que tu va passer tout tes nuits...");
        displayBlack("\t - PERSONNAGE : ...");
        displayBlack("\t - HECTOR : Ici, il y'a encore moins de choses a faire que la journée");
        displayBlack("\t   Tu peut juste gérer tes affaires personelles.");
        displayBlack("\t - PERSONNAGE : C'est vraiment horrible, je peut pas rester ici");
        displayBlack("\t - HECTOR : *silence* Il y a peu de choses a faire ici.");
        displayBlack("\t   Moi et Jese, on a pris perpet'. On sortira pas ici avant 45 ans...");
        displayBlack("\t - PERSONNAGE : Ou-est ce que tu veut en venir?");
        displayBlack("\t - HECTOR : *A voie basse* On a un plan pour s'échapper...");
        displayBlack("\t - PERSONNAGE : Je viens avec vous.");
        displayBlack("\t - HECTOR : Tu pourra, mais pour l'instant, il nous manque 1000 dollars pour organiser la fuite.");
        displayBlack("\t - PERSONNAGE : T'inquiete, on les trouvera.");
        displayContinue();
        
        displayBlue("Vous avez fini le didactitiel des activités de nuit");
        displayBlue("Vous avez maintenant un objectif, réunir 1000$ pour organiser votre évasion!");
        displayContinue();
    }
    
    
    public void testCombat(){
        team1 = new ArrayList<Character>();
        team2 = new ArrayList<Character>();
        
        //Initialise les caracteristique basique 100 10 10 10
        Map<Characteristic, Integer> c = new HashMap();
        c.put(Characteristic.HEALTH, 100);
        c.put(Characteristic.DEFENCE, 10);
        c.put(Characteristic.DEXTERITY, 10);
        c.put(Characteristic.STRENGTH, 10);
        
        //Initialise les équipe avec nom est CharactereType
        Character c1a = new Boxer("Combatant_1_t1",CharacterType.HUMAN);
        Character c1b = new MaleNurse("Combatant_2_t1",CharacterType.HUMAN);
        //Character c1c = new Highbrow("Combatant_3_t1",CharacterType.HUMAN);
        
        Character c2a = new Boxer("Combatant_1_t2",CharacterType.IA);
        Character c2b = new MaleNurse("Combatant_2_t2",CharacterType.IA);
        //Character c2c = new Highbrow("Combatant_3_t2",CharacterType.HUMAN);
        
        c1a.initCharacteristic(110, 100, 100, 10);
        c1b.initCharacteristic(110, 100, 100, 10);
        //c1c.initCharacteristic(10, 10, 100, 10);
        
        c2a.initCharacteristic(10, 10, 100, 1);
        c2b.initCharacteristic(10, 10, 100, 1);
        //c2c.initCharacteristic(10, 10, 100, 1);
        
        team1.add(c1a);
        team1.add(c1b);
        //team1.add(c1c);
        
        team2.add(c2a);
        team2.add(c2b);
        //team2.add(c2c);
        
//        NewFight fightTest = new NewFight(team1,team2);
//        fightTest.display();
        
//        NewFight fightTest2 = new NewFight(team1,team2);
//        fightTest2.display();
    }
    
    public void initializeGameObjects(){
        ConsumableItem growthHormone = new ConsumableItem("Hormone de croissance", 1, Characteristic.STRENGTH, 10, "hormones qui augmente la force temporairement de 10 points");
        ConsumableItem creatin = new ConsumableItem("Créatine", 2, Characteristic.STRENGTH, 20, "substance qui augmente la force temporairement de 20 points");
        ConsumableItem steroid = new ConsumableItem("Stéroides", 3, Characteristic.STRENGTH, 30, "substance qui augmente la force temporairement de 30 points");
    
        ConsumableItem cafein = new ConsumableItem("Caféïne", 1, Characteristic.DEXTERITY, 10, "substance qui augmente la dexterité temporairement de 10 points");
        ConsumableItem ginseng = new ConsumableItem("Ginseng", 2, Characteristic.DEXTERITY, 20, "substance qui augmente la dexterité temporairement de 20 points");
        ConsumableItem taurine = new ConsumableItem("Taurine", 3, Characteristic.DEXTERITY, 30, "substance qui augmente la dexterité temporairement de 30 points");
        
        ConsumableItem miniAdrenaline = new ConsumableItem("Mini dose d'adrénaline", 1, Characteristic.HEALTH, 10, "substance qui augmente la santé de 25 points");
        ConsumableItem superAdrenaline = new ConsumableItem("Super dose d'adrénaline", 2, Characteristic.HEALTH, 20, "substance qui augmente la santé de 50 points");
        ConsumableItem maxiAdrenaline = new ConsumableItem("Maxi dose d'adrénaline", 3, Characteristic.HEALTH, 30, "substance qui augmente la force santé de 100 points");
        
        ConsumableItem vodka = new ConsumableItem("Shot de vodka", 1, Characteristic.DEFENCE, 10, "substance qui augmente votre résitance aux coups temporairement de 10 points");
        ConsumableItem cocaine = new ConsumableItem("Ligne de cocaïne", 2, Characteristic.DEFENCE, 20, "substance qui augmente la force temporairement de 20 points");
        ConsumableItem captagon = new ConsumableItem("Captagon", 3, Characteristic.DEFENCE, 30, "substance qui augmente la force temporairement de 30 points");
        
        Weapon razorBlade = new Weapon("Lame de rasoir", 4, 5, 60, "arme tranchante moyennement maniable qui inflige de faible dégats (5 points)");
        Weapon knuckle = new Weapon("Poing-Américain", 5, 10, 90, "arme extrèmement maniable qui inflige des dégats moyens (10 points)");
        Weapon knife = new Weapon("Couteau de chase", 6, 20, 90, "arme tranchante extrèmement maniable qui inflige de lourds dégats (20 points)");
        
        Armor foamGloves = new Armor("Gants avec renforts en mousse", 4, 5, "gants légers qui protègent faiblement le personnage");
        Armor plasticGloves = new Armor("Gants avec renforts en plastique", 5, 10, "gants qui protègent moyennement le personnage");
        Armor kevlarGloves = new Armor("Gants avec renforts en kevlar", 6, 20, "gants lourds qui protègent fortement le personnage");
        
        Armor foamTShirt = new Armor("Gants avec renforts en mousse", 4, 5, "t-shirt légers qui protègent faiblement le personnage");
        Armor plasticTShirt = new Armor("Gants avec renforts en plastique", 10, 5, "t-shirt lourds qui protègent moyennement le personnage");
        Armor kevlarTShirt = new Armor("Gants avec renforts en kevlar", 6, 20, "t-shirt lourds qui protègent fortement le personnage");
        
        itemsGame.add(growthHormone);
        itemsGame.add(creatin);
        itemsGame.add(steroid);
        itemsGame.add(cafein);
        itemsGame.add(ginseng);
        itemsGame.add(taurine);
        itemsGame.add(miniAdrenaline);
        itemsGame.add(superAdrenaline);
        itemsGame.add(maxiAdrenaline);
        itemsGame.add(vodka);
        itemsGame.add(cocaine);
        itemsGame.add(captagon);
        itemsGame.add(razorBlade);
        itemsGame.add(knuckle);
        itemsGame.add(knife);
        itemsGame.add(foamGloves);
        itemsGame.add(plasticGloves);
        itemsGame.add(kevlarGloves);
        itemsGame.add(foamTShirt);
        itemsGame.add(plasticTShirt);
        itemsGame.add(kevlarTShirt);

                
        ArrayList<Character> gang1Members = new ArrayList<Character>();
        ArrayList<Character> gang2Members = new ArrayList<Character>();
        ArrayList<Character> gang3Members = new ArrayList<Character>();
        
        Character piranha1 = new Boxer("Joaquin",CharacterType.IA);
        Character piranha2 = new Highbrow("Jesus",CharacterType.IA);
        Character piranha3 = new MaleNurse("Cesar",CharacterType.IA);
        piranha1.initCharacteristics(1);
        piranha2.initCharacteristics(1);
        piranha3.initCharacteristics(1);
        gang1Members.add(piranha1);
        gang1Members.add(piranha2);
        gang1Members.add(piranha3);
        
        Character eme1 = new Boxer("Enrique",CharacterType.IA);
        Character eme2 = new Highbrow("Ricardo",CharacterType.IA);
        Character eme3 = new MaleNurse("Horacio",CharacterType.IA);
        eme1.initCharacteristics(2);
        eme2.initCharacteristics(2);
        eme3.initCharacteristics(2);
        gang2Members.add(eme1);
        gang2Members.add(eme2);
        gang2Members.add(eme3);
        
        Character maras1 = new Boxer("Ramiro",CharacterType.IA);
        Character maras2 = new Highbrow("Diego",CharacterType.IA);
        Character maras3 = new MaleNurse("Juan-Carlos",CharacterType.IA);
        maras1.initCharacteristics(3);
        maras2.initCharacteristics(3);
        maras3.initCharacteristics(3);
        gang3Members.add(maras1);
        gang3Members.add(maras1);
        gang3Members.add(maras1);
        
        ArrayList<Item> gang1Rewards = new ArrayList<Item>();
        ArrayList<Item> gang2Rewards = new ArrayList<Item>();
        ArrayList<Item> gang3Rewards = new ArrayList<Item>();
        
        gang1Rewards.add(growthHormone);
        gang2Rewards.add(creatin);
        gang3Rewards.add(steroid);
        gang1Rewards.add(cafein);
        gang2Rewards.add(ginseng);
        gang3Rewards.add(taurine);
        gang1Rewards.add(miniAdrenaline);
        gang2Rewards.add(superAdrenaline);
        gang3Rewards.add(maxiAdrenaline);
        gang1Rewards.add(vodka);
        gang2Rewards.add(cocaine);
        gang3Rewards.add(captagon);
        gang1Rewards.add(razorBlade);
        gang2Rewards.add(knuckle);
        gang3Rewards.add(knife);
        gang1Rewards.add(foamGloves);
        gang2Rewards.add(plasticGloves);
        gang3Rewards.add(kevlarGloves);
        gang1Rewards.add(foamTShirt);
        gang2Rewards.add(plasticTShirt);
        gang3Rewards.add(kevlarTShirt);
        
        
        EnnemyTeam gang1 = new EnnemyTeam("Gang des Piranhas de Lima", gang1Members, 1, gang1Rewards);
        EnnemyTeam gang2 = new EnnemyTeam("Gang de la Mara Salvatrucha", gang2Members, 2, gang2Rewards);
        EnnemyTeam gang3 = new EnnemyTeam("Gang de la eMe de Cuzco", gang3Members, 3, gang3Rewards);
        
        ennemies.add(gang1);
        ennemies.add(gang2);
        ennemies.add(gang3);
    }
}
