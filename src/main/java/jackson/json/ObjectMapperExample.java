package jackson.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jackson.model.Rectangle;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Example taken from:
 * https://www.journaldev.com/2324/jackson-json-java-parser-api-example-tutorial
 */
public class ObjectMapperExample {

    public static void main(String[] args) throws IOException {
        // Deserialise
        byte[] jsonData = Files.readAllBytes(Paths.get("rectangle.txt"));
        var objectMapper = new ObjectMapper();
        Rectangle r1 = objectMapper.readValue(jsonData, Rectangle.class);
        System.out.println("Rectangle Object\n" + r1);

        // Serialise
        Rectangle r2 = createRectangle();
        // Configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        StringWriter s = new StringWriter();
        objectMapper.writeValue(s, r2);
        System.out.println("Rectangle JSON is\n" + s);
    }

    public static Rectangle createRectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(100);
        rectangle.setWidth(200);
        rectangle.setX(50);
        rectangle.setY(50);
        return rectangle;
    }
}
