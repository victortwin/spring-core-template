package com.epam.edu.spring.core.template.initializer;

import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.springframework.stereotype.Component;

@Component
public class TestDataInitializer {
    public void createItems(SimpleItemService simpleItemService) {
        simpleItemService.createItem(new Item(1, "Ice axe", 500.0, "Yellow"));
        simpleItemService.createItem(new Item(2, "Harness", 2500.0, "Red"));
        simpleItemService.createItem(new Item(3, "Helmet", 600.0, "Blue"));
        simpleItemService.createItem(new Item(4, "Gloves", 1500.0, "Black"));

    }
}
