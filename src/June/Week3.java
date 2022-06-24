package June;

public class Week3{
    public static void main(String[] args){
        long start = System.nanoTime();
        int result = squares(1, 1000000000);
        long duration = System.nanoTime() - start;
        System.out.println(String.format("Square count: %d\ntime in nano-seconds: %d\ntime in seconds: %f", result, duration, duration / 1_000_000_000D));
    }

    static int squares(int a, int b){
        return Math.max((int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a))) + 1, 0);
    }
}
