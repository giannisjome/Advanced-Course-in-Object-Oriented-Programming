import java.util.*;

class EmptyArray extends Exception {}

class NegativeNumbersFound extends Exception {
    private final List<Integer> indices;
    private final List<Integer> values;

    public NegativeNumbersFound(List<Integer> indices, List<Integer> values) {
        this.indices = indices;
        this.values = values;
    }

    public List<Integer> getIndices() { return indices; }
    public List<Integer> getValues() { return values; }
}

public class AvgCalculator {

    public static float avg(int[] nums) throws EmptyArray, NegativeNumbersFound {
        if (nums == null || nums.length == 0)
            throw new EmptyArray();

        List<Integer> badIndices = new ArrayList<>();
        List<Integer> badValues = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                badIndices.add(i);
                badValues.add(nums[i]);
            }
        }
        if (!badIndices.isEmpty())
            throw new NegativeNumbersFound(badIndices, badValues);

        int sum = 0;
        for (int n : nums) sum += n;
        return (float) sum / nums.length;
    }

    public static void main(String[] args) {
        int[] nums = { 1, -2, -3, 4 }; // ← Test this with different arrays
        try {
            float result = avg(nums);
            System.out.println(result);
        } catch (EmptyArray e) {
            System.out.println("Array is empty.");
        } catch (NegativeNumbersFound e) {
            List<Integer> indices = e.getIndices();
            List<Integer> values = e.getValues();
            for (int i = 0; i < indices.size(); i++) {
                int displayIndex = indices.get(i) + 1; // 1-based index
                int value = values.get(i);
                System.out.println("The " + displayIndex + "th number " + value + " in your array is invalid");
            }
        }
    }
}
