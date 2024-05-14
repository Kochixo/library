def call(String email) {
    echo "PASSED INTO LIB"
    String teste = allCommitterDetails.Trim()
    return teste == email;
    }

def allCommitterDetails = bat ( 
 script: 'git log --format="%ae" | head -1',
 returnStdout: true
)