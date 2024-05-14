def call() {
    def lastCommitterEmail = sh (
        script: "git log --format=\"%ae\" | head -1",
        returnStdout: true
    )
    def user = hudson.model.User.current();
    email = user.getProperty(hudson.tasks.Mailer.UserProperty.class).getAddress();
    return lastCommitterEmail == email;
} 