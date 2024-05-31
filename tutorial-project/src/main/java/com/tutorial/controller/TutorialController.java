package com.tutorial.controller;

import com.tutorial.entity.Tutorial;
import com.tutorial.payload.ApiResponse;
import com.tutorial.payload.TutorialConstants;
import com.tutorial.payload.TutorialResponse;
import com.tutorial.service.TutorialService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TutorialController {
    @Autowired
    private TutorialService tutorialService;
    
    @PostMapping("/api/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
        return new ResponseEntity<>(tutorialService.createTutorial(tutorial), HttpStatus.CREATED);
    }
    
    @GetMapping("/api/tutorials")
    public ResponseEntity<TutorialResponse> getAllTutorials(
        @RequestParam(value = "page",defaultValue = TutorialConstants.PAGE_NUMBER, required = false) Integer pageNumber,
        @RequestParam(value = "size",defaultValue = TutorialConstants.PAGE_SIZE,required = false) Integer pageSize,
        @RequestParam(value = "sortBy",defaultValue = TutorialConstants.SORT_BY,required = false) String sortBy,
        @RequestParam(value = "sortDir",defaultValue = TutorialConstants.SORT_DIR,required = false) String sortDir
    ) {
        return new ResponseEntity<>(tutorialService.getAllTutorials(pageNumber,pageSize,sortBy,sortDir), HttpStatus.OK);
    }
    
    @GetMapping("/api/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable Integer id) {
        return new ResponseEntity<>(tutorialService.getTutorialById(id), HttpStatus.OK);
    }
    
    @GetMapping("/api/tutorials/")
    public ResponseEntity<List<Tutorial>> getTutorialByTitle(@RequestParam(value = "data") String data) {
        return new ResponseEntity<>(tutorialService.getTutorialByTitleLike(data), HttpStatus.OK);
    }
    @DeleteMapping("/api/tutorials/{id}")
    public ResponseEntity<ApiResponse> deleteTutorialById(@PathVariable Integer id) {
        return new ResponseEntity<>(tutorialService.deleteTutorial(id), HttpStatus.OK);
    }
    
    @PutMapping("/api/tutorials")
    public ResponseEntity<Tutorial> updateTutorial(@RequestBody Tutorial tutorial) {
        return new ResponseEntity<>(tutorialService.updateTutorial(tutorial), HttpStatus.OK);
    }
}
