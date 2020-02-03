import java.io.IOException;

public class Main {
   static Visitor bello = new Visitor();
    public static void main(String[] args) throws IOException {
        bello.setFullName("Musa Mgijima");
        bello.setAge(26);
        bello.setNameOfPersonVisited("Kgaugelo Ramaramela");
        bello.setComments("Wuuuuuuuuh Wabala3423ba Dub DUb");
        bello.save();
        bello.load("Musa Mgijima");





    }
}
