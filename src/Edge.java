class Edge {
    private Integer weigth = 0;
    private Integer left = 0;
    private Integer right = 0;

    public Edge(Integer left, Integer right, Integer weigth) {
        this.weigth = weigth;
        this.left = left;
        this.right = right;
    }

    public Integer getWeigth() {
        return weigth;
    }

    public Integer getLeft() {
        return left;
    }

    public Integer getRight() {
        return right;
    }

    @Override
    public String toString() {
        return " { " + left + " <--> " + right + " -> weight: "+ weigth +"}";
    }
}
