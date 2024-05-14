import hudson.model.AbstractProject
import hudson.tasks.Mailer
import hudson.model.User
import jenkins.model.Jenkins


def call() {
    def lastCommitterEmail = sh (
        script: "git log --format=\"%ae\" | head -1",
        returnStdout: true
    )
    def envVars = Jenkins.instance.getGlobalNodeProperties()[0].getEnvVars() 
    echo envVars['GIT_AUTHOR_EMAIL']
    return lastCommitterEmail.trim() != umail.getAddress().trim();
} 