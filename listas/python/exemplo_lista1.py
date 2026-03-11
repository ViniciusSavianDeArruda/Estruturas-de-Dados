#Exemplo de criação e manipulação de uma lista em Python
lista_nomes = []
#Adicionar nomes a lista

#Exibir a lista inteira
print(lista_nomes)


#Remover um nome da lista
#lista_nomes.remove(nome)


if len(lista_nomes != 0):
    nome = input("Digite um nome:")
    if lista_nomes.__contains__(nome):
        lista_nomes.remove(nome)
    else:
        print("nome nao esta na lista")

    print(lista_nomes)
else:
    print("Lista Vazia....")





