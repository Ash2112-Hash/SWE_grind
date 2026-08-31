package com.example.content_calendar.controller;


import com.example.content_calendar.model.Content;
import com.example.content_calendar.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;


@RestController
@RequestMapping("/api/content") //this is a class level req mapping for reqs
public class ContentController {

    private final ContentCollectionRepository repository;

//    @Autowired this is implicit when you only have one public constructor for a class
    public ContentController(ContentCollectionRepository repository){
        this.repository = repository;
    }

    // find all pieces of content in the sys
    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }


    // GET for reading

    @GetMapping("/{id}")
    public Content findSpecificContent(@PathVariable("id") Integer contentId){
        return repository.findById(contentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found"));
    }


    // POST for creation
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void createContent(@RequestBody Content contentBody){
       repository.addNewContent(contentBody);
    }


    // update a content record that already exists, this is a PUT call
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("update/{id}")
    public void updateContent(@RequestBody Content contentBody, @PathVariable Integer id){
        if (!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.updateContent(contentBody);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("delete/{id}")
    public void deleteContent(@RequestBody Content contentBody, @PathVariable Integer id){
        if (!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not Found");
        }
        repository.deleteContent(contentBody);
    }


}
