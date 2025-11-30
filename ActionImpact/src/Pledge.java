import java.util.ArrayList;

/**
 *
 * @author Fabian.S
 */

//Stores the pledge details like: user name, date, and chosen actions to take

public class Pledge {
    
    //class attributes
    private String userName;  //name of the user  
    private String date;  //date of the pledge
    private ArrayList<String> actionsChosen;  //list of actions taken
    
    //constructor used to create a new pledge object
    public Pledge(String userName, String date, ArrayList<String> actionsChosen){
            this.userName = userName;
            this.date = date;
            this.actionsChosen = actionsChosen;
    }
    
    //getters
    public String getUserName() { return userName; }
    public String getDate() { return date; }
    public ArrayList<String> getActionChose() { return actionsChosen; }
    
    //methods to display the pledge on screen
    @Override
    public String toString() {
        return userName + " - (" + date + ") - " + actionsChosen;  //shows how the pledge is displayed
    }
}
  
    
    
