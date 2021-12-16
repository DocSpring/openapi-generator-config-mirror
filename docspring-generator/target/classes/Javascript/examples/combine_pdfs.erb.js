var options = {
  test: false,
  source_pdfs: [
    { type: 'submission', id: 'sub_000000000000000001' },
    { type: 'template', id: 'tpl_000000000000000001' },
    { type: 'submission', id: 'sub_000000000000000002' },
  ],
  wait: <%= @options.fetch(:wait) %>,
}

docspring.combinePdfs(options, function (error, response) {
  if (error) throw error
<% if @options.fetch(:type) == :wrapper -%>
  var combined_submission = response.combined_submission
<% end -%>

<% if @template_type == :doc -%>
  console.log('Download your PDF at:', combined_submission.download_url)
<% else -%>
  expect(response.status).to.be('success')
  expect(combined_submission.id).to.match(/^com_/)

<%   if @options.fetch(:wait) -%>
  expect(combined_submission.state).to.be('processed')
  expect(combined_submission.download_url).to.not.be(null)
  expect(combined_submission.download_url).to.not.be('')
<%   else -%>
  expect(combined_submission.state).to.be('pending')
  expect(combined_submission.download_url).to.be(null)
<%   end -%>
  done()
<% end -%>
})
