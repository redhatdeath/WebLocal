package ru.shanin.weblocal.api.local.data;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPost {

    @SerializedName("Key")
    @Expose
    public Integer key;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Surname")
    @Expose
    public String surname;
    @SerializedName("SecondName")
    @Expose
    public String secondName;
    @SerializedName("Mark")
    @Expose
    public Integer mark;

    @Override
    public String toString() {
        return (new Gson()).toJson(this);
    }

}
