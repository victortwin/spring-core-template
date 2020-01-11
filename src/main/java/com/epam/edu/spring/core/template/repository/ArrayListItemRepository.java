package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Репозиторий, основанный на классе ArrayList.
 * initialSequence должен браться из application.properties
 */
@Repository
public class ArrayListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    @Value("${initial.sequence}")
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
        holder = new ArrayList<>();
        setInitialSequence(getInitialSequenceValue());
    }
}
