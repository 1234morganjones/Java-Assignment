import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StockGUI extends JFrame implements ActionListener {

    // INPUT FIELDS
    private JTextField codeField;
    private JTextField priceField;
    private JTextField quantityField;
    private JTextField amountField;

    // BUTTONS
    private JButton createButton;
    private JButton addButton;
    private JButton sellButton;
    private JButton updatePriceButton;

    // OUTPUT AREA
    private JTextArea displayArea;

    // STORE MULTIPLE ITEMS
    private ArrayList<Stockitem> items = new ArrayList<>();

    // CONSTRUCTOR
    public StockGUI() {

        setTitle("Stock Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // INPUTS
        add(new JLabel("Stock Code:"));
        codeField = new JTextField(10);
        add(codeField);

        add(new JLabel("Price:"));
        priceField = new JTextField(10);
        add(priceField);

        add(new JLabel("Quantity:"));
        quantityField = new JTextField(10);
        add(quantityField);

        add(new JLabel("Amount:"));
        amountField = new JTextField(10);
        add(amountField);

        // BUTTONS
        createButton = new JButton("Create Item");
        addButton = new JButton("Add Stock");
        sellButton = new JButton("Sell Stock");
        updatePriceButton = new JButton("Update Price");

        add(createButton);
        add(addButton);
        add(sellButton);
        add(updatePriceButton);

        // DISPLAY
        displayArea = new JTextArea(15, 45);
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea));

        // LISTENERS
        createButton.addActionListener(this);
        addButton.addActionListener(this);
        sellButton.addActionListener(this);
        updatePriceButton.addActionListener(this);

        setVisible(true);
    }

    // =========================
    // FIND ITEM (FIXED)
    // =========================
    private Stockitem findItem(String code) {
        code = code.trim().toUpperCase();

        for (Stockitem item : items) {
            if (item.getStockCode().trim().toUpperCase().equals(code)) {
                return item;
            }
        }
        return null;
    }

    // =========================
    // DISPLAY ALL ITEMS
    // =========================
    private void displayAllItems() {
        displayArea.setText("");

        for (Stockitem item : items) {
            displayArea.append(item.toString());
            displayArea.append("\n----------------------\n");
        }
    }

    // =========================
    // BUTTON LOGIC
    // =========================
    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            // CREATE ITEM
            if (e.getSource() == createButton) {

                String code = codeField.getText().trim();
                double price = Double.parseDouble(priceField.getText().trim());
                int quantity = Integer.parseInt(quantityField.getText().trim());

                Stockitem item;

                if (code.startsWith("NS")) {
                    item = new NavSys(code, price, quantity);
                } else if (code.startsWith("EN")) {
                    item = new EnginePart(code, price, quantity);
                } else if (code.startsWith("TY")) {
                    item = new Tyre(code, price, quantity);
                } else {
                    item = new Stockitem(code, price, quantity);
                }

                items.add(item);

                displayArea.setText("Item created successfully\n\n");
                displayAllItems();
            }

            // ADD STOCK
            else if (e.getSource() == addButton) {

                Stockitem item = findItem(codeField.getText().trim());
                int amount = Integer.parseInt(amountField.getText().trim());

                if (item != null && item.addstock(amount)) {
                    displayArea.setText("Stock added\n\n");
                } else {
                    displayArea.setText("Failed to add stock\n\n");
                }

                displayAllItems();
            }

            // SELL STOCK
            else if (e.getSource() == sellButton) {

                Stockitem item = findItem(codeField.getText().trim());
                int amount = Integer.parseInt(amountField.getText().trim());

                if (item != null && item.sellStock(amount)) {
                    displayArea.setText("Stock sold\n\n");
                } else {
                    displayArea.setText("Failed to sell stock\n\n");
                }

                displayAllItems();
            }

            // UPDATE PRICE (FIXED - THIS IS THE IMPORTANT PART)
            else if (e.getSource() == updatePriceButton) {

                Stockitem item = findItem(codeField.getText().trim());

                if (item == null) {
                    displayArea.setText("Item not found\n");
                    return;
                }

                double newPrice = Double.parseDouble(priceField.getText().trim());

                item.setPrice(newPrice);

                displayArea.setText("Price updated successfully\n\n");
                displayAllItems();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid values.");
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {
        new StockGUI();
    }
}