import com.sun.deploy.util.ArrayUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.tools.javac.util.List;

import java.util.ArrayList;

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

    public BooleanCircuit(BooleanCircuit head, BooleanCircuit tail) {
        this.head = head;
        this.tail = tail;
        operator = BooleanOp.IGNORE;
    }

    public BooleanCircuit(String value, TreeType treeType, boolean isParen) {
        this.isParen = isParen;

        if (treeType == TreeType.SOP) {
            List<String> values = List.from(value.split("\\Q" + BooleanOp.OR.toString() + "\\E"));
            if( values.size() > 2) {
                head = new BooleanCircuit(values.head, treeType);
                tail = new BooleanCircuit(value.substring(values.head.length() + 3), treeType);
                operator = BooleanOp.OR;
                type = CircuitType.CIRCUIT;
            } else {
                values = List.from(value.split("\\Q" + BooleanOp.XOR.toString() + "\\E"));
                if( values.size() > 2) {
                    head = new BooleanCircuit(values.head, treeType);
                    tail = new BooleanCircuit(value.substring(values.head.length() + 3), treeType);
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
