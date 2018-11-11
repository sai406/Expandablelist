package com.mstech.expandablelist;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class DisplayTypeJobs implements Serializable {

    public List<DriverJobsModel> getStore() {
        return Store;
    }

    public String getDisplayTypes() {
        return DisplayName;
    }

    @SerializedName("Jobs")
    public List<DriverJobsModel> Store;

    @SerializedName("DisplayName")
    public String DisplayName;

}
