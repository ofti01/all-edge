package com.lotfi.compte.utils;



import org.apache.commons.math3.random.RandomDataGenerator;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.UUIDGenerator;

import java.io.Serializable;

public class BaseIdentifierGenerator extends UUIDGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        final String prefix = "01206";
        final String start = "018";
        String noumrou = "";
        for (int i=0; i<12;i++) noumrou+= ""+ new RandomDataGenerator().nextLong(0,9);

        return prefix+noumrou+start;

    }
}
