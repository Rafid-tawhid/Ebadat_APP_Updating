package com.example.custombottomnavigation.models;

import android.widget.ImageView;

import java.util.List;

public class DuaItems {
    String title;
    int dua;
    int arbi;
    int bangla;
    int ayat;

    public DuaItems(String title, int dua, int arbi, int bangla, int ayat) {
        this.title = title;
        this.dua = dua;
        this.arbi = arbi;
        this.bangla = bangla;
        this.ayat = ayat;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDua() {
        return dua;
    }

    public void setDua(int dua) {
        this.dua = dua;
    }

    public int getArbi() {
        return arbi;
    }

    public void setArbi(int arbi) {
        this.arbi = arbi;
    }

    public int getBangla() {
        return bangla;
    }

    public void setBangla(int bangla) {
        this.bangla = bangla;
    }

    public int getAyat() {
        return ayat;
    }

    public void setAyat(int ayat) {
        this.ayat = ayat;
    }
}
