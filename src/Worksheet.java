/**
 * PA7 Part 1 worksheet (style not required)
 */
public class Worksheet {

    /**
     * method that stores the result of Q1 in PA7 worksheet
     * @return heap's array representation after insertions
     */
    public static int[] insertionResult(){
        /*
        TODO: replace the values with the heap's array representations
         */
        int[] output =  new int[]{100, 90, 77, 55, 89, 20, 33, 19, 47, 42, 85, 7};
        return output;
    }

    /**
     * method that stores the result of Q2 in PA7 worksheet
     * @return heap's array representations for each iteration of element removal, 5 iterations in total
     */
    public static int[][] removalResult(){
        /*
        TODO: store the values with the heap's array representations for each removal iteration
         */
        int[][] output = new int[5][12];
        output[0] = new int[]{31, 50, 38, 53, 56, 81, 46, 61, 64, 70, 57, 0};
        output[1] = new int[]{38, 50, 46, 53, 56, 81, 57, 61, 64, 70, 0, 0};
        output[2] = new int[]{46, 50, 57, 53, 56, 81, 70, 61, 64, 0, 0, 0};
        output[3] = new int[]{50, 53, 57, 61, 56, 81, 70, 64, 0, 0, 0, 0};
        output[4] = new int[]{53, 56, 57, 61, 64, 81, 70, 0, 0, 0, 0, 0};
        return output;
    }

    /**
     * method that stores the result of Q3 in PA7 worksheet
     * @return heap's array representations for d-ary heaps, where d = 3,4
     */
    public static int[][] dResult(){
        /*
        TODO: store 3-ary heap's array representation output[0] and store 4-ary representation in output[1]
         */
        int[][] output = new int[2][11];
        output[0] = new int[]{82, 51, 75, 33, 37, 43, 46, 45, 69, 21, 19};
        output[1] = new int[]{82, 75, 45, 33, 37, 43, 46, 51, 69, 21, 19};
        return output;
    }

    /**
     * method that stores the result of Q4 in PA7 worksheet
     * @return array representations
     */
    public static int[][] heapOperations(){
        /*
        TODO: store heap's array status after multiples operations - operation i will be stored at index i-1
         */
        int[][] output = new int[5][12];
        output[0] = new int[]{66, 65, 50, 55, 60, 31, 32, 21, 30, 0, 0, 0, 0};
        output[1] = new int[]{90, 65, 50, 66, 60, 32, 31, 21, 30, 10, 55, 0, 0};
        output[2] = new int[]{66, 65, 50, 55, 60, 32, 31, 21, 30, 10, 0, 0, 0};
        output[3] = new int[]{83, 65, 50, 67, 60, 32, 31, 21, 30, 10, 55, 66, 0};
        output[4] = new int[]{55, 32, 50, 21, 10, 30, 31, 0, 0, 0, 0, 0, 0};
        return output;
    }
}
