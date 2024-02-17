package com.example.furreverrfinds_backend1.service.impl;

import com.example.furreverrfinds_backend1.dto.ContentDto;
import com.example.furreverrfinds_backend1.entity.Content;
import com.example.furreverrfinds_backend1.repository.ContentRepo;
import com.example.furreverrfinds_backend1.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {

    private final ContentRepo contentRepo;

    @Override
    public List<Content> findAll() {
        return contentRepo.findAll();
    }

    @Override
    public List<Content> searchByCategory(String category) {
        return contentRepo.searchByCategory(category);
    }

    @Override
    public Optional<Content> findById(Long id) {
        return contentRepo.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        contentRepo.deleteById(id);
    }

    @Override
    public long getTotalCount() {
        return contentRepo.count();
    }

    @Override
    public void save(ContentDto contentDto) {
        Content content;

        if (contentDto.getId() != null) {
            content = contentRepo.findById(contentDto.getId()).get();
        } else {
            content = new Content();
        }

        content.setItemTitle(contentDto.getItemTitle());
        content.setItemPhoto(contentDto.getItemPhoto());
        content.setItemPrice(contentDto.getItemPrice());
        content.setCategoryType(contentDto.getCategoryType());
        content.setSubcategoryType(contentDto.getSubcategoryType());
        content.setItemDescription(contentDto.getItemDescription());


        content = contentRepo.save(content);


    }
}
