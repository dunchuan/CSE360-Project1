
public enum BooleanOp {
    AND(""),
    OR(" + "),
    XOR("\u2295");

    private String value;

    private BooleanOp(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
