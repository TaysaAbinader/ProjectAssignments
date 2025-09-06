package OrientationChapter_1_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AgeProbabilityCalculator {
    // Key: Age Group
    // Value: Age Quantity
    private HashMap<Integer, Integer> agesMap;

    // Total amount of age quantities.
    private int totalQuantity;

    // Sorted ages, in ascending order.
    private ArrayList<Integer> sortedAges;

    // Key: Age Group
    // Value: Age Probability
    private HashMap<Integer, Double> ageProbabilities;

    // Sorted probabilities per age, in ascending order.
    private ArrayList<Double> sortedProbabilities;

    // Cumulative Distribution Function (CDF).
    private ArrayList<Double> cdf;

    public AgeProbabilityCalculator (HashMap<Integer, Integer> agesMap) {
        setAgesMap(agesMap);
    }

    public void setAgesMap(HashMap<Integer, Integer> agesMap) {
        this.agesMap = agesMap;

        // Calculate the total distribution quantity.
        this.totalQuantity = calculatetotalQuantity();

        // Create a sorted ages array, in ascending order.
        this.sortedAges = calculateSortedAges();

        // Calculate the age probabilities.
        this.ageProbabilities = calculateAgeProbabilities();

        // Sort the age probabilities by age, in ascending order.
        this.sortedProbabilities = calculateSortedProbabilities();

        // Calculates the Cumulative Distribution Function (CDF).
        this.cdf = calculateCumulativeDistributionFunction();
    }

    private ArrayList<Integer> calculateSortedAges () {
        ArrayList<Integer> sortedAges = new ArrayList<>(agesMap.keySet());
        // Sort ages, in ascending order.
        Collections.sort(sortedAges);
        return sortedAges;
    }

    private int calculatetotalQuantity () {
        int sumValues = 0;
        for (int value : agesMap.values()) {
           sumValues += value;
        }
        return sumValues;
    }

    private HashMap<Integer, Double> calculateAgeProbabilities () {
        double ageProbability = 0;
        HashMap<Integer, Double> ageProbabilities = new HashMap<>();

        for (Map.Entry<Integer, Integer> item : agesMap.entrySet()){
            int ageGroup = item.getKey();
            double ageQuantity = (double) item.getValue();

            if (this.totalQuantity == 0) {
                ageProbability = 0; // avoid division by zero.
            } else {
                ageProbability = ageQuantity / this.totalQuantity;
            }

            ageProbabilities.put(ageGroup, ageProbability);
        }

        return ageProbabilities;
    }

    public ArrayList<Double> calculateSortedProbabilities () {
        ArrayList<Double> sortedProbabilities = new ArrayList<>();

        for (int sortedAge : sortedAges) {
            double ageProbability = ageProbabilities.get(sortedAge);
            sortedProbabilities.add(ageProbability);
        }

        return sortedProbabilities;
    }

    public ArrayList<Double> calculateCumulativeDistributionFunction () {
        ArrayList<Double> cdf = new ArrayList<>();
        double cumulativeProbability = 0.0;

        for (double sortedProbability : sortedProbabilities){
            cumulativeProbability += sortedProbability;
            cdf.add(cumulativeProbability);
        }

        return cdf;
    }

    public ArrayList<Integer> getSortedAges () {
        return this.sortedAges;
    }

    public HashMap<Integer, Double> getAgeProbabilities () {
        return this.ageProbabilities;
    }

    public ArrayList<Double> getCDF() {
        return this.cdf;
    }

    public ArrayList<Integer> generateAgeSamples (int quantity) {
        ArrayList<Integer> ageSamples = new ArrayList<>();
        for (int counter = 0; counter < quantity; counter++) {
            double random = Math.random();
            int ageSample = 0;

            // This works because CDF is sorted according to age, in ascending order, in the
            // same way as the sorted ages array.
            for (int index = 0; index < cdf.size(); index++) {
                if (random <= cdf.get(index)) {
                    ageSample = sortedAges.get(index);
                    break;
                }
            }

            ageSamples.add(ageSample);
        }

        return ageSamples;
    }

    public void displayAgeSamples (ArrayList<Integer> ageSamples) {
        // Key: Age group
        // Value: Quantity of individuals with that given age.
        HashMap<Integer, Integer> ageSamplesCounter = new HashMap<>();
        for (int ageSample : ageSamples) {
            // ageSamplesCounter.merge(ageSample, 1, Integer::sum);
            if (!ageSamplesCounter.containsKey(ageSample)) {
                ageSamplesCounter.put(ageSample, 1);
            } else {
                int currentAgeCount = ageSamplesCounter.get(ageSample);
                ageSamplesCounter.put(ageSample, currentAgeCount + 1);
            }
        }

        int quantity = ageSamples.size();
        System.out.printf("Age samples counter (%d samples):\n", quantity);
        for (int ageGroup : sortedAges) {
            double percentage = ageSamplesCounter.get(ageGroup);
            percentage /= quantity;
            System.out.printf("Age: %4d Quantity: %4d Percentage: %.2f Probability: %.2f\n",
                                ageGroup,
                                ageSamplesCounter.get(ageGroup),
                                percentage,
                                ageProbabilities.get(ageGroup));
        }
        System.out.println();
    }

    public void displayCalculation () {
        System.out.println("Age Probabilities:");
        ArrayList<Integer> sortedAges = getSortedAges();
        HashMap<Integer, Double> ageProbabilities = getAgeProbabilities();
        for (int age : sortedAges) {
            double ageProbability = ageProbabilities.get(age);
            System.out.printf("Age: %d = %.2f\n", age, ageProbability);
        }
        System.out.println();

        System.out.println("Cumulative Distribution Function (CDF):");
        ArrayList<Double> cdf = getCDF();
        for (int index = 0; index < sortedAges.size(); index++) {
            System.out.printf("Age: %d = %.2f\n", sortedAges.get(index), cdf.get(index));
        }
        System.out.println();
        
        // Generate 1000 samples.
        ArrayList<Integer> ageSamples1000 = generateAgeSamples(1000);
        displayAgeSamples(ageSamples1000);

        // Generate 10000 samples.
        ArrayList<Integer> ageSamples10000 = generateAgeSamples(10000);
        displayAgeSamples(ageSamples10000);
    }

    public static void main(String[] args) {
        // Note: Could also have used TreeMap which stores key values in a sorted manner.
        HashMap <Integer, Integer> agesMap = new HashMap<>();
        agesMap.put(19, 5);
        agesMap.put(21, 7);
        agesMap.put(25, 10);
        agesMap.put(28, 8);
        agesMap.put(32, 3);
        agesMap.put(40, 2);

        AgeProbabilityCalculator calculator = new AgeProbabilityCalculator(agesMap);
        calculator.displayCalculation();

        // New ages map.
        agesMap = new HashMap<>();
        agesMap.put(10, 10);
        agesMap.put(20, 10);
        agesMap.put(30, 10);
        agesMap.put(40, 10);
        agesMap.put(50, 10);
        agesMap.put(60, 10);
        agesMap.put(70, 10);
        agesMap.put(80, 10);
        agesMap.put(90, 10);
        agesMap.put(100, 10);

        calculator.setAgesMap(agesMap);
        calculator.displayCalculation();
    }
}
