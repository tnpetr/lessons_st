package ru.st.less.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.st.less.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Contact count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();

    }

    private void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        save(contacts, new File(file));
    }

    private void save(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData().withFname(randomString(10))
                    .withLname(randomString(10))
                    .withMobile(String.valueOf(new  Random().nextInt()))
                    .withHomePhone(String.valueOf(new  Random().nextInt()))
                    .withWorkPhone(String.valueOf(new  Random().nextInt()))
                    .withEmail(randomString(10) + "@" + randomString(5) + "." + randomString(2))
                    .withEmail2(randomString(10) + "@" + randomString(5) + "." + randomString(2))
                    .withEmail3(randomString(10) + "@" + randomString(5) + "." + randomString(2))
                    .withAddress(randomString(20)));
        }
        return contacts;
    }

    public String randomString(int lengh) {
        int leftLimit = 97; //a
        int rightLimit = 122; //z
        Random random = new Random();
        String generatedRandomString = random.ints(leftLimit, rightLimit + 1)
                .limit(lengh)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedRandomString;
    }
}
