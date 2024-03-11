import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void paintPoint100x150y(AxisSystem axisSystem) {
        axisSystem.addSinglePoint(100, 150, "Blue");
    }

    public static void paintPointNeg200x200y(AxisSystem axisSystem) {
        axisSystem.addSinglePoint(-200, 200, "Blue");
    }

    public static void paintSpecificMultiplePoints(AxisSystem axisSystem) {
        int[] points = {50, 50, 60, 60, 70, 70};
        axisSystem.addMultiplePoints(points, "Blue");
    }

    public static void paintChosenPoint(AxisSystem axisSystem) {
        int x, y;
        do {
            System.out.println("Enter the coordinates. Your range is between 250 and -250: ");
            x = scanner.nextInt();
            y = scanner.nextInt();
        } while ((x < -250 || x > 250) || (y < -250 || y > 250));
        axisSystem.addSinglePoint(x, y, "Blue");
    }

    public static void chooseHowManyPointsToPaint(AxisSystem axisSystem) {
        System.out.println("How many points you want to add?");
        int pointsAmount = scanner.nextInt();
        System.out.println("What color would you like to paint them?");
        String color = new Scanner(System.in).nextLine();
        int[] points = getRandomPoints(axisSystem, pointsAmount);
        axisSystem.addMultiplePoints(points, color);
    }

    public static int[] getRandomPoints(AxisSystem axisSystem, int pointsAmount) {
        int x, y;
        int[] points = new int[pointsAmount * 2];
        for (int i = 0; i < points.length; i += 2) {
            x = random.nextInt(-250, 251);
            points[i] = x;
            y = random.nextInt(-250, 251);
            points[i + 1] = y;
        }
        return points;
    }

    public static void paintSpecificFunction(AxisSystem axisSystem) {
        int y;
        for (int x = -175; x <= 75; x++) {
            y = 2 * x + 100;
            axisSystem.addSinglePoint(x, y, "Blue");
        }
    }
    public static void paintChosenFunction(AxisSystem axisSystem){
        System.out.println("Enter the coefficient of x: ");
        int m = scanner.nextInt();
        System.out.println("Enter free number: ");
        int n = scanner.nextInt();
        int y;
        boolean inRange;
        for (int x = -250; x <= 250; x++) {
            y = m * x + n;
            inRange = (y >= -250) && (y <= 250);
            if(inRange) {
                axisSystem.addSinglePoint(x, y, "Blue");
            }
        }
    }
    public static void paintQuadraticFunction(AxisSystem axisSystem){
        int y;
        for (int x = -9; x <= 10; x++) {
            y = (2*(x*x)) -3*x+ 50;
            axisSystem.addSinglePoint(x, y, "Blue");
        }
    }



    public static void main(String[] args) {
        AxisSystem axisSystem = new AxisSystem(); //this line displays the initial axis
    }

}
