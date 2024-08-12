## VM과 컨테이너 비교

### 공통점
- **가상화 기술**: 둘 다 물리적인 하드웨어 리소스를 효율적으로 사용하기 위해 가상화 기술을 활용합니다.
- **격리 환경 제공**: 애플리케이션을 독립된 환경에서 실행하여 충돌이나 호환성 문제를 줄입니다.
- **배포 및 관리 용이**: 가상화된 환경을 통해 애플리케이션의 배포, 관리, 확장이 용이합니다.

### 차이점
#### VM 가상화
- **구조**: VM은 하이퍼바이저 위에 각 가상 머신마다 독립적인 운영체제를 포함합니다. 각 VM에는 게스트 OS, 가상 하드웨어, 그리고 그 위에 애플리케이션이 실행됩니다.
- **무게**: 각 VM은 전체 운영체제를 포함하기 때문에 무겁고, 많은 시스템 자원을 소비합니다.
- **격리 수준**: VM은 높은 수준의 격리를 제공하여 거의 완벽하게 게스트와 호스트를 분리할 수 있습니다.

#### 컨테이너 가상화
- **구조**: 컨테이너는 호스트 OS의 커널을 공유하며, 필요한 애플리케이션과 그 종속성만 포함합니다. 도커 엔진 위에 컨테이너가 직접 올라가고, 그 위에 애플리케이션이 실행됩니다.
- **무게**: 컨테이너는 운영체제를 공유하기 때문에 훨씬 가볍고 빠릅니다.
- **격리 수준**: 컨테이너는 프로세스 수준에서 격리되지만, 커널을 공유하기 때문에 VM보다 격리 수준이 낮습니다.

## Docker 설치 및 실행

### AWS (Ubuntu Linux) 설치
```bash
sudo apt update
sudo apt install docker.io
```

### MAC 설치
1. [Docker 공식 사이트](https://www.docker.com/)에서 본인 맥북에 맞는 dmg 파일을 다운로드합니다.
2. 다운로드가 완료되면 **Applications** 폴더에서 Docker를 실행합니다.

## 도커 기본 명령어

### 🎨 이미지 관련

- **이미지 목록 보기**
    ```bash
    $ sudo docker images
    ```

- **이미지 검색**
    ```bash
    $ sudo docker search [이미지 이름]
    ```

- **이미지 받기**
    ```bash
    $ sudo docker pull [이미지 이름]:[버전]
    ```

- **이미지 삭제**
    ```bash
    $ sudo docker rmi [이미지 id]
    ```

### 📦 컨테이너 관련

- **컨테이너 목록 보기**
    ```bash
    $ sudo docker ps
    ```

- **컨테이너 실행**
    ```bash
    $ sudo docker run [options] image[:TAG|@DIGEST] [COMMAND] [ARG...]
    ```

- **컨테이너 시작**
    ```bash
    $ sudo docker start [컨테이너 id 또는 name]
    ```

- **컨테이너 재시작**
    ```bash
    $ sudo docker restart [컨테이너 id 또는 name]
    ```

- **컨테이너 접속**
    ```bash
    $ sudo docker attach [컨테이너 id 또는 name]
    ```

- **컨테이너 정지**
    ```bash
    $ sudo docker stop [컨테이너 id 또는 name]
    ```


# docker 명령어

## docker (container) create
- 컨테이너를 생성하고 자동으로 시작하지는 않음
```powershell
docker create --name [이름] [image]
```

옵션	|설명
---|---
-i | (--interactive)	표준 입력(STDIN)을 활성화함. 컨테이너와 attach 되어있지 않더라도 표준 입력을 유지함.
-t | (--tty)	컨테이너에 pseudo-terminal을 할당

## docker ps
    - 실행(Up)중인 컨테이너 목록 확인
    - docker container ls와 같음
## docker start [container-name]
    - 컨테이너를 시작
    - 생성해둔 컨테이너를 시작할 수 있음

## docker 컨테이너 포트변경
```powershell
docker run -d -it -p port:port --name name image
```


## docker stop [container-name]

## docker run 
- -d 옵션을 사용해 사용자가 직접 컨테이너 안으로 접근하지 않고, 컨테이너의 COMMAND를 백그라운드로 실행할 수 있습니다. 컨테이너를 시작할 때, 명령어의 맨 뒤에 임의로 COMMAND를 정의할 수 있습니다.

```powershell
docker run -it --name date centos /bin/date
docker run -it --name test --restart always centos
```

옵션|키워드|설명
---|---|---
--restart| no | 재시작하지않음
| |on-failure|종료 상태(Exited code)가 0이 아닌 경우 재시작
| | on-failure:(n)|종료 상태(Exited code)가 0이 아닌경우 n회만 재시작
| |always| 항상 재시작

옵션|설명
---|---
--cpus|	컨테이너에서 최대 사용 가능한 cpu의 수를 지정(CPU 사용 비율 지정)
 | |ex) –cpus=0.2 는 CPU를 0.2개(20%)만큼 사용한다는 의미
-c (--cpu-share)|default 값은 1024
||512라고 정의하면 프로세스들 간의 CPU 자원의 경합이 발생했을 때 다른 프로세스들(1024)의 50%만 자원 할당 가능
-m (--memory)|메모리 사용량을 제한(b, k, m, g 단위 정의

## docker attach
    - 컨테이너 내부에 접근하여 STDIN/STDOUT/STDERR를 사용
    - 컨테이너 PID=1 표준 입출력을 이용

```powershell
docker run -it --name test centos
docker ps -a
docker attach test
```

## docker exec
- 동작중인 컨테이너에서 새로운 프로세스를 실행
- COMMAND 말고 별도의 명령어를 실행한다.
```powershell
docker run -d --name web httpd
docker ps -a
docker exec -it web /bin/bash
```

## docker logs
    - 컨테이너의 PID=1 프로세스의 STDIN/STDOUT/STDERR를 출력 가능
```powershell
docker run -dit --name pingtest centos /bin/ping localhost
docker ps
docker logs -f pingtest
docker logs -ft pingtest
```

옵션|설명
---|---
-f(--follow)|실시간으로 로그 추적, 출력
-t(--timestamp)|타임스탬프 출력

## docker stats
    - 동작중인 컨테이너의 상태와 사용중인 리소스의 양을 확인할 때 사용
    - 상태 확인이 끝나면 Ctrl+c 로 명령어 종료

```powershell
docker run -dit --name test --cpus=0.3 stress
docker stats
```

## docker rm
- 컨테이너를 삭제한다.
```powershell
docker ps -a
docker rm [container-name]
docker rm -f [container-name]
```
동작중인 컨테이너를 삭제하려면 stop 명령어를 사용해 종료후 삭제하거나
rm 명령어에 -f 옵션을 사용해 삭제할 수 있다.

## docker rmi [image-name]
- 이미지를 삭제한다.

## docker cp
- 컨테이너와 호스트 간의 파일 복사
```powershell
touch example.txt

docker run -dit --name test centos
docker ps -a
docker cp ~/example.txt tesst:/
docker exec test /bin/ls example.txt
docker cp test:/example.txt ~/example2.txt
```


# docker pull

```powershell
docker pull jenkins/jenkins:latest
```

## docker exec을 이용해 컨테이너접근하기
```powershell
docker exec -it [container-name] [bash]
-- 젠킨스 암호확인하기
$ cat /var/jenkins_home/secrets/initialAdminPassword 
```
