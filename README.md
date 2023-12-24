# send_service

Данный учебный проект представляет собой небольшой микросервис,
цель которого отправлять полученные им данные.

На данный момент реализовано получение данных с топика "task-remind" в Apache Kafka
и отправка их по почте,
однако приложение было спроектировано так,
что можно добавить новые источники данных,
и другие точки назначения, к примеру телеграм.

Сейчас проект работает только с department_manager,
однако к нему также можно интегрировать другие приложения.

Send Service дальше будет улучшаться,
приобретая новые возможности и вскоре получит свой образ в DockerHub,
для удобного подключения проекта через Docker compose.

### Некоторые технологии:
* Spring Framework(boot, web)
* Apache Kafka (Реактивная)

### Спасибо за прочтение. 