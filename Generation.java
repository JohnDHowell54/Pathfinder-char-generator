import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Handles the actual generation
 * 
 * @author John
 */
public class Generation
{
    //The random number gen
    Random rn = new Random();
    //contains the char info
    String chClass;
    String chRace;
    String chSkills;
    int skillPL;
    String chSPL;
    //Hashmap for stats
    HashMap<String,Integer> stats;
    HashMap<Integer,String> pfClass;
    HashMap<Integer, String> pfRace;
    //Files to read info from
    File classRead = new File("classes.txt");
    File raceRead = new File("races.txt");
    File skillsRead = new File("skills.txt");
    //Scanners to scan classes & race
    Scanner classScan;
    Scanner raceScan;
    Scanner skillScan;
    

    /**
     * Constructor for objects of class Generation
     */
    public Generation() throws FileNotFoundException
    {
       stats = new HashMap<String,Integer>();
       pfClass = new HashMap<Integer, String>();
       pfRace = new HashMap<Integer, String>();
       
       classScan = new Scanner(classRead);
       raceScan = new Scanner(raceRead);
       int i =1;
       
       //Add the classes to the pfClass HashMap. 
       while(classScan.hasNext())
       {
    	   String scanClass = classScan.nextLine();
    	   pfClass.put(i, scanClass);
    	   i++;
       }
       
       
       
       int x = 1;
       //Add the race to the pfRace hashmap
       while(raceScan.hasNext())
       {
    	   String scanRace = raceScan.nextLine();
    	   pfRace.put(x, scanRace);
    	   x++;
       }
       

       
    }
    
    //The functions to simulate a roll and to drop the lowest of 4 rolls
    
    public int roll(int x, int y)
    {
       int result = rn.nextInt(y - x +1) + x;
       return result;
    }
     /**
      * This function calls roll 4 times
      * and drops the lowest number
      */
    public int dropLowest()
    {
        int first  = roll(1,6);
        int second   = roll(1,6);
        int third  = roll(1,6);
        int fourth = roll(1,6);
        
        int low = first;
        
        if( low < second)
        {
            low = second;
        }
        if( low < third)
        {
            low = third;
        }
        if ( low < fourth)
        {
            low = fourth;
        }
        int result = first + second + third+ fourth - low;
        return result;
        
    }
    
    //Function to roll a stat
    /**
     * Rolls a stat
     * @param: The name of the stat
     */
    public void rollStat(String stat)
    {
        int num = dropLowest();
        stats.put(stat,num);
    }
    
    /**
     * Rolls all the stats at once
     */
    public void genStats()
    {
        rollStat("Strength");
        rollStat("Dex");
        rollStat("Con");
        rollStat("Int");
        rollStat("Wis");
        rollStat("Cha");
        
    }
    
