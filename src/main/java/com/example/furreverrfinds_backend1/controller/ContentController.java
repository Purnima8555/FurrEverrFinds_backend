package com.example.furreverrfinds_backend1.controller;


import com.example.furreverrfinds_backend1.dto.ContentDto;
import com.example.furreverrfinds_backend1.entity.Content;
import com.example.furreverrfinds_backend1.helper.ApiResponse;
import com.example.furreverrfinds_backend1.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/content")
@RequiredArgsConstructor
public class ContentController {
    private final ContentService contentService;
    private final ApiResponse apiResponse;


    @GetMapping
    public ResponseEntity<Map<String ,Object>> get(){
        return apiResponse.successResponse("Data fetch successfully",true,null,contentService.findAll());
    }

    @GetMapping("/byCategory/{category}")
    public List<Content> searchByCategory(@PathVariable("category") String category) {
        return this.contentService.searchByCategory(category);
    }

    @PostMapping("/save")
    public String createData(@RequestBody ContentDto contentDto){
        contentService.save(contentDto);
        return "created data";
    }

    @GetMapping("/{id}")
    public Optional<Content> findById(@PathVariable("id") Long id) {
        return contentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        contentService.deleteById(id);
        return "Data deleted successfully";
    }

    @GetMapping("/count")
    public long getTotalCount() {
        return contentService.getTotalCount();
    }

}
