#!/usr/bin/env ruby
# frozen_string_literal: true

#
# This example demonstrates merging multiple generated PDFs into a single PDF.
#
# This example is just a demonstration, and cannot be run from the command line.

Dir.chdir File.join(File.dirname(__FILE__), '../../clients/ruby')
require 'bundler/setup'
Bundler.require

begin
  DocSpring.configure do |c|
    c.username  = ENV['DOCSPRING_TOKEN_ID']
    c.password  = ENV['DOCSPRING_TOKEN_SECRET']
  end

  docspring = DocSpring::Client.new

  response = docspring.combine_submissions(
    submission_ids: %w[SUBMISSION_1_ID SUBMISSION_2_ID],
    metadata: {
      user_id: 123,
    }
  )

  puts "Download your combined PDF at: #{response.combined_submission.download_url}"
rescue DocSpring::ApiError => e
  puts "#{e.class}: #{e.message}"
  puts e.code          # HTTP response code
  puts e.response_body # HTTP response body
  puts e.backtrace[0..3].join("\n")
end
