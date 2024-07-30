class FinancialForecasting {
    public static double predictFutureValue(double[] pastValues, int n) {
        if (n == 0) {
            return pastValues[0];
        }
        return (1 + growthRate(pastValues, n)) * predictFutureValue(pastValues, n - 1);
    }

    private static double growthRate(double[] pastValues, int n) {
        return (pastValues[n] - pastValues[n - 1]) / pastValues[n - 1];
    }
}

/*

Analysis
Time Complexity: O(n)
Recursive solutions can be optimized using memoization to avoid excessive computation.

*/