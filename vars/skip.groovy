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
                        echo env.GIT_AUTHOR_EMAIL
                        echo skiped_email
                    }
                }
            }
            stage('Teste') {
                when {
                    not{
                        expression {
                            env.GIT_AUTHOR_EMAIL != skiped_email
                        }
                    }
                }
                steps {
                    script{
                        currentBuild.result = "ABORTED"
                        error("Jenkins is the commiter")
                    }
                }
            }
        }
    }
}
