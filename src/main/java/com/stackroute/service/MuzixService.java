package com.stackroute.service;

import com.stackroute.domain.Muzix;

import java.util.List;

public interface MuzixService {
    public Muzix saveTrack(Muzix muzix);
    public List<Muzix> getAllTracks();
    public boolean deleteTrack(int trackId);
    public boolean updateComment(int trackId, String comment);
}
