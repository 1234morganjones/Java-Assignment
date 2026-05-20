public class EnginePart extends Stockitem {

    public EnginePart(String code, double price, int quantity) {
        super(code, price, quantity);
    }

    @Override
    public String getStockName() {
        return "Engine Part";
    }

    @Override
    public String getStockDescription() {
        return "Engine component";
    }
}