import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Test {

    public static void main(String[] args) {
        String loginType ="MKR~RDCMEEM_BAH~T8";




        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("D:\\MeemBahrain_Mobile\\TestFramework_New\\src\\main\\resources\\properties\\projectConfig.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            String loginUser=prop.getProperty("Test_Android_user");

//            String username = loginUser.split("~")[0];
            //System.out.println(username);
            //String username = loginUser[1];
            System.out.println(prop.getProperty("dbuser"));
            System.out.println(prop.getProperty("dbpassword"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}




