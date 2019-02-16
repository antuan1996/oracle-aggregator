package io.university.storage.impl;

import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.02.2019
 */
abstract class BasicStorageUtils<T, ID> {

    boolean isIdValid(ID id) {
        return !isIdNotValid(id);
    }
    boolean isIdNotValid(ID id) {
        return (id == null);
    }

    boolean isValid(T t) {
        return !isNotValid(t);
    }
    boolean isNotValid(T t) {
        return (t == null);
    }

    boolean isValid(List<T> ts) {
        return !isNotValid(ts);
    }
    boolean isNotValid(List<T> ts) {
        return (ts == null || ts.isEmpty());
    }
}
