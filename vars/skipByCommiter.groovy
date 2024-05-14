def call() {
    BUILD_TRIGGER_BY = currentBuild.getBuildCauses()[0].userId
    echo "BUILD_TRIGGER_BY: ${BUILD_TRIGGER_BY}"
    def lastCommitterEmail = sh (
        script: "git log --format=\"%ae\" | head -1",
        returnStdout: true
    )
    return lastCommitterEmail == email;
} 