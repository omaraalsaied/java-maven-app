pipeline { 

    agent any  

    environment {
        NEW_VERSION = '1.3.0'
        GITHUB_CREDENTIALS = credentials('github-credentials')
    }

    // tools {
    //     maven 'maven-3.6'
    //     npm 'my-node-18.13'
    // }

    parameters { 
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true , description: '')
    }
    stages {

        stage("pull"){
            steps { 
                echo "pulling the application"
                echo "github credeintails are: ${GITHUB_CREDENTIALS}"

            }
        }

        stage("build"){
            steps { 
                echo "building the application"
                echo "building version ${NEW_VERSION} "
                

            }
        }

        stage("test"){
            when {
                exprerssion {
                    params.executeTests
                }
            }
            steps { 
                echo "testing the application"
                // code to test the application 
            }
        }

        stage("deploy"){

            steps { 
                echo "deploying the application"
                echo "deploying version ${params.VERSION}"
            }

        }
        
    }
}
