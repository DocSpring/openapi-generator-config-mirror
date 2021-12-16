# Find your API tokens here: https://app.docspring.com/api_tokens

require 'docspring'

ENV['DOCSPRING_TOKEN_ID'] = "YOUR_API_TOKEN_ID"
ENV['DOCSPRING_TOKEN_SECRET'] = "YOUR_API_TOKEN_SECRET"

<%= render :setup_client %>

<%= render @example_name %>
