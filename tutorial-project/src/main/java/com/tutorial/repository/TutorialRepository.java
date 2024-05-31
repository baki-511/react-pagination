package com.tutorial.repository;

import com.tutorial.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
    List<Tutorial> findByTitleLike(String title);
   
    List<Tutorial> findByTitleContaining(String title);
}
