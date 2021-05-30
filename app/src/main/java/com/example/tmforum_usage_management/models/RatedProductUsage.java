package com.example.tmforum_usage_management.models;

import java.util.Date;

public class RatedProductUsage {
    private Money bucketValueConvertedInAmount;
    private Boolean isBilled;
    private Boolean isTaxExempt;
    private String offerTariffType;
    private String ratingAmountType;
    private Date ratingDate;
    private Money taxExcludedRatingAmount;
    private Money taxIncludedRatingAmount;
    private Double taxRate;
    private String usageRatingTag;
    private ProductRef productRef;
    private String baseType;
    private String schemaLocation;
    private String type;

    public RatedProductUsage() {
    }

    public RatedProductUsage(Money bucketValueConvertedInAmount, Boolean isBilled, Boolean isTaxExempt, String offerTariffType,
                             String ratingAmountType, Date ratingDate, Money taxExcludedRatingAmount, Money taxIncludedRatingAmount, Double taxRate,
                             String usageRatingTag, ProductRef productRef, String baseType, String schemaLocation, String type) {
        this.bucketValueConvertedInAmount = bucketValueConvertedInAmount;
        this.isBilled = isBilled;
        this.isTaxExempt = isTaxExempt;
        this.offerTariffType = offerTariffType;
        this.ratingAmountType = ratingAmountType;
        this.ratingDate = ratingDate;
        this.taxExcludedRatingAmount = taxExcludedRatingAmount;
        this.taxIncludedRatingAmount = taxIncludedRatingAmount;
        this.taxRate = taxRate;
        this.usageRatingTag = usageRatingTag;
        this.productRef = productRef;
        this.baseType = baseType;
        this.schemaLocation = schemaLocation;
        this.type = type;
    }

    public Money getBucketValueConvertedInAmount() {
        return bucketValueConvertedInAmount;
    }

    public void setBucketValueConvertedInAmount(Money bucketValueConvertedInAmount) {
        this.bucketValueConvertedInAmount = bucketValueConvertedInAmount;
    }

    public Boolean getBilled() {
        return isBilled;
    }

    public void setBilled(Boolean billed) {
        isBilled = billed;
    }

    public Boolean getTaxExempt() {
        return isTaxExempt;
    }

    public void setTaxExempt(Boolean taxExempt) {
        isTaxExempt = taxExempt;
    }

    public String getOfferTariffType() {
        return offerTariffType;
    }

    public void setOfferTariffType(String offerTariffType) {
        this.offerTariffType = offerTariffType;
    }

    public String getRatingAmountType() {
        return ratingAmountType;
    }

    public void setRatingAmountType(String ratingAmountType) {
        this.ratingAmountType = ratingAmountType;
    }

    public Date getRatingDate() {
        return ratingDate;
    }

    public void setRatingDate(Date ratingDate) {
        this.ratingDate = ratingDate;
    }

    public Money getTaxExcludedRatingAmount() {
        return taxExcludedRatingAmount;
    }

    public void setTaxExcludedRatingAmount(Money taxExcludedRatingAmount) {
        this.taxExcludedRatingAmount = taxExcludedRatingAmount;
    }

    public Money getTaxIncludedRatingAmount() {
        return taxIncludedRatingAmount;
    }

    public void setTaxIncludedRatingAmount(Money taxIncludedRatingAmount) {
        this.taxIncludedRatingAmount = taxIncludedRatingAmount;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public String getUsageRatingTag() {
        return usageRatingTag;
    }

    public void setUsageRatingTag(String usageRatingTag) {
        this.usageRatingTag = usageRatingTag;
    }

    public ProductRef getProductRef() {
        return productRef;
    }

    public void setProductRef(ProductRef productRef) {
        this.productRef = productRef;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public String getSchemaLocation() {
        return schemaLocation;
    }

    public void setSchemaLocation(String schemaLocation) {
        this.schemaLocation = schemaLocation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
