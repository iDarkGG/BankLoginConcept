import java.util.Scanner;
import javax.swing.JOptionPane;
public class BancoApp {
   
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Banco banco = new Banco();
        Banco.AccountNumberHashSet();
        int entrada = 0;
        do{
            System.out.println("1. Create Account");
            System.out.println("2. AccountNumber Code Sender");
            System.out.println("3. Login");
            System.out.println("4. Exit");
            entrada = input.nextInt();
            switch(entrada){
                case 1:
                    System.out.println("Enter your name");
                    String userName = input.next();
                    System.out.println("Enter your password");
                    String password = input.next();
                    banco.dataBase.add(new Banco(userName, password));
                break;
                case 2:
                    System.out.println("Ha seleccionado la opcion 2");
                    String userName2 = JOptionPane.showInputDialog("Por favor ingrese su Usuario");
                    String password2 = JOptionPane.showInputDialog("Por favor ingrese su Contraseña");
                    banco.AccountNumerSender(userName2, password2);
                break;
                case 3:
                    System.out.println("Enter your name");
                    String userName3 = input.next();
                    System.out.println("Enter your account number");
                    Long userAccountNumber = input.nextLong();
                    System.out.println("Enter your password");
                    String password3 = input.next();
                    banco.userChecker(userName3, userAccountNumber, password3);
                break;
                case 4:
                    System.out.println("Goodbye");
            }
        }while(entrada != 4);

        input.close();
      
    }
    

}
