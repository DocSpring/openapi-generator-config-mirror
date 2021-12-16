// Run: node getSubmission.js

var DocSpring = require('docspring')

var config = new DocSpring.Configuration()
config.apiTokenId = 'yRaaR9JmTPtGX7EN'
config.apiTokenSecret = 'IB3TRkSdm4f2BdtU_D3YgxjdMB7l-r2fOgvxD1Yzwec'
// config.basePath = 'http://app.docspring.local:3000/api/v1'
client = new DocSpring.Client(config)

client.getSubmission('sub_ADPq6GNqNqpAZG9Yzb', function (error, response) {
  if (error) throw error
  console.log(response)
})
