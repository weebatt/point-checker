FROM node:18

WORKDIR /app

COPY package.json package-lock.json ./
RUN npm install ci


COPY . .

RUN npm run build

RUN npm install -g serve

WORKDIR /app/dist

CMD ["serve", "-s", ".", "-l", "80"]
