package com.example.recyclerviewpopup.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Anggota {

    @SerializedName("id")
    private String id;

    @SerializedName("nama")
    private String nama;

    @SerializedName("title")
    private String title;

    @SerializedName("moto")
    private String moto;

    @SerializedName("email")
    private String email;

    @SerializedName("image")
    private String image;

    @SerializedName("value")
    private String value;

    @SerializedName("message")
    private String message;

    @SerializedName("result")
    List<Anggota> dataAnggota;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMoto() {
        return moto;
    }

    public void setMoto(String moto) {
        this.moto = moto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Anggota> getDataAnggota() {
        return dataAnggota;
    }

    public void setDataAnggota(List<Anggota> dataAnggota) {
        this.dataAnggota = dataAnggota;
    }
}
