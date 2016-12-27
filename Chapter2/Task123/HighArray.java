class HighArray {

    private long[] a;

    private int nElems;

    public HighArray(int n) {
        this.a = new long[n];
        this.nElems = 0;
    }

    public boolean find(long l) {
        int n = 0;
        while (n < this.nElems) {
            if (this.a[n] == l) break;
            ++n;
        }
        if (n == this.nElems) {
            return false;
        }
        return true;
    }

    public void insert(long l) {
        this.a[this.nElems] = l;
        ++this.nElems;
    }

    public boolean delete(long l) {
        int n = 0;
        while (n < this.nElems) {
            if (l == this.a[n]) break;
            ++n;
        }
        if (n == this.nElems) {
            return false;
        }
        int n2 = n;
        while (n2 < this.nElems) {
            this.a[n2] = this.a[n2 + 1];
            ++n2;
        }
        --this.nElems;
        return true;
    }

    public void display() {
        int n = 0;
        while (n < this.nElems) {
            System.out.print("" + this.a[n] + " ");
            ++n;
        }
        System.out.println("");
    }

    // Task#1
    public long getMax() { // O(N) - complexity in unsorted algorithm
        if (this.nElems == 0) {
            return -1;
        }
        long max = a[0];
        for (int i = 0; i < this.nElems; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    // Task#2  O(N) [O(N+N)]
    // Writing this method from scratch
    public long removeMax() {
        if (this.nElems == 0) {
            return -1;
        }
        long max = a[0];
        int indexMax = 0;
        for (int i = 0; i < this.nElems; i++) {
            if (a[i] > max) {
                max = a[i];
                indexMax = i;
            }
        }

        for (int i = indexMax; i < this.nElems; i++) {
            a[i] = a[i + 1];
        }
        --this.nElems;
        return max;
    }

    public int getnElems() {
        return nElems;
    }

    public long[] noDups(){
        for (int i=0; i < nElems; i++){
            long number = a[i];
            for (int j = 0; j < nElems; j++){
                if (j != i && a[j] == a[i]){
                    deleteByIndex(j);
                }
            }
        }
        return a;
    }

    public long deleteByIndex(int index){
        for (int j = index; j < this.nElems; j++){
            a[j] = a[j+1];
        }
        --this.nElems;
        return a[index];
    }

    public void initialize(long [] a){
        for (int i=0; i < a.length; i++){
            this.a[i] = a[i];
            this.nElems++;
        }
    }

}