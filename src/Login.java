
import javax.swing.JOptionPane;

public class Login {
    
    private String username,password;
    private String databaseUsername = "admin";
    private String databasePassword = "admin";
    private boolean isUserLogged = false;
    
    public Login(String uname , String pwd){
    
    this.username= uname;
    this.password = pwd;
    }
    public boolean validateLogin (){
    if(username.equals(databaseUsername)&& password.equals(databasePassword)){
    isUserLogged =true;
    }
    else{
        JOptionPane.showMessageDialog(null,"Username and Password do not match" , "Faild to Login"
        , JOptionPane.ERROR_MESSAGE);
        
        isUserLogged=false;
    }
    return isUserLogged;
    }
    
}