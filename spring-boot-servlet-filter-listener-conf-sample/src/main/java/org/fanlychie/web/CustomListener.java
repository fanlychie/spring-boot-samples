package org.fanlychie.web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created by fanlychie on 2017/7/2.
 */
public class CustomListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        System.out.println("------ CustomListener ------");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {

    }

}