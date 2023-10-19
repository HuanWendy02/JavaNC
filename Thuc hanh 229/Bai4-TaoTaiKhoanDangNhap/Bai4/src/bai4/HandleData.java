
package bai4;
import org.mindrot.jbcrypt.BCrypt;
import java.io.*;
/**
 *
 * @author Doan Huu Minh
 */
public class HandleData {
    private static final String FILE_PATH = "account.txt";
    
    //Write data to file
    public static void writeData(String username , String password){
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            String usernameHash = encodeData(username);
            String passwordHash = encodeData(password);
            writer.println(usernameHash + " " + passwordHash);
        } catch (IOException e) {
            e.printStackTrace();
             System.out.println(e);
        }
    }
    public static void main(String[] args) {
       
       boolean check  = handleDataFromClient("hello 12345");
        System.out.println(check);
       
    }
    //Read data in file text and check 
    public static boolean handleDataFromClient(String text){
        String []data = text.split("\\s+");
        
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))){
            String line;
            while((line = bufferedReader.readLine() )!= null){
                String []account = line.split("\\s+");
                if(checkDataValid(data[0], account[0]) && checkDataValid(data[1], account[1])){
                    return true;
                }
            }
            return false;
        }catch(IOException ex){
            ex.getStackTrace();
        }
        return false;
    }
    
    //Encode data save to database 
    public static String encodeData(String data){
        //Hash data with BCrypt with method hashpw
        String hashData = BCrypt.hashpw(data, BCrypt.gensalt());
        return hashData;
    }
    
    //Check data valid in database 
    public static boolean checkDataValid(String data , String dataHash){
        //checkpw method to compare data input and data after hash success 
        return BCrypt.checkpw(data, dataHash);
    }
}
