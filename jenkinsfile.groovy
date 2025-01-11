pipeline {
    agent any

    stages {
        stage ('build') {
            steps {
                sh 'echo "Building hte project ..."'
                sh 'python setup.py build' // Example build command for python
            }
        }
        stage('Test') {
            steps {
                sh 'echo "Running tests .. "'
                sh 'python -m unittest discover' //example test command for python
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo "Deploying the applciation..."'
                //Example deploy commanf could vary greatly depening on the target environment
                sh 'scp -r build/ [user]@[server]:[path]' // Example deployment command using scp
            }
        }
    }
}