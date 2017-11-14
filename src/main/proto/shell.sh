##用于将proto文件生成java的脚本
#!/bin/bash
proto_path="/g/protobuf序列化工具/bin"
cd ${proto_path}/..
src_path=$("pwd")/src
protoc -I=${proto_path} --java_out=${src_path} ${proto_path}/down/*.proto