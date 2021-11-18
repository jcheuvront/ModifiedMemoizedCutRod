

public class ModifiedCutRod {

    public static int modifiedMemoizedCutRod(int[] p, int n){
        int[] r = new int[n + 1];
        int[] s = new int[n + 1];

        for(int i = 0; i < r.length; i++){
            r[i] = Integer.MIN_VALUE;
        }

        int sumCuts = modifiedMemoizedCutRodAux(p, n, r, s);
        System.out.print("\n The value of r" + n + " = " + sumCuts);

        int val = s[n] + 1;
        System.out.print(" The solution" + " = " + val);

        while(val > 0){
            val = n - val;
            n = n - val;
            if(val > 0){
                System.out.print(" + " + val);
            }
        }
       return sumCuts;
    }

    public static int modifiedMemoizedCutRodAux(int[] p, int n, int[] r, int[] s) {
        if (r[n] > 0) {
            return r[n];
        }

        int q = Integer.MIN_VALUE;
        if (n == 0) {
            q = 0;
        }
         else{
                for(int i = 0; i < n; i++){
                    int sumCuts = (p[i] + modifiedMemoizedCutRodAux(p, n - i - 1, r, s));
                    if(sumCuts > q){
                        q = sumCuts;
                        s[n] = i;
                        //System.out.print(Arrays.toString(s));
                    }
                }
            }
            r[n] = q;
            return q;
    }

    /*public static int printCutRodSolutions(int[] p, int n){
        int j = n - 1;
        while(j > 0){
            System.out.print(s[j]);
            j = j - s[n-1];
        }
        return s[n];
    }*/

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        for(int i = 1; i <= prices.length; i++){
            int value = modifiedMemoizedCutRod(prices, i);
            //System.out.println(" The price = " + value);
        }
    }
}

