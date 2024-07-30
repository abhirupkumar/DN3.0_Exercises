public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base case: no more years left to apply the growth rate
        if (years == 0) {
            return presentValue;
        }
        // Recursive case: apply the growth rate for one year and recurse for the remaining years
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000; // Initial investment
        double growthRate = 0.05;   // Growth rate (5%)
        int years = 10;             // Number of years

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.println("Future Value after " + years + " years: $" + futureValue);
    }
}
