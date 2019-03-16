package io.university.controller.common.aggregator;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.university.model.dao.common.CPerson;
import io.university.service.factory.impl.CPeopleFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

/**
 * ! NO DESCRIPTION !
 *
 * @author GoodforGod
 * @since 16.03.2019
 */
abstract class BasicDatabaseController {

    private final Logger logger = LoggerFactory.getLogger(BasicDatabaseController.class);

    private final CPeopleFactory factory;
    private final ObjectMapper mapper = new ObjectMapper();
    private final TypeReference<List<CPerson>> reference = new TypeReference<List<CPerson>>() {
    };

    BasicDatabaseController(CPeopleFactory factory) {
        this.factory = factory;
    }

    /**
     * Filters CPerson entities parts to emulate only data for
     * Specific database only
     */
    abstract List<CPerson> filterOtherDatabases(final List<CPerson> list);

    /**
     * Emulate json serialisation and deserialization
     */
    List<CPerson> generateAsJson(final int n) {
        try {
            final List<CPerson> people = generateCorrect(2);
            final List<CPerson> filtered = filterOtherDatabases(people);
            final String json = mapper.writeValueAsString(filtered);
            return mapper.readValue(json, reference);
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return Collections.emptyList();
        }
    }

    /**
     * Generates people with correct links between objects
     */
    List<CPerson> generateCorrect(final int n) {
        final List<CPerson> people = factory.build(n);
        return filterOtherDatabases(people);
    }
}
