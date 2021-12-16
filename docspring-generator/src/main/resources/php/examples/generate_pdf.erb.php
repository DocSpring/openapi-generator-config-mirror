<?php
$template_id = 'tpl_000000000000000001'; // string |
$submission_data = new \DocSpring\Model\SubmissionData();
$submission_data->setData([
  "title" => 'Test PDF',
  "description" => 'This is a test PDF!',
]);
$submission_data->setTest(<%= @test_pdfs %>);
$submission_data->setFieldOverrides([
  "title" => [
    "required" => false
  ]
]);
<% if @options.fetch(:type) == :original -%>
$response = $docspring->generatePDF($template_id, $submission_data);
$submission = $response->getSubmission();
<% else -%>
$submission = $docspring->generatePDF($template_id, $submission_data);
<% end -%>

<% if @template_type == :doc -%>
echo "Download your PDF at: " . $submission->getDownloadUrl();
<% end -%>
