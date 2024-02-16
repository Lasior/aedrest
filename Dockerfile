FROM node

LABEL version = 1.0
LABEL mantainer="Cristian Martin Quintero"

RUN mkdir -p /opt/app

WORKDIR /opt/app

COPY package.json .
RUN npm install --quiet

COPY . .

EXPOSE 8080

CMD npm start