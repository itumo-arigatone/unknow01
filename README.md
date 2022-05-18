# unknow01
kotlin(spring boot) + JS(react)

# 構築
S3 + CloudFront + ECSの構成を想定

# コマンドメモ
docker image build
```sh
# unknow01ディレクトリで
docker-compose build
# or
docker-compose up -d
```
開発中は自分でサーバーを起動したいから、dockerfileのCMDの所はコメントアウトで良いかも？  
バックエンドの開発の時はdocker-compose.ymlのwebの方は消して良いと思う。※コミットはしないようにして

build
```sh
sh gradlew build --info
```
execution
```sh
java -jar ./build/libs/[jarファイル]
```

# RestAPI確認のcurlメモ
```sh
curl -b cookie.txt -c cookie.txt -X POST -H "Content-Type: application/json" -H "x-xsrf-token:{csrfToken}" -d '{"email":"unkoman@example.com","name":"unkoman","password":"unkoman"}' -i "http://localhost:8080/user/create_user"
curl -b cookie.txt -c cookie.txt -X POST "http://localhost:8080/login" -d "email=unko@example.com" -d "password=100" -i
curl -b cookie.txt -i "http://localhost:8080/hello"
curl -b cookie.txt -H "x-xsrf-token:{csrfToken}" -i -X POST http://localhost:8080/logout
```