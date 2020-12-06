package com.sample;


import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.logger.*;

/**
 * This is a sample class to launch a rule.
 */
public class Drools {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	KieRuntimeLogger kLogger = ks.getLoggers().newFileLogger(kSession, "test");
            // go !

            kSession.fireAllRules();
            kLogger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    

    public static class Question {
    	public String question;
    	public String answer;
    	public Question(String q, String a) {
    		this.question = q;
    		this.answer = a;
    	}
    }

}
