실습에 앞서 선행해야 하는 과정
---

* 카프카 클러스터 내 checkout.complete.v1, checkout.aggregated.v1 토픽 생성
* bin/kafka-topics.sh --create --topic [토픽명] --partitions 5 --bootstrap-server localhost:9092

전체적인 Flow
---
* check-out-service에서 결재 -> checkout.complete.v1 토픽에 메시지 발행
* shipment-service에서 결재 내역을 checkout.complete.v1 토픽으로부터 받음
* kafka-streams가 1분마다 위 과정들을 집계하고 checkout.aggregated.v1 토픽에 집계 결과 메시지 발행
