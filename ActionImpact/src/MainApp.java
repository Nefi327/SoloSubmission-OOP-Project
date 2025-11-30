/**
 *
 * @author Fabian.S
 */

public class MainApp {
    
    public static void main(String[] args) {
        
        final PledgeManager pledgeManager = new PledgeManager();
        
        java.awt.EventQueue.invokeLater (new Runnable(){
            @Override
            public void run(){
                //pass the manager into the main screen
                new ActionCentreMain(pledgeManager).setVisible(true);
            }
        });
    }
}
