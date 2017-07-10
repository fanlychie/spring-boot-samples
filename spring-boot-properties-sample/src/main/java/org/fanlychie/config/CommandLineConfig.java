package org.fanlychie.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by fanlychie on 2017/7/11.
 */
@Component
public class CommandLineConfig {

    @Value("${command-line-arg}")
    private String commandLineArg;

    public String getCommandLineArg() {
        return commandLineArg;
    }

    public void setCommandLineArg(String commandLineArg) {
        this.commandLineArg = commandLineArg;
    }

    @Override
    public String toString() {
        return "CommandLineConfig{" +
                "commandLineArg='" + commandLineArg + '\'' +
                '}';
    }

}