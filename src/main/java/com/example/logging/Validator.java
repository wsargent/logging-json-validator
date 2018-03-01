package com.example.logging;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.IOException;

public class Validator {

    public ProcessingReport validate(JsonNode good) throws IOException, ProcessingException {
        final JsonNode fstabSchema = JsonLoader.fromResource("/logging-schema.json");

        final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        final JsonSchema schema = factory.getJsonSchema(fstabSchema);

        return schema.validate(good);
    }
}
