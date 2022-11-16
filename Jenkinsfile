pipeline {
    agent any
    
tools 
{
    maven "M2_HOME"
}


    environment { 

        registry = "ahmedjerbi1998/achatproject" 

        registryCredential = 'dockerhub_id' 

        dockerImage = '' 

    }


    stages {
         stage('GIT') {
            steps {
           
      
              git branch:'ahmed',url: 'https://github.com/jerbi23/achtatDevops.git'


            }
         }
           stage('CLEAN') {
            steps {
              
          script {
   
               sh "mvn clean"
   
            }
   
        }
             }
             
                   stage('COMPILE') {
            steps {
              
          script {

               sh "mvn compile "

            }
  
        }
             }
        
              stage('TEST') {
            steps {

               sh "mvn test "

            }
              }
              
                    stage('jar') {
            steps {

               sh "mvn package -Dmaven.test.skip=true "
            
            }
              }
              
              
                     stage('nexus') {
            steps {

               sh "mvn deploy -Dmaven.test.skip=true "

            }

        }
        
           stage('sonar') {
            steps {
              
        
              sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=15011991  "
     
           
              
            }
            
            
        }
              

           
        
        stage('Building Docker Image') { 

            steps { 

                script { 

                    dockerImage = docker.build registry + ":1.0" 

                }

            } 

        }

        stage('Pushing Image to DockerHub') { 

            steps { 

                script { 

                    docker.withRegistry( '', registryCredential ) { 

                      dockerImage.push() 

                    }

                } 

            }

        }
         
         
     
         
          stage("Docker-Compose") { 
             steps { 
                 script { 
                    sh "docker-compose up -d  "
                 } 
             } 
          }
          
         
              
            
       
        
    
}

    post {
            always{
                
                emailext to: "ahmed.jerbi@esprit.tn",
                subject: "My job is:${currentBuild.currentResult}: ${env.JOB_NAME}",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}",
        attachLog: true
                
            }
        }



}