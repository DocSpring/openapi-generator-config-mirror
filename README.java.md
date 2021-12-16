# docspring Java Native Client Library

This is a maven package for using the [DocSpring API](https://docspring.com/documentation) to convert [HTML to PDF and XLSX](https://docspring.com).

## Installation

To install the API client library to your local Maven repository, simply execute:

```bash
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```bash
mvn deploy
```

After the client libarary is installed/deployed, you can use it in your Maven project by adding the following to your _pom.xml_:

```xml
<dependency>
  <groupId>com.docspring</groupId>
  <artifactId>docspring</artifactId>
  <version>1.1.1</version>
</dependency>
```

## Usage

See [examples](examples/) for runnable examples with file output, error handling, etc.

```java
import java.io.*;
import java.net.*;
import com.docspring.*;

public class Sync {
  public static void main(String[] args) throws Exception {
    DocApi docspring = new DocApi();
    ApiClient client = docspring.getApiClient();
   client.setUsername("YOUR_API_KEY_HERE"); // this key works for test documents
    //client.setDebugging(true);

    Doc doc = new Doc();
    doc.setTest(true);                                                   // test documents are free but watermarked
    doc.setDocumentContent("<html><body>Hello World</body></html>");     // supply content directly
    // doc.setDocumentUrl("http://docspring.com/examples/invoice.html"); // or use a url
    doc.setDocumentType(Doc.DocumentTypeEnum.PDF);                       // PDF or XLS or XLSX
    doc.setName("docspring-java.pdf");                                   // help you find a document later
    doc.setJavascript(true);                                             // enable JavaScript processing
    // prince_options = new PrinceOptions();
    // doc.setPrinceOptions(prince_options);
    // prince_options.setMedia("screen");                                // use screen styles instead of print styles
    // prince_options.setBaseurl("http://hello.com")                     // pretend URL when using document_content
    docspring.createDoc(doc);
  }
}
```

Docs created like this are limited to 60 seconds to render, check out the [async example](examples/Async.java) which allows 10 minutes.

We have guides for doing some of the common things:

- [Headers and Footers](https://docspring.com/documentation/style#pdf-headers-footers) including page skipping
- [CSS Media Selector](https://docspring.com/documentation/api#api_basic_pdf) to make the page look exactly as it does in your browser
- Protect content with [HTTP authentication](https://docspring.com/documentation/api#api_http_user) or [proxies](https://docspring.com/documentation/api#api_http_proxy) so only docspring can access them

## More Help

docspring has a lot of more [styling](https://docspring.com/documentation/style) and [implementation options](https://docspring.com/documentation/api).

Stuck? We're experts at using docspring so please [email us](mailto:support@docspring.com) if you run into trouble.

## Development

The majority of the code in this repo is generated using swagger-codegen on [docspring.yaml](docspring.yaml). You can modify this file and regenerate the client using `script/generate_language java`.

## How to set up the release process:

Follow this guide: https://medium.com/@scottyab/how-to-publish-your-open-source-library-to-maven-central-5178d9579c5

## Release Process

If you haven't released before, please see the [release setup guide](RELEASE_SETUP.java.md).

1. Pull latest master
2. Merge feature branch(es) into master
3. `script/test`
4. Increment version in code:

- `swagger-config.json`
- `build.gradle`
- `pom.xml`
- `README.md`

5. Update [CHANGELOG.md](CHANGELOG.md)
6. Commit "Release vX.Y.Z"
7. Push to GitHub
8. Tag version: `git tag 'vX.Y.Z' && git push --tags`
9. `eval $(gpg-agent --daemon)`
10. `gpg --use-agent --armor --detach-sign` and press ^C after authenticating
11. `mvn clean deploy`
12. Verify package release at [Central](http://search.maven.org/#search%7Cgav%7C1%7Cg%3A%22com.docspring%22%20AND%20a%3A%22docspring%22) (takes anywhere from minutes to days)
13. Use the git tag and make a new release with `target/docspring-*` attached, https://github.com/docspring/docspring-java/tags
14. Refresh documentation on docspring.com

## Version Policy

This library follows [Semantic Versioning 2.0.0](http://semver.org).
