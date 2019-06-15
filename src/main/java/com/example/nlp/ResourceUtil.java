package com.example.nlp;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceUtil {

        private ResourceUtil() {
        }

        public static Path getResource(final String resourceName) {
            try {
                return Paths.get(Thread.currentThread().getContextClassLoader().getResource(resourceName).toURI());
            } catch (URISyntaxException e) {
                throw new RuntimeException("リソースファイルが取得できませんでした。ファイル名=" + resourceName);
            }
        }


}
