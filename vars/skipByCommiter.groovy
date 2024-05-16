def call() {
    def lastCommitterEmail = sh (
        script: "git log --format=\"%ae\" | head -1",
        returnStdout: true
    )
    echo hudson.model.Run.getCause()
    return lastCommitterEmail.trim() != this.env.GIT_AUTHOR_EMAIL;
} 