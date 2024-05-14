def call(String email) {
    echo "PASSED INTO LIB"
    def allCommitterDetails = "git log --format=\"%ae\" | head -1".execute().text

    echo allCommitterDetails
    echo allCommitterDetails.Trim()

    String teste = allCommitterDetails
    return teste == email;
}