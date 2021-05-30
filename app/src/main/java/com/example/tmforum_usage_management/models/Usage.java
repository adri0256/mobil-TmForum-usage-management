package com.example.tmforum_usage_management.models;

import com.google.firebase.firestore.DocumentId;

import java.util.Date;

public class Usage {
    @DocumentId
    private String id;

    private String href;
    private Date usageDate;
    private String usageType;
    private String description;
    private UsageStatusType status;
    private String baseType;
    private String schemaLocation;
    private String type;

    private RatedProductUsage ratedProductUsage;
    private RelatedParty relatedParty;
    private UsageCharacteristic usageCharacteristic;
    private UsageSpecificationRef usageSpecification;

    public Usage() {
    }

    public Usage(String href, Date usageDate, String usageType, String description, UsageStatusType status, String baseType,
                 String schemaLocation, String type, RatedProductUsage ratedProductUsage, RelatedParty relatedParty, UsageCharacteristic usageCharacteristic,
                 UsageSpecificationRef usageSpecification) {
        this.href = href;
        this.usageDate = usageDate;
        this.usageType = usageType;
        this.description = description;
        this.status = status;
        this.baseType = baseType;
        this.schemaLocation = schemaLocation;
        this.type = type;
        this.ratedProductUsage = ratedProductUsage;
        this.relatedParty = relatedParty;
        this.usageCharacteristic = usageCharacteristic;
        this.usageSpecification = usageSpecification;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Date getUsageDate() {
        return usageDate;
    }

    public void setUsageDate(Date usageDate) {
        this.usageDate = usageDate;
    }

    public String getUsageType() {
        return usageType;
    }

    public void setUsageType(String usageType) {
        this.usageType = usageType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UsageStatusType getStatus() {
        return status;
    }

    public void setStatus(UsageStatusType status) {
        this.status = status;
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

    public RatedProductUsage getRatedProductUsage() {
        return ratedProductUsage;
    }

    public void setRatedProductUsage(RatedProductUsage ratedProductUsage) {
        this.ratedProductUsage = ratedProductUsage;
    }

    public RelatedParty getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(RelatedParty relatedParty) {
        this.relatedParty = relatedParty;
    }

    public UsageCharacteristic getUsageCharacteristic() {
        return usageCharacteristic;
    }

    public void setUsageCharacteristic(UsageCharacteristic usageCharacteristic) {
        this.usageCharacteristic = usageCharacteristic;
    }

    public UsageSpecificationRef getUsageSpecification() {
        return usageSpecification;
    }

    public void setUsageSpecification(UsageSpecificationRef usageSpecification) {
        this.usageSpecification = usageSpecification;
    }
}
