package com.tutorial.payload;

import com.tutorial.entity.Tutorial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorialResponse {
    private List<Tutorial> tutorials;
    private int currentPage;
    private int size;
    private long totalItems;
    private int totalPages;
    private boolean lastPage;
}
