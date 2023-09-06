pipeline {

    agent any

    stages {

        stage("build") {
            when {
                expression { BRANCH_NAME == 'master' }
            }
            steps {
                echo 'building the application'
            }
        }

        stage("test") {

            steps {
                echo 'testing the application'
                
            }
        }

        stage("deploy") {
            when {
                    expression { BRANCH_NAME == 'master' }
                }
            steps {
                echo 'deploying the application'

            }
        }
    }
}