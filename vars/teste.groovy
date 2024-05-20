def call() {
    Run.fromExternalizableId(currentBuild.externalizableId).delete()
}