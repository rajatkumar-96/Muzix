package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Table(name="muzix")
public class Muzix {
    @Id
    int trackId;
    String trackName;
    String trackComment;




}
