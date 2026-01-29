package hope.com.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.TextReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ETLLoaderService {

    @Value("classpath:input.txt")
    private Resource resource;

    public List<Document> loadTextasDocument() {
        TextReader txtReader = new TextReader(resource);
        List<Document> documents = txtReader.get();
        return documents;
    }
}
