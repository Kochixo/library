import hudson.model.AbstractProject
import hudson.tasks.Mailer
import hudson.model.User
import jenkins.model.Jenkins


def call() {
    def lastCommitterEmail = sh (
        script: "git log --format=\"%ae\" | head -1",
        returnStdout: true
    )
    def env = System.getenv()
    env.each{
    println it
    } 
    return lastCommitterEmail.trim() != umail.getAddress().trim();
} 