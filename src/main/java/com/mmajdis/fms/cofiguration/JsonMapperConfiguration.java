package com.mmajdis.fms.cofiguration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonMapperConfiguration implements FactoryBean<ObjectMapper> {

    /**
     * Json Mapper.
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }


    @Override
    public ObjectMapper getObject() throws Exception {
        return OBJECT_MAPPER;
    }

    @Override
    public Class<?> getObjectType() {
        return ObjectMapper.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
