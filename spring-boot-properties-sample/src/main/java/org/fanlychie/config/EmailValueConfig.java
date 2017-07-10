package org.fanlychie.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by fanlychie on 2017/7/10.
 */
@Component
public class EmailValueConfig {

    @Value("${email-name}")
    private String emailName;

    @Value("${email-from}")
    private String emailFrom;

    public String getEmailName() {
        return emailName;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    @Override
    public String toString() {
        return "EmailValueConfig{" +
                "emailName='" + emailName + '\'' +
                ", emailFrom='" + emailFrom + '\'' +
                '}';
    }

}