def teste() {
    def skiped_email = "jenkins" 

pipeline {
    agent any
    environment {
        GIT_AUTHOR_EMAIL = ""
    }
    stages {
        stage("get commit") {
            steps {
                script {
                    GIT_AUTHOR_EMAIL = sh(script: 'git log --format="%ae" | head -1', returnStdout: true).trim()
                }
            }
        }
        stage('Teste') {
            when {
                expression {
                    GIT_AUTHOR_EMAIL != skiped_email
                }
            }
        }
    }
}
}