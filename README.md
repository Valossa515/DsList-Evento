# DsList-Evento
Aplicação Sptring Boot com varios conceitos bacanas

# Tecnologias Utilizadas
1 - Spring Framework
2 - Postgresql
3 - Postman
4 - Docker
5 - Rawilway

## Docker
Em se tratando da aula não foi possivel pelo tempo e pelo formato do evento explicar sobre o docker o professor apenas gerou um arquivo.yml e deu os comandos apresentados no curso.
Porem se deseja realizar o mesmo que foi apresentado é necessario instalar o docker na sua maquina.
Segue a url para que você possa instalar o docker é bem simples, só seguir os passos apresentados
https://docs.docker.com/desktop/install/windows-install/

# O projeto na pratica
O proejto ele funciona de 2 formas uma forma local para testar e corrigir detalhes que não compromentam as funcionalidades, um ambeinte de desenvolvimento e por ultimo um de produção.
Aqui estarei mostrando apenas o resultado final do projeto onde apresento um print do meu postman fazendo uma requizição na url que ja esta em produção na nuvem.
Também mostrarei um print do banco de dados também em produção.

![postman_requisicao](https://github.com/Valossa515/DsList-Evento/assets/18370776/5934f747-1f27-48a6-927c-e7d20f7ff06f)


![postgres-container](https://github.com/Valossa515/DsList-Evento/assets/18370776/3152c09e-c172-447e-b693-577849661e4c)


Aqui o nosso container do postgresql ja esta funcionando e podemos ver os dados ja em produção no servidor provisionado pelo serviço de hospedagem

Caso queira verificar se o proejto funciona estarei deixando disponivel a url que retorna um formato json

https://dslist-evento-production.up.railway.app/games

# Observação
A hospedagem do backend não esta mais sendo gratuita para a maioria dos casos, sendo assim se voce tentar acessar a url para ver se realmente o proejto funciona e não conseguir acessar;
1 - Meu limite de creditos expirou
2 - como é um projeto de estudo pode ser que eu não pague para deixar ele no ar



