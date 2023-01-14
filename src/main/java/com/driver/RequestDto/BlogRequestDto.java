package com.driver.RequestDto;

import java.util.Date;

public class BlogRequestDto {

    private String title;

    private String content;

    private Date publishDate;

    public BlogRequestDto() {
    }

    public BlogRequestDto(String title, String content, Date publishDate) {
        this.title = title;
        this.content = content;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
