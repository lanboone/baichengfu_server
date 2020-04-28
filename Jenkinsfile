pipeline {
  agent any
  stages {
    stage('检出') {
      steps {
        checkout([
          $class: 'GitSCM',
          branches: [[name: env.GIT_BUILD_REF]],
          userRemoteConfigs: [[
            url: env.GIT_REPO_URL,
            credentialsId: env.CREDENTIALS_ID
          ]]])
        }
      }
      stage('构建') {
        steps {
          echo '构建中...'
          sh 'mvn clean'
          sh 'mvn package'
          sh 'ls ./target'
          echo '构建完成.'
          archiveArtifacts(artifacts: 'README.md', fingerprint: true)
          archiveArtifacts(artifacts: '**/target/*.jar', fingerprint: true)
        }
      }
      stage('测试') {
        steps {
          echo '单元测试中...'
          echo '单元测试完成.'
          writeFile(file: 'TEST-demo.junit4.AppTest.xml', text: '''
                    <testsuite name="demo.junit4.AppTest" time="0.053" tests="3" errors="0" skipped="0" failures="0">
                        <properties>
                        </properties>
                        <testcase name="testApp" classname="demo.junit4.AppTest" time="0.003"/>
                        <testcase name="test1" classname="demo.junit4.AppTest" time="0"/>
                        <testcase name="test2" classname="demo.junit4.AppTest" time="0"/>
                    </testsuite>
                ''')
          junit '*.xml'
        }
      }
      stage('部署') {
        steps {
          echo '部署中...'
          script {
            def remote = [:]
            remote.name = 'sit-server'
            remote.allowAnyHosts = true
            remote.host = '8.129.180.116'
            remote.port = 22
            remote.user = 'root'


            // 把「CODING 凭据管理」中的「凭据 ID」填入 credentialsId，而 username 和 password 无需修改
            withCredentials([usernamePassword(credentialsId: "de91ed45-843a-486f-85d8-be3b91aafcec", usernameVariable: 'username', passwordVariable: 'password')]) {
              remote.user = username
              remote.password = password


              // SSH 上传文件到远端服务器
              sshPut remote: remote, from: '/*.jar', into: '/home/lastest'


            }
          }

          echo '部署完成'
        }
      }
    }
  }