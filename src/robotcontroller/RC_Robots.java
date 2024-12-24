package robotcontroller;

import java.util.Scanner;

public class RC_Robots {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxX = scanner.nextInt();
        int maxY = scanner.nextInt();
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String[] positionInput = scanner.nextLine().split(" ");
            int x = Integer.parseInt(positionInput[0]);
            int y = Integer.parseInt(positionInput[1]);
            char direction = positionInput[2].charAt(0);

            String instructions = scanner.nextLine();

            for (char command : instructions.toCharArray()) {
                if (command == 'L') {
                    direction = turnLeft(direction);
                } else if (command == 'R') {
                    direction = turnRight(direction);
                } else if (command == 'M') {
                    int[] newPosition = moveForward(x, y, direction);
                    if (isWithinBounds(newPosition[0], newPosition[1], maxX, maxY)) {
                        x = newPosition[0];
                        y = newPosition[1];
                    }
                }
            }

            System.out.println(x + " " + y + " " + direction);
        }

        scanner.close();
    }

    public static char turnLeft(char direction) {
        switch (direction) {
            case 'N':
                return 'W';
            case 'W':
                return 'S';
            case 'S':
                return 'E';
            case 'E':
                return 'N';
            default:
                return direction;
        }
    }

    public static char turnRight(char direction) {
        switch (direction) {
            case 'N':
                return 'E';
            case 'E':
                return 'S';
            case 'S':
                return 'W';
            case 'W':
                return 'N';
            default:
                return direction;
        }
    }

    public static int[] moveForward(int x, int y, char direction) {
        switch (direction) {
            case 'N':
                return new int[]{x, y + 1};
            case 'E':
                return new int[]{x + 1, y};
            case 'S':
                return new int[]{x, y - 1};
            case 'W':
                return new int[]{x - 1, y};
            default:
                return new int[]{x, y};
        }
    }

    public static boolean isWithinBounds(int x, int y, int maxX, int maxY) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }
}
