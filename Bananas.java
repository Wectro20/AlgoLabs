public class Bananas {
    public int[] piles;
    public int[] temp;
    public int hours;

    public Bananas(int[] piles, int hours) {
        this.piles = piles;
        this.hours = hours;
        comparsion();
        isAllNull ();
    }
    public boolean isAllNull () {
        for (int i = 0; i < piles.length; i++) {
            if (piles[i] != 0) {
                return true;
            }
        }
        System.out.println("Nothing to eat (˃̣̣̥╭╮˂̣̣̥)");
        return false;
    }

    public boolean isArrNull (int [] arr) {
        for (int value : arr) {
            if ( value > 0) {
                return false;
            }
        }
        return true;
    }

    public void comparsion() {

        if (piles.length > hours) {
            System.out.println("Too much piles with bananas !!! I can't eat them all :(");
            System.exit(0);
        }
        if (piles.length == hours) {
            int max = piles[0];
            for (int i = 1; i < piles.length; i++) {
                if(max < piles[i]){
                    max = piles[i];
                }
            }
            System.out.println("Minimal number of bananas need to be eaten by: " + hours + " hours -> " + max);
            System.exit(0);
        }
        boolean kFound = true;
        int k = 0;
        while (kFound) {
            temp = piles.clone();
            int hoursCurrent = 0;
            k++;
            for (int i = 0; i < temp.length;i++) {
                if(hoursCurrent > hours) {
                    break;
                }
                while (temp[i] > 0) {
                    temp[i]-=k;
                    hoursCurrent++;

                    if(hoursCurrent > hours) {
                        break;
                    }
                }
            }
            if(hoursCurrent == hours && isArrNull(temp)){
                kFound = false;
            }
        }
        System.out.println("Minimal number of bananas need to be eaten by: " + hours + " hours -> " + k);
    }
}
