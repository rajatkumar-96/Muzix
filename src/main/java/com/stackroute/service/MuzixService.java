package com.stackroute.service;

import com.stackroute.domain.Muzix;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface MuzixService {
    public Muzix saveTrack(Muzix muzix) throws TrackAlreadyExistsException;
    public List<Muzix> getAllTracks();
    public boolean deleteTrack(int trackId) throws TrackNotFoundException;
    public boolean updateComment(int trackId, String comment)throws TrackNotFoundException;
    public List<Muzix> trackByName(String trackName)throws TrackNotFoundException;
}
