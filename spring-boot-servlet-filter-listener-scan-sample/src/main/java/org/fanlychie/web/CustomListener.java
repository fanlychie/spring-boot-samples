package org.fanlychie.web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by fanlychie on 2017/7/2.
 */
@WebListener
public class CustomListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        System.out.println("------ CustomListener Annotation ------");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {

    }

}