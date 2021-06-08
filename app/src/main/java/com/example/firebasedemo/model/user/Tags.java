package com.example.firebasedemo.model.user;

import java.util.List;

public class Tags {
    private List<Custom> custom;
    private List<Aggregated> aggregated;

    public List<Custom> getCustom() {
        return custom;
    }

    public void setCustom(List<Custom> custom) {
        this.custom = custom;
    }

    public List<Aggregated> getAggregated() {
        return aggregated;
    }

    public void setAggregated(List<Aggregated> aggregated) {
        this.aggregated = aggregated;
    }
}
