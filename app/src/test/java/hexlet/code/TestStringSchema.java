package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestStringSchema {
    @Test
    public void testContains() {
        var schema1 = new StringSchema();
        schema1.contains("good").contains("all things aim");

        var text1 = "Every art and every inquiry, "
                + "and similarly every action and pursuit, "
                + "is thought to aim at some good; "
                + "and for this reason the good has rightly been declared to be that at which all things aim.";

        assertTrue(schema1.isValid(text1));

        var schema2 = new StringSchema();
        var text2 = "hello world";
        schema2.contains("goodbye");
        assertFalse(schema2.isValid(text2));

        // special cases
        var schema3 = new StringSchema();
        assertTrue(schema3.isValid(""));
        assertTrue(schema3.isValid(null));
    }

    @Test
    public void testRequired() {
        var schema1 = new StringSchema();
        schema1.required();
        assertFalse(schema1.isValid(""));
        assertFalse(schema1.isValid(null));
    }

    @Test
    public void testMinLength() {
        var schema1 = new StringSchema();
        schema1.minLength(15);

        var text1 = "here more than 15 symbols";
        assertTrue(schema1.isValid(text1));

        var text2 = "less than 15";
        assertFalse(schema1.isValid(text2));
    }
}