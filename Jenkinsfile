#!/usr/bin/env groovy
@Library('jenkins-shared-library') _
def gv

pipeline {
    agent any 

    tools {
        maven 'maven-3.6'
    }

    stages {

        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }


        stage("build jar") {
            steps {
                
                    script {
                    buildApp 'omaraalsaied/java-maven-app:1.3' 
                    }
                
            }
        }

        stage("Dockerizing") {
            steps { 
                script {
                    dockerizingApp()
                }
            }
        }
        
        stage('test') {
            steps {
                script { 
                    gv.testApp()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                   gv.deployApp()
                }
            }
            
        }
    }
}
