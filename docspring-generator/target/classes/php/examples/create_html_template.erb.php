<?php
$create_template_data = new \DocSpring\Model\CreateHtmlTemplateData([
  "template" => [
    "template_type" => "html",
    "name" => "Test HTML Template",
    "html" => "Test HTML",
    "scss" => "Test SCSS",
    "header_html" => "Test Header HTML",
    "footer_html" => "Test Header HTML",
  ]
]); // \DocSpring\Model\CreateHtmlTemplateData |
$response = $this->docspring->createHTMLTemplate($create_template_data);
<% if @template_type == :doc -%>
echo "Created new template with ID: " . $response->getId();
<% end -%>
