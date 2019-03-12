package io.university.service.impl;

import io.university.service.IFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 12.03.2019
 */
public abstract class BasicFactory<E> implements IFactory<E> {

    protected <T> T randomPick(List<T> list) {
        return (list.size() == 1) ? list.get(0) : list.get(ThreadLocalRandom.current().nextInt(0, list.size() - 1));
    }
}
