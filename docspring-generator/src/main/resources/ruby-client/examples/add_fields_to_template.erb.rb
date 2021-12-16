<% if @template_type == :doc -%>
client = DocSpring::Client.new
<% end -%>
template_id = 'tpl_000000000000000001'

response = client.add_fields_to_template(
  template_id,
  fields: [
    {
      name: 'new_field1',
      page: 1,
      required: false,
    },
    {
      name: 'new_field2',
      type: 'number',
      page: 1,
      required: false,
    },
    {
      name: 'new_field3',
      type: 'date',
      page: 1,
      required: false,
      x: 300,
    },
  ]
)
<% if @template_type == :doc -%>
puts response
# => {:new_field_ids=>[3, 4, 5], :status=>"success"}
<% else -%>
expect(response.status).to eq 'success'
expect(response.new_field_ids).to eq [3, 4, 5]
expect(response.new_field_ids[0].class).to eq Integer
<% end -%>
