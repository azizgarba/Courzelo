pipeline {
   agent any 
   stages {
      stage('testing maven') {
        steps {
            sh "mvn -version"
        }
      }
         stage('testing java') {
        steps {
            sh "java -version"
        }
      }
   }
}
