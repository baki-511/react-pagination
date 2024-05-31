package com.tutorial.service.impl;

import com.tutorial.entity.Tutorial;
import com.tutorial.exception.TutorialNotFoundException;
import com.tutorial.payload.ApiResponse;
import com.tutorial.payload.TutorialResponse;
import com.tutorial.repository.TutorialRepository;
import com.tutorial.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialServiceImpl implements TutorialService {
    @Autowired
    private TutorialRepository tutorialRepository;
    
    @Override
    public Tutorial createTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }
    
    @Override
    public TutorialResponse getAllTutorials(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.trim().equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        Page<Tutorial> page = tutorialRepository.findAll(pageRequest);
        List<Tutorial> tutorialList = page.getContent();
        
        TutorialResponse tutorialResponse = new TutorialResponse();
        tutorialResponse.setTutorials(tutorialList);
        tutorialResponse.setCurrentPage(page.getNumber());
        tutorialResponse.setSize(page.getSize());
        tutorialResponse.setTotalItems(page.getTotalElements());
        tutorialResponse.setTotalPages(page.getTotalPages());
        tutorialResponse.setLastPage(page.isLast());
        return tutorialResponse;
    }
    
    @Override
    public Tutorial getTutorialById(Integer id) {
        return tutorialRepository.findById(id)
                .orElseThrow(() -> new TutorialNotFoundException(id));
    }
    
    @Override
    public ApiResponse deleteTutorial(Integer id) {
        Tutorial tutorial = getTutorialById(id);
        tutorialRepository.delete(tutorial);
        return new ApiResponse("Tutorial Deleted Successfully!", true);
    }
    
    @Override
    public Tutorial updateTutorial(Tutorial tutorial) {
        getTutorialById(tutorial.getId());
        return tutorialRepository.save(tutorial);
    }
    
    @Override
    public List<Tutorial> getTutorialByTitleLike(String title) {
        return tutorialRepository.findByTitleContaining(title);
    }
    
}
