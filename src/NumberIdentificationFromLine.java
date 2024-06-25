import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberIdentificationFromLine {

    private String line;
    private ArrayList<Long> numbers;

    public NumberIdentificationFromLine() {
        this.numbers = new ArrayList<>();
    }

    private void setLine(String line) {
        this.line = line;
    }

    private ArrayList<Long> getNumbers() {
        return numbers;
    }

    private void NumberIdentification(){

        numbers.clear();
        Pattern pattern = Pattern.compile("\\b(\\d+)\\b");
        Matcher matcher = pattern.matcher(line);

        while(matcher.find()){
            Long number = Long.parseLong(matcher.group(1));
            numbers.add(number);
        }
    }

    public ArrayList<Long> setLineAndGetNumbers(String line){
        setLine(line);
        this.NumberIdentification();

        return getNumbers();
    }

}
