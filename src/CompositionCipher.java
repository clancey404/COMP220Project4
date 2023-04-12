import java.util.ArrayList;

public class CompositionCipher extends Cipher{

    private ArrayList<Cipher> ciphers;

    public CompositionCipher(){
        ciphers = new ArrayList<>();
        // Constructor
    }

    public CompositionCipher(CompositionCipher other){
        this.ciphers = new ArrayList<>();
        for(Cipher julius : other.ciphers){
            this.ciphers.add(julius);
        }
        // Copy Constructor
    }

    public char encrypt(char c){
        for(Cipher brutus : ciphers){
            c = brutus.encrypt(c);
        }
        return c;
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
        this.ciphers.add(fresh);
    }
}
