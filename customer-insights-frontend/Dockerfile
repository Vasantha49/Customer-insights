# Stage 1: Build Angular app
FROM node:18 AS build
WORKDIR /app

COPY package*.json ./
RUN npm install

# Install Angular CLI inside the container
RUN npm install -g @angular/cli

COPY . .
RUN ng build --configuration=production

# Stage 2: Serve with NGINX
FROM nginx:alpine
COPY --from=build /app/dist/customer-insights-frontend /usr/share/nginx/html
EXPOSE 80
