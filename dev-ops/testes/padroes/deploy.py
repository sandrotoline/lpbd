import zipfile
import os
from termcolor import colored


page_base_dev_ops = "C:\\Users\\Aluno\\Documents\\sakaue\\dev-ops\\"
path_teste_bin = "C:\\teste\\apache-tomcat-8.5.51\\bin"
path_prod_bin = "C:\\projeto\\apache-tomcat-8.5.51\\bin"
path_prod =  "C:\\projeto\\"
path_apache = page_base_dev_ops + "testes\\arquivos\\apache-tomcat-8.5.51.zip"
path_war = "C:\\Users\\Aluno\\Documents\\sakaue\\LPBD\\target\\LPBD-0.0.1-SNAPSHOT.war"
path_prod_deploy = "C:\\projeto\\apache-tomcat-8.5.51\\webapps"

def stopTeste():
    print(colored("Parando servidor de teste...", 'green'))
    global path_teste_bin
    os.chdir(path_teste_bin)
    os.system("shutdown")


def criarDiretorioProd():
    print(colored("Criando diretório de produção...", 'green'))
    global path_prod
    os.system("rd /s /q " +path_prod)
    if not os.path.exists(path_prod):
        os.makedirs(path_prod)


def extrairProd():
    print(colored("Extraindo servidor de produção...", 'green'))
    global path_apache
    global path_prod
    with zipfile.ZipFile(path_apache, 'r') as zip_ref:
        zip_ref.extractall(path_prod)

def moverWarProdStart():
    print(colored("Copiando projeto para servidor de produção e inicialização do sistema...", 'green'))
    global path_war
    global path_prod_deploy
    global path_prod_bin
    os.system("copy " + path_war + " " + path_prod_deploy + "\\ROOT.war")
    os.chdir(path_prod_bin)
    os.system("rd /s /q " + path_prod_deploy + "\\ROOT\\")
    os.system("startup")
    print("Sistema iniciado")

def deploy():
    stopTeste()
    criarDiretorioProd()
    extrairProd()
    moverWarProdStart()


    
    