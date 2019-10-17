package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.muzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("usethis")
@Primary

public class MuzixServiceDummyImpl implements MuzixService{
    muzixRepository muzixrepository;

    @Autowired
    public MuzixServiceDummyImpl(muzixRepository muzixreppository) {
        this.muzixrepository = muzixreppository;
    }

    @Override
    public Muzix saveTrack(Muzix muzix) throws TrackAlreadyExistsException {
        if(muzixrepository.existsById(muzix.getTrackId())){
            throw new TrackAlreadyExistsException("Track Already Exists,Please try again");
        }
        Muzix savedTrack = muzixrepository.save(muzix);
        return savedTrack;
    }

    @Override
    public List<Muzix> getAllTracks() {
        return muzixrepository.findAll();
    }


    @Override
    public boolean deleteTrack(int trackId) throws TrackNotFoundException {
        Muzix muzix=new Muzix();
        if(!muzixrepository.existsById(muzix.getTrackId())){
            throw new TrackNotFoundException("Track Not Found,Please try again");
        }
        muzixrepository.deleteById(trackId);
        return true;
    }

    @Override
    public boolean updateComment(int trackId, String comment) throws  TrackNotFoundException {
        Muzix muzix=new Muzix();
        if(!muzixrepository.existsById(muzix.getTrackId())){
            throw new TrackNotFoundException("Track Not Found,Please try again");
        }
        try {
            Muzix oldTrack = muzixrepository.getOne(trackId);
            oldTrack.setTrackComment(comment);
            muzixrepository.save(oldTrack);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Muzix> trackByName(String trackName) throws TrackNotFoundException {
        Muzix muzix=new Muzix();
        if(!muzixrepository.existsById(muzix.getTrackId())){
            throw new TrackNotFoundException("Track Not Found,Please try again");
        }
        return muzixrepository.findAllTracksByName(trackName);


    }
}
