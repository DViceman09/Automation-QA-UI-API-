package api.pojos;

public class SearchProductRequest {
    private String search_product;

    public SearchProductRequest(String search_product) {
        this.search_product = search_product;
    }

    public String getSearch_product() {
        return search_product;
    }

    public void setSearch_product(String search_product) {
        this.search_product = search_product;
    }
}
