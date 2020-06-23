package jackson.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jackson.model.Rectangle;
import jackson.model.RRectangle;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * Example taken from:
 * https://www.journaldev.com/2324/jackson-json-java-parser-api-example-tutorial
 */
public class RecordObjectMapperExample {

    public static void main(String[] args) throws IOException {
        // Deserialise
        byte[] jsonData = Files.readAllBytes(Paths.get("rectangle.txt"));
        var objectMapper = new ObjectMapper();
        RRectangle rr1 = objectMapper.readValue(jsonData, RRectangle.class);
        System.out.println("Record Rectangle Object\n" + rr1);

        // Serialise
        RRectangle rr2 = createRRectangle();
        // Configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        StringWriter s = new StringWriter();
        objectMapper.writeValue(s, rr2);
        System.out.println("Rectangle JSON is\n" + s);
    }

    public static RRectangle createRRectangle() {
        return new RRectangle(100, 200, 50, 50);
    }
}
