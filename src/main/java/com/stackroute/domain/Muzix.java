package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Muzix {
    @Id
    int trackId;
    String trackName;
    String trackComment;

    public Muzix(){}

    public Muzix(int trackId, String trackName, String trackComment) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackComment = trackComment;
    }

    @Override
    public String toString() {
        return "muzix{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", trackComment='" + trackComment + '\'' +
                '}';
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTrackComment() {
        return trackComment;
    }

    public void setTrackComment(String trackComment) {
        this.trackComment = trackComment;
    }



}
