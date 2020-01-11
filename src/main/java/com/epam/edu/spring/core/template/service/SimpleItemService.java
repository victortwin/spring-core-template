package com.epam.edu.spring.core.template.service;

import com.epam.edu.spring.core.template.entity.Item;

public class SimpleItemService implements ItemService {
    @Override
    public Item getById(long id) {
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        return false;
    }
}
