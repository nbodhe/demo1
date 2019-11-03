node{
    stage("Checkout"){
        git 'https://github.com/nbodhe/demo1.git'
    }
    stage("Build"){
        sh 'mvn clean package'
    }
    stage("Create Image"){
        sh 'sudo docker build -t nikhil82687/openjdk:1.0 .'
    }
    stage('Clean exisitnng Container'){
        sh 'sudo docker stop demo1 && sudo docker rm demo1'
    }
    stage("Create Container"){
        sh 'sudo docker run -itd --name demo1 -p 8000:8888 nikhil82687/openjdk:1.0 /bin/bash'
    }
}