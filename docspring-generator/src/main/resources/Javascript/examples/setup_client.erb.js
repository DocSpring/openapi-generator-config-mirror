var config = new DocSpring.Configuration()
config.apiTokenId = '<%= @api_token_id %>'
config.apiTokenSecret = '<%= @api_token_secret %>'
docspring = new DocSpring.Client(config)
