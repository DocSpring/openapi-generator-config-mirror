client = DocSpring::Client.new
template_id = 'tpl_000000000000000001'

<% if @template_type != :doc -%>
expect(client).to receive(:sleep).with(1).once
<% end -%>
response = client.generate_pdf(
  template_id: template_id,
  data: {
    title: 'Test PDF',
    description: 'This PDF is great!',
  },
  field_overrides: {
    title: {
      required: false
    }
  }
)
submission = response.submission

<% if @template_type == :doc -%>
puts "Download your PDF at: #{submission.download_url}"
<% else -%>
expect(response.status).to eq 'success'
expect(submission.id).to start_with 'sub_'
expect(submission.expired).to eq false
expect(submission.state).to eq 'processed'
expect(submission.pdf_hash).to eq 'TEST_SUBMISSION_SHA256_HASH'
expect(submission.download_url).to include 'submissions/submission.pdf'
<% end -%>
