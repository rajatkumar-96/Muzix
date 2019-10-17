package com.stackroute.seeddata;
import com.stackroute.domain.Muzix;

import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.repository.muzixRepository;
import com.stackroute.service.MuzixService;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Runner implements CommandLineRunner {
    @Autowired
    private MuzixService muzixService;
    @Value("${trackname}")
    private String name;
    @Value("${trackcomment}")
    private String comment;
    @Value("${trackid}")
    private int id;
    //public Runner( MuzixService muzixService) {
   //     this.muzixService = muzixService;
    //}

    @Override
    public void run(String... args) throws TrackAlreadyExistsException {
        Muzix muzix=new Muzix(id,name,comment);
        try{
            muzixService.saveTrack(muzix);
        }catch (TrackAlreadyExistsException ex){

        }
    }
}
