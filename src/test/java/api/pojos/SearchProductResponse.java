package api.pojos;

import java.util.List;

public class SearchProductResponse {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
