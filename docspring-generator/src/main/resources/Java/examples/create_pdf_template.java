/*
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
 */

File templateDocumentFile = new File("<%= @template_type == :test ? '../../test_fixtures/first_last_signature.pdf' : './form.pdf' %>");
RequestBody templateDocumentRequestBody = RequestBody.create(
    MediaType.parse("application/pdf"),
    templateDocumentFile
);
MultipartBody.Part templateDocumentPart = MultipartBody.Part.createFormData(
    "PDF",
    templateDocumentFile.getName(),
    templateDocumentRequestBody
);
String templateName = "New Uploaded Template";
String templateParentFolderId = null;

retrofit2.Response<PendingTemplate> retrofitResponse = api.createPDFTemplate(
  templateDocumentPart,
  templateName,
  templateParentFolderId
).execute();
if (!retrofitResponse.isSuccessful()) {
  logger.info(retrofitResponse.errorBody().string());
}
PendingTemplate template = retrofitResponse.body();

<% if @template_type == :doc -%>
  System.out.printf("Uploaded template! ID: %s", template.getId());
<% else -%>
assertThat(template.getId(), startsWith("tpl_"));
assertEquals(template.getName(), "New Uploaded Template");
<% end -%>
