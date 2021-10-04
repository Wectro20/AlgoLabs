public class Bananas {
    private int[] piles;
    private int[] temp;
    private int hours;
    private int k = 0;

    public void setPiles(int[] piles) {
        this.piles = piles;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getK() {
        return k;
    }

    public Bananas() {}

    public Bananas(int[] piles, int hours) {
        this.piles = piles;
        this.hours = hours;
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
        if(isArrNull(piles)) {
            System.out.println("Nothing to eat (˃̣̣̥╭╮˂̣̣̥)");
            return;
        }
        if (piles.length > hours) {
            System.out.println("Too much piles with bananas !!! I can't eat them all :(");
            return;
        }
        if (piles.length == hours) {
            k = piles[0];
            for (int i = 1; i < piles.length; i++) {
                if(k < piles[i]){
                    k = piles[i];
                }
            }
            System.out.println("Minimal number of bananas need to be eaten by: " + hours + " hours -> " + k);
            return;
        }
        boolean kFound = true;
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
