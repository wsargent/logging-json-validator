package com.example.logging;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;

import java.io.IOException;

public class App
{
    private static final Validator validator = new Validator();

    public static void main( String[] args )
    {
        try {
            final JsonNode good = JsonLoader.fromResource("/example1.json");
            ProcessingReport report = validator.validate(good);
            System.out.println(report);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ProcessingException e) {
            e.printStackTrace();
        }
    }
}
