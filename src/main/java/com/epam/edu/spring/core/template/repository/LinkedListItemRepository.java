package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.annotation.InjectRandomInt;
import com.epam.edu.spring.core.template.entity.Item;

import java.util.LinkedList;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @InjectRandomInt(min = 0, max = 10)
    private int initialSequenceValue;

    public int getInitialSequenceValue() {
        return initialSequenceValue;
    }

    @Override
    public Item getById(long id) {
        if (!holder.isEmpty()) {
            for (Item item : holder) {
                if (item.getId() == id) {
                    return item;
                }
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        if (item != null) {
            if (!holder.isEmpty()) {
                for (Item alreadyExistingItem : holder) {
                    if (alreadyExistingItem.getId() == item.getId())
                        return false;
                }
            }
            //item.setId(getInitialSequenceValue());
            holder.add(item);
            return true;
        }
        return false;
    }

    void setInitialSequence(int val) {
        initialSequence = val;
    }

    void setHolder() {
        holder = new LinkedList<>();
        setInitialSequence(getInitialSequenceValue());
    }
}
