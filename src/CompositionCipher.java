import java.util.ArrayList;

public class CompositionCipher extends Cipher{

    private ArrayList<Cipher> ciphers;

    public CompositionCipher(){
        ciphers = new ArrayList<>();
        // Constructor
    }

    public CompositionCipher(CompositionCipher other){
        ciphers = new ArrayList<>();
        for(int i = 0; i < other.ciphers.size(); i++){
            ciphers.add(other.ciphers.get(i));
        }
        // Copy Constructor
    }

    public char encrypt(char c){
        for(int i = 0; i < ciphers.size(); i++){
            c = ciphers.get(i).encrypt(c);
        }
        return c;
        // Encrypts each character through all the ciphers
    }

    public char decrypt(char c){
        for(int i = (ciphers.size() - 1); i > -1; i--){
            c = ciphers.get(i).decrypt(c);
        }
        return c;
    }

    public Cipher newCopy(){
        return new CompositionCipher(this);
    }

    public void add(Cipher theCipher){
        Cipher fresh = theCipher.newCopy();
        ciphers.add(fresh);
    }
}
