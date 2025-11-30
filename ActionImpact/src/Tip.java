/**
 *
 * @author fabi3
 */

public class Tip {
    
    private String title;  //shown in the list
    private String category;  //e.g. community
    private String details;  //explanation text
    
    public Tip(String title,String category, String details){
        this.title = title;
        this.category = category;
        this.details = details;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getCategory(){
        return category;
    }
    
    public String getDetails(){
        return details;
    }
    
    //this will appear in the JList
    @Override
    public String toString(){
        return title;
    }
}
