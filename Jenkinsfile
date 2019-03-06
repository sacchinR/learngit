pipeline {
  agent any
  stages{
  stage('Build'){
    steps{
      withMaven(maven:'localmaven')
      sh 'mvn clean compile'
    }
    
   }
    stage('Test'){
    steps{
      withMaven(maven:'localmaven')
      sh 'mvn test'
    }
    
   } 
    stage('Deploy'){
    steps{
      withMaven(maven:'localmaven')
      sh 'mvn deploy'
    }
    
   } 
    
  }
  

}
