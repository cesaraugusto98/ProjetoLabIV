# ProjetoLabIV
Projeto de Ecommerce, criado usando Java, MySQL, Maven, Liquibase, Sprint Boot.

# Integrantes
Cesar Augusto Siqueira Santos @cesaraugusto98

Gustavo Soares @gsoare2

Jonathan Souza @joohnnathans

Kevin Mikio @kevin799

Lucas Domingos @lucasdlg5

Carlos Eduardo dos Santos @EduCarlos0311

# Configurações inicials da base de dados

Schema: lab04db

username: lab04

senha: lab04


# Execução Inicial do Projeto utilizando terminal

1 - git clone https://github.com/cesaraugusto98/ProjetoLabIV.git

2 - git checkout release01

3 - cd projetolab4

4 - mvn clean install

5 - mvn liquibase:update

6 - mvn spring-boot:run


# Comandos Git
git clone https://github.com/cesaraugusto98/ProjetoLabIV.git

git checkout origin/release01

git status

git reset


# Comandos Liquibase

mvn liquibase:update

mvn liquibase:status

mvn liquibase:dropAll

# Comandos Maven

mvn clean

mvn install

# Comando Spring Boot

mvn spring-boot:run

# Referencias

###
https://pt.stackoverflow.com/questions/234755/diferen%C3%A7as-onetomany-manytomany-manytoone-onetoone

### Liquibase Doc
https://www.liquibase.org/

### Overview Liquibase
https://www.baeldung.com/liquibase-refactor-schema-of-java-app

### Maven Doc
https://maven.apache.org/
