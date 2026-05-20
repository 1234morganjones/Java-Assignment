public class Tyre extends Stockitem {

    public Tyre(String code, double price, int quantity) {
        super(code, price, quantity);
    }

    @Override
    public String getStockName() {
        return "Tyre";
    }

    @Override
    public String getStockDescription() {
        return "Vehicle tyre";
    }
}