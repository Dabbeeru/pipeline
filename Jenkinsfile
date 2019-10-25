 pipeline {
        environment {
    registry = "dilleswari/learning"
    registryCredential = 'Dockerhub'
  }
          agent any
          stages {
              stage('Checkout external proj') {
                steps {
                    git branch: 'master',
                        credentialsId: 'gitlab',
                    url: 'https://github.com/Dabbeeru/pipeline.git'
        
                    sh "ls -lat"
                }
        		}
        	
            
              
            
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }

        stage ('Build') {
            steps {
                sh 'mvn clean package -DskipTests' 
            }

  }
 
    

 stage('Building image') {
      steps{
          
         
        script {
          docker.build registry + ":$BUILD_NUMBER"
          
          sh 'docker images'
          sh 'docker run  -it -d centos /bin/bash'
         
         
         
        }
      }
    }
	stage ('Deploye to dockerhub'){
steps
   {
	sh'docker login -u dilleswari -p l@xmi321'
         sh 'docker push dilleswari/centos'
       sh  'docker tag centos dilleswari/centos'
	   }
	   }
  
  stage('Run Tests') {
     
      steps ('webapp') {
        sh "mvn  -fae test"
         
      }
     
     
  }
    }

}
