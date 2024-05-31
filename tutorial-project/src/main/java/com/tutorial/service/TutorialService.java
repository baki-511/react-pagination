package com.tutorial.service;

import com.tutorial.entity.Tutorial;
import com.tutorial.payload.ApiResponse;
import com.tutorial.payload.TutorialResponse;

import java.util.List;

public interface TutorialService {
    public Tutorial createTutorial(Tutorial tutorial);
    
    public TutorialResponse getAllTutorials(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
    
    public Tutorial getTutorialById(Integer id);
    
    public ApiResponse deleteTutorial(Integer id);
    
    public Tutorial updateTutorial(Tutorial tutorial);
    
    public List<Tutorial> getTutorialByTitleLike(String title);
}
