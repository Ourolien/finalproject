
package pkgfinal.project;


public class Product {
    private String productID;
    private String manufacturer;
    private String price;
    private int stock;
    private String productname;

    public Product() {
    
    }
    
    public Product(String productID, String manufacturer, String price, int stock, String productname) {
        this.productID = productID;
        this.manufacturer = manufacturer;
        this.price = price;
        this.stock = stock;
        this.productname = productname;
    }

    public String getProductID() {
        return productID;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
    
    
    
    
}
