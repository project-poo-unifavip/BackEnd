package com.estoque.estoquejava.dto;

public class ProductsDTO {

    private Long id;
    private String productCode;
    private String name;  // Nome do produto
    private String category;  // Categoria do produto
    private Double unitCost;
    private Double profitMargin;

    public ProductsDTO(Long id, String productCode, String name, String category, Double unitCost, Double profitMargin) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.category = category;
        this.unitCost = unitCost;
        this.profitMargin = profitMargin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    public Double getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(Double profitMargin) {
        this.profitMargin = profitMargin;
    }
}
