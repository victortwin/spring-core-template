package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.annotation.InjectRandomInt;
import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.LinkedList;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
@Repository
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @InjectRandomInt(min = 1, max = 100)
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

    @PostConstruct
    void setHolder() {
        holder = new LinkedList<>();
        setInitialSequence(getInitialSequenceValue());
    }
}
