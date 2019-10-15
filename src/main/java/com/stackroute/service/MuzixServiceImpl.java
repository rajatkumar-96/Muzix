package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.repository.muzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MuzixServiceImpl implements MuzixService {
    muzixRepository muzixrepository;
    @Autowired
    public MuzixServiceImpl(muzixRepository muzixreppository){this.muzixrepository=muzixreppository;}
    @Override
    public Muzix saveTrack(Muzix muzix) {
        Muzix savedTrack=muzixrepository.save(muzix);
        return savedTrack;
    }

    @Override
    public List<Muzix> getAllTracks() {
        return muzixrepository.findAll();
    }



    @Override
    public boolean deleteTrack(int trackId) {
        muzixrepository.deleteById(trackId);
return true;
    }

    @Override
    public boolean updateComment(int trackId, String comment) {
        try {
            Muzix oldTrack = muzixrepository.getOne(trackId);
            oldTrack.setTrackComment(comment);
            muzixrepository.save(oldTrack);
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