     /**
     * Generates a class from the hashmap pfClass
     */
    public String genClass()
    {
        int classNum= roll(1,11);
        chClass = pfClass.get(classNum);
        return chClass;
    }
    /**
     * Generates a race from the hashmap pfRace
     */
    public String genRace()
    {
        int raceNum= roll(1,7);
        chRace = pfRace.get(raceNum);
        return chRace;
    }
    /**
     * Method to get the class skills.
     * @throws FileNotFoundException 
     */
    public String getClassSkills() throws FileNotFoundException
    {
    	
    	skillScan = new Scanner(skillsRead);
    	
    switch(chClass) {
    	case "Barbarian":
    		while(skillScan.hasNext())
    		{
    		if(skillScan.nextLine().equals("Barbarian"))
    		{
    			chSkills = skillScan.nextLine();
    			chSPL = "You have 4 + int modifier points to spend per level \n";
    			break;
    		}
    		else
    			skillScan.nextLine();
    		}
    		break;
    	case "Bard":
    		while(skillScan.hasNext())
    		{
    		if(skillScan.nextLine().equals("Bard"))
    		{
    			chSkills = skillScan.nextLine();
    			chSPL = "You have 6 + int modifier points to spend per level \n";
    			break;
    		}
    		else
    			skillScan.nextLine();
    		}
    		break;
    	case "Cleric":
    		while(skillScan.hasNext())
    		{
    		if(skillScan.nextLine().equals("Cleric"))
    		{
    			chSkills = skillScan.nextLine();
    			chSPL = "You have 2 + int modifier points to spend per level \n";
    			break;
    		}
    		else
    			skillScan.nextLine();
    		}
    		break;
    	case "Druid":
    		while(skillScan.hasNext())
    		{
    		if(skillScan.nextLine().equals("Druid"))
    		{
    			chSkills = skillScan.nextLine();
    			chSPL = "You have 4 + int modifier points to spend per level \n";
    			break;
    		}
    		else
    			skillScan.nextLine();
    		}
    		break;
    	case "Fighter":
    		while(skillScan.hasNext())
    		{
    		if(skillScan.nextLine().equals("Fighter"))
    		{
    			chSkills = skillScan.nextLine();
    			chSPL = "You have 2 + int modifier points to spend per level \n";
    			break;
    		}
    		else
    			skillScan.nextLine();
    		}
    		break;
    	case "Monk":
    		while(skillScan.hasNext())
    		{
    		if(skillScan.nextLine().equals("Monk"))
    		{
    			chSkills = skillScan.nextLine();
    			chSPL = "You have 4 + int modifier points to spend per level \n";
    			break;
    		}
    		else
    			skillScan.nextLine();
    		}
    		break;
    	case "Paladin":
    		while(skillScan.hasNext())
    		{
    		if(skillScan.nextLine().equals("Paladin"))
    		{
    			chSkills = skillScan.nextLine();
    			chSPL = "You have 2 + int modifier points to spend per level \n";
    			break;
    		}
    		else
    			skillScan.nextLine();
    		}
    		break;
    	case "Ranger":
    		while(skillScan.hasNext())
    		{
    		if(skillScan.nextLine().equals("Ranger"))
    		{
    			chSkills = skillScan.nextLine();
    			chSPL = "You have 6 + int modifier points to spend per level \n";
    			break;
    		}
    		else
    			skillScan.nextLine();
    		}
    		break;
    		
    	case "Rogue":
    		while(skillScan.hasNext())
    		{
    		if(skillScan.nextLine().equals("Rogue"))
    		{
    			chSkills = skillScan.nextLine();
    			chSPL = "You have 8 + int modifier points to spend per level \n";
    			break;
    		}
    		else
    			skillScan.nextLine();
    		}
    		break;
    		
    	case "Sorcerer":
    		while(skillScan.hasNext())
    		{
    		if(skillScan.nextLine().equals("Sorcerer"))
    		{
    			chSkills = skillScan.nextLine();
    			chSPL = "You have 2 + int modifier points to spend per level \n";
    			break;
    		}
    		else
    			skillScan.nextLine();
    		}
    		break;
    		
    	case "Wizard":
    		while(skillScan.hasNext())
    		{
    		if(skillScan.nextLine().equals("Wizard"))
    		{
    			chSkills = skillScan.nextLine();
    			chSPL = "You have 2 + int modifier points to spend per level \n";
    			break;
    		}
    		else
    			skillScan.nextLine();
    		}
    		break;
    			}
        
        
        
        
        return chSkills;
    }
    
    /*
     * This method checks for racial bonuses
     */
    public void raceBonus()
    {
    	switch(chRace){
    	case "Dwarf":
    		int con = stats.get("Con") + 2;
    		int wis = stats.get("Wis") + 2;
    		int cha = stats.get("Cha") - 2;
    		stats.put("Con",con);
    		stats.put("Wis", wis);
    		stats.put("cha", cha);
    		break;
    		
    	case "Elf":
    		 con = stats.get("Con") - 2;
    		 int dex = stats.get("Dex") + 2;
    		 int intel = stats.get("Int") + 2;
    		 stats.put("Con", con);
    		 stats.put("Dex", dex);
    		 stats.put("Int",intel);
    		 break;
    		
    		case "Gnome":
    		con = stats.get("Con") + 2;
    		cha = stats.get("Cha") +2;
    		int str = stats.get("Str") -2;
    		stats.put("Con",con);
    		stats.put("Cha",cha);
    		stats.put("Str", str);
    		break;
    		
    	case "Halfling":
    		dex = stats.get("Dex");
    		cha = stats.get("Cha") + 2;
    		str = stats.get("Str") -2;
    		stats.put("Dex", dex);
    		stats.put("Cha",cha);
    		stats.put("Str", str);
    		break;
    	
    		
    		
    	
    	
    	
    	}
    	
    }
    
    
    
    
    //Methods to print things
    /**
     * Prints a specific stat
     * @param: the stat to print
     */
    public String printStat(String pr)
    {
        String ret = ( pr + " " + stats.get(pr));
        
        return ret;
    }
    public String printClass()
    {
        return chClass;
    }
    /**
     * Prints all the stuff
     * @throws FileNotFoundException 
     */
    public String printAll() throws FileNotFoundException
    {
        String allStat = "Class: " +
        genClass() + "\n"
        + "Race: " + genRace() + "\n"
        + printStat("Strength") + "\n"
        + printStat("Dex") + "\n"
        + printStat("Con") + "\n"
        + printStat("Int") + "\n"
        + printStat("Wis") + "\n"
        + printStat("Cha") + "\n" + 
        "Skills: \n" +
        
        getClassSkills() + "\n"
        + chSPL + "\n"; //extra \n for another blank line between two gens
        
        return allStat;
        
    }
    
 
}
