import java.util.ArrayList;
import java.util.HashSet;
public class Banco{
    protected ArrayList<Banco> dataBase = new ArrayList<Banco>();
    private static HashSet<Long> accountNumberList = new HashSet<Long>();
    private String userName;
    private String password;
    private Long userAccountNumber;
    private static Long min = 1111111111111111L;
    private static Long max = 9999999999999999L;
    private static Long rdmResult;

    Banco(){

    }

    public Banco(String userName, String password){
        this.userName = userName;
        this.password = password;
        this.userAccountNumber = HashSetGetter();
    }

    //getters and setters
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserAccountNumber() {
        return userAccountNumber;
    }

    public void setUserAccountNumber(Long userAccountNumber) {
        this.userAccountNumber = userAccountNumber;
    }


    //methods   
    private static Long AccountNumberGenerator(){
        rdmResult = (long) (Math.random() * (max - min + 1) + min);  
        return rdmResult;
    }

    protected static void AccountNumberHashSet(){
        if(accountNumberList.size() < 100){
            accountNumberList.add(AccountNumberGenerator());
        }
    }
    
    private Long HashSetGetter(){
        java.util.Iterator<Long> itr = Banco.accountNumberList.iterator();
        Long element = itr.next();
        while(itr.hasNext()){
            element = itr.next();
            if(element != null){
                Banco.accountNumberList.remove(element);
            }
        }
        return element;
    }


    public void AccountNumerSender(String userName, String Password){
        Long userACC = 0L;
        for(Banco banco : dataBase){
            if(banco.getUserName().equals(userName) && banco.getPassword().equals(Password)){
                userACC = banco.getUserAccountNumber();
                System.out.println("//////////Bienvenido//////////");
                System.out.println("Credenciales correctas");
                System.out.println("Your account number is: " + userACC);
                System.out.println("//////////Fin//////////");
            }
        }
        
    }

    public void userChecker(String userName, Long userAccountNumber, String password){
        for (Banco banco : dataBase) {
            if(banco.getUserName().equals(userName) && banco.getUserAccountNumber().equals(userAccountNumber) && banco.getPassword().equals(password)){
                System.out.println("Welcome " + userName);
            }else{
                System.out.println("Wrong credentials");
            }
        }
    }


    


}
