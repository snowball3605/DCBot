package com.onmi_tech.Util;

import com.onmi_tech.Main;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class LanguageManager {
    public static String get(String key) {
        try (InputStream in = Files.newInputStream(Paths.get("lang/" + Main.language + ".yml"))) {
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(in);
            if (data == null) {
            } else {
                return (String) data.get(key);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
