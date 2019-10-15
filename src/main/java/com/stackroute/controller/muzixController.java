package com.stackroute.controller;


import com.stackroute.domain.Muzix;
import com.stackroute.service.MuzixService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class muzixController {
    MuzixService muzixservice;
    public muzixController(MuzixService muzixservice){
        this.muzixservice=muzixservice;
    }
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Muzix muzix){
        ResponseEntity responseEntity;
        try{
            muzixservice.saveTrack(muzix);
            responseEntity=new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);

        }catch (Exception ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);

        }
        return responseEntity;
    }
    @GetMapping("track")
    public ResponseEntity<?> getAllTacks(){
        return new ResponseEntity<List<Muzix>>(muzixservice.getAllTracks(), HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public  ResponseEntity deleteTrack(@RequestBody int trackId){
        return new ResponseEntity<>(muzixservice.deleteTrack(trackId), HttpStatus.OK);
    }
    @PostMapping("update/{trackId}")
    public  ResponseEntity<?> updateTrack(@PathVariable int trackId, @RequestBody  String trackComment){
        return new ResponseEntity<>(muzixservice.updateComment(trackId,trackComment),HttpStatus.OK);
    }

}
