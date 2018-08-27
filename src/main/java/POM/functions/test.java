package POM.functions;

public class test {


    public static void main(String args[]) {

        String Num = "Ref No  399FRIN181410013";
        String OTP=Num.replace("Ref No  ", "").trim();
        System.out.println(OTP);

    }

}
