package ru.shanin.weblocal.api.local.data;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataGet {
    @SerializedName("String")
    @Expose
    String string;

    @Override
    public String toString() {
        return (new Gson()).toJson(this);
    }
}
