// as an admin you can use this to get user's api token
// this is useful when you need to automate something using service user's api token
// run it from Jenkins script console which you can find here :: <YOUR JENKINS URL>/script

user = hudson.model.User.get('userId')
prop = user.getProperty(jenkins.security.ApiTokenProperty.class)
println(prop.getApiTokenInsecure())
