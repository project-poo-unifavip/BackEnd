package com.estoque.estoquejava.dto;

import java.math.BigDecimal;

public class ProductsDTO {
    private Long id;
    private String productCode;
    private BigDecimal unitCost;
    private BigDecimal profitMargin;

    public ProductsDTO() {}

    public ProductsDTO(Long id, String productCode, BigDecimal unitCost, BigDecimal profitMargin) {
        this.id = id;
        this.productCode = productCode;
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

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public BigDecimal getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(BigDecimal profitMargin) {
        this.profitMargin = profitMargin;
    }
}
