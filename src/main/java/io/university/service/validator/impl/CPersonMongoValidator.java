package io.university.service.validator.impl;

import io.university.model.dao.common.CPerson;
import io.university.service.validator.IValidator;
import io.university.storage.impl.common.CCommunityStorage;
import io.university.storage.impl.common.CPersonStorage;
import io.university.storage.impl.common.CRoomStorage;
import io.university.storage.impl.common.CVisitStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 13.03.2019
 */
@Service
public class CPersonMongoValidator implements IValidator<CPerson> {

    @Autowired private CCommunityStorage communityStorage;
    @Autowired private CPersonStorage personStorage;
    @Autowired private CVisitStorage visitStorage;
    @Autowired private CRoomStorage roomStorage;

    @Override
    public List<CPerson> validate(List<CPerson> people) {
        if(CollectionUtils.isEmpty(people))
            return Collections.emptyList();

        return Collections.emptyList();
    }
}
