# acertTest
### EndPoints:

Consulta cliente
#Get http://localhost:8080/cliente

A api é paginada, basta adicionar os parametros: paginated= true, size = número maximo de registros, page = numero da pagina
Porém não é obrigatório, caso o envio seja realizado sem parametros, é consultado todos os registros, caso queira pesquisar pelo id, basta adicionar http://localhost:8080/cliente/id

Cadastro de cliente
#Post http://localhost:8080/cliente
body
```json
{
    "cnpj" : "28849244000162",
    "nome" : " Lucas Maraia S.a",
    "razaoSocial" : "Lucas Maraia tecnologia"
}

Edição de cliente
#Put http://localhost:8080/cliente/id
body
```json

{
    "cnpj" : "28849244000162",
    "nome" : " Giovanna Veloso",
    "razaoSocial" : "Giovanna Veloso tecnologia"
}

Consulta de pedido
#Get http://localhost:8080/pedido

A api é paginada, basta adicionar os parametros: paginated= true, size = número maximo de registros, page = numero da pagina
Porém não é obrigatório, caso o envio seja realizado sem parametros, é consultado todos os registros , caso queira pesquisar pelo id, basta adicionar http://localhost:8080/pedido/id

Cadastro de pedido
#Post http://localhost:8080/pedido
```json
{
  "descricao": "Pedido da Giovanna",
  "cliente": {
    "id": 1
  },
  "valor": 150.50
}

Edição de pedido
#Put http://localhost:8080/pedido/id
```json
{
  "descricao": "Este pedido da Giovanna mudou o valor",
  "cliente": {
    "id": 1
  },
  "valor": 200.50
}
Consulta entrega
http://localhost:8080/entrega

A api é paginada, basta adicionar os parametros: paginated= true, size = número maximo de registros, page = numero da pagina
Porém não é obrigatório, caso o envio seja realizado sem parametros, é consultado todos os registros , caso queira pesquisar pelo id, basta adicionar http://localhost:8080/entrega/id

Cadastro de Entrega
#Post http://localhost:8080/entrega
```json
{
    "descricao" : "Esta entrega é da Giovanna",
    "endereco" : "Avenida dos Ourives 480",
    "pedido" : {
        "id" : 1
    }
}

Edição de entrega
#Put http://localhost:8080/entrega/id
```json
{
  "descricao": "Este pedido da Giovanna mudou o valor",
  "cliente": {
    "id": 1
  },
  "valor": 200.50
}



