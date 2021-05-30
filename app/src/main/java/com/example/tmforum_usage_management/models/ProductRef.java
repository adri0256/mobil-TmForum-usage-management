package com.example.tmforum_usage_management.models;

public class ProductRef {
    private String id;
    private String href;
    private String name;
    private String relationshipType;
    private String baseType;
    private String referedType;
    private String schemaLocation;
    private String type;

    public ProductRef() {
    }

    public ProductRef(String id, String href, String name, String relationshipType, String baseType, String referedType, String schemaLocation, String type) {
        this.id = id;
        this.href = href;
        this.name = name;
        this.relationshipType = relationshipType;
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

    public String getRelationshipType() {
        return relationshipType;
    }

    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
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
