package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Override
    public Item getById(long id) {
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        return false;
    }

    void setInitialSequence(int val) {
        //TODO
    }

    void setHolder() {
        //TODO
    }
}
