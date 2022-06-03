package com.Anusuya.training.servlet.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class listener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener {


    public void requestDestroyed(ServletRequestEvent event)  {
    	System.out.println("request destroyed");
    }

    public void requestInitialized(ServletRequestEvent event)  { 
    	System.out.println("request created");
    }
	
}
