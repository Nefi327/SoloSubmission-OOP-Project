import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;



/**
 *
 * @author Fabian.S
 */

//This class stores all the pledges made, 
//and makes it possbiel to search for them and remove them

public class PledgeManager {
    
    //ArrayList for the pledge objects
    private ArrayList<Pledge> pledges;
   
    //file name for saving pledges
    private static final String FILE_NAME = "pledges.txt";
    
    //constructor
    public PledgeManager() {
        pledges = new ArrayList<>();  //this create and empty lsit when app starts
        loadFromFile();
    }
    
    //method for  'add' function
    public void addPledge(Pledge p) {
        pledges.add(p);
        saveToFile();
    }
    
    //method for 'display' function
    public ArrayList<Pledge> getAllPledge(){    
        return pledges;  //will be used to display all pledges in ImpactSummaryScreen
    }
    
    //method for 'search' function
    public Pledge findByName(String name){
        for (Pledge p : pledges) {
            if (p.getUserName().equalsIgnoreCase(name)){
                return p;  //returns the pledge closest to one beaing searched for
            }
        }
        return null;  //this is if no match was found at all
    }
    //method for 'delete' function
    public boolean removeByName(String name){  //uses search method to locate the pledge and then delete it
        Pledge p = findByName(name);
        if (p != null) {
            pledges.remove(p);
            saveToFile();
            return true;  //if deletion was successful
        }
        return false;  //if nothing was deleted
    }
    //file save/load
    
    public void saveToFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
            
            for (Pledge p : pledges){
                //join actions into a single string, seperated by ;
                String actionsJoined = String.join(";", p.getActionChose());
                
                //format
                String line = p.getUserName() + "|" + p.getDate() + "|" + actionsJoined;
                
                writer.write(line);
                writer.newLine();
            }
            
        } catch (IOException e){
            System.err.println("Error saving pledges: " + e.getMessage());
            
        }
    }
    
    //loads pledges from the text file
    public void loadFromFile(){
        pledges.clear();  //start with an empty list
        
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            
            while((line = reader.readLine()) != null){
                //expect format: name|date|actions
                String[] parts = line.split("\\|");
            
                if (parts.length >= 3){
                    String name = parts[0];
                    String date = parts[1];
                    String actionsPart = parts[2];

                    ArrayList<String> actions = new ArrayList<>();
                    if(!actionsPart.isEmpty()){
                        actions.addAll(Arrays.asList(actionsPart.split(";")));
                    }

                    Pledge p = new Pledge(name, date, actions);
                    pledges.add(p);
                }
            }
        } catch (IOException e){
            //File might not exist when run for the first time
            System.err.println("No existing pledge file or error reading: " + e.getMessage());    
        }         
    }
}
   