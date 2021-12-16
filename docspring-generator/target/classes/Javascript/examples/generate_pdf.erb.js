var template_id = 'tpl_000000000000000001'
var submission_data = {
  editable: false,
  data: {
    title: 'Test PDF',
    description: 'This PDF is great!',
  },
  metadata: {
    user_id: 123,
  },
  field_overrides: {
    title: {
      required: false,
    },
  },
  wait: <%= @options.fetch(:wait) %>,
}
docspring.generatePDF(template_id, submission_data, function (
  error,
  response
) {
  if (error) {
    console.log(response, error)
    throw error
  }
<% if @options.fetch(:type) == :wrapper -%>
  var submission = response.submission
<% end -%>
<% if @template_type == :doc -%>
  console.log('Download your PDF at:', submission.download_url)
<% else -%>
  expect(response.status).to.be('success')
  expect(submission.id).to.match(/^sub_/)
  expect(submission.expired).to.be(false)
  expect(submission.editable).to.be(false)
<%   if @options.fetch(:wait) -%>
  expect(submission.state).to.be('processed')
  expect(submission.download_url).to.not.be(null)
  expect(submission.download_url).to.not.be('')
<%   else -%>
  expect(submission.state).to.be('pending')
<%   end -%>
  done()
<% end -%>
})
