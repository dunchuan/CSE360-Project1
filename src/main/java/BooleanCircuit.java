public class BooleanCircuit {
    static enum CircuitType {
        CIRCUIT,
        BASE
    }

    public static enum TreeType{
        SOP, POS
    }

    private CircuitType type;
    private String value = null;
    private BooleanCircuit head = null;
    private BooleanCircuit tail = null;
    private BooleanOp operator = null;
    private boolean isParen = false;

    public BooleanCircuit(String value, TreeType treeType) {
        this(value, treeType, false);

    }

    public BooleanCircuit(String value, TreeType treeType, boolean isParen) {
        this.isParen = isParen;

        if (treeType == TreeType.SOP) {
            String[] values = value.split(BooleanOp.OR.toString());
            if( values.length > 2) {
                head = new BooleanCircuit(values[0], treeType);
                tail = new BooleanCircuit(value.substring(values[0].length()), treeType);
                operator = BooleanOp.OR;
                type = CircuitType.CIRCUIT;
            } else {
                values = value.split(BooleanOp.XOR.toString());
                if( values.length > 2) {
                    head = new BooleanCircuit(values[0], treeType);
                    tail = new BooleanCircuit(value.substring(values[0].length()), treeType);
                    operator = BooleanOp.XOR;
                    type = CircuitType.CIRCUIT;
                } else {
                    if (value.length() > 1) {
                        head = new BooleanCircuit(value.substring(0, 1), treeType);
                        tail = new BooleanCircuit(value.substring(1), treeType);
                        operator = BooleanOp.AND;
                        type = CircuitType.CIRCUIT;
                    } else {
                        this.value = value;
                        type = CircuitType.BASE;
                    }
                }
            }
        }

//        if (treeType == TreeType.SOP) {
//            String[] values = value.split(BooleanOp.OR.toString());
//            if( values.length > 2) {
//                head = new BooleanCircuit(values[0], treeType);
//                tail = new BooleanCircuit(value.substring(values[0].length()), treeType);
//                operator = BooleanOp.OR;
//                type = CircuitType.CIRCUIT;
//            } else {
//                values = value.split(BooleanOp.XOR.toString());
//                if( values.length > 2) {
//                    head = new BooleanCircuit(values[0], treeType);
//                    tail = new BooleanCircuit(value.substring(values[0].length()), treeType);
//                    operator = BooleanOp.XOR;
//                    type = CircuitType.CIRCUIT;
//                } else {
//                    if (value.length() > 1) {
//                        head = new BooleanCircuit(value.substring(0, 1), treeType);
//                        tail = new BooleanCircuit(value.substring(1), treeType);
//                        operator = BooleanOp.AND;
//                        type = CircuitType.CIRCUIT;
//                    } else {
//                        this.value = value;
//                        type = CircuitType.BASE;
//                    }
//                }
//            }
//        }
    }

    public String toString() {
        String strValue;

        if (isParen) {
            strValue = "(";
        }
        else {
            strValue = "";
        }

        if (type==CircuitType.BASE) {
            strValue += value;
        } else {
            strValue += "" + head + operator + tail;
        }
        if (isParen) {
            strValue += ")";
        }
        return  strValue;
    }


}
