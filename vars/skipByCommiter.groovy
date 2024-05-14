def call(String email) {
    echo "PASSED INTO LIB"
    def allCommitterDetails = "git log --format=\"%ae\" | head -1".execute()

    echo allCommitterDetails.in.text
    echo allCommitterDetails.err.text

    String teste = allCommitterDetails
    return teste == email;
}