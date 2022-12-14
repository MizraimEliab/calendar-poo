package Calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Calendar {
	
	Contact[] list_contacts = new Contact[99];
    private int count_contacts = 0; // Contador de objetos creados. Variable muy importante.

    public void Find(String name, int phone) {
        for (int i = 0; i < this.count_contacts; i++) {

            if (name.equals(this.list_contacts[i].get_name())) {
                System.out.println("this contact already exist");
            }
        }

    }

    public void Add(String name, int phone, int mobile, String email) {
        if (count_contacts < 99) {
            this.list_contacts[count_contacts] = new Contact();
            this.list_contacts[count_contacts].set_name(name);
            this.list_contacts[count_contacts].set_phone(phone);
            this.list_contacts[count_contacts].set_mobile(mobile);
            this.list_contacts[count_contacts].set_email(email);
            this.count_contacts++;
            Order();
        } else {
            System.out.println("the calendar is full");
        }

    }

    public void Search(String name) {
        boolean find = false;

        for (int i = 0; i < count_contacts; i++) {
            if (name.equals(this.list_contacts[i].get_name())) {
                System.out.println("name: " + this.list_contacts[i].get_name() + " phone: " + this.list_contacts[i].get_phone() + " mobile: " + this.list_contacts[i].get_mobile() + " email: " + this.list_contacts[i].get_email());
                find = true;
            }
        }
        if (!find) {
            System.out.println("contact not exist");
        }
    }

    public void Order() {
        //Este método ordenará el array de contacos por el nombre mediante el Método Burbuja
        int N = this.count_contacts;
        String name1;
        String name2;
        //Optimizo para cuando tenga más de dos elementos al menos.
        if (count_contacts >= 2) {
            for (int i = 1; i <= N - 1; i++) {
                for (int j = 1; j <= N - i; j++) {
                	name1 = this.list_contacts[j - 1].get_name();
                	name2 = this.list_contacts[j].get_name();
                    if (name1.charAt(0) > name2.charAt(0)) {
                        Contact tmp = this.list_contacts[j - 1];
                        this.list_contacts[j - 1] = this.list_contacts[j];
                        this.list_contacts[j] = tmp;
                    }
                }
            }
        }
    }

    public void Show() {
        if (this.count_contacts == 0) {
            System.out.println("whitout contacts");
        } else {
            for (int t = 0; t < this.count_contacts; t++) {
                // Es necesario por precaución usar el this para el metodo, puesto que si se ejecuta muchas veces la referencias a memoria pueden fallar.
                System.out.println("name: " + this.list_contacts[t].get_name() + " phone: " + this.list_contacts[t].get_phone() + " mobile: " + this.list_contacts[t].get_mobile() + " email: " + this.list_contacts[t].get_email());
            }
        }
    }

    public void Empty() {
        try {
            System.out.println("all contacts will be deleted");
            System.out.println("¿are you sure (S/N)?");
            String response;
            BufferedReader imput = new BufferedReader(new InputStreamReader(System.in));
            response = imput.readLine();
            response = response.toUpperCase();
            if (response.equals("S")) {

                //Lo hago por mera formalidad porque java se encarga de liberar los objetos no referenciados creados. El garbage collector
                for (int i = 0; i < this.count_contacts; i++) {
                    this.list_contacts[i].set_name("");
                    this.list_contacts[i].set_phone(0);
                }
                count_contacts = 0;
                System.out.println("calendar empty OK");
            } else {
                System.out.println("action cancel");
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Delete() {
        try {
            boolean find = false;
            BufferedReader imput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("contact name to delete:");
            String delete = imput.readLine().toUpperCase();
            if (count_contacts == 0) {
                System.out.println("whitout contacts");
            } else {
                for (int i = 0; i < count_contacts; i++) {

                    if (delete.equals(this.list_contacts[i].get_name())) {
                        System.out.println(i + 1 + ". " + "name: " + this.list_contacts[i].get_name() + " phone: " + this.list_contacts[i].get_phone() + " mobile: " + this.list_contacts[i].get_mobile() + " email: " + this.list_contacts[i].get_email());
                        find = true;
                    }
                }
                if (find) {
                    System.out.println("which contact do you want to delete, enter the associated number?");
                    int delete_number = Integer.parseInt(imput.readLine());
                    delete_number--;
                    System.out.println("¿are you sure (S/N)?");
                    String response;
                    response = imput.readLine();
                    response = response.toUpperCase();
                    if (response.equals("S")) {
                        Contact[] temp = new Contact[99];
                        int ii = 0;
                        boolean find2=false;
                        for (int i = 0; i < this.count_contacts; i++) {

                            if (i != delete_number) {
                                // Creo el objeto temporal para el borrado
                                if (!find2)
                                {
                                	temp[ii] = this.list_contacts[ii];
                                  ii++;
                                }
                                else
                                {
                                    if (ii<this.count_contacts)
                                    { temp[ii] = this.list_contacts[ii+1];
                                     ii++;
                                    }
                                }

                            } else {
                            	temp[ii] = this.list_contacts[ii + 1];
                                ii++;
                                find2=true;

                            }
                        }
                        this.count_contacts--;
                        System.out.println("contact deleted OK");
                        for (int j = 0; j < this.count_contacts; j++) {
                            this.list_contacts[j] = temp[j];

                        }

                    }

                } else {
                    System.out.println("sorry, contact not found 404");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Edit() {
        try {
            boolean find = false;
            BufferedReader imput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("contact name to modify:");
            String delete = imput.readLine().toUpperCase();
            if (count_contacts == 0) {
                System.out.println("whitout contacts");
            } else {
                for (int i = 0; i < this.count_contacts; i++) {

                    if (delete.equals(this.list_contacts[i].get_name())) {
                        System.out.println(i + 1 + ". " + "name: " + this.list_contacts[i].get_name() + " phone: " + this.list_contacts[i].get_phone() + " mobile: " + this.list_contacts[i].get_mobile() + " email: " + this.list_contacts[i].get_email());
                        find = true;
                    }
                }
                if (find) {
                    System.out.println("which contact do you want to modify, enter the number:");
                    int choose = Integer.parseInt(imput.readLine());

                    System.out.println("new name:");
                    String name = imput.readLine();
                    System.out.println("new phone:");
                    int phone = Integer.parseInt(imput.readLine());
                    System.out.println("new mobile:");
                    int mobile = Integer.parseInt(imput.readLine());
                    System.out.println("new email:");
                    String email = imput.readLine();

                    this.list_contacts[choose - 1].set_name(name);
                    this.list_contacts[choose - 1].set_phone(phone);
                    this.list_contacts[choose - 1].set_mobile(mobile);
                    this.list_contacts[choose - 1].set_email(email);
                    Order();
                } else {
                    System.out.println("there are no contacts with this name");
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
