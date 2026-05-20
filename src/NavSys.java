public class NavSys extends Stockitem {

    public NavSys(String code, double price, int quantity) {
        super(code, price, quantity);
    }
    //Overrides stock Name
    @Override
    public String getStockName() {
        return "Navigation System";
    }
//Overrides stock description
    @Override
    public String getStockDescription() {
        return "Geo Vision Sat Nav";
    }
}
