var template_id = 'tpl_000000000000000001'
var newFieldData = {
  fields: [
    {
      name: 'new_field_1',
      page: 1,
      type: 'string',<% if @template_type == :test %>
      required: false,<% end %>
    },
    {
      name: 'new_field_2',
      page: 1,
      type: 'number',
      integer: true,<% if @template_type == :test %>
      required: false,<% end %>
    },
  ],
}
<%-# Prettier is being super annoying - the formatting needs to be different for test vs docs. -%>
docspring.addFieldsToTemplate(template_id, newFieldData, function (
  error,
  response
) {
  if (error) {
    console.log(response, error)
    throw error
  }
<% if @template_type == :doc -%>
  console.log(response)
<% else -%>
  expect(response.status).to.be('success')
  expect(response.new_field_ids).to.eql([3, 4])
  expect(response.errors).to.be(undefined)
  done()
<% end -%>
})
