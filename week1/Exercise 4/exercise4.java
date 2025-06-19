import java.util.*;

public class exercise4 {

    // Calculate AVG Monthly Growth Rate
    public static double calculateAvgGrowthRate(double[] monthlyRevenue, int size) {
        double totalGrowth = 0.0;
       
        for (int i = 1; i < size; i++) {
            double growth = (monthlyRevenue[i] - monthlyRevenue[i - 1]) / monthlyRevenue[i - 1];
            totalGrowth += growth;
        }

        return totalGrowth / (size- 1);
    }

    // Forecast Revenue 
    public static double[] forecast(double[] hist, int histSize, int n) {
        double[] forecast = new double[histSize + n];

        // Copy historical data
        for (int i = 0; i < histSize; i++) {
            forecast[i] = hist[i];
        }

        double avg = calculateAvgGrowthRate(hist, histSize);
        double last = hist[histSize - 1];

        for (int i = histSize; i < histSize + n; i++) {
            last *= (1 + avg);
            forecast[i] = last;
        }
        return forecast;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of past months data: ");
        int n = scanner.nextInt();
        double[] past = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter revenue for month %d: ", i + 1);
            past[i] = scanner.nextDouble();
        }
        
        System.out.println("Enter number of months to forecast: ");
        int m = scanner.nextInt();

        double[] result  = forecast(past,n, m);
        System.out.println("\nHistorical Revenue Data");
        for (int i = 0; i < n; i++) {
            System.out.printf("\tMonth %d: Rs.%.2f%n", i + 1, result [i]);
        }

        System.out.println("\nForecasted Revenue");
        for (int i = n; i < result .length; i++) {
            System.out.printf("\tMonth %d: Rs.%.2f%n", i + 1, result [i]);
        }

        scanner.close();
    }
}