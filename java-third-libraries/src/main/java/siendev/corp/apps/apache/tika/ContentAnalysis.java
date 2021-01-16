package siendev.corp.apps.apache.tika;

import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Iurii Golubnichenko
 *
 * Just simple example how we can work with Apache Tika.
 */
public class ContentAnalysis {

    public static String getDocumentType(InputStream inputStream) throws IOException {
        Tika tika = new Tika();
        return tika.detect(inputStream);
    }

    public static Metadata getDocumentMetadata(InputStream inputStream) throws IOException {
        Tika tika = new Tika();
        Metadata metadata = new Metadata();

        tika.parse(inputStream, metadata);
        return metadata;
    }
}
