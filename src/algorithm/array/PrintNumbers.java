package algorithm.array;


public class PrintNumbers {
    public static void main(String[] args) {

    }

    public int[] printNumbers(int n) {
        if (n == 0) {
            return new int[0];
        }
        StringBuilder wei = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            wei.append("9");
        }
        int parseInt = Integer.parseInt(wei.toString());
        int[] result = new int[parseInt];
        for (int i = 0; i < parseInt; i++) {
            result[i] = i+1;
        }
        return result;
    }

    public int[] printNumbers1(int n) {
        int v = (int) (Math.pow(10, n) - 1);
        int[] result = new int[v];
        for (int i = 0; i < v; i++) {
            result[i] = i+1;
        }
        return result;
    }
}
