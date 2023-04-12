public class Main {
    public static void main(String[] args){
        CompositionCipher comp = new CompositionCipher();
        System.out.println(comp.encrypt('b'));
        System.out.println(comp.decrypt('d'));
        comp.add(new CaesarCipher(19));
        comp.add(new CaesarCipher(12));
        System.out.println(comp.encrypt('a'));

    }
}
