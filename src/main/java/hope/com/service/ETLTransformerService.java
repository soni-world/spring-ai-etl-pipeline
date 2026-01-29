package hope.com.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.document.Document;
import org.springframework.ai.model.transformer.KeywordMetadataEnricher;
import org.springframework.ai.model.transformer.SummaryMetadataEnricher;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ETLTransformerService {

    @Autowired
    ChatModel chatModel;

    public List<Document> transformDocument(List<Document> docs){
        TextSplitter textSplitter = new TokenTextSplitter();
        List<Document> splitDoc = textSplitter.split(docs);
        // KeywordMetadataEnricher enricher = new KeywordMetadataEnricher(chatModel, 4);
        SummaryMetadataEnricher enricher =  new SummaryMetadataEnricher(chatModel, List.of(SummaryMetadataEnricher.SummaryType.CURRENT));
        return enricher.apply(splitDoc);
    }
}
