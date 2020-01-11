package com.epam.edu.spring.core.template;

import com.epam.edu.spring.core.template.configuration.MainConfiguration;
import com.epam.edu.spring.core.template.configuration.RepositoryConfiguration;
import com.epam.edu.spring.core.template.repository.ArrayListItemRepository;
import com.epam.edu.spring.core.template.repository.LinkedListItemRepository;
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

	}

}
