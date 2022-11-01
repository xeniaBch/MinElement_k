import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, -1, -2, 3};
        minFour2(array);
        minFour(array);
    }

    private static void minFour2(int[] array) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        int min4 = Integer.MAX_VALUE;
        for (int el : array) {
            if (el < min1) {
                min4 = min3;
                min3 = min2;
                min2 = min1;
                min1 = el;
                continue;
            }
            if (el > min1 && el < min2) {
                min4 = min3;
                min3 = min2;
                min2 = el;
                continue;
            }
            if (el > min1 && el > min2 && el < min3) {
                min4 = min3;
                min3 = el;
                continue;
            }
            if (el > min1 && el > min2 && el > min3 && el < min4) {
                min4 = el;
            }
        }
        if (min3 == Integer.MAX_VALUE) {
            System.out.println("min3 doesn't exist");
            System.out.println("min4 doesn't exist");
            return;
        }
        if (min4 == Integer.MAX_VALUE) {
            System.out.println("min3 = " + min3);
            System.out.println("min4 doesn't exist");
            return;
        }
        System.out.println("min3 = " + min3);
        System.out.println("min4 = " + min4);
    }

    private static void minFour(int[] inputArr) {
        int[] minArr = new int[4];
        Arrays.fill(minArr, Integer.MAX_VALUE);

        for (int el : inputArr) {
            int count = 0;

            for (int elMin : minArr) {
                if (el == elMin) break;

                if (el < elMin) {
                    for (int i = minArr.length - 1; i > count; i--) {
                        minArr[i] = minArr[i - 1];
                    }
                    minArr[count] = el;
                    break;
                }
                count++;
            }
        }

        if (minArr[2] == Integer.MAX_VALUE) {
            System.out.println("min3 doesn't exist");
            System.out.println("min4 doesn't exist");
            return;
        }
        if (minArr[3] == Integer.MAX_VALUE) {
            System.out.println("min3 = " + minArr[2]);
            System.out.println("min4 doesn't exist");
            return;
        }
        System.out.println("min3 = " + minArr[2]);
        System.out.println("min4 = " + minArr[3]);
    }
}
