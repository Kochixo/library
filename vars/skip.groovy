def call() {
    def skiped_email = "kochixo10@gmail.com" 
    pipeline {
        agent any
        environment {
            GIT_AUTHOR_EMAIL = ""
        }
        stages {
            stage("get commit") {
                steps {
                    script {
                        env.GIT_AUTHOR_EMAIL = sh(script: 'git log --format="%ae" | head -1', returnStdout: true).trim()
                    }
                }
            }
            stage('Teste') {
                when {
                    expression {
                        env.GIT_AUTHOR_EMAIL != skiped_email
                    }
                }
            }
        }
    }
}