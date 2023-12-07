### Setup para subir a aplicação:
1. Java 17
2. MySQL usado em testes: 8
3. Node 
4. NPM

### Instruções:
#### Linux:
1. Instalação docker & docker-compose (caso ainda não tenha)
```
sudo apt-get update
sudo apt-get install apt-transport-https ca-certificates curl software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg
echo "deb [signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
sudo apt-get update
sudo apt-get install docker-ce docker-ce-cli containerd.io
sudo usermod -aG docker $USER
sudo curl -L "https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
```
2. Subir contâiners
```
sudo docker-compose up
```

#### WINDOWS:
1. Instalação docker & docker-compose (caso ainda não tenha)
Baixe e instale o Docker Desktop através do <a href="https://www.docker.com/products/docker-desktop">site oficial</a>.

    Siga as instruções de instalação fornecidas pelo instalador.
Comandos para instalar o Docker Compose no Windows:
Baixe e instale o Docker Compose seguindo as instruções do <a href="https://docs.docker.com/compose/install/">site oficial</a>.

    Certifique-se de adicionar o Docker Compose ao PATH durante a instalação.
Comandos para executar o Docker Compose no Windows:
Abra o Prompt de Comando ou PowerShell.

    Navegue até o diretório onde está o seu arquivo docker-compose.yml.

    Execute o seguinte comando para subir os contêineres definidos no arquivo docker-compose.yml:

2. Subir contâiners
```
sudo docker-compose up
```
Ou
#### Back-end:
1. Criar o schema (Não é necessário rodar o dump visto que o framework ORM (Hibernate) fará a criação da estrutura)
```
create schema school_manager
```
2. Compilar e rodar pelo maven
```
$ mvn clean install
$ mvn spring-boot:run
```
#### Front-end

```
$cd C:\Code\Trabalho1-BAN2\SchoolManagerAngularClient
$ npm install -g @angular/cli
$ npm i
$ npm start
```

### Credits
https://github.com/jpdev01
<br>
https://github.com/GuilhermeMendesRosa


### Descrição
Uma aplicação deverá ser desenvolvida que faça uso e manipulação do banco de dados relacional. Tal aplicação não necessita apresentar uma interface gráfica, portanto, se a equipe preferir poderá usar a interface em modo texto (REST não será aceito como interface). Não será exigida uma linguagem de programação específica, entretanto, a solução exemplo e suporte da professora será apenas na linguagem Java. Esta aplicação deverá prover interfaces e respectivo funcionamento para as seguintes operações:

1. Operações CRUD para todas as tabelas de entidade do banco de dados (Exemplo de um CRUD: cadastro, recuperação (consulta), atualização (update) e remoção (delete) de Animais de uma clínica veterinária)
2. Operações de Processos de negócio para todas as tabelas associativas do banco de dados - são tabelas que relacionam mais de uma entidade (Exemplo: Efetuar consulta de um Animal da clínica - o que deve relacionar um veterinário, o animal, seu dono e contendo informações do que foi tratado na consulta como doença e medicamentos prescritos)
3. Mínimo de 3 Relatórios do sistema. Cada relatório deve envolver a associação de mais de uma tabela (Exemplo: Relatório dos animais atendidos em um dado período por um dado veterinário)

### Documentação

https://docs.google.com/document/d/11-AcaoiJOv__kgFC5p4O1LxNnR7zO0vPM1PsplVTVqk/edit?usp=sharing

### Na Fase 1 as equipes deverão entregar:

1) Um documento de texto contendo:  
   2) uma seção com uma introdução explicativa do domínio de informação escolhido, 
   3) o esquema conceitual 
   4) o esquema lógico na forma de um dicionário de dados

2) Um repositório ou diretório na nuvem contendo: 
   3) arquivos de código-fonte da aplicação desenvolvida
   4) um arquivo de backup do banco de dados
   5) um arquivo de texto com instruções para a compilação e execução da aplicação. Forneça o link do repositório no documento de texto solicitado no item 1.

