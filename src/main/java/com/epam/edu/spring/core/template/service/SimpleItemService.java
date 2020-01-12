package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.configuration.RepositoryConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.ItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Lazy
@Service
public class SimpleItemService implements ItemService {

    @Value("${item.repository.implementation}")
    private String itemRepositoryImplementation;

    private ItemRepository itemRepository;

    private ApplicationContext itemRepositoryContext =
            new AnnotationConfigApplicationContext(RepositoryConfiguration.class);


    public String getItemRepositoryImplementation() {
        return itemRepositoryImplementation;
    }

    public ApplicationContext getItemRepositoryContext() {
        return itemRepositoryContext;
    }

    @Override
    public Item getById(long id) {
        return itemRepository.getById(id);
    }

    @Override
    public boolean createItem(Item item) {
        return itemRepository.createItem(item);
    }

    @PostConstruct
    public void initializeItemRepository() {
        if (itemRepositoryImplementation.equals("linked")){
            itemRepository = itemRepositoryContext.getBean("linkedListItemRepository", LinkedListItemRepository.class);
        } else {
            itemRepository = itemRepositoryContext.getBean("arrayListItemRepository", ArrayListItemRepository.class);
        }
    }
}
