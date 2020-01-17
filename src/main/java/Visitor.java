import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Visitor {
    //log declaration
    Logger VisitorLogger = LogManager.getLogger();
    //universal universal variables
    String fullName,
            dateOfVisit=LocalDate.now().toString(),
            timeOfVisit= LocalTime.now().toString(),
            comments= "No Comment",
            nameOfPersonVisited;
    int age;

    //setters for the variables
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setNameOfPersonVisited(String nameOfPersonVisited) {
        System.out.println("sitevisited");
        this.nameOfPersonVisited = nameOfPersonVisited;
    }

    public void setAge(int age) {
        this.age = age;
    }


        //This is my save method to save information of the visitor
    void save() throws IOException {


        try {
            //Creation of file
             String fileName = fullName.replace(' ','_');
             File writer = new File("visitor_{" + fileName + "}.txt");
            String saver = "Name: "+fullName+"\n"+"Age: "+age+"\n"+dateOfVisit+"\n"+timeOfVisit+"\n"+comments+"\n"+nameOfPersonVisited+"\n--------------------------------------------\n";
            String sameVisitor = "Date of Visit: "+dateOfVisit+"\n"+"Time of Visit: "+timeOfVisit+"\n"+"Comment: "+comments+"\n"+"Person Visited: "+nameOfPersonVisited+"\n--------------------------------------------\n";

            if(writer.createNewFile()){
                //this creates a new file and inserts information in the file
                System.out.println("First time visitor");
                Files.write(Paths.get("visitor_{" + fileName + "}.txt"),saver.getBytes());
            }else {
                //this is when the file already exists so it will append the information to the existing information
                System.out.println("Visitor visiting again");
                Files.write(Paths.get("visitor_{" + fileName + "}.txt"),sameVisitor.getBytes(), StandardOpenOption.APPEND);
            }
            //logger to inform user where the file with the information is located
            VisitorLogger.info("results in visitor_" + fileName + ".txt");

        }catch (NullPointerException | IOException e){
            System.out.println("Please enter visitor information before saving");
        }



    }
    void load (String search) {

        String fileName = search.replace(' ','_');
        File Reader = new File("visitor_{" + fileName + "}.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Reader));
            String contents;
            while((contents = reader.readLine()) != null){
                System.out.println(contents);
            }
        }catch (FileNotFoundException e){
            System.out.println("File does not exist");
            VisitorLogger.error(e);
        }catch (IOException e){
            VisitorLogger.error(e);
        }

    }

}
