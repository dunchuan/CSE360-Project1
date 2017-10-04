public class BooleanQuestion {

    BooleanCircuit circuit;
    String finishedCircuit;
    String[][] laws;
    String[][] transforms;

    public BooleanQuestion() {
        circuit = new BooleanCircuit("AB + AC + C", BooleanCircuit.TreeType.SOP);
        laws = new String[4][4];
        transforms = new String[4][4];

        laws[0][0] = "Distributive Law";
        laws[0][1] = "Communitive Law";
        laws[0][2] = "De Morgan's Law";
//        transforms[0][0] =
//        transforms[0][1] =
//        transforms[0][2] =
//        transforms[0][3] =

    }
}
