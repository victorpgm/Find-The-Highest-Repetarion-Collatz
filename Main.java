public class Main {

    static int count = 0, longestRepetation = 0;
    static long longestNumberProcessed = 0;

    static void collatz(long x) {
        
         if(x > 1) {
            collatz((x % 2 == 0) ? x / 2 : (3 * x + 1));
            count++;
        }
    }

    public static void main(String[] args) {

        long startTime = System.nanoTime();
        long m = (long) Math.pow(2,20);

        for(long i = 1; i <= m; i++){
            count = 0;
            if(i % 2 != 0){

                collatz(i);

                if(count > longestRepetation){
                    longestNumberProcessed = i;
                    longestRepetation = count;
                }
            }
            
        }

        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        double durationInSeconds = duration / 1e9;
        System.out.println("Tempo de execução: " + durationInSeconds + " segundos");
        System.out.println("A maior repetição foi: " + longestNumberProcessed);
        System.out.println("A maior número processado foi: " + longestRepetation);
    }
       
}

