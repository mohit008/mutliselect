package com.mutli.select_search;

/**
 * Created by mohit.soni on 16-04-2018.
 * This class hold data.
 */

public class KeyValue {

    String id;
    Boolean visible;
    String name;
    boolean checked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "KeyValue{" +
                "visible=" + visible +
                ", name='" + name + '\'' +
                ", checked=" + checked +
                '}';
    }
}
