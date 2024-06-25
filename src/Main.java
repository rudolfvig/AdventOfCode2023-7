import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        MyFileScanner sc = new MyFileScanner("input.txt");
        ArrayList<String> lines = sc.getLines();
        ArrayList<String[]> handsAndBids = new ArrayList<>();
        for (String line : lines){
            String[] handAndBid = new String[2];
            handAndBid[0] = line.split(" ")[0];
            handAndBid[1] = line.split(" ")[1];
            handsAndBids.add(handAndBid);
        }
        handsAndBids.sort(new PokerHandComparator());
        int sumOfWins = 0;
        for(int i = 0; i < handsAndBids.size(); i++){
            sumOfWins += Integer.parseInt(handsAndBids.get(i)[1]) * (i+1);
        }
        System.out.println("Result: " + sumOfWins);

        handsAndBids.sort(new PokerHandComparatorWithJokerRule());
        int sumOfWinsWithJokerRule = 0;
        for(int i = 0; i < handsAndBids.size(); i++){
            sumOfWinsWithJokerRule += Integer.parseInt(handsAndBids.get(i)[1]) * (i+1);
        }
        System.out.println("Result for part2(Joker Rule): " + sumOfWinsWithJokerRule);

    }
}