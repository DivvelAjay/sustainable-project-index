import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.Scanner;

public class Graphs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🌱 Sustainable Agriculture with Graphs 🌱");
        System.out.println("-----------------------------------------");

        // ===== Crop Recommendation =====
        System.out.println("\n=== Crop Recommendation ===");
        System.out.print("Enter Nitrogen value: ");
        int N = sc.nextInt();

        System.out.print("Enter Phosphorus value: ");
        int P = sc.nextInt();

        System.out.print("Enter Potassium value: ");
        int K = sc.nextInt();

        System.out.print("Enter Temperature (°C): ");
        double temp = sc.nextDouble();

        System.out.print("Enter Humidity (%): ");
        double humidity = sc.nextDouble();

        System.out.print("Enter pH value: ");
        double ph = sc.nextDouble();

        System.out.print("Enter Rainfall (mm): ");
        double rainfall = sc.nextDouble();

        String crop;
        if (rainfall > 200 && temp > 20 && humidity > 70) {
            crop = "Rice";
        } else if (ph >= 6.0 && ph <= 7.5 && N > 50) {
            crop = "Wheat";
        } else if (temp >= 20 && temp <= 30 && rainfall < 100) {
            crop = "Groundnut";
        } else {
            crop = "Maize";
        }

        System.out.println("✅ Recommended Crop: " + crop);

        // ===== Crop Yield Prediction =====
        System.out.println("\n=== Crop Yield Prediction ===");
        System.out.print("Enter Rainfall (mm/year): ");
        double rainfallYear = sc.nextDouble();

        System.out.print("Enter Average Temperature (°C): ");
        double avgTemp = sc.nextDouble();

        System.out.print("Enter Fertilizer/Pesticide Usage (kg/ha): ");
        double pesticide = sc.nextDouble();

        System.out.print("Enter Area of Cultivation (hectares): ");
        double area = sc.nextDouble();

        double yield = (0.5 * rainfallYear) + (2.0 * avgTemp) - (0.1 * pesticide) + (0.05 * area);

        System.out.printf("📊 Predicted Crop Yield (kg/ha): %.2f\n", yield);

        // ===== Show Graph =====
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(rainfallYear, "Environmental Factors", "Rainfall");
        dataset.addValue(avgTemp, "Environmental Factors", "Temperature");
        dataset.addValue(pesticide, "Environmental Factors", "Pesticide");
        dataset.addValue(area, "Environmental Factors", "Area");
        dataset.addValue(yield, "Prediction", "Predicted Yield");

        JFreeChart chart = ChartFactory.createBarChart(
                "Sustainable Agriculture Analysis",
                "Parameters",
                "Values",
                dataset);

        ChartFrame frame = new ChartFrame("Results", chart);
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sc.close();
    }
}

