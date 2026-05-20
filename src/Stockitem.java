public class Stockitem {

    protected String stockCode;
    protected double price;
    protected int quantity;

    // Constructor
    public Stockitem(String code, double price, int quantity) {
        this.stockCode = code;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getStockCode() {
        return stockCode;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // SET PRICE
    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    // ADD STOCK
    public boolean addstock(int amount) {
        if (amount <= 0) return false;
        if (quantity + amount > 100) return false;

        quantity += amount;
        return true;
    }

    // SELL STOCK
    public boolean sellStock(int amount) {
        if (amount <= 0) return false;
        if (amount > quantity) return false;

        quantity -= amount;
        return true;
    }

    // VAT
    public double getPriceWithVAT() {
        return price * 1.175;
    }

    // DEFAULT NAME (OVERRIDDEN)
    public String getStockName() {
        return "Generic Stock Item";
    }

    // DEFAULT DESCRIPTION (OVERRIDDEN)
    public String getStockDescription() {
        return "No description available";
    }

    // OUTPUT
    public String toString() {
        return "Stock Name: " + getStockName() +
                "\nDescription: " + getStockDescription() +
                "\nStock Code: " + stockCode +
                "\nPrice: £" + price +
                "\nQuantity: " + quantity +
                "\nVAT Price: £" + getPriceWithVAT() +
                "\n";
    }
}