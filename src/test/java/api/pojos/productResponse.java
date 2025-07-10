package api.pojos;
import java.util.List;

public class productResponse {
    private List<Product> products;

    // Getters and setters
    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }
}
