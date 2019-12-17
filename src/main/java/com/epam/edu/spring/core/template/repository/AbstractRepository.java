package com.epam.edu.spring.core.template.repository;

import java.util.List;

/**
 * Абстрактный класс для хранения сущностей.
 * ID сущности генерируется, исходя из initialSequence
 * @param <T>
 */
public abstract class AbstractRepository<T> {

    protected long initialSequence = 0;

    protected List<T> holder;

    abstract void setInitialSequence(int val);

    abstract void setHolder();

}
