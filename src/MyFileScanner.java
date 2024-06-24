import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MyFileScanner {

    private File file;
    private Scanner scanner;

    // Constructor to initialize with a file path
    public MyFileScanner(String filePath) {
        try{
        this.file = new File(filePath);
        this.scanner = new Scanner(this.file);

        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found or doesnt exist!");
        }
    }


    // Method to close the scanner
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }

    // Example method to process all lines and print them
    public ArrayList<String> getLines() {
        ArrayList<String> lines = new ArrayList<>();
        try {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } finally {
            close();
        }
        return lines;
    }
}
