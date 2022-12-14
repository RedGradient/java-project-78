package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema {
    private static final String SIZEOF = "SIZEOF";
    private static final String SHAPE = "SHAPE";

    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeof(int value) {
        Predicate<Object> predicate = object -> ((Map) object).size() == value;
        addRule(SIZEOF, predicate);
        return this;
    }

    public void shape(Map<String, BaseSchema> schemas) {
        Predicate<Object> predicate = object -> {
            var map = (Map) object;
            for (var pair : schemas.entrySet()) {
                var key = pair.getKey();
                var schema = pair.getValue();
                if (!schema.isValid(map.get(key))) {
                    return false;
                }
            }
            return true;
        };

        addRule(SHAPE, predicate);
    }
}
