def call(String email) {
    echo "PASSED INTO LIB"
    def allCommitterDetails = sh (
        script: "git log --format=\"%ae\" | head -1",
        Stdout: true
    )

    def pwd = "pwd".execute()

    echo pwd.in.text
    echo pwd.err.text

    echo allCommitterDetails

    String teste = allCommitterDetails
    return teste == email;
} 