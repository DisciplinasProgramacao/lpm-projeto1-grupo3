# Especifique aqui seu plano de testes, no formato:

ProductTest
1. deve validar a descrição do produto
- shouldValidateDescription
2. deve lançar exceção quando a descrição do produto for invalida
- shouldThrowExceptionIfDescriptionisInvalid2
3. deve calcular a margem de lucros do produto
- shouldCalculateProfitMargin
4. deve calcular a taxa de imposto do produto somando o preco de custo com a taxa de imposto
- shouldCalculateProfitMargin
5. deve calcular o preco de venda do produto somando o preco de custo, margem de lucro e imposto
- shouldCalculateSalesPrice

ProductControllerTest
1. deve criar produto e retornar httpSatus criado, ou seja, o produto criado com sucesso
- shouldCreateproductAndReturnHttpSatusCreated
2. deve obter o produto e retornar HttpStatus ok
- shouldGetProductAndReturnHttpStatusOk
3. deve atualizar o produto e retornar HtppStatus updated
- shouldUpdateProductAndReturnHttpStatusCreated
4. deve deletar o produto e retornar HttpStatus ok
- shouldDeleteProductAndReturnHttpStatusOk


