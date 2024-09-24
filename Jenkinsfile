pipeline {
   agent any 
   stages {
      stage('Maven Version') {  // Nom unique pour la première étape
        steps {
            sh "mvn -version"
        }
      }
      stage('Java Version') {  // Nom unique pour la deuxième étape
        steps {
            sh "java -version"
        }
      }
   }
}
