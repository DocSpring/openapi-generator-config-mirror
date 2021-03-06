# OpenAPI Generator for the DocSpringRubyClient library

## Overview

This is a boiler-plate project to generate your own project derived from an OpenAPI specification.
Its goal is to get you started with the basic plumbing so you can put in your own logic.
It won't work without your changes applied.

## What's OpenAPI

The goal of OpenAPI is to define a standard, language-agnostic interface to REST APIs which allows both humans and computers to discover and understand the capabilities of the service without access to source code, documentation, or through network traffic inspection.
When properly described with OpenAPI, a consumer can understand and interact with the remote service with a minimal amount of implementation logic.
Similar to what interfaces have done for lower-level programming, OpenAPI removes the guesswork in calling the service.

Check out [OpenAPI-Spec](https://github.com/OAI/OpenAPI-Specification) for additional information about the OpenAPI project, including additional libraries with support for other languages and more.

## How do I use this?

At this point, you've likely generated a client setup. It will include something along these lines:

```
.
|- README.md    // this file
|- pom.xml      // build script
|-- src
|--- main
|---- java
|----- com.docspring.codegen.DocSpringRubyClientGenerator.java // generator file
|---- resources
|----- DocSpringRubyClient // template files
|----- META-INF
|------ services
|------- org.openapitools.codegen.CodegenConfig
```

You _will_ need to make changes in at least the following:

`DocSpringRubyClientGenerator.java`

Templates in this folder:

`src/main/resources/DocSpringRubyClient`

Once modified, you can run this:

```
mvn package
```

In your generator project. A single jar file will be produced in `target`. You can now use that with [OpenAPI Generator](https://openapi-generator.tech):

For mac/linux:

```
java -cp /path/to/openapi-generator-cli.jar:/path/to/your.jar org.openapitools.codegen.OpenAPIGenerator generate -g DocSpringRubyClient -i /path/to/openapi.yaml -o ./test
```

(Do not forget to replace the values `/path/to/openapi-generator-cli.jar`, `/path/to/your.jar` and `/path/to/openapi.yaml` in the previous command)

For Windows users, you will need to use `;` instead of `:` in the classpath, e.g.

```
java -cp /path/to/openapi-generator-cli.jar;/path/to/your.jar org.openapitools.codegen.OpenAPIGenerator generate -g DocSpringRubyClient -i /path/to/openapi.yaml -o ./test
```

Now your templates are available to the client generator and you can write output values

## But how do I modify this?

The `DocSpringRubyClientGenerator.java` has comments in it--lots of comments. There is no good substitute
for reading the code more, though. See how the `DocSpringRubyClientGenerator` implements `CodegenConfig`.
That class has the signature of all values that can be overridden.

For the templates themselves, you have a number of values available to you for generation.
You can execute the `java` command from above while passing different debug flags to show
the object you have available during client generation:

```
# The following additional debug options are available for all codegen targets:
# -DdebugOpenAPI prints the OpenAPI Specification as interpreted by the codegen
# -DdebugModels prints models passed to the template engine
# -DdebugOperations prints operations passed to the template engine
# -DdebugSupportingFiles prints additional data passed to the template engine

java -DdebugOperations -cp /path/to/openapi-generator-cli.jar:/path/to/your.jar org.openapitools.codegen.OpenAPIGenerator generate -g DocSpringRubyClient -i /path/to/openapi.yaml -o ./test
```

Will, for example, output the debug info for operations.
You can use this info in the `api.mustache` file.
