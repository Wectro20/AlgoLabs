import java.util.ArrayList;
import java.util.List;

public class Fantz {

    public boolean pows(Long numbers, int number) {
        if (numbers == 0) {
            return false;
        }
        Long power = Math.round((Math.log(numbers) / Math.log(number)));
        power = Math.round(Math.pow(number, power));
        return power.equals(numbers);
    }

    public int findMinBin(String binaryNum, int number) {
        List<Integer> part = new ArrayList<>();
        for (int i = 0; i < binaryNum.length() + 1; i++) {
            part.add(i, binaryNum.length() + 1);
        }
        part.set(0, 0);

        for (int currentIndex = 1; currentIndex <= binaryNum.length(); currentIndex++) {
            if (binaryNum.charAt(currentIndex - 1) == '0') {
                continue;
            }
            for (int lastIndex = 0; lastIndex < currentIndex; lastIndex++) {
                if (binaryNum.charAt(lastIndex) == '0') {
                    continue;
                }
                String current = binaryNum.substring(lastIndex, currentIndex);
                if (!pows(Long.parseLong(current, 2), number)) {
                    continue;
                }
                part.set(currentIndex, Math.min(part.get(currentIndex), part.get(lastIndex) + 1));
            }
        }
        if (part.get(binaryNum.length()) < binaryNum.length() + 1) {
            return part.get(binaryNum.length());
        }
        return -1;
    }
}
