package io.university.service.impl;

import io.dummymaker.factory.impl.GenProduceFactory;
import io.university.model.dao.common.CPerson;
import io.university.service.IFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 05.03.2019
 */
@Component
public class CPeopleFactory implements IFactory<CPerson> {

    private final GenProduceFactory factory = new GenProduceFactory();

    @Override
    public CPerson build() {
        return build(1).get(0);
    }

    @Override
    public List<CPerson> build(int n) {
        return Collections.emptyList();
    }
}
