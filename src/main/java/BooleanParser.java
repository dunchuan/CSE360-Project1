public class BooleanParser {

    public static void main(String[] args) {
        BooleanParser parser = new BooleanParser();

        parser.parseSOP("A + B");

    }

    public BooleanCircuit parseSOP(String value) {
        if (value.contains("()")) {
            return new BooleanCircuit(value, BooleanCircuit.TreeType.SOP);
        } else {
            return null;
        }
    }
}
