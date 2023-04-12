import java.util.Scanner;

public abstract class Cipher {

    public abstract char encrypt(char c);

    public abstract char decrypt(char c);

    public String encrypt(String s){
        Scanner scan = new Scanner(s);
        scan.useDelimiter("");
        String result = "";

        while(scan.hasNext()){
            result += this.encrypt(scan.next().charAt(0));
        }

        return result;
    }

    public String decrypt(String s){
        Scanner scan = new Scanner(s);
        scan.useDelimiter("");
        String result = "";

        while(scan.hasNext()){
            char c = scan.next().charAt(0);
            result += this.decrypt(c);
        }

        return result;
    }

    public abstract Cipher newCopy();
}
