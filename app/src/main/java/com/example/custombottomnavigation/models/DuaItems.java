package com.example.custombottomnavigation.models;

import android.widget.ImageView;

import java.util.List;

public class DuaItems {
    String title,arbi,bangla,ortho,ayat;

    public DuaItems(String title, String arbi, String bangla, String ortho, String ayat) {
        this.title = title;
        this.arbi = arbi;
        this.bangla = bangla;
        this.ortho = ortho;
        this.ayat = ayat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArbi() {
        return arbi;
    }

    public void setArbi(String arbi) {
        this.arbi = arbi;
    }

    public String getBangla() {
        return bangla;
    }

    public void setBangla(String bangla) {
        this.bangla = bangla;
    }

    public String getOrtho() {
        return ortho;
    }

    public void setOrtho(String ortho) {
        this.ortho = ortho;
    }

    public String getAyat() {
        return ayat;
    }

    public void setAyat(String ayat) {
        this.ayat = ayat;
    }
}
