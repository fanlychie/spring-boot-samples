package org.fanlychie.enums;

/**
 * Created by fanlychie on 2017/7/2.
 */
public enum Sex {

    MALE("男"),

    FEMALE("女"),

    ;

    private final String displayText;

    private Sex(String displayText) {
        this.displayText = displayText;
    }

    @Override
    public String toString() {
        return displayText;
    }

}