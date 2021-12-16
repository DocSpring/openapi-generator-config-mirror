ApiClient client = new ApiClient("api_token_basic", "<%= @api_token_id %>", "<%= @api_token_secret %>");
<% if @template_type == :test -%>
client.getAdapterBuilder().baseUrl("<%= @api_url %>");
<% end -%>
api = client.createService(PdfApi.class);
