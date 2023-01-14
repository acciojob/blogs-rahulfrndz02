package com.driver.RequestDto;

public class ImageRequestDto {

    private String description;

    private String dimensions;

    public ImageRequestDto() {
    }

    public ImageRequestDto(String description, String dimensions) {
        this.description = description;
        this.dimensions = dimensions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
