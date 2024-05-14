def call(String email) {
    echo "PASSED INTO LIB"
    def allCommitterDetails = sh (
        script: "git log --format=\"%ae\" | head -1",
        returnStdout: true
    )

    echo allCommitterDetails

    String teste = allCommitterDetails
    return teste == email;
} 