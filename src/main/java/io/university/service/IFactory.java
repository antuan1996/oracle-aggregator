package io.university.service;

import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 01.03.2019
 */
public interface IFactory<T> {
    T build();

    List<T> build(int n);
}
