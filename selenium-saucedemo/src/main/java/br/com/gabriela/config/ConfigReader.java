package br.com.gabriela.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        InputStream input = ConfigReader.class.getClassLoader()
                .getResourceAsStream("config/config.properties");

        if (input == null) {
            throw new RuntimeException("Arquivo config.properties não encontrado.");
        }

        try {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Não foi possível carregar o arquivo config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
