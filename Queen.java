//import java.util.Arrays;
import java.util.Random;

public class Queen {

    public static boolean placement(char queen[][], int count) {
        if (count == 8) return true;
        int x = 0;
        int y = 0;
        while (x < 8) {
            x++;
            while (y < 8) {
                Boolean may = beats(x, y, queen);
                if (may) {
                    add(x, y, queen);
                    count++;
                    Boolean res = placement(queen, count);
                    if (res) {
                        return true;
                    } else {
                        takeOff(x, y, queen);
                        count--;
                    }
                } else {
                    y++;
                }

            }
            return false;
        }

    }

    public static boolean beats(int x, int y, char[][] queen) {
        boolean is_flag = true;
        for (int i = 0; i < queen.length; i++) {
            for (int j = 0; j < queen[0].length; j++) {
                if (queen[i][j] == 'Q') {
                    if (i == x || j == y || (int) (Math.abs((i - x))) == (int) (Math.abs((j - y)))) {
                        is_flag = false;

                    }
                }

            }

        }
        return is_flag;
    }

    public static void add(int x, int y, char[][] queen) {
        queen[x][y] = 'Q';

    }

    public static void takeOff(int x, int y, char[][] queen) {
        queen[x][y] = '*';

    }

    public static void main(String[] args) {
        char[][] queen = new char[8][8];
        int size = queen.length;

        int min = 0;
        int diff = size - min;
        Random r = new Random();
        int k = r.nextInt(diff + 1) + min;
        int m = r.nextInt(diff + 1) + min;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < queen[0].length; j++) {
                queen[i][j] = '*';
            }
        }
        queen[k][m] = 'Q';
        // System.out.println(Arrays.deepToString(queen));
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + queen[i][j] + " ");
            }
            System.out.println();
        }

        int count = 1;
        placement(queen, count);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" " + queen[i][j] + " ");
            }
            System.out.println();
        }

    }
}







    
        
 


    
   
    
