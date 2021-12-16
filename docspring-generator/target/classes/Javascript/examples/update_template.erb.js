var template_id = 'tpl_000000000000000001'
var template_data = {
  template: {
    name: 'New Template Name',
    html: '<html><body>New HTML</html></body>',
  },
}
docspring.updateTemplate(template_id, template_data, function (
  error,
  response
) {
  if (error) throw error
<% if @template_type == :doc -%>
  console.log(response)
<% else -%>
  expect(response.status).to.be('success')
  done()
<% end -%>
})
