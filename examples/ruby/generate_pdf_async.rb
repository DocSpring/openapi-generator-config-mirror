#!/usr/bin/env ruby
# frozen_string_literal: true

#
# This example demonstrates generating a PDF from a preconfigured template,
# and NOT waiting for the PDF to be processed.
#
# You can run this example with: ./examples/ruby/generate_pdf_async.rb

Dir.chdir File.join(File.dirname(__FILE__), '../../clients/ruby')
require 'bundler/setup'
Bundler.require

# This is a real test API token and template on docspring.com
# -------------------------------------------------------------
API_TOKEN_ID = 'yRaaR9JmTPtGX7EN'
API_TOKEN_SECRET = 'IB3TRkSdm4f2BdtU_D3YgxjdMB7l-r2fOgvxD1Yzwec'
TEMPLATE_ID = '6zz3dYRYM67fxMXA'

begin
  DocSpring.configure do |c|
    c.username  = API_TOKEN_ID               # Your API Token ID
    c.password  = API_TOKEN_SECRET           # Your API Token Secret
    # c.debugging = true
  end

  docspring = DocSpring::Client.new

  puts 'Generating PDF, but not waiting for job to finish processing...'

  response = docspring.generate_pdf(
    template_id: TEMPLATE_ID,
    wait: false,
    data: {
      first_name: 'John',
      last_name: 'Smith',
      favorite_color: 'Blue',
    }
  )

  puts 'PDF job was submitted:'
  puts response

  submission = response.submission
  while submission.state == 'pending'
    sleep 1
    submission = docspring.get_submission(response.submission.id)
  end

  puts 'PDF finished processing:'
  puts submission
rescue DocSpring::ApiError => e
  puts "#{e.class}: #{e.message}"
  puts e.code          # HTTP response code
  puts e.response_body # HTTP response body
  puts e.backtrace[0..3].join("\n")
end
