import hudson.model.AbstractProject
import hudson.tasks.Mailer
import hudson.model.User

def call() {
    def lastCommitterEmail = sh (
        script: "git log --format=\"%ae\" | head -1",
        returnStdout: true
    )
    buildCause = currentBuild.getBuildCauses('hudson.model.Cause$UserIdCause')
    id = buildCause[0].userId
    echo "id: ${id}"
    User u = User.get(id)
    echo "u: ${u}"
    umail = u.getProperty(Mailer.UserProperty.class)
    echo "umail: ${umail}"
    email = umail.getAddress()
    echo "email: ${email}"
    return lastCommitterEmail.trim() != email.trim();
} 