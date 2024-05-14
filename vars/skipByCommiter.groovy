def call() {
    def lastCommitterEmail = sh (
        script: "git log --format=\"%ae\" | head -1",
        returnStdout: true
    )
    def email = hudson.model.User.current().getProperty(hudson.tasks.Mailer.UserProperty.class).getAddress();

    return lastCommitterEmail ==  email;
} 