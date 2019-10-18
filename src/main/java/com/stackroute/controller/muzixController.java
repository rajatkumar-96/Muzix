package com.stackroute.controller;


import com.stackroute.domain.Muzix;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.MuzixService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@PropertySource("classpath:application.mongo.properties")
@RestController
@RequestMapping(value = "api/v1")
public class muzixController {
    MuzixService muzixservice;
    @Autowired
    private Environment env;
    public muzixController(MuzixService muzixservice){
        this.muzixservice=muzixservice;
    }
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Muzix muzix) throws TrackAlreadyExistsException {
        ResponseEntity responseEntity;
            if(muzix.getTrackName()==null ){
                muzix.setTrackName(env.getProperty("trackname"));
            }
            if(muzix.getTrackId()==0){
                muzix.setTrackId(Integer.parseInt(env.getProperty("trackid")));
            }
            if(muzix.getTrackComment()==null){
                muzix.setTrackComment(env.getProperty("trackcomment"));
            }

            muzixservice.saveTrack(muzix);
            responseEntity=new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
              return responseEntity;
    }
    @GetMapping("track")
    public ResponseEntity<?> getAllTacks(){
        return new ResponseEntity<List<Muzix>>(muzixservice.getAllTracks(), HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public  ResponseEntity deleteTrack(@RequestBody int trackId) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        //try{
            muzixservice.deleteTrack(trackId);
            responseEntity=new ResponseEntity<String>("Successfully done",HttpStatus.OK );
     //   }catch (TrackNotFoundException ex){
           // responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);

        //}
        return responseEntity;
        }
    @PostMapping("update/{trackId}")
    public  ResponseEntity<?> updateTrack(@PathVariable int trackId, @RequestBody  String trackComment) throws TrackNotFoundException {
        ResponseEntity responseEntity;
        //try {
            muzixservice.updateComment(trackId, trackComment);
            responseEntity = new ResponseEntity<String>("Successfully Done", HttpStatus.OK);
       // }catch (TrackNotFoundException ex){
           // responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);

        //}
        return responseEntity;
    }
    @PostMapping("track/{trackName}")
    public ResponseEntity<?> trackByName(@PathVariable String trackName) throws TrackNotFoundException {
        ResponseEntity responseEntity;

        //try {
            List<Muzix> m = muzixservice.trackByName(trackName);
            responseEntity = new ResponseEntity<>(m, HttpStatus.CREATED);
       // } catch (TrackNotFoundException e) {
         //   responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
          //  e.printStackTrace();
   //     }
        return responseEntity;
    }

}
