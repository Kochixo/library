def call() {
    def lastCommitterEmail = sh (
        script: "git log --format=\"%ae\" | head -1",
        returnStdout: true
    )
    def cause = currentBuild.getBuildCauses()
    println cause
    return lastCommitterEmail.trim() != this.env.GIT_AUTHOR_EMAIL;
} 