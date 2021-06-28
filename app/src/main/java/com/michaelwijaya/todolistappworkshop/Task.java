package com.michaelwijaya.todolistappworkshop;

public class Task {
    private String title;
    private boolean isChecked = false;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
