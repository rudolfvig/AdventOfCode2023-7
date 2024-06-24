import java.util.*;

public class PokerHandComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        //types of hands :
        // 5 of a kind(7), 4 of a kind(6), full house(5), 3 of a kind(4), 2 pair(3), pair(2), high card(1)
        Integer typeOfo1 = typeOfHand(o1);
        Integer typeOfo2 = typeOfHand(o2);
        if(typeOfo1.equals(typeOfo2)){
            return strengthComparator(o1, o2);
        }
        else if(typeOfo1 > typeOfo2){
            return 1;
        }
        else return -1;
    }

    private int strengthComparator(String o1, String o2){
        for (int i = 0; i < o1.length(); i++){
            int strengthOfo1 = getStrengthOfACard(o1.charAt(i));
            int strengthOfo2 = getStrengthOfACard(o2.charAt(i));
            if(strengthOfo1 == strengthOfo2){
                continue;
            }
            if(strengthOfo1 > strengthOfo2){
                return 1;
            }
            else return -1;
        }
        System.out.println("Something went wrong in the strength comparator, looks like 2 identical hand");
        return 0;
    }

    private Integer getStrengthOfACard(char c){
        switch (c){
            case '2' : return 1;
            case '3' : return 2;
            case '4' : return 3;
            case '5' : return 4;
            case '6' : return 5;
            case '7' : return 6;
            case '8' : return 7;
            case '9' : return 8;
            case 'T' : return 9;
            case 'J' : return 10;
            case 'Q' : return 11;
            case 'K' : return 12;
            case 'A' : return 13;
        }
        System.out.println("Something went wrong in determining the strength of a card!");
        return 0;
    }
    // 5 of a kind(7), 4 of a kind(6), full house(5), 3 of a kind(4), 2 pair(3), pair(2), high card(1)
    private Integer typeOfHand(String str){
        if(areAllCharactersUnique(str)) return 1;
        if(hasExactlyOnePair(str)) return 2;
        if(hasExactlyTwoPairs(str)) return 3;
        if(hasThreeOfAKind(str)) return 4;
        if(hasFullHouse(str)) return 5;
        if(hasFourOfAKind(str)) return 6;
        if(hasFiveOfAKind(str)) return 7;

        System.out.println("Something went wrong in type determining");
        return 0;
    }

    public static boolean areAllCharactersUnique(String str) {
        Set<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (!charSet.add(c)) {
                return false; // Duplicate character found
            }
        }
        return true; // All characters are unique
    }

    public static boolean hasExactlyOnePair(String str) {
        Set<Character> charSet = new HashSet<>();
        int duplicateCount = 0;

        for (char c : str.toCharArray()) {
            if (!charSet.add(c)) {
                duplicateCount++;
            }
        }
        // Check if there is exactly one duplicate and all other characters are unique
        return duplicateCount == 1 && charSet.size() == (str.length() - 1);
    }

    public static boolean hasExactlyTwoPairs(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Count occurrences of each character
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        int pairsCount = 0;
        for (int count : charCountMap.values()) {
            if (count == 2) {
                pairsCount++;
            } else if (count > 2) {
                // If any character appears more than twice, return false immediately
                return false;
            }
        }
        // Return true if there are exactly two pairs and all other characters appear once
        return pairsCount == 2;
    }

    public static boolean hasThreeOfAKind(String str){
        Set<Character> charSet = new HashSet<>();
        int duplicateCount = 0;

        for (char c : str.toCharArray()) {
            if (!charSet.add(c)) {
                duplicateCount++;
            }
        }
        // Check if there is exactly one duplicate and all other characters are unique
        return duplicateCount == 2 && charSet.size() == (str.length() - 2);
    }

    public static boolean hasFullHouse(String str){
        Map<Character, Integer> charCountMap = new HashMap<>();
        // Count occurrences of each character
        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        boolean need1 = false;
        boolean need2 = false;
        for (int count : charCountMap.values()) {
            if (count == 2) {
                need1 = true;
            } else if (count == 3) {
                need2 = true;
            }
        }
        return need1 && need2;
    }

    public static boolean hasFourOfAKind(String str){
        Set<Character> charSet = new HashSet<>();
        int duplicateCount = 0;

        for (char c : str.toCharArray()) {
            if (!charSet.add(c)) {
                duplicateCount++;
            }
        }
        // Check if there is exactly one duplicate and all other characters are unique
        return duplicateCount == 3 && charSet.size() == (str.length() - 3);
    }

    public static boolean hasFiveOfAKind(String str){
        Set<Character> charSet = new HashSet<>();
        int duplicateCount = 0;

        for (char c : str.toCharArray()) {
            if (!charSet.add(c)) {
                duplicateCount++;
            }
        }
        // Check if there is exactly one duplicate and all other characters are unique
        return duplicateCount == 4 && charSet.size() == (str.length() - 4);
    }

}
