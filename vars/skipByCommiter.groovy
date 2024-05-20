def call() {
    def causes = currentBuild.getBuildCauses()

    def isUser = causes[0].containsKey('userId') ? true : false
    
    def isNotJenkinsCommiter = sh (
        script: "git log --format=\"%ae\" | head -1",
        returnStdout: true
    ) != this.env.GIT_AUTHOR_EMAIL ? true : false

    if (isUser || isNotJenkinsCommiter) {
        return true 
    } else {
        Run.fromExternalizableId(currentBuild.externalizableId).delete()
        return false
    }
} 