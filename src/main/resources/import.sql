#--- configuration bdd dev
#%dev.quarkus.datasource.jdbc.url=jdbc:mariadb://127.0.0.1:3306/GoodFood2
#%dev.quarkus.datasource.username=GoodFood2
#%dev.quarkus.datasource.password=azertyui
#%dev.quarkus.datasource.db-kind=mariadb

%dev.quarkus.datasource.jdbc.url=jdbc:mariadb://127.0.0.1:3306/goodfoodfinal
#%prod.quarkus.datasource.jdbc.url=jdbc:mariadb://127.0.0.1:3306/GoodFood2
%dev.quarkus.datasource.username=root
%dev.quarkus.datasource.password=azertyui
%dev.quarkus.datasource.db-kind=mariadb
#--- configuration bdd prod
%prod.quarkus.datasource.jdbc.url=jdbc:mariadb://127.0.0.1:3306/goodfoodfinal
#%prod.quarkus.datasource.jdbc.url=jdbc:mariadb://127.0.0.1:3306/goodfoodfinal
%prod.quarkus.datasource.username=root
%prod.quarkus.datasource.password=azertyui
%prod.quarkus.datasource.db-kind=mariadb
#--- configuration bdd test
%test.quarkus.datasource.jdbc.url=jdbc:mariadb://127.0.0.1:3306/goodfoodfinal_test
%test.quarkus.datasource.username=root
%test.quarkus.datasource.password=azertyui
%test.quarkus.datasource.db-kind=mariadb
#--- activation swagger-ui
quarkus.swagger-ui.enable=true
quarkus.swagger-ui.path=swagger-ui
quarkus.swagger-ui.always-include=true
#-- quarkus.oidc.tenant-enabled=false

mp.jwt.verify.publickey.location=/META-INF/resources/publicKey.pem
quarkus.native.resources.includes=/META-INF/resources/publicKey.pem
smallrye.jwt.sign.key.location=/META-INF/resources/privateKey.pem
mp.jwt.verify.issuer=https://localhost:8080/issuer
quarkus.smallrye-jwt.enabled=true

mp.openapi.extensions.smallrye.info.title=API GoodFood2
mp.openapi.extensions.smallrye.info.version=1.0.0
mp.openapi.extensions.smallrye.info.description="Cette api permet de pouvoir faire un ensemble d'action pour le projet GoodFood2"
mp.openapi.extensions.smallrye.info.contact.email=julien.legrand.pro@gmail.com
mp.openapi.extensions.smallrye.info.contact.name=Julien LEGRAND
mp.openapi.extensions.smallrye.info.license.name=Apache 2.0
mp.openapi.extensions.smallrye.info.license.url=http://www.apache.org/licenses/LICENSE-2.0.html
quarkus.http.port=8082
quarkus.http.test-port=8083 
quarkus.http.cors=true
quarkus.http.cors.origins=*
quarkus.http.cors.headers=*
quarkus.http.host=0.0.0.0
quarkus.container-image.registry=globecen
quarkus.container-image.builder=docker