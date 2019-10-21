package at.htl.firstproject;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class InitBean {

    @PostConstruct
    private void init() {
        System.out.println(" *** it works ***");
    }

}
