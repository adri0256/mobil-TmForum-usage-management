package com.example.tmforum_usage_management.models;

public class CharacteristicRelationship {
    private String id;
    private String href;
    private String relationshipType;
    private String baseType;
    private String schemaLocation;
    private String type;

    public CharacteristicRelationship() {
    }

    public CharacteristicRelationship(String id, String href, String relationshipType, String baseType, String schemaLocation, String type) {
        this.id = id;
        this.href = href;
        this.relationshipType = relationshipType;
        this.baseType = baseType;
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
