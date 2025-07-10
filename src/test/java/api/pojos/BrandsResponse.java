package api.pojos;

import java.util.List;

public class BrandsResponse {
    private int responseCode;
    private List<Brand> brands;

    // Getters and setters
    public int getResponseCode() { return responseCode; }
    public void setResponseCode(int responseCode) { this.responseCode = responseCode; }

    public List<Brand> getBrands() { return brands; }
    public void setBrands(List<Brand> brands) { this.brands = brands; }
}
