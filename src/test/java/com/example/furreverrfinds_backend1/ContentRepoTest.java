package com.example.furreverrfinds_backend1;

import com.example.furreverrfinds_backend1.entity.Content;
import com.example.furreverrfinds_backend1.repository.ContentRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContentRepoTest {

    @Autowired
    private ContentRepo contentRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveItem() {
        Content content = new Content();
        content.setItemTitle("Test Item");
        content.setItemPrice("100");
        content.setCategoryType("Test Category");
        content.setSubcategoryType("Test Subcategory");
        content.setItemDescription("Test Description");

        content = contentRepo.save(content);

        Assertions.assertThat(content.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void searchByCategory() {
        List<Content> contentList = contentRepo.searchByCategory("Test Category");

        Assertions.assertThat(contentList).isNotNull();
        Assertions.assertThat(contentList.size()).isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void count() {
        long count = contentRepo.count();
        Assertions.assertThat(count).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void findById() {
        Optional<Content> optionalContent = contentRepo.findById(1L);
        Assertions.assertThat(optionalContent).isPresent();
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void updateContent() {
        Optional<Content> optionalContent = contentRepo.findById(1L);
        Assertions.assertThat(optionalContent).isPresent();

        Content content = optionalContent.get();
        content.setItemTitle("Updated Test Item");

        contentRepo.save(content);

        Content updatedContent = contentRepo.findById(1L).orElse(null);
        Assertions.assertThat(updatedContent).isNotNull();
        Assertions.assertThat(updatedContent.getItemTitle()).isEqualTo("Updated Test Item");
    }

    @Test
    @Order(6)
    public void deleteById() {
        contentRepo.deleteById(1L);

        Optional<Content> deletedContent = contentRepo.findById(1L);
        Assertions.assertThat(deletedContent).isEmpty();
    }
}
