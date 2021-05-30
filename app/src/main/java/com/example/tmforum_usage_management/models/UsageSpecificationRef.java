package com.example.tmforum_usage_management.models;

public class UsageSpecificationRef {
    private String id;
    private String href;
    private String name;
    private String baseType;
    private String referedType;
    private String schemaLocation;
    private String type;

    public UsageSpecificationRef() {
    }

    public UsageSpecificationRef(String id, String href, String name, String baseType, String referedType, String schemaLocation, String type) {
        this.id = id;
        this.href = href;
        this.name = name;
        this.baseType = baseType;
        this.referedType = referedType;
        this.schemaLocation = schemaLocation;
        this.type = type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public String getReferedType() {
        return referedType;
    }

    public void setReferedType(String referedType) {
        this.referedType = referedType;
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
