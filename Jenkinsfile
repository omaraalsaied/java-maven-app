#!/usr/bin/env groovy
@Library('jenkins-shared-library') _
def gv

pipeline {
    agent any 

    tools {
        maven 'maven-3.6'
    }

    stages {

        stage("version incrementation") {
            steps {
                script {
                    echo "incrementing app version" 
                    sh 'mvn build-helper:parse-version versions:set -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} versions:commit'
                    def matcher = readFile('pom.xml') =~ ' <version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                }
            }
        }

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
                  dockerizingApp "omaraalsaied/java-maven-app:${IMAGE_NAME}"
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
