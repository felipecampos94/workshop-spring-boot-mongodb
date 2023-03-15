package com.java.workshopmongodb.model;

import com.java.workshopmongodb.dto.AuthorDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class Post implements Serializable {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;
}
