String templateId = "tpl_000000000000000001";
SubmissionData submissionData = new SubmissionData();
Map<String, String> data = new HashMap<>();
data.put("title", "Test PDF");
data.put("description", "This PDF is great!");
submissionData.setData(data);

Map<String, Object> fieldOverrides = new HashMap<>();
Map<String, Boolean> requiredMap = new HashMap<>();
requiredMap.put("required", false);
fieldOverrides.put("title", requiredMap);
submissionData.setFieldOverrides(fieldOverrides);

retrofit2.Response<CreateSubmissionResponse> retrofitResponse = api.generatePDF(templateId, submissionData)
    .execute();
if (!retrofitResponse.isSuccessful()) {
  logger.info(retrofitResponse.errorBody().string());
}
CreateSubmissionResponse response = retrofitResponse.body();
Submission submission = response.getSubmission();

<% if @template_type == :doc -%>
  System.out.printf("Generated PDF. ID: %s, Download URL: %s", submission.getId(), submission.getDownloadUrl());
<% else %>
assertEquals(201, retrofitResponse.code());
assertEquals(CreateSubmissionResponse.StatusEnum.SUCCESS, response.getStatus());
assertThat(submission.getId(), startsWith("sub_"));
assertEquals(false, submission.getExpired());
assertEquals(Submission.StateEnum.PENDING, submission.getState());
<% end %>
