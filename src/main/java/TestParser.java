public class TestParser {
    public static void main(String[] args) {
        Parser pars = new Parser();
        pars.info("Севастополь");
        pars.splitter(pars.toString());
        new Gui();
    }
}
