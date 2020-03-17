package task.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.report.ProcessingReport;
import com.github.fge.jsonschema.util.JsonLoader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Validators {
    public static boolean isJsonValid(String json, String schemaJson) {
        try {
            JsonNode schemaNode = JsonLoader.fromReader(new FileReader(new File(schemaJson)));
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema jsonSchema = factory.getJsonSchema(schemaNode);
            JsonNode jsonNode = JsonLoader.fromReader(new FileReader(new File(json)));
            ProcessingReport report = jsonSchema.validate(jsonNode);
            return report.isSuccess();
        } catch (IOException | ProcessingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
