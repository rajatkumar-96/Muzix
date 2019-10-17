package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.muzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MuzixServiceImpl implements MuzixService {
    private muzixRepository muzixrepository;

    @Autowired
    public MuzixServiceImpl(muzixRepository muzixreppository) {
        this.muzixrepository = muzixreppository;
    }

    @Override
    public Muzix saveTrack(Muzix muzix) throws TrackAlreadyExistsException {
        if(muzixrepository.existsById(muzix.getTrackId())){
            throw new TrackAlreadyExistsException("Track Already Exists");
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
            throw new TrackNotFoundException("Track Not FOund");
        }
        muzixrepository.deleteById(trackId);
        return true;
    }

    @Override
    public boolean updateComment(int trackId, String comment) throws  TrackNotFoundException {
        Muzix muzix=new Muzix();
        if(!muzixrepository.existsById(muzix.getTrackId())){
            throw new TrackNotFoundException("Track Not FOund");
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
            throw new TrackNotFoundException("Track Not FOund");
        }
        return muzixrepository.findAllTracksByName(trackName);


    }
}
