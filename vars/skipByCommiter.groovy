import hudson.model.AbstractProject
import hudson.tasks.Mailer
import hudson.model.User
import jenkins.model.Jenkins


def call() {
    def lastCommitterEmail = sh (
        script: "git log --format=\"%ae\" | head -1",
        returnStdout: true
    )
    println(this.env.GIT_AUTHOR_EMAIL)
    println(env.GIT_AUTHOR_EMAIL)
    return lastCommitterEmail.trim() != umail.getAddress().trim();
} 