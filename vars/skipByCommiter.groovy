import hudson.model.AbstractProject
import hudson.tasks.Mailer
import hudson.model.User

def call() {
    def lastCommitterEmail = sh (
        script: "git log --format=\"%ae\" | head -1",
        returnStdout: true
    )
    def item = hudson.model.Hudson.instance.getItem("teste") 
    def build = item.getLastBuild()
    def cause = build.getCause(hudson.model.Cause.UserIdCause.class)
    def id = cause.getUserId()
    User u = User.get(id)
    def umail = u.getProperty(Mailer.UserProperty.class)
    echo umail.getAddress()
    return lastCommitterEmail == umail.getAddress();
} 