public class Ch4Hw {
    private int count = 0;

    public int iterativeProduct(int a, int b) {
        for (int i = 0; i < b-1; i++){
            a += a;
        }
        return a;
    }

    public int recursiveProduct(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return a + recursiveProduct(a, b-1);
    }

    public long someFun(int n) {
        if (n <= 0) {
            return 2;
        } else {
            return someFun(n-1) * someFun(n-1);
        }
    }

    public int power3(int n) {
        if (n == 0) {
            return 1;
        } else {
            int p = power3(n/2);

            p *= p;
            count += 1;

            if (n % 2 == 1) {
                p *= 3;
                count += 1;
            }
            
            return p;
        }

    }
    
    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Ch4Hw hw = new Ch4Hw();
        
        System.out.println(hw.power3(15));
        System.out.println(hw.getCount());

    }
}

