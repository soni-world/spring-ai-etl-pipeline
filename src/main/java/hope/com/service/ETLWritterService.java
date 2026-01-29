package hope.com.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.document.MetadataMode;
import org.springframework.ai.writer.FileDocumentWriter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ETLWritterService {

    public void writeToFile(List<Document> docs){
        FileDocumentWriter writer = new FileDocumentWriter("output.txt", false,
                MetadataMode.ALL, false);
        writer.accept(docs);
    }
}
