## Banco
Subindo um banco via terminal pelo docker e salvando o endereço no projeto.

docker run --name postgresql -p 5432:5432 -e POSTGRES_PASSWORD=postgres -v "<endereco_no_pc>:/var/lib/postgresql/data" postgres

Quiser entrar no banco após criado

docker exec -it <id_do_container> bash

Ira abrir o root do banco, para começar a fazer mexer no sql colocará os seguintes comandos

psql -U postgres

A parti de agora pode fazer os sql no terminal.
