package hope.com.controller;

import hope.com.service.ETLLoaderService;
import hope.com.service.ETLTransformerService;
import hope.com.service.ETLWritterService;
import org.springframework.ai.document.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ETLDocController {
    private final ETLLoaderService etlLoaderService;
    private final ETLTransformerService etlTransformerService;
    private final ETLWritterService etlWritterService;

    public ETLDocController(ETLLoaderService etlLoaderService, ETLTransformerService etlTransformerService, ETLWritterService etlWritterService) {
        this.etlLoaderService = etlLoaderService;
        this.etlTransformerService = etlTransformerService;
        this.etlWritterService = etlWritterService;
    }

    @GetMapping("/etl")
    public String etl(){
        List<Document> doc = etlLoaderService.loadTextasDocument();
        List<Document> doctoTransform = etlTransformerService.transformDocument(doc);
        etlWritterService.writeToFile(doctoTransform);
        return "Pipeline completed";
    }
}
