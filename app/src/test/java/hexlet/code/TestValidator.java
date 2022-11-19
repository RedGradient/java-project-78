package hexlet.code;

import hexlet.code.Schemas.NumberSchema;
import hexlet.code.Schemas.StringSchema;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class TestValidator {
    @Test
    public void testString() {
        var validator = new Validator();
        var schema = validator.string();

        assertInstanceOf(StringSchema.class, schema);
    }

    @Test
    public void testNumber() {
        var validator = new Validator();
        var schema = validator.number();

        assertInstanceOf(NumberSchema.class, schema);
    }
}
