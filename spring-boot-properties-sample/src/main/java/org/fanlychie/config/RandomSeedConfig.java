package org.fanlychie.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by fanlychie on 2017/7/10.
 */
@Component
@ConfigurationProperties("random-seed")
public class RandomSeedConfig {

    private int randomIntValue;

    private int randomIntRangeValue;

    private long randomLongValue;

    private long randomLongRangeValue;

    private String randomUuidValue;

    private String randomStrValue;

    public int getRandomIntValue() {
        return randomIntValue;
    }

    public void setRandomIntValue(int randomIntValue) {
        this.randomIntValue = randomIntValue;
    }

    public int getRandomIntRangeValue() {
        return randomIntRangeValue;
    }

    public void setRandomIntRangeValue(int randomIntRangeValue) {
        this.randomIntRangeValue = randomIntRangeValue;
    }

    public long getRandomLongValue() {
        return randomLongValue;
    }

    public void setRandomLongValue(long randomLongValue) {
        this.randomLongValue = randomLongValue;
    }

    public long getRandomLongRangeValue() {
        return randomLongRangeValue;
    }

    public void setRandomLongRangeValue(long randomLongRangeValue) {
        this.randomLongRangeValue = randomLongRangeValue;
    }

    public String getRandomUuidValue() {
        return randomUuidValue;
    }

    public void setRandomUuidValue(String randomUuidValue) {
        this.randomUuidValue = randomUuidValue;
    }

    public String getRandomStrValue() {
        return randomStrValue;
    }

    public void setRandomStrValue(String randomStrValue) {
        this.randomStrValue = randomStrValue;
    }

    @Override
    public String toString() {
        return "RandomSeedConfig{" +
                "randomIntValue=" + randomIntValue +
                ", randomIntRangeValue=" + randomIntRangeValue +
                ", randomLongValue=" + randomLongValue +
                ", randomLongRangeValue=" + randomLongRangeValue +
                ", randomUuidValue='" + randomUuidValue + '\'' +
                ", randomStrValue='" + randomStrValue + '\'' +
                '}';
    }

}