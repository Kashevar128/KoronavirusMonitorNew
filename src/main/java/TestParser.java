public class TestParser {
    public static void main(String[] args) {
        Parser pars = new Parser();
        pars.info("Севастополь");
        String s = pars.toString();
        System.out.println(s);
        pars.splitter(pars.toString());
    }
}
