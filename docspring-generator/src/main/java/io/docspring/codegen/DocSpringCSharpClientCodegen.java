package com.docspring.codegen;

import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.CSharpClientCodegen;

public class DocSpringCSharpClientCodegen extends CSharpClientCodegen {
    public DocSpringCSharpClientCodegen() {
        super();
        // Don't use docspring-sharp
        embeddedTemplateDir = templateDir = "csharp";
    }

    @Override
    public String getName() {
        return "docspring-csharp";
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
        supportingFiles.add(new SupportingFile("PDFApiIntegrationTests.cs",
                "src/DocSpring.Client.Test/Api/PDFApiIntegrationTests.cs"));

        supportingFiles.add(new SupportingFile("install_packages.sh.mustache", "", "install_packages.sh"));
    }
}
