// def buildApp () {
//      echo "building the jar file .. "
//     sh "mvn package"
// }

// def dockerizingApp () {
//     echo "building docker image .. "
//     withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PWD', usernameVariable: 'USER')]) {
//         sh 'docker build -t omaraalsaied/java-maven-app:1.2 .'
//         sh "echo $PWD | docker login -u $USER --password-stdin" 
//         sh 'docker push omaraalsaied/java-maven-app:1.2'
//     }
// }

def testApp() {
    
    echo 'testing the application'
}


def deployApp () {
    echo 'Deploying the application'
}



return this
