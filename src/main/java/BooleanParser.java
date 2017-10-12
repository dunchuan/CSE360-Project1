public class BooleanParser {

    public static void main(String[] args) {
        BooleanParser parser = new BooleanParser();

        BooleanCircuit circuit = parser.parseSOP("A + B", BooleanCircuit.TreeType.SOP);
        System.out.println(circuit);

        circuit = parser.parseSOP("A + (B + C) + F(E + (G + H) + F) + D", BooleanCircuit.TreeType.SOP);
        System.out.println(circuit);


    }
    public BooleanCircuit parseSOP(String value, BooleanCircuit.TreeType treeType) {
        return parseSOP(value, treeType, false);
    }

    public BooleanCircuit parseSOP(String value, BooleanCircuit.TreeType treeType, boolean isParen) {
        if (value.contains("(") || value.contains("(")) {
            int parenCount = 0;
            Integer startIndex = null;
            for (int i = 0; i < value.length(); i++) {
                if (value.charAt(i) == '(') {
                    if (parenCount == 0)
                        startIndex = i;
                    parenCount++;
                } else if (value.charAt(i) == ')')
                    parenCount--;

                if (startIndex != null && parenCount == 0)
                    return
                            new BooleanCircuit(parseSOP(value.substring(0, startIndex), treeType, false),
                                    (

                            new BooleanCircuit(parseSOP(value.substring(startIndex + 1, i), treeType, true),

                                    new BooleanCircuit(value.substring(i + 1), treeType, false))));


            }
        }

        if (isParen)
            return new BooleanCircuit(value, treeType, true);
        else
            return new BooleanCircuit(value, treeType);

    }
}
