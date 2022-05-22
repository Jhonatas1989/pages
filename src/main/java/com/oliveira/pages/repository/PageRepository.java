package com.oliveira.pages.repository;

import com.oliveira.pages.model.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PageRepository extends MongoRepository<Page, String> {
}
