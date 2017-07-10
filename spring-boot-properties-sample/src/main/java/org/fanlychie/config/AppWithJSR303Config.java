package org.fanlychie.config;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * Created by fanlychie on 2017/7/10.
 */
@Component
@ConfigurationProperties("app")
public class AppWithJSR303Config {

    @NotNull
    private String name;

    @NotBlank
    @Length(min = 1, max = 100)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AppConfig{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}