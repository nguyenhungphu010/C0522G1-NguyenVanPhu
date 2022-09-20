package com.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongInforDto {

    private int id;

    @NotBlank(message = "vui lòng không bỏ trống")
    @Size(max = 800, message = " không quá 800 ký tự")
    @Pattern(regexp = "[A-Za-z0-9]*$", message = " không có ký tự đặc biệt")
    private String name;

    @NotBlank(message = "vui lòng không bỏ trống")
    @Size(max = 300, message = " không quá 300 ký tự")
    @Pattern(regexp = "[A-Za-z0-9]*$", message = " không có ký tự đặc biệt")
    private String singer;

    @NotBlank(message = "vui lòng không bỏ trống")
    @Size(max = 1000, message = " không quá 1000 ký tự")
    @Pattern(regexp = "[A-Za-z0-9\\,]*$", message = " không có ký tự đặc biệt, trừ dấu phẩy")
    private String category;

    public SongInforDto() {
    }

    public SongInforDto(int id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
