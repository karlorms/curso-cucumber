#language: pt
@funcionais
 Funcionalidade: Cadastro de contas

Como um usu�rio 
Gostaria de cadastrar contas
Para que eu possa distribuir meu dinheiro de uma forma mais organizada

#Background
Contexto:
	Dado que estou acessando a aplicacao
	Quando informo o usuario "karlorms@gmail.com"
	E a senha "karlorms"
	E seleciono entrar
	Entao visualizo a pagina inicial
	Quando seleciono Contas
	E seleciono Adicionar

Esquema do Cenario: Deve validar regras cadastro contas
	Quando informo a conta <conta>
	E seleciono Salvar
	Entao recebo a mensagem "<mensagem>"
	
Exemplos:
	| conta            | mensagem                           |
	| conta de Teste   | Conta adicionada com sucesso!      |
	|                  | Informe o nome da conta            |
	| Conta mesmo nome | Já existe uma conta com esse nome! |