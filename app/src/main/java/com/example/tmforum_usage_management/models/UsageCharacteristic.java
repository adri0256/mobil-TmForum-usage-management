package com.example.tmforum_usage_management.models;

public class UsageCharacteristic {
    private String id;
    private String name;
    private String value;
    private String baseType;
    private CharacteristicRelationship characteristicRelationship;
    private String valueType;
    private String schemaLocation;
    private String type;

    public UsageCharacteristic() {
    }

    public UsageCharacteristic(String id, String name, String value, String baseType, CharacteristicRelationship characteristicRelationship, String valueType, String schemaLocation, String type) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.baseType = baseType;
        this.characteristicRelationship = characteristicRelationship;
        this.valueType = valueType;
        this.schemaLocation = schemaLocation;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getBaseType() {
        return baseType;
    }

    public void setBaseType(String baseType) {
        this.baseType = baseType;
    }

    public CharacteristicRelationship getCharacteristicRelationship() {
        return characteristicRelationship;
    }

    public void setCharacteristicRelationship(CharacteristicRelationship characteristicRelationship) {
        this.characteristicRelationship = characteristicRelationship;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
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
