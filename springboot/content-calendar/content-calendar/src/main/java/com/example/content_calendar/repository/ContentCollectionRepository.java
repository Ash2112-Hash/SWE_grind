package com.example.content_calendar.repository;

import com.example.content_calendar.model.Content;
import com.example.content_calendar.model.Status;
import com.example.content_calendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


// This class will not be communicating with a db (although the annotation allows for it)
// It is just for keeping a collection of data in memory (local for now)
@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void addNewContent(Content newContent){
        contentList.add(newContent);
    }

    public Boolean existsById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void updateContent(Content newContent){
        contentList.removeIf(c -> c.id().equals(newContent.id()));
        addNewContent(newContent);
    }

    public void deleteContent(Content newContent){
        contentList.removeIf(c -> c.id().equals(newContent.id()));
    }


    //this annotation is used to set up any data, deps or extra content before the class is put into service
    // in this case, its used to setup some dummy data to return during api testing
    @PostConstruct
    private void init(){
        Content content = new Content(
                1,
                "My first record",
                "first blog record",
                Status.COMPLETED,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "testurl.com"
        );

        contentList.add(content);

    }


}
