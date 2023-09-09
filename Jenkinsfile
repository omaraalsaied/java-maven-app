#!/usr/bin/env groovy
@library('jenkins-shared-library')
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
                  buildApp()
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