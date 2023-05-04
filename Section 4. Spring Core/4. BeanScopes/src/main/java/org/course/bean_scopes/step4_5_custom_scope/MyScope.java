package org.course.bean_scopes.step4_5_custom_scope;

import java.security.KeyPair;
import java.time.LocalTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.cglib.core.Local;

public class MyScope implements Scope {

    private Map<String, Map.Entry<LocalTime, Object>> beans = new ConcurrentHashMap<>();
    private Map<String, Object> destroyCallbacks = new ConcurrentHashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {

        beans.computeIfAbsent(name, k -> new ConcurrentHashMap.SimpleEntry<>(LocalTime.now(), objectFactory.getObject()));

        return beans.computeIfPresent(name, (k, v) -> {
            LocalTime time = v.getKey();
            if (time.isBefore(LocalTime.now().minusSeconds(5))) {
                return new ConcurrentHashMap.SimpleEntry<>(LocalTime.now(), objectFactory.getObject());
            }

            return v;
        }).getValue();
    }

    @Override
    public Object remove(String name) {
        destroyCallbacks.remove(name);
        return beans.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        destroyCallbacks.put(name, callback);
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "myScope";
    }
}