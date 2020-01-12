package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.entity.Item;
import com.epam.edu.spring.core.template.factory.ColorFactory;
import com.epam.edu.spring.core.template.initializer.TestDataInitializer;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
import com.epam.edu.spring.core.template.service.SimpleItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringCoreTemplate {

	public static void main(String[] args) {

		ApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfiguration.class);
		ArrayListItemRepository arrayListItemRepository =
				context.getBean("arrayListItemRepository", ArrayListItemRepository.class);

		LinkedListItemRepository linkedListItemRepository =
				context.getBean("linkedListItemRepository", LinkedListItemRepository.class);

		System.out.println(arrayListItemRepository.getInitialSequenceValue());
		System.out.println(linkedListItemRepository.getInitialSequenceValue());

		SimpleItemService simpleItemService = context.getBean("simpleItemService", SimpleItemService.class);
		System.out.println(simpleItemService.getItemRepositoryImplementation());

		TestDataInitializer testDataInitializer =
				context.getBean("testDataInitializer", TestDataInitializer.class);

		testDataInitializer.createItems(simpleItemService);

		System.out.println(simpleItemService.getById(1).getColor());
		System.out.println(simpleItemService.getById(3).getName());
		System.out.println(simpleItemService.getById(2).getPrice());

		ColorFactory colorFactory = context.getBean("colorFactory", ColorFactory.class);

		System.out.println(colorFactory.getColorsList());

		simpleItemService.createItem(new Item(8, "Rope", 6000, "Green"));
		System.out.println(simpleItemService.getById(8).getName());
	

	}

}
