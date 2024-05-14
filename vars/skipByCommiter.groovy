def call() {
    def lastCommitterEmail = sh (
        script: "git log --format=\"%ae\" | head -1",
        returnStdout: true
    )
    return lastCommitterEmail.trim() != this.env.GIT_AUTHOR_EMAIL;
} 