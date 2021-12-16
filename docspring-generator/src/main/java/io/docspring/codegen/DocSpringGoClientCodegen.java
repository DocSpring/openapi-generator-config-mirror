package com.docspring.codegen;

import org.openapitools.codegen.*;
import org.openapitools.codegen.languages.GoClientCodegen;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.examples.Example;

import java.io.File;

public class DocSpringGoClientCodegen extends GoClientCodegen {
    @Override
    public String getName() {
        return "docspring-go";
    }

    @Override
    public void postProcessParameter(CodegenParameter parameter) {
        super.postProcessParameter(parameter);
        if (parameter.isBodyParam)
            parameter.required = true;
    }
}
