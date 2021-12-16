package com.docspring.codegen;

import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.JavaClientCodegen;

public class DocSpringJavaClientCodegen extends JavaClientCodegen {
    @Override
    public String getName() {
        return "docspring-java";
    }

    @Override
    public void postProcessParameter(CodegenParameter parameter) {
        super.postProcessParameter(parameter);
        if (parameter.isBodyParam)
            parameter.required = true;
    }

    @Override
    public void processOpts() {
        super.processOpts();
        supportingFiles.add(new SupportingFile("PdfApiIntegrationTest.java",
                "src/test/java/com/docspring/PdfApiIntegrationTest.java"));
    }
}
