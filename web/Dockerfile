FROM node
WORKDIR /web
COPY package*.json .
RUN npm i
COPY . .
RUN npm run build

FROM node
WORKDIR /web
RUN npm i -g serve
COPY --from=0 /web/build .
ENTRYPOINT serve
