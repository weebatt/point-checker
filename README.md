# point-checker
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)](https://gradle.org/)

[![Vue.js](https://img.shields.io/badge/Vue.js-4FC08D?style=for-the-badge&logo=vue.js&logoColor=white)](https://vuejs.org/)
[![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)](https://developer.mozilla.org/en-US/docs/Web/JavaScript)

[![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://www.docker.com/)
[![Docker Compose](https://img.shields.io/badge/Docker_Compose-2496ED?style=for-the-badge&logo=docker&logoColor=white)](https://docs.docker.com/compose/)

**point-checker** — это приложение, написанное на **Java Spring Boot** (Gradle) и **Vue + JavaScript**, позволяющее запускать бэкенд и фронтенд в виде отдельных сервисов, а также собирать и запускать всё целиком с помощью **Docker** и **Docker Compose**.

---

## Содержание
1. [О проекте](#о-проекте)
2. [Технологии](#технологии)
3. [Начало работы](#начало-работы)
4. [Сборка и запуск](#сборка-и-запуск)
   - [Локальный запуск без Docker](#локальный-запуск-без-docker)
   - [Сборка и запуск с Docker](#сборка-и-запуск-с-docker)
5. [Структура проекта](#структура-проекта)
6. [Контакты](#контакты)
7. [Лицензия](#лицензия)

---

## О проекте
Проект **point-checker** содержит **backend** и **frontend** для решения некой задачи (например, анализа данных, ведения статистики или учёта «очков» — подробнее зависит от вашей бизнес-логики). 

В качестве бэкенда используется **Java Spring Boot** с системой сборки **Gradle**. Фронтенд написан на **Vue + JavaScript**. 

Запуск может осуществляться как вручную (через Gradle и npm), так и через контейнеры **Docker** с использованием **Docker Compose**.

---

## Технологии
Основные инструменты и технологии, используемые в проекте:

- **Java** (Spring Boot) + **Gradle**  
- **Vue** + **JavaScript**  
- **Docker** и **Docker Compose**  

---

## Начало работы

1. Убедитесь, что у вас установлен Git, чтобы вы могли клонировать репозиторий.
2. Проверьте, что у вас есть необходимые версии **Java** (рекомендуется 17 или выше), **Gradle** (если собираете локально) и **npm**/**Node.js** (для фронтенда).
3. Для Docker-версии убедитесь, что Docker и Docker Compose установлены и корректно работают на вашей машине.

Клонируйте репозиторий:
```bash
git clone https://github.com/weebatt/point-checker.git
```
## Сборка и запуск
### Локальный запуск без Docker 
#### Бэкенд (Gradle + Spring Boot)
1. Зайдите в папку backend:
```bash
cd backend
```
2. Соберите проект:

```bash
gradle build
```
3. Запустите Spring Boot-приложение:

```bash
gradle bootRun
```

4. По умолчанию приложение будет доступно на порту 8080 (http://localhost:8080).

#### Фронтенд (Vue + JavaScript)
1. Зайдите в папку frontend:
```bash
cd frontend
```

2. Установите зависимости:
```bash
npm install
```

3. Запустите локальный сервер разработчика:
```bash
npm run serve
```

4. Фронтенд по умолчанию доступен на порту 80 или 8080 (в зависимости от настроек Vue). В консоли при запуске вы увидите точный адрес (например, http://localhost:8080).

### Сборка и запуск с Docker
#### Шаг 1: Предварительная настройка
Убедитесь, что в файле docker-compose.yml нет строки:
```yaml
version: '3.8'
```
Если она указана — удалите или закомментируйте её.

#### Шаг 2: Структура docker-compose.yml

```yaml
services:
  frontend:
    build:
      context: ./frontend
      dockerfile: Dockerfile
    ports:
      - "80:80"
    networks:
      - app-network

  backend:
    build:
      context: ./backend
      dockerfile: Dockerfile
    ports:
      - "8080:8080"
    networks:
      - app-network

networks:
  app-network:
```

#### Шаг 3: Сборка контейнеров

Из корневой директории проекта (где лежит docker-compose.yml) выполните:
```bash
docker-compose build
```

#### Шаг 4: Запуск контейнеров
Запустите проект:
```bash
docker-compose up -d
```

- Фронтенд будет доступен по адресу: http://localhost (или http://127.0.0.1)

- Бэкенд будет доступен по адресу: http://localhost:8080

Чтобы посмотреть логи и убедиться, что всё работает:

```bash
docker-compose logs -f
```

#### Остановка контейнеров
```bash
docker-compose down
```

## Структура проекта
Ниже приведён пример структуры репозитория (папки и файлы могут меняться в зависимости от ваших нужд):

```bash
point-checker/
├── backend/
│   ├── src/
│   ├── build.gradle
│   ├── Dockerfile
│   └── ...
├── frontend/
│   ├── src/
│   ├── package.json
│   ├── Dockerfile
│   └── ...
├── docker-compose.yml
├── LICENSE
├── .gitignore
├── .gitattributes
└── README.md
```

## Контакты
Telegram: 
- @weebat - по всем вопросам не связанным с работой обитаю тут
- @batapejka - рабочий аккаунт

Email: batareyka.work@gmail.com

## Лицензия
Этот проект распространяется под лицензией Apache License 2.0. См. файл LICENSE.txt для подробной информации.

