import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


       Visitor bello = new Visitor();
       bello.setFullName("Kgaugelo Ramaramela");
       bello.setAge(21);
       bello.setNameOfPersonVisited("Lincoln Mgijima");
       bello.save();

       bello.load("Kgaugelo Ramaramela");



    }
}
