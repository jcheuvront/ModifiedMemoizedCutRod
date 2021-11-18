public class CutRod {

    public static int memoizedCutRod(int[] p, int n){
        int[] r = new int[n + 1];

        for(int i = 0; i < r.length; i++){
            r[i] = Integer.MIN_VALUE;
        }
        return memoizedCutRodAux(p, n, r);
    }

    public static int memoizedCutRodAux(int[] p, int n, int[] r){
        if(r[n] >= 0){
            return r[n];
        }

        int q = Integer.MIN_VALUE;
        if(n == 0){
            q = 0;
        }
        else{
            for(int i = 0; i < n; i++){
                int sumCuts = p[i] + memoizedCutRodAux(p, n - i - 1, r);
                if(sumCuts > q){
                    q = sumCuts;
                }
            }
        }
        r[n] = q;
       return q;
    }

    public static void main(String[] args) {
       int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

       for(int i = 1; i <= prices.length; i++){
           int value = memoizedCutRod(prices, i);
           System.out.println("The value of r" + i + " = " + value);
       }

    }
}
