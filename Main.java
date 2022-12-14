package Calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
	
	public static void main(String[] args) {
        try {
            BufferedReader imput = new BufferedReader(new InputStreamReader(System.in));
            String choose="";
            char opt='1';
            Calendar calendar = new Calendar();
            while ((opt=='1') || (opt=='2') || (opt=='3') || (opt=='4')|| (opt=='5') || (opt=='6') )
            {
                System.out.println("Calendar");
                System.out.println("-------------------------------------");
                System.out.println("1. add contact");
                System.out.println("2. search contact");
                System.out.println("3. edit contact");
                System.out.println("4. delete contact");
                System.out.println("5. list all contacts");
                System.out.println("6. clean calendar");
                System.out.println("0. exit");
                System.out.println("-------------------------------------");
                choose=imput.readLine();
                opt= choose.charAt(0);
                System.out.println("Option: ");
                System.out.println("");
                
                switch(opt){
                    case '1':
                        String name;
                        String phone;
                        String mobile;
                        String email;
                        boolean validate;
                        System.out.println("put the name:");
                        name=imput.readLine();
                        System.out.println("put the phone:");
                        phone=imput.readLine();
                        System.out.println("put the mobile:");
                        mobile=imput.readLine();
                        System.out.println("put the email:");
                        email=imput.readLine();
                        validate=isNumeric(phone);
                        validate=isNumeric(mobile);
                        if (validate){
                             int phone_val= Integer.parseInt(phone);
                             int mobile_val= Integer.parseInt(mobile);
                             System.out.println("los values en int son: ");
                             System.out.println(phone_val);
                             System.out.println(mobile_val);
                             calendar.Find(name, phone_val);
                             calendar.Add(name, phone_val, mobile_val, email);
                        }
                        else{
                             System.out.println("is not a number, format incorrect.");}
                        
                       
                        break;
                       
                                
                    case '2':
                        System.out.println("put the name to search:");
                        name=imput.readLine().toUpperCase();
                        calendar.Search(name);
                        break;
                    case '3':
                    	calendar.Edit();
                         break;
                    case '4':
                    	calendar.Delete();
                        break;
                    case '5':
                    	calendar.Show();
                        break;
                    case '6':
                    	calendar.Empty();
                        break;
                    case '0':
                        System.out.println("see you later :)");
                        break;
                     
                    default:
                        System.out.println("wrong option");
                        opt='1';
                     
                }
                
            }    
            
                    } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static boolean isNumeric(String str)
    {
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
    }

}
