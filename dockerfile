FROM devopsedu/webapp
RUN rm /var/www/html/index.html
COPY website /var/www/html
EXPOSE 80
ENTRYPOINT ["apachectl", "-D", "FOREGROUND"]
