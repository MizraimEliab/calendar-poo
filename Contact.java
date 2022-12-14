package Calendar;

public class Contact {
	private String name;
    private int phone;
    private int mobile;
    private String email;
    public Contact()
    {
    this.name=null;
    this.phone=0;
    this.mobile = 0;
    this.email=null;
    }
    public Contact(String nombre, int phone, int mobile, String email) {
        this.name = nombre;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
    }
    public void set_name(String nomb){        
        this.name=nomb.toUpperCase();
    }
    public void set_phone(int telf){
        this.phone=telf;
    }
    public void set_mobile(int mob){
        this.mobile=mob;
    }
    public void set_email(String mail){
        this.email=mail;
    }

    public String get_name() {
        return this.name;
    }

    public int get_phone() {
        return phone;
    }
    public int get_mobile() {
        return mobile;
    }
    public String get_email() {
        return email;
    }
   
}
