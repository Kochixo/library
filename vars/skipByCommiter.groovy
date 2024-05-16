def call() {
    def causes = currentBuild.getBuildCauses()

    if causes.containsKey("userId"){
        return true
    } else {
        def lastCommitterEmail = sh (
            script: "git log --format=\"%ae\" | head -1",
            returnStdout: true
        )

        return lastCommitterEmail.trim() != this.env.GIT_AUTHOR_EMAIL;
    }
} 