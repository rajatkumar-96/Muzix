package com.stackroute.seeddata;

import com.stackroute.domain.Muzix;

import com.stackroute.repository.muzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Listener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private muzixRepository muzixrepository;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        muzixrepository.save(new Muzix(1, "Memories", "New Released"));
    }
}
