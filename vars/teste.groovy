def call() {
    checkout scm
    result = sh (script: "git log -1 | grep '\\[release\\]'", returnStatus: true) 
    if (result == 0) {
        currentBuild.result = 'ABORTED'
        Run.fromExternalizableId(currentBuild.externalizableId).delete()
    }
}