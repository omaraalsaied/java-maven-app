pipeline {
    agent any 

    tools {
        maven 'maven-3.6'
    }

    stages {
        stage("build jar") {
            steps { 
                script {
                    echo "building the jar file .. "
                    sh "mvn package"
                }
            }
        }

        stage("Dockerizing") {
            steps { 
                script {
                    echo "building docker image .. "
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PWD', usernameVariable: 'USER')]) {
                        sh 'docker build -t omaraalsaied/java-maven-app:1.2 -f Dockerfile'
                        sh "echo $PWD | docker login -u $USER --password-stdin" 
                        sh 'docker push omaraalsaied/java-maven-app:1.2'
                    }
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "deploying the application"
                }
            }
            
        }
    }
}
